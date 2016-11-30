package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Player implements Serializable{

	private String userName;
	private Date dateOfBirth;
	private String password;
	public ArrayList<Card> cards;
	private int score;
	public ArrayList<Tile> tiles;
	private String PCName;

	public Player(String userName, String password, Date dateOfBirth, String PCName){
		this.userName = userName;
		this.dateOfBirth= dateOfBirth;
		this.password = password;
		this.PCName = PCName;
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
		return this.PCName;
	}

	public void setPCName(String PCName){
		this.PCName = PCName;
	}

	//wenn PCName des registrierten Benutzers nicht mit aktuellem PC übereinstimmt.
	//wird der Player
	public void updatePCName(){
//		try{
//			Scanner scan = new Scanner(new File("RegisteredPlayers.txt"));
//			BufferedWriter br = new BufferedWriter(new FileWriter("RegisteredPlayers.txt"));
//
//			while(scan.hasNextLine()){
//				String line = scan.nextLine();
//				String[] next = line.split(":");
//				if(next[0].equals(this.getUserName()) && !this.getPCName().equals(System.getProperty("user.name"))){
//					next[3]= System.getProperty("user.name");
//					br.write(next[0]+":"+next[1]+":"+next[2]+":"+next[3]+"\n");
//				}else{
//					br.write(line+"\n");
//				}
//			}
//			br.close();				
//		}catch(Exception e){
//			System.out.println(e);
//		}	

		this.setPCName(System.getProperty("user.name"));
	}


	//identifiziert Player über dessen PCNamen
	public static Player getPlayerPC(String PCName){
		if(server.Server.regPlayers.size()>0){
			for(Player p:server.Server.regPlayers){
				if(p.getPCName().equals(PCName)){
					return p;
				}
			}
		}else{
			return server.Server.regPlayers.get(0);
		}

		return server.Server.regPlayers.get(0);
	}

	//identifiziert Player über dessen UserNamen
	public static Player getPlayerUser(String userName){
		if(server.Server.regPlayers.size()>0){
			for(Player p:server.Server.regPlayers){
				if(p.getUserName().equals(userName)){
					return p;
				}
			}
		}else{
			return server.Server.regPlayers.get(0);
		}

		return server.Server.regPlayers.get(0);
	}


	//prüft, ob Player mit diesem UserName bereits erstellt
	public static boolean checkUser(String userName){
		boolean exist = false;
		for(Player p:server.Server.regPlayers){
			if(p.getUserName().equals(userName)){
				exist = true;
			}
		}
		return exist;
	}

//	// fügt neuen User im File RegisteredPlayers hinzu
//	public static void addUser(String userName, String password, Date dateOfBirth, String PCName){
//		try {
//			FileWriter fw = new FileWriter("RegisteredPlayers.txt", true);
//			BufferedWriter bw = new BufferedWriter(fw);
//			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//			Scanner scan = new Scanner(new File("RegisteredPlayers.txt"));
//
//			bw.write(userName+":"+password+":"+dateFormat.format(dateOfBirth)+":"+PCName+"\n");
//			bw.close();
//
//			server.Server.regPlayers.add(new Player(userName, password, dateOfBirth,PCName));
//
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


	public String toString(){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return "Name: "+this.userName+"\n"+"Passwort: "+this.password+"\n"+"Geburtsdatum: "+dateFormat.format(this.dateOfBirth);
	}

}
