package client;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.Game;
import common.Player;
import common.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LobbyController implements Initializable, Serializable {

	private static final long serialVersionUID = -1547512304397946316L;
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
	TextField tf_Sitzungsname;

	@FXML
	ChoiceBox cb_AnzahlSpieler;

	@FXML
	Button b_SitzungErstellen;

	@FXML
	Pane lobbyPane;

	public static ListView<String> offeneSitzungen;
	//offeneSitzungenList ist notwendig für die Kontrolle ob eine Sitzung bereits existiert
	public static ArrayList<String> offeneSitzungenList = new ArrayList <String>();
	//im openSession sind alle offenen Session Objekte
	public static ArrayList<Session> openSessions = new ArrayList <Session>();
	//selectedSessionListView wird der Stringwert aus der selektierten Zeile der ListView gespeichert
	public static String selectedSessionListView;
	//ist das in der ListView selektierte Sessionobjekt
	public static Session selectedSession;
	ObservableList<Integer> cb_AnzahlSpielerList = (ObservableList<Integer>) FXCollections.observableArrayList(2,3,4);
	public static Label fehlermeldung;

	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		//Wertinitialisierung der Choicebox
		cb_AnzahlSpieler.setItems(cb_AnzahlSpielerList);

		offeneSitzungen = new ListView<String>();
		offeneSitzungen.setLayoutX(394);
		offeneSitzungen.setLayoutY(123);
		offeneSitzungen.setPrefWidth(388);
		offeneSitzungen.setPrefHeight(200);
		offeneSitzungen.toFront();
		lobbyPane.getChildren().add(offeneSitzungen);

		fehlermeldung = new Label();
		fehlermeldung.setLayoutX(350);
		fehlermeldung.setLayoutY(432);
		fehlermeldung.setTextFill(Color.web("#e44317"));
		fehlermeldung.setEffect(text_Sitzungsname.getEffect());
		fehlermeldung.setFont(Font.font(24));
		fehlermeldung.toFront();
		lobbyPane.getChildren().add(fehlermeldung);

		//Wenn Lobby gestartet wird, werden dem Player alle offenen Sitzungen angezeigt
		ClientThread.sendToServer(new Game("arrayList openSessions an Client"));
	}

	public void createNewSession(){
		try{
			String sessionName = tf_Sitzungsname.getText();
			Integer numOfPlayers = (Integer) cb_AnzahlSpieler.getValue();
			Player player = Player.getPlayerID(ClientThread.getId());
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
					ClientThread.sendToServer(new Game(session,"sitzung erstellt"));
				}else{
					fehlermeldung.setText("Dieser Sitzungsname existiert bereits.");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//Diese Methode vergleicht ob der eingegebene Sitzungsname bereits existiert
	public static boolean sessionAlreadyExist(String sessionName){
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
		try{
			//Damit wenn ListView leer ist und darauf geklickt wird, das Programm nicht zusammenstürtzt
			if(!offeneSitzungen.getSelectionModel().isEmpty()){
				for (int z = 0; z < openSessions.size();z++){
					//löscht den Player aus der Session
					if(openSessions.get(z).getSessionName().equals(selectSession().getSessionName())){
						Player[] players = selectSession().getPlayers();
						Player currentPlayer = Player.getPlayerID(ClientThread.getId());
						for (int i = 0; i<players.length;i++){
							if(!(players[i] == null)){
								if(players[i].getUserName().equals(currentPlayer.getUserName())){
									players[i] = null;
									selectSession().setPlayers(players);
								}
							}
						}
						ClientThread.sendToServer(new Game(selectSession(), currentPlayer, "Player aus Sitzung ausgetreten"));
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
							ClientThread.sendToServer(new Game(selectSession(), "sitzung ist leer"));

						}
					}
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	//gibt den Index aus dem Playerarray zurück, wo das erste Platzhalter null ist, brauchen wir für die Methode joinSession
	public static int getIndexPlayerArray(Player[] p){
		//index = -1, weil 0 geht nicht, da im Array an der Position 0 auch null sein kann, 
		//so ist es sicher wenn -1, dass das erste null in der Array zurückgegeben wird
		int index = -1;
		for (int i=0; i < p.length;i++){
			if(p[i] == null && index == -1){
				index = i;
			}
		}
		return index;
	}

	// hier muss ein Objekt weiterverschickt werden für die Client-Server-Kommunikation
	public void joinSession(){
		if(!offeneSitzungen.getSelectionModel().isEmpty()){
			Player[] players = selectSession().getPlayers();
			int index = getIndexPlayerArray(players);
			Player p = Player.getPlayerID(ClientThread.getId());
			boolean alreadyInSession = false;
			for(Player player:players){
				if(player != null){
					if(player.getUserName().equals(p.getUserName())){
						alreadyInSession = true;
					}
				}
			}
			if(!alreadyInSession){
				players[index] = p;
				selectSession().setPlayers(players);
			}else{
				fehlermeldung.setText("Sie sind der Sitzung bereits beigetreten.");
			}
			ClientThread.sendToServer(new Game(selectSession(),p, "Player ist Sitzung beigetreten"));
		}
	}

	public static Session selectSession(){
		if(!offeneSitzungen.getSelectionModel().isEmpty()){
			selectedSessionListView = offeneSitzungen.getSelectionModel().getSelectedItem();
			Session session = null;

			for (Session s:openSessions){
				if	(s.getSessionName().equals(selectedSessionListView)){
					session = s;
				}
			}
			selectedSession = session;
			return selectedSession;
		}else{
			return selectedSession = null;
		}
	}


	public void startSession(){
		if (!offeneSitzungen.getSelectionModel().isEmpty()){
			//nur der Sitzungsersteller darf die Sitzung starten
			if(selectSession().getPlayers()[0].getClientID() == ClientThread.getId()){
				//prüft, ob Sitzung voll ist
				Player[] players = selectSession().getPlayers();
				//Array muss voll sein um spielen zu können
				boolean arrayNotFull = false;
				for(Player p:players){
					if(p == null){
						arrayNotFull = true;
					}
				}
				if(!arrayNotFull){
					try{
						Game game = new Game(selectSession(), "spiel gestartet");
						ClientThread.sendToServer(game);
					}catch(Exception e){
						e.printStackTrace();
					}

					//String aus ArrayList <String> offeneSitzungenList löschen
					for (int i = 0; i < offeneSitzungenList.size(); i++){
						if(offeneSitzungenList.get(i).equals(selectedSessionListView)){
							offeneSitzungenList.remove(i);
						}
					}
					//Session aus ArrayList <Session> openSessions löschen
					for(int b = 0; b < openSessions.size(); b++){
						if(openSessions.get(b).equals(selectSession())){
							openSessions.remove(b);
						}
					}
					//Item aus ListView <String> offeneSitzungen löschen
					for (int c = 0; c < offeneSitzungen.getItems().size();c++){
						if (offeneSitzungen.getItems().get(c).equals(selectedSessionListView)){
							offeneSitzungen.getItems().remove(c);
						}
					}
				}else{
					fehlermeldung.setText("Die Sitzung ist noch nicht voll.");
				}
			}
			else{
				fehlermeldung.setText("Nur der Sitzungsersteller darf das Spiel starten.");
			}
		}
	}
}
