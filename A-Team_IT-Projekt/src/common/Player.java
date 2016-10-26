package common;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Player {

	private String userName;
	private Date dateOfBirth;
	private String password;
	public ArrayList<Card> cards;
	private int score;
	public ArrayList<Tile> tiles;
	private String PCName;
	public static ArrayList<Player> registeredPlayers = new ArrayList<Player>();
	private boolean exist;

	public Player(String userName, Date dateOfBirth, String password){
		this.userName = userName;
		this.dateOfBirth= dateOfBirth;
		this.password = password;
		this.PCName = System.getProperty("user.name");
		cards = new ArrayList<Card>();
		tiles = new ArrayList<Tile>();
		score = 0;
		checkUser(userName);
		if(exist==false){
			registeredPlayers.add(this);
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
		return System.getProperty("user.name");
	}
	
	//prüft, ob Player bereits erstellt
	public void checkUser(String userName){
		exist = false;
		for(int i=0;i<Player.registeredPlayers.size(); i++){
			if(userName.equals(Player.registeredPlayers.get(i).userName)){
				System.out.println("Dieser Benutzername ist schon vergeben!");
				exist=true;
			}
		}
	}
	
	public String toString(){
		return "Name: "+this.userName+"\n"+"Passwort: "+this.password+"\n"+"Geburtsdatum: "+this.dateOfBirth;
	}

}
