package common;

import client.TableDataSet;

public class Session {


	private int numOfPlayers;
	private Player[] players;
	private String sessionName;


	
	public Session(String sessionName, int numOfPlayers, Player[] players){
		this.sessionName = sessionName;
		this.numOfPlayers = numOfPlayers;
		this.players =players;
		
	}
		
	//holt die selektierte Sitzung um das Spiel zu starten
	public TableDataSet getOpenSession(TableDataSet data){
		return data;
	}



}
