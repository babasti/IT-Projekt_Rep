package client;

import java.awt.TextField;
import java.io.Serializable;

public class Game implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String player;
	
	public Game(String player){
		this.player = player;
	}
	
	public void setPlayer(String player){
		this.player = player;
	}
	
	public String getPlayer(){
		return this.player;
	}
	
	public String toSTring(){
		return "Player name: "+player;
	}
	

}
