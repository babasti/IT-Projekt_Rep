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

		if(checkUser(userName)==false){
			addUser(userName, password, dateOfBirth, PCName);
		}
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

	//Methode überladen, damit man mit userNamen Passwort holen kann
	public static String getPassword(String userName){
		String pw = null;
		Scanner scan;
		try {
			scan = new Scanner(new File("RegisteredPlayers.txt"));

			scan.useDelimiter(Pattern.compile(":"));
			//geht Zeile für Zeile das File durch und vergleicht erster Eintrag pro Zeile mit eingegebenem Usernamen
			while(scan.hasNext()){
				String[] regUser = scan.nextLine().split(":");
				if(regUser[0].equals(userName)){
					pw = regUser[1];
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pw;
	}


	public String getPCName(){
		return System.getProperty("user.name");
	}


	//prüft, ob Player bereits erstellt
	public static boolean checkUser(Player p){
		boolean exist = false;
		String userName = p.getUserName();
		try {
			Scanner scan = new Scanner(new File("RegisteredPlayers.txt"));
			scan.useDelimiter(":");
			//geht Zeile für Zeile das File durch und vergleicht erster Eintrag pro Zeile mit eingegebenem Usernamen
			while(scan.hasNext()){
				if(scan.next().equals(userName)){
					exist = true;
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return exist;
	}

	//CheckUser überladen, damit ich mit userName oder Player nach Usern im File suchen kann
	public static boolean checkUser(String userName){
		boolean exist = false;
		try {
			Scanner scan = new Scanner(new File("RegisteredPlayers.txt"));
			scan.useDelimiter(":");

			while(scan.hasNext()){
				String next= scan.next();
				if(next.equals(userName)){
					exist=true;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
