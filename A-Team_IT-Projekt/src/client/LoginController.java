package client;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
		String eingabeName = tf_username.getText();
		String eingabePW = pf_password.getText();

		if(Player.checkUser(eingabeName)){ //Benutzer existiert
			Player p = Player.getPlayerUser(eingabeName);
			if(p.getPassword().equals(eingabePW)){// Benutzer existier&Passwort korrekt
				Player.getPlayerUser(eingabeName).updatePCName();
				text_Fehlermeldung.setText("Eingaben korrekt");
				try{
					//Weiterleitung in Lobby				
					FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Lobby.fxml"));
					Pane rootPane = (Pane) fxmlloader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(rootPane));
					stage.show();
					
					//schliesst das alte GUI
					Stage stage1 = (Stage)b_login.getScene().getWindow();
					stage1.close();
				}catch(Exception e){
					System.out.println(e);
				}
			}else{ //Benutzer existiert aber Passwort falsch
				text_Fehlermeldung.setText("Das Passwort ist falsch.");
			}
		}else{
			text_Fehlermeldung.setText("Diesen Benutzer gibt es noch nicht.\n Bitte registrieren Sie sich.");
		}
	}

	public void switchToRegistration(){
		try{			
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Registration.fxml"));
			Pane rootPane = (Pane) fxmlloader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(rootPane));
			stage.show();
			
			//schliesst das alte GUI
			Stage stage1 = (Stage)b_registration.getScene().getWindow();
			stage1.close();
		} catch (Exception e){
			e.printStackTrace();
		}

	}

}
