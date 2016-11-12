package client;

import javafx.beans.property.SimpleStringProperty;

public class TableDataSet {
	
	private final SimpleStringProperty sessionName;
	private final SimpleStringProperty numOfPlayers;
	private final SimpleStringProperty userName;
	
	public TableDataSet(String sName, Integer nOfPlayers, String uName){
		this.sessionName = new SimpleStringProperty(sName);
		this.numOfPlayers = new SimpleStringProperty(nOfPlayers.toString());
		this.userName = new SimpleStringProperty(uName);
	}
	
	public String getSessionName(){
		return sessionName.get();
	}
	
	public void setSessionName(String sName){
		sessionName.set(sName);
	}
	
	public String getNumOfPlayers(){
		return numOfPlayers.get();
	}
	
	public void setNumOfPlayers(Integer nOfPlayers){
		numOfPlayers.set(nOfPlayers.toString());
	}
	
	public String getUserName(){
		return userName.get();
	}
	
	public void setUserName(String uName){
		userName.set(uName.toString());
	}

}
