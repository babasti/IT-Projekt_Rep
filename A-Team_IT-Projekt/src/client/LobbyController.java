package client;

import java.net.URL;
import java.util.ResourceBundle;

import common.Session;
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
	
	ObservableList<Integer> cb_AnzahlSpielerList = (ObservableList<Integer>) FXCollections.observableArrayList(2,3,4);
	
	@FXML
	Label text_OffeneSitzungen;
	
	@FXML
	private TableView <TableDataSet> table_OffeneSitzungen;
	
	@FXML
	private TableColumn <TableDataSet, String> spalte_Sitzung;
	
	@FXML
	private TableColumn <TableDataSet, String> spalte_Spieler;
	
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
	 
	ObservableList<TableDataSet> data = FXCollections.observableArrayList();
	 
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		cb_AnzahlSpieler.setItems(cb_AnzahlSpielerList);
		
		spalte_Sitzung.setCellValueFactory(new PropertyValueFactory<TableDataSet, String>("sessionName"));
		spalte_Anzahl.setCellValueFactory(new PropertyValueFactory<TableDataSet, String>("numOfPlayers"));
		spalte_Spieler.setCellValueFactory(new PropertyValueFactory<TableDataSet, String>("userName"));
		table_OffeneSitzungen.setItems(data);
		table_OffeneSitzungen.getColumns().clear();
		table_OffeneSitzungen.getColumns().addAll(spalte_Sitzung, spalte_Anzahl, spalte_Spieler);
	}
	
	public void createNewSession(){
		
		String sessionName = tf_Sitzungsname.getText();
		Integer numOfPlayers = (Integer) cb_AnzahlSpieler.getValue();
		String userName = "Alen"; //hier muss noch der richtige Benutzername hin
		
	
		if (table_OffeneSitzungen.getColumns().contains(sessionName) == false){
		
		TableDataSet tds = new TableDataSet(sessionName, numOfPlayers, userName);
		data.add(tds);
		}else{
			
		}
		
		
		
	}
	
	public void exitSession(){
		
	}
	
	public void joinSession(){
		
	}
	
	public void selectSession(){
		
	}
	
	public void startSession(){
		
	}

}
