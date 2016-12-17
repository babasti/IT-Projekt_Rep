package client;

import java.io.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Client extends Application implements Serializable{
	
	private static final long serialVersionUID = 5208359137429335816L;

	public static void main(String[] args) throws Exception{	
		launch();
	}

	public void start(Stage primaryStage) throws Exception {
		try{
			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}


