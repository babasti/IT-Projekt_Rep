package common;

import java.io.Serializable;
import java.util.ArrayList;


public class Session implements Serializable{


	private int numOfPlayers;
	private Player[] players;
	private String sessionName;
	private ArrayList<Player> playersList;


	
	public Session(String sessionName, int numOfPlayers, Player[] players){
		this.sessionName = sessionName;
		this.numOfPlayers = numOfPlayers;
		this.players =players;
		for(Player player : players){
			playersList.add(player);
		}
		
	}
		
	
	public void setSessionName(String sessionName){
		this.sessionName = sessionName;
	}
	
	public String getSessionName(){
		return this.sessionName;
	}
	
	public void setNumOfPlayers(int numOfPlayers){
		this.numOfPlayers = numOfPlayers;
	}
	
	public int getNumOfPlayers(){
		return this.numOfPlayers;
	}
	
	public void setPlayers(Player [] players){
		this.players = players;
	}
	public ArrayList<Player> getPlayersList(){
		return this.playersList;
	}
	
	public void setPlayersList(ArrayList<Player> playersList){
		this.playersList = playersList;
	}
	
	public Player [] getPlayers(){
		return this.players;
	}
	
	public void addPlayerToPlayersArray(Player p){
		for (int i = 0; i < players.length;i++){
			if (players[i].equals(null)){
				players[i] = p;
			}
		}
	}

	public String toString(){
		return this.getSessionName()+", "+this.getNumOfPlayers()+", "+this.getPlayers();
	}

}
