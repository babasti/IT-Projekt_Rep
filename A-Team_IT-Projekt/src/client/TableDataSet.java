package client;

import common.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TableDataSet {
	
	private final SimpleStringProperty sessionName;
	private final SimpleStringProperty numOfPlayers;

	
	public TableDataSet(String sName, Integer nOfPlayers){
		this.sessionName = new SimpleStringProperty(sName);
		this.numOfPlayers = new SimpleStringProperty(nOfPlayers.toString());
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
	
	public StringProperty sessionNameProperty(){
		return sessionName;
	}
	
}
