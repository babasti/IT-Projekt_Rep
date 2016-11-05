package client;

import java.net.URL;
import java.util.ResourceBundle;

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

public class LobbyController implements Initializable {
	
	ObservableList<Integer> cb_AnzahlSpielerList = (ObservableList<Integer>) FXCollections.observableArrayList(2,3,4);
	
	@FXML
	Label text_OffeneSitzungen;
	
	@FXML
	TableView table_OffeneSitzungen;
	
	@FXML
	TableColumn spalte_Sitzung;
	
	@FXML
	TableColumn spalte_Spieler;
	
	@FXML
	TableColumn spalte_Anzahl;
	
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
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cb_AnzahlSpieler.setItems(cb_AnzahlSpielerList);
		
	}
	
	public void createNewSession(){
		
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
