package client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
	
	
	@FXML
	TextField tf_username;
	
	@FXML
	PasswordField pf_password;
	
	@FXML
	Label text_LoginAtlantis;
	
	@FXML
	Label text_Benutzername;
	
	@FXML
	Label text_Passwort;
	
	@FXML
	Label text_Fehlermeldung;
	
	@FXML
	Button b_login;
	
	@FXML
	Button b_registration;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void login(){
		
	}
	
	public void switchToRegistration(){
		
	}
	
	
}
