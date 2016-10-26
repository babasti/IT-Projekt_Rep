package common;

import java.awt.TextField;
import java.io.Serializable;

public class Game implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Player[] players;
	
	public Game(Player[] players){
		this.players = players;
	}
		
	public String toSTring(){
		return "Player name: "+player;
	}
	

}
