package server;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

import client.GameController;


// receives objects from client, replace their names and send it back to client
// needs ObjectOutputStream and ObjectInputStream to send and read Objects
public class ServerObject implements Runnable {

	private static int port = 9999;

	Socket clientSocket;

	public ServerObject(Socket clientSocket){
		this.clientSocket = clientSocket;
	}

	public void run() {

		try{
			Socket socket = new Socket();

			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

			common.Game game2 = (common.Game)in.readObject();

			System.out.println("Objekt beim Server angekommen");
			game2.setPlayer("Alen");

			out.writeObject(game2);

			System.out.println("Objekt vom Server zur�ckgeschickt! ");
			System.out.println(game2);

		}catch (Exception e){
			System.out.println("Fehler: "+e);

		}


	}

}
