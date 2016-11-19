package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Player {

	private String userName;
	private Date dateOfBirth;
	private String password;
	public ArrayList<Card> cards;
	private int score;
	public ArrayList<Tile> tiles;
	private String PCName;

	public Player(String userName, String password, Date dateOfBirth){
		this.userName = userName;
		this.dateOfBirth= dateOfBirth;
		this.password = password;
		this.PCName = System.getProperty("user.name");
		cards = new ArrayList<Card>();
		tiles = new ArrayList<Tile>();
		score = 0;
	}

	public void setScore(int score){
		this.score = score;
	}

	public int getScore(){
		return this.score;
	}

	public String getUserName(){
		return this.userName;
	}

	public Date getDateOfBirth(){
		return this.dateOfBirth;
	}

	public String getPassword(){
		return this.password;
	}

	public String getPCName(){
		return System.getProperty("user.name");
	}

	public void setPCName(String PCName){
		this.PCName = PCName;
	}
	
	//geht Spieler aus File durch
	public static String[] regPlayerFile(){
		Scanner scan = new Scanner(new File("RegisteredPlayers.txt"));
		

		while(scan.hasNextLine()){
			String[] next = scan.nextLine().split(":");
			String[] d = next[2].split("-");
			Date date = new Date(Integer.parseInt(d[2]), Integer.parseInt(d[1]), Integer.parseInt(d[0]));
			regPlayers.add(new Player(next[0], next[1], date));			
		}
	}
	//wenn PCName des registrierten Benutzers nicht mit aktuellem PC übereinstimmt.
	//wird der Player
	public void updatePCName(){
		if(!this.getPCName().equals(System.getProperty("user.name"))){
			this.setPCName(System.getProperty("user.name"));
		}
	}

	//identifiziert Player über dessen PCNamen
	public static Player getPlayerPC(String PCName){
		if(client.Client.regPlayers.size()>0){
			for(Player p:client.Client.regPlayers){
				if(p.getPCName().equals(PCName)){
					return p;
				}
			}
		}else{
			return client.Client.regPlayers.get(0);
		}

		return client.Client.regPlayers.get(0);
	}

	//identifiziert Player über dessen UserNamen
	public static Player getPlayerUser(String userName){
		if(client.Client.regPlayers.size()>0){
			for(Player p:client.Client.regPlayers){
				if(p.getUserName().equals(userName)){
					return p;
				}
			}
		}else{
			return server.ServerThread.regPlayers.get(0);
		}

		return server.ServerThread.regPlayers.get(0);
	}


	//prüft, ob Player mit diesem UserName bereits erstellt
	public static boolean checkUser(String userName){
		boolean exist = false;
			for(Player p:server.ServerThread.regPlayers){
				if(p.getUserName().equals(userName)){
					exist = true;
				}
			}
		return exist;
	}

	// fügt neuen User im File RegisteredPlayers hinzu
	public static void addUser(String userName, String password, Date dateOfBirth, String PCName){
		try {
			FileWriter fw = new FileWriter("RegisteredPlayers.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Scanner scan = new Scanner(new File("RegisteredPlayers.txt"));

			bw.write(userName+":"+password+":"+dateFormat.format(dateOfBirth)+":"+PCName+"\n");
			bw.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	public String toString(){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return "Name: "+this.userName+"\n"+"Passwort: "+this.password+"\n"+"Geburtsdatum: "+dateFormat.format(this.dateOfBirth);
	}

}
