package common;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


import client.ClientThread;


public class Player implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2853507843070301083L;
	private String userName;
	private Date dateOfBirth;
	private String password;
	public ArrayList<Card> playerCards;
	private int score;
	private String PCName;
	private boolean alreadyLoggedIn = false;
	private ArrayList<Avatar> playerAvatars;
	private String avatarColor;


	public Player(String userName, String password, Date dateOfBirth, String PCName){
		this.userName = userName;
		this.dateOfBirth= dateOfBirth;
		this.password = password;
		this.PCName = PCName;
		playerCards = new ArrayList<Card>();
		score = 0;
		playerAvatars = new ArrayList<Avatar>();
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

	public boolean getAlreadyLoggedIn(){
		return this.alreadyLoggedIn;
	}

	public void setAlreadyLoggedIn(boolean b){
		this.alreadyLoggedIn = b;
	}

	public void setAvatarColor (String avatarColor){
		this.avatarColor = avatarColor;
	}


	public ArrayList<Avatar> getPlayerAvatars(){
		return this.playerAvatars;
	}
	
	public ArrayList<Card> getPlayerCards(){
		return this.playerCards;
	}

}
