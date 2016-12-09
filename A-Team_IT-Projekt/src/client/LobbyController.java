package client;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.Game;
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
	//offeneSitzungenList ist notwendig für die Kontrolle ob eine Sitzung bereits existiert
	private ArrayList<String> offeneSitzungenList = new ArrayList <String>();
	//im openSession sind alle offenen Session Objekte
	private ArrayList<Session> openSessions = new ArrayList <Session>();
	//selectedSessionListView wird der Stringwert aus der selektierten Zeile der ListView gespeichert
	private String selectedSessionListView;
	//ist das in der ListView selektierte Sessionobjekt
	private Session selectedSession;

	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		//Wertinitialisierung der Choicebox
		cb_AnzahlSpieler.setItems(cb_AnzahlSpielerList);
	}



	// hier muss ein Objekt weiterverschickt werden für die Client-Server-Kommunikation
	public void createNewSession(){
		try{
			String sessionName = tf_Sitzungsname.getText();
			Integer numOfPlayers = (Integer) cb_AnzahlSpieler.getValue();
			Player player = Player.getPlayerPC(System.getProperty("user.name"));
			if(tf_Sitzungsname.getText().isEmpty() || cb_AnzahlSpieler.getSelectionModel().isEmpty()){
				fehlermeldung.setText("Bitte geben Sie einen Sitzungsnamen sowie die Anzahl der Spieler an.");
			}else{
				//Player Array wird erst hier erstellt, weil es sonst eine Nullpointerexception wirft, wenn es gleich beim 
				//Methodenanfang instanziert wird und der Spieler am Anfang ohne die Anzahlspieler zu wählen eine Sitzung 
				//erstellen will, session kann erst danach instanziert werden da Player [] ein Parameter des Sessionobjekts ist
				if (!sessionAlreadyExist(sessionName)){
					Player[] players = new Player[numOfPlayers];
					players[0] = player;
					Session session = new Session(sessionName, numOfPlayers, players);
					offeneSitzungen.getItems().addAll(sessionName);
					offeneSitzungenList.add(sessionName);
					openSessions.add(session);
				}else{
					fehlermeldung.setText("Dieser Sitzungsname existiert bereits.");
				}
			}

		}catch(Exception e){
			e.printStackTrace();
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


	// hier muss ein Objekt weiterverschickt werden für die Client-Server-Kommunikation
	public void exitSession(){
		//Damit wenn ListView leer ist und darauf geklickt wird, das Programm nicht zusammenstürtzt
		if(!offeneSitzungen.getSelectionModel().isEmpty()){
			for (Session s: openSessions){
				//löscht den Player aus der Session
				if(s.equals(selectedSession)){
					Player[] players = selectedSession.getPlayers();
					for (int i = 0; i<players.length;i++){
						if(!(players[i] == null)){
							if(players[i].getUserName().equals(players[0].getUserName())){
								players[i] = null;
								selectedSession.setPlayers(players);
							}
						}
					}
					//wenn der letzte Player aus der Session geht, sollte die Session gelöscht werden
					//jedes Mal wenn ein Player im Array den Wert null hat, steigt der counter um 1, das heisst also wenn 
					//counter gleich wie die Arraygrösse ist, sind keine Players in der Session vorhanden und sie kann gelöscht werden
					int counter = 0;
					for(int i = 0; i<players.length;i++){
						if(players[i] == null){
							counter++;
						}
					}
					//wenn counter gleichgross wie die Grösse des Arrays ist, dann:
					if(counter == players.length){
						//String aus ArrayList <String> offeneSitzungenList löschen
						for (int i = 0; i < offeneSitzungenList.size(); i++){
							if(offeneSitzungenList.get(i).equals(selectedSessionListView)){
								offeneSitzungenList.remove(i);
							}
						}
						// Session aus ArrayList <Session> openSessions löschen
						for(int b = 0; b < openSessions.size(); b++){
							if(openSessions.get(b).equals(selectedSession)){
								openSessions.remove(b);
							}
						}
						
						
						//String aus ListView <String> offeneSitzungen löschen
						if (offeneSitzungen.getItems().equals(selectedSessionListView)){
							offeneSitzungen.getItems().clear();
						}
					}
				}
			}
		}
	}


	// hier muss ein Objekt weiterverschickt werden für die Client-Server-Kommunikation
	public void joinSession(){
		if (!offeneSitzungen.getSelectionModel().isEmpty()){
			selectedSession.getPlayers();
		}
	}

	public Session selectSession(){
		if(!offeneSitzungen.getSelectionModel().isEmpty()){
			selectedSessionListView = offeneSitzungen.getSelectionModel().getSelectedItem();
			Session session = null;

			for (Session s:openSessions){
				if	(s.getSessionName().equals(selectedSessionListView)){
					session = s;
				}
			}
			this.selectedSession = session;
			System.out.println(selectedSession.toString());
			Player[] players = selectedSession.getPlayers();
			for(int i=0;i<players.length;i++){
				System.out.println(players[i]);
			}
			return selectedSession;
		}else{
			return selectedSession = null;
		}
	}

	public void startSession(){

	}

}
