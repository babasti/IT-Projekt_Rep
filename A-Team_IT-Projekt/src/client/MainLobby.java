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

public class MainLobby extends Application implements Serializable {

	public static void main(String[] args) {
		launch();

	}

	public void start(Stage primaryStage) throws Exception {
		try{
			
			server.Server.regPlayers = new ArrayList<Player>();

			Date d1 = new Date(92,0,15);
			Date d2 = new Date(91,1,25);
			Date d3 = new Date(57,10,1);

			Player p1 = new Player("alen","ananas",d1,"alenbrisevac");
			server.Server.regPlayers.add(p1);
			
			
			
			Player p2 = new Player("alen","fhnw",d2,"ananas");
			server.Server.regPlayers.add(p2);
			
			
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Lobby.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

}
