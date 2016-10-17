package client;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;


public class GameController implements Initializable {

	@FXML
	Button b1 = new Button ("1");
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void handle(){
		client.ClientCommunication.sendToServer("localHost",1234,b1);
	}
	
}
	
