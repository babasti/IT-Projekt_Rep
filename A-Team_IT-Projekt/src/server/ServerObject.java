package server;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

import client.GameController;


// receives objects from client, replace their names and send it back to client
// needs ObjectOutputStream and ObjectInputStream to send and read Objects
public class ServerObject {
	
	private static int port = 9999;

	public static void main(String[] args) {
		
		
		try{
			ServerSocket server = new ServerSocket(port);
			
			System.out.println("Server auf Port "+port+" gestartet \n"+"Warten auf Client\n");
			
			Socket socket = server.accept();
			
			System.out.println("Client angemeldet");
			
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			
			common.Game game2 = (common.Game)in.readObject();
			
			System.out.println("Objekt beim Server angekommen");
					
			out.writeObject(game2);
			
			System.out.println("Objekt vom Server zur�ckgeschickt! ");
			System.out.println(game2);
			
		}catch (Exception e){
			System.out.println("Fehler: "+e);
			
		}
		

	}

}
