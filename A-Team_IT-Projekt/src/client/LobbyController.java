package client;

import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class LobbyController implements Initializable {



	@FXML
	Label text_OffeneSitzungen;

	@FXML
	private TableView <TableDataSet> table_OffeneSitzungen;

	@FXML
	private TableColumn <TableDataSet, String> spalte_Sitzung;

	@FXML
	private TableColumn <TableDataSet, String> spalte_Anzahl;

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


	ObservableList<Integer> cb_AnzahlSpielerList = (ObservableList<Integer>) FXCollections.observableArrayList(2,3,4);
	ObservableList<TableDataSet> data = FXCollections.observableArrayList(	);



	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		//Wertinitialisierung der Choicebox
		cb_AnzahlSpieler.setItems(cb_AnzahlSpielerList);

		//Einfügen der Werte in die Tabelle
		spalte_Sitzung.setCellValueFactory(new PropertyValueFactory<TableDataSet, String>("sessionName"));
		spalte_Anzahl.setCellValueFactory(new PropertyValueFactory<TableDataSet, String>("numOfPlayers"));

		table_OffeneSitzungen.setItems(data);
		table_OffeneSitzungen.getColumns().clear();
		table_OffeneSitzungen.getColumns().addAll(spalte_Sitzung, spalte_Anzahl);


	}




	public void createNewSession(){
		String sessionName = tf_Sitzungsname.getText();
		Integer numOfPlayers = (Integer) cb_AnzahlSpieler.getValue();
		TableDataSet tds = new TableDataSet(sessionName, numOfPlayers);
		if(!sessionAlreadyExist(sessionName)){
			data.add(tds);
		}

		//	hier müssen die Daten dem neuinstanzierten Sessionobjekt übergeben werden
		Player[] players = new Player[numOfPlayers];
		//Player.getPlayerPC(System.getProperty("user.name"))
	 //	new Session (sessionName, numOfPlayers, players)


	}
	//Diese Methode vergleicht ob der eingegebene Sitzungsname bereits existiert
	private boolean sessionAlreadyExist(String sessionName){
		boolean alreadyExist = false;
		for(int i = 0; i < data.size();i++){
			if(data.get(i).getSessionName().equals(sessionName)){
				alreadyExist = true;
			}
		}
		return alreadyExist;
	}






	public void exitSession(){

	}

	public void joinSession(){
		Player p;
	}

	//wenn row gleich true, ist eine Zeile markiert
	//als Parameter muss hier Session übergeben werden?
	public boolean selectSession(TableView table_OffeneSitzungen){
		TableDataSet selectedItem = (TableDataSet) table_OffeneSitzungen.getSelectionModel().getSelectedItem();
		if (selectedItem != null){
			return  true;
		}
		return false;
	}




	public void startSession(){

	}

}
