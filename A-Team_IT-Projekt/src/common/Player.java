package common;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import client.ClientThread;
import client.CreateCircleColor;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Player implements Serializable{
	
	private static final long serialVersionUID = -2853507843070301083L;
	private String userName;
	private Date dateOfBirth;
	private String password;
	private int clientID;
	public ArrayList<Card> playerCards;
	private int score;
	private boolean alreadyLoggedIn = false;
	private ArrayList<Avatar> playerAvatars;
	private String avatarColor;
	transient private Circle avatarCircle;
	

	public Player(String userName, String password, Date dateOfBirth){
		
		this.userName = userName;
		this.dateOfBirth= dateOfBirth;
		this.password = password;
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
	
	public int getClientID(){
		return this.clientID;
	}
	
	public void setClientID(int clientID){
		this.clientID = clientID;
	}

	//identifiziert Player über dessen PCNamen
	public static Player getPlayerID(int clientID){
		Player searchedPlayer = null;
		for(Player p:ClientThread.regPlayers){
			if(p.getClientID() == clientID){
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
	public String getAvatarColor (){
		
		return avatarColor;
	}
	
	public ArrayList<Avatar> getPlayerAvatars(){
		return this.playerAvatars;
	}
	
	public ArrayList<Card> getPlayerCards(){
		return this.playerCards;
	}
	
	public void setPlayerCards(ArrayList<Card> playerCards){
		this.playerCards = playerCards;
	}

	public Circle getAvatarCircle() {
		Circle circle = new Circle();
		circle.setFill(CreateCircleColor.getCreateCircleColor().createColor(getAvatarColor()));
		circle.setStroke(Color.BLACK);
		circle.setRadius(10);
		circle.setVisible(true);
		circle.toFront();
		return circle;
	}

	public void setAvatarCircle(Circle avatarCircle) {
		this.avatarCircle = avatarCircle;
	}
}
