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

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import client.ClientThread;

public class Player implements Serializable{

	private String userName;
	private Date dateOfBirth;
	private String password;
	public ArrayList<Card> cards;
	private int score;
	private String PCName;
	private ArrayList<Circle> avatars;
	private Circle avatar1 = new Circle();
	private Circle avatar2 = new Circle();
	private Circle avatar3 = new Circle();

	public Player(String userName, String password, Date dateOfBirth, String PCName){
		this.userName = userName;
		this.dateOfBirth= dateOfBirth;
		this.password = password;
		this.PCName = PCName;
		cards = new ArrayList<Card>();
		score = 0;
		avatars = new ArrayList<Circle>();
		avatars.add(avatar1);
		avatars.add(avatar2);
		avatars.add(avatar3);
		for(int i = 0; i < avatars.size(); i++){
			avatars.get(i).setRadius(10);
			avatars.get(i).setStroke(Color.BLACK);
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

	public String getPCName(){
		return this.PCName;
	}

	public void setPCName(String PCName){
		this.PCName = PCName;
	}

	//wenn PCName des registrierten Benutzers nicht mit aktuellem PCNamen übereinstimmt
	public void updatePCName(){
		this.setPCName(System.getProperty("user.name"));
	}

	//identifiziert Player über dessen PCNamen
	public static Player getPlayerPC(String PCName){
		Player searchedPlayer = null;
		for(Player p:ClientThread.regPlayers){
			if(p.getPCName().equals(PCName)){
				searchedPlayer = p;
			}
		}
		return searchedPlayer;
	}

	//identifiziert Player über dessen UserNamen
	public static Player getPlayerUser(String userName){
		Player searchedPlayer = null;
		for(Player p:ClientThread.regPlayers){
			if(p.getUserName().equals(userName)){
				searchedPlayer = p;
			}
		}
		return searchedPlayer;
	}


	//prüft, ob Player mit diesem UserName bereits erstellt
	public static boolean checkUser(String userName){
		boolean exist = false;
		for(Player p:ClientThread.regPlayers){
			if(p.getUserName().equals(userName)){
				exist = true;
			}
		}
		return exist;
	}
	
	public ArrayList<Circle> getAvatar(){
		return this.avatars;
	}
	
	public void addToScore(int points){
		this.score += points;
	}
	
	public void subFromScore(int points){
		this.score -=points;
	}

	public String toString(){
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return "Name: "+this.userName+"\n"+"Passwort: "+this.password+"\n"+"Geburtsdatum: "+dateFormat.format(this.dateOfBirth);
	}

}
