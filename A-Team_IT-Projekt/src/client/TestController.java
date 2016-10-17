package client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TestController implements Initializable{
	
	@FXML
	Button b1;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void buttonClicked(){
		client.ClientCommunication.sendToServer("localHost", 1234, b1);
	}
	
	

}
