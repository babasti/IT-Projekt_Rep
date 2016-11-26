

package client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import common.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainRegistration extends Application implements Serializable {

	public static void main(String[] args) {
		launch();
	}

	public void start(Stage primaryStage) throws Exception {
		try{			
		server.ServerThread.regPlayers = new ArrayList<Player>();

		Date d1 = new Date(92,0,15);
		Date d2 = new Date(91,1,25);
		Date d3 = new Date(57,10,1);

		String PCName = System.getProperty("user.name");

		Player p1 = new Player("Barbara","ananas",d1,PCName);
		server.ServerThread.regPlayers.add(p1);
		System.out.println(Player.checkUser("Barbara"));
		Player p2 = new Player("alen","fhnw",d2,PCName);
		server.ServerThread.regPlayers.add(p2);
		System.out.println(Player.checkUser("alen"));
		Player p3 = new Player("simi","naros",d3,PCName);
		server.ServerThread.regPlayers.add(p3);
		System.out.println(Player.checkUser("simi"));


		Pane root = (Pane)FXMLLoader.load(getClass().getResource("Registration.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();

		}catch (Exception e){
			e.printStackTrace();
		}

	}

}



