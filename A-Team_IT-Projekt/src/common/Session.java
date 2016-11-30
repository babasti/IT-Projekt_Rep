package common;


public class Session {


	private int numOfPlayers;
	private Player[] players;
	private String sessionName;


	
	public Session(String sessionName, int numOfPlayers, Player[] players){
		this.sessionName = sessionName;
		this.numOfPlayers = numOfPlayers;
		this.players =players;
		
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
	
	public Player [] getPlayers(){
		return this.players;
	}



}
