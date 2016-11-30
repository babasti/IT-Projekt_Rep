package client;

import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

import server.Server;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import common.Game;
import common.Player;

public class ClientNew extends Application implements Serializable{
	private static Socket socket;
	private static ObjectOutputStream objectOutputStream;
	private static ObjectInputStream objectInputStream;

	public static void main(String[] args) throws Exception{	

		launch();

		objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		objectInputStream = new ObjectInputStream(socket.getInputStream());
	}

	public void start(Stage primaryStage) throws Exception {
		try{
			Game g;
			server.Server.regPlayers = new ArrayList<Player>();
			//
			//			Date d1 = new Date(92,0,15);
			//			Date d2 = new Date(91,1,25);
			//			Date d3 = new Date(57,10,1);
			//
			//			String PCName = System.getProperty("user.name");
			//
			//			Player p1 = new Player("Barbara","ananas",d1,PCName);
			//			server.Server.regPlayers.add(p1);
			//			System.out.println(Player.checkUser("Barbara"));
			//			Player p2 = new Player("alen","fhnw",d2,PCName);
			//			server.Server.regPlayers.add(p2);
			//			System.out.println(Player.checkUser("alen"));
			//			Player p3 = new Player("simi","naros",d3,PCName);
			//			server.Server.regPlayers.add(p3);
			//			System.out.println(Player.checkUser("simi"));

			Pane root = (Pane)FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
			
//			while((g = (Game)objectInputStream.readObject()) != null){
//				if(g.getWhat().equals("arrayList")){
//					ArrayList<Player> regPlayers = g.getAl();
//					for(Player p : regPlayers){
//						System.out.println(p);
//					}
//				}
//			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//sendet Objekt an Server
	public static void sendToServer(Game g){
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(g);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// instanziert die Instanzvariabel entsprechend den gewünschten Vorgaben im LoginController
	public static void setClientSocket(Socket socket1){
		socket = socket1;
	}
	
	
}


