package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MainGame extends Application {
	
	
	public void start(Stage primaryStage) throws Exception {
		try {
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Game.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		launch();
	}

}
