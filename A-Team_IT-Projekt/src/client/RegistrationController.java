package client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class RegistrationController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void register(){
		String eingabeName = tf_username.getText();
		String eingabePW = pf_password.getText();
	}

}
