package client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController implements Initializable {
<<<<<<< HEAD
=======
	
	@FXML
	Label text_Registration;
	
	@FXML
	Label text_Benutzername;
	
	@FXML
	Label text_Passwort;
	
	@FXML
	Label text_PasswortWiederholen;
	
	@FXML
	Label text_Geburtsdatum;
	
	@FXML
	TextField tf_username;
	
	@FXML
	PasswordField pf_password;
	
	@FXML
	PasswordField pf_repeatPassword;
	
	@FXML
	DatePicker dp_geburtsdatum;
	
	@FXML
	Button b_register;
	
>>>>>>> branch 'master' of https://github.com/babasti/IT-Projekt_Rep.git

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void register(){
		String eingabeName = tf_username.getText();
		String eingabePW = pf_password.getText();
	}

	public void register(){
		
	}
}
