package client;

import java.io.*;
import java.net.Socket;

import common.Game;

public class ClientObject {
	
	
	private static Game game = new Game("Simone");

	
	// connect client with Server
	public static Game clientServerCommunication(Game game) {
		
		try{
			Socket client = new Socket ("localhost", 9999);
			
			ObjectOutputStream out = new ObjectOutputStream (client.getOutputStream());
			
			ObjectInputStream in = new ObjectInputStream (client.getInputStream());
			
			System.out.println("Server kontaktiert: " +client.getInetAddress());
			
			
			
			out.writeObject(game);
			
			
			System.out.println("Objekt name " + game.getPlayer());
			System.out.println("Objekt vom Client versendet!");
			
			Game game1 = (Game)in.readObject();
			
			System.out.println("Objekt vom Server erhalten und eingelesen");
			System.out.println(game1.toSTring());
			
			return game1;
			
		}catch (Exception e){
			System.out.println("\nFehler: "+e);
		}
		return game;
		
		

	}
	
	// send Game Object to Server and returns Player Name to Controller
	public static String sendGameObject(){
		
		
		Game gameClient = clientServerCommunication(game);
		
		return gameClient.getPlayer();
		
		
	}
	
}

