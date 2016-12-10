package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.Game;
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

	@FXML
	Button hostButton;

	@FXML
	TextField ipAdresse;

	private boolean setSocket = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void login(){
		String eingabeName = tf_username.getText();
		String eingabePW = pf_password.getText();
		if(!setSocket){ //besteht Verbindung zum Server?
			text_Fehlermeldung.setText("Bitte wählen Sie einen Host aus.");
		}else{
			if(Player.checkUser(eingabeName)){ //Benutzer existiert
				Player p = Player.getPlayerUser(eingabeName);
				if(!p.getAlreadyLoggedIn()){
					if(p.getPassword().equals(eingabePW)){// Benutzer existiert&Passwort korrekt
						p.updatePCName();
						p.setAlreadyLoggedIn(true);
						ClientThread.sendToServer(new Game(p));
						text_Fehlermeldung.setText("Eingaben korrekt");
						try{
							//Weiterleitung in Lobby	
							FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Lobby.fxml"));
							Pane lobbyPane = (Pane)fxmlloader.load();
							Stage stage = new Stage();
							stage.setResizable(false);
							stage.setScene(new Scene(lobbyPane));
							stage.show();

							//schliesst das alte GUI
							Stage stage1 = (Stage)b_login.getScene().getWindow();
							stage1.close();
						}catch(Exception e){
							e.printStackTrace();
						}
					}else{ //Benutzer existiert aber Passwort falsch
						text_Fehlermeldung.setText("Das Passwort ist falsch.");
					}
				}else{ //Benutzer bereits eingeloggt
					text_Fehlermeldung.setText("Dieser Benutzer ist bereits eingeloggt.");
				}
			}else{ //Benutzer existiert nicht
				text_Fehlermeldung.setText("Diesen Benutzer gibt es noch nicht.\n Bitte registrieren Sie sich.");
			}
		}

	}

	public void switchToRegistration(){
		try{
			if(setSocket){ //wenn Verbindung zum Server hergestellt wurde
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Registration.fxml"));
				Pane rootPane = (Pane) fxmlloader.load();
				Stage stage = new Stage();
				stage.setResizable(false);
				stage.setScene(new Scene(rootPane));
				stage.show();

				//schliesst das alte GUI
				Stage stage1 = (Stage)b_registration.getScene().getWindow();
				stage1.close();
			}else{
				text_Fehlermeldung.setText("Bitte wählen Sie einen Host aus.");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	//diese Methode schreibt die eigene IP-Adresse in das Textfeld im Login
	//die IP-Adresse im Textfeld wird benötigt um eine Verbindung mit dem Server herzustellen
	public void setSocket(){
		try {
			InetAddress ip = InetAddress.getLocalHost();
			ipAdresse.setText(ip.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//mit dieser Methode wird die Verbindung zwischen Client und Server hergestellt
	public void setServerSocket(){
		try{
			System.out.println("Connecting...");
			Socket socket = new Socket(ipAdresse.getText(), server.Server.PORT);
			System.out.println("Connection successful...");
			setSocket = true;
			new ClientThread(socket).start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
