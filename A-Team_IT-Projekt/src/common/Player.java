package common;

import java.util.ArrayList;
import java.util.Date;

public class Player {
	
	private String userName;
	private Date dateOfBirth;
	private String password;
	public ArrayList<Card> cards;
	private int score;
	public ArrayList<Tile> tiles;
	
	public Player(String userName, Date dateOfBirth, String password){
		this.userName = userName;
		this.dateOfBirth= dateOfBirth;
		this.password = password;
		cards = new ArrayList<Card>;
		tiles = new ArrayList<Tile>;
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

}
