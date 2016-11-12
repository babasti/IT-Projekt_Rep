package client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import common.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController implements Initializable {


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
	public Button b_register;

	@FXML
	Label text_Fehlermeldung;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void register(){
		Date oldest = new Date(1900,0,1); //ältestes mögliches Datum ist 1.1.1900
		Calendar cal;
		String eingabeName = tf_username.getText();
		String eingabePW1 = pf_password.getText();
		String eingabePW2 = pf_repeatPassword.getText();
		Date eingabeDatum = Date.from(dp_geburtsdatum.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());

		if(checkUser(userName)==false){
			addUser(userName, password, dateOfBirth, PCName);
		}
		
		//		if(!common.Player.checkUser(eingabeName) && !(eingabeName == null) && eingabePW1.equals(eingabePW2) && !(eingabePW1 == null) && eingabeDatum.after(oldest) && eingabeDatum.before(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))){
		//			{
		//				b_register.setDisable(false);
		//				//in Lobby weiterleiten
		//			}
		//		}

		if(common.Player.checkUser(eingabeName)){
			text_Fehlermeldung.setText("Diesen Benutzer gibt es schon. \n Bitte wähle einen anderen Namen.");
		}else if(eingabeName == null){
			text_Fehlermeldung.setText("Sie haben keinen Benutzernamen eingegeben.");
		}else{
			if(!eingabePW1.equals(eingabePW2)){
				text_Fehlermeldung.setText("Die beiden Passwörter stimmen nicht überein. Bitte gib sie noch einmal ein.");
			}else if(eingabePW1 == null || eingabePW2 == null){
				b_register.setDisable(true);
				text_Fehlermeldung.setText("Sie haben kein Passwort eingegeben.");
				//prüft ob Datum zwischen 1.1.1900 und heute liegt
				if(!(eingabeDatum.after(oldest) && eingabeDatum.before(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())))){
					b_register.setDisable(true);
				}else{
					try{
						BufferedReader in = new BufferedReader(new FileReader("RegisteredPlayers.txt"));
						int count = 0;
						while(in.readLine() != null){
							count++;
						}
						String playerName = "player"+String.valueOf(count);
						
						Player.addUser(eingabeName, eingabePW1, eingabeDatum, System.getProperty("user.name"));
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}


	}

}
