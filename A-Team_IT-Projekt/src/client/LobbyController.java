package client;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.Player;
import common.Session;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class LobbyController implements Initializable {



	@FXML
	Label text_OffeneSitzungen;

	@FXML
	Button b_SitzungBeitreten;

	@FXML
	Button b_SitzungVerlassen;

	@FXML
	Button b_SpielStarten;

	@FXML
	Label text_NeueSitzungErstellen;

	@FXML
	Label text_Sitzungsname;

	@FXML
	Label text_AnzahlSpieler;
	
	@FXML
	Label fehlermeldung;

	@FXML
	TextField tf_Sitzungsname;

	@FXML
	ChoiceBox cb_AnzahlSpieler;

	@FXML
	Button b_SitzungErstellen;

	@FXML
	ListView<String> offeneSitzungen;


	ObservableList<Integer> cb_AnzahlSpielerList = (ObservableList<Integer>) FXCollections.observableArrayList(2,3,4);
	private ArrayList<String> offeneSitzungenList = new ArrayList <String>();

	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		//Wertinitialisierung der Choicebox
		cb_AnzahlSpieler.setItems(cb_AnzahlSpielerList);
		

	}
	


	public void createNewSession(){
		String sessionName = tf_Sitzungsname.getText();
		Integer numOfPlayers = (Integer) cb_AnzahlSpieler.getValue();
		//um den Player zu holen muss man auf die ArrayListe vom Server zugreifen --> mit Bäbsle am Samstag anschauen
		//Player player = Player.getPlayerPC(System.getProperty("user.name"));
		//players[0] = player;
		if(tf_Sitzungsname.getText().isEmpty() || cb_AnzahlSpieler.getSelectionModel().isEmpty()){
			fehlermeldung.setText("Bitte geben Sie einen Sitzungsnamen sowie die Anzahl der Spieler an");
		}else{
			//Player Array wird erst hier erstellt, weil es sonst eine Nullpointerexception wirft, wenn es gleich beim 
			//Methodenanfang instanziert wird und der Spieler am Anfang ohne die Anzahlspieler zu wählen eine Sitzung 
			//erstellen will, session kann erst danach instanziert werden da Player [] ein Parameter des Sessionobjekts ist
			if (!sessionAlreadyExist(sessionName)){
				Player[] players = new Player[numOfPlayers];
				Session session = new Session(sessionName, numOfPlayers, players);
				offeneSitzungen.getItems().addAll(sessionName);
				offeneSitzungenList.add(sessionName);
			}else{
				fehlermeldung.setText("Dieser Sitzungsname existiert bereits");
			}
		}
	}

	//Diese Methode vergleicht ob der eingegebene Sitzungsname bereits existiert
	private boolean sessionAlreadyExist(String sessionName){
		boolean alreadyExist = false;
		if(offeneSitzungenList.size()>0){
			for(String s : offeneSitzungenList){
				if(s.equals(sessionName)){
					alreadyExist = true;
				}
			}
		}
		return alreadyExist;
	}

	public void exitSession(){

	}

	public void joinSession(){
		Player p;
	}


	//als Parameter muss hier Session übergeben werden?
	//	public Session selectSession(){
	//
	//	}

	public void startSession(){

	}

}
