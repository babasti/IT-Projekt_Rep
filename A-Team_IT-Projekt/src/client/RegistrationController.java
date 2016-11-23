package client;

import java.io.BufferedReader;

import javafx.beans.value.ChangeListener; 
import javafx.beans.value.ObservableValue;

import java.io.FileReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import common.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
	private TextField tf_username;

	@FXML
	private PasswordField pf_password;

	@FXML
	private PasswordField pf_repeatPassword;

	@FXML
	private DatePicker dp_geburtsdatum;

	@FXML
	private Button b_register;

	@FXML
	Label text_Fehlermeldung;


	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	//	public RegistrationController(){
	//		
	//		int sum=0;
	//		
	//		tf_username.textProperty().addListener(new ChangeListener<String>(){
	//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
	//				sum += 1;
	//				if(sum == 3){
	//					b_register.setDisable(false);
	//				}
	//			}
	//		});
	//		pf_password.textProperty().addListener(new ChangeListener<String>(){
	//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
	//				sum += 1;
	//				if(sum == 3){
	//					b_register.setDisable(false);
	//				}
	//			}
	//		});
	//		pf_repeatPassword.textProperty().addListener(new ChangeListener<String>(){
	//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
	//				sum += 1;
	//				if(sum == 3){
	//					b_register.setDisable(false);
	//				}
	//			}
	//		});
	//	}


	public void register(){
		Date oldest = new Date(1900,0,1); //ältestes mögliches Datum ist 1.1.1900
		String eingabeName  = tf_username.getText();
		String eingabePW1 = pf_password.getText();
		String eingabePW2 = pf_repeatPassword.getText();
		Date eingabeDatum = Date.from(dp_geburtsdatum.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		System.out.println("Hallo");

		if(eingabeName.isEmpty()){
			System.out.println("2");
			text_Fehlermeldung.setText("Sie haben keinen Benutzernamen eingegeben.");
		}else if(common.Player.checkUser(eingabeName)){
			System.out.println("1");
			text_Fehlermeldung.setText("Diesen Benutzer gibt es schon. \n Bitte wähle einen anderen Namen.");
		}else{
			if(eingabePW1.isEmpty() || eingabePW2.isEmpty()){
				System.out.println("4");
				text_Fehlermeldung.setText("Sie haben kein Passwort eingegeben.");
			} if(!eingabePW1.equals(eingabePW2)){
				System.out.println("3");
				text_Fehlermeldung.setText("Die beiden Passwörter stimmen nicht überein. Bitte gib sie noch einmal ein.");
			}
			//prüft ob Datum zwischen 1.1.1900 und heute liegt
			if(!(eingabeDatum.after(oldest) && eingabeDatum.before(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())))){
				text_Fehlermeldung.setText("Das eingegebene Datum ist ungültig.");
				System.out.println("5");
			}else{
				System.out.println("6");
				Player.addUser(eingabeName, eingabePW1, eingabeDatum, System.getProperty("user.name"));

				try{
					//Weiterleitung in Lobby				
					FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("Lobby.fxml"));
					Pane rootPane = (Pane) fxmlloader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(rootPane));
					stage.show();

					//schliesst das alte GUI
					Stage stage1 = (Stage)b_register.getScene().getWindow();
					stage1.close();
				}catch(Exception e){
					System.out.println(e);
				}
			}
		}
	}
}
