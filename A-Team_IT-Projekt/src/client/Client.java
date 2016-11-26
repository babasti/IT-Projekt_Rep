package client;

import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import common.Player;

public class Client extends Application{
	static Socket socket;
	static ObjectOutputStream objectOutputStream;
	static ObjectInputStream objectInputStream;
	
	//	static common.Player [] playerArray;
	//	
	//	common.Player p1 = new common.Player("simi", "lala", null);
	//	common.Player p2 = new common.Player("al", "lele", null);
	//	

	public static void main(String[] args) throws Exception{	
		
		
		
		System.out.println("Connecting...");
		
		socket = new Socket ("localhost", server.Server.PORT);
		System.out.println("Connection successful.");
		
		objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		objectInputStream = new ObjectInputStream(socket.getInputStream());


		BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));

		launch();

		//nur zu test zwecken muss gelöscht werden ab hier sollte ein Game Objekt versendet werden

		//			System.out.println("Enter you Name and Age...")				
		//			String readerInput =bufferedReader.readLine();
		//			String[] readerInputTokens = readerInput.split(" ");
		//			common.Game clientGame = new common.Game(readerInputTokens[0], Integer.decode(readerInputTokens[1]));
		//			System.out.println("Object from Client: \n"+clientGame.toSTring());
		//
		//			common.Game clientGame = new common.Game(playerArray);
		//
		//			System.out.println("Sending Object to Server...");
		//			objectOutputStream.writeObject(clientGame);
		//			common.Game serverGame = (common.Game)objectInputStream.readObject();
		//			System.out.println("Object changed from Server to: \n"+serverGame.toSTring());	


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

			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public void sendToServer(Object o){
		try {
			objectOutputStream.writeObject(o);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


