package server;

import java.io.*;
import java.net.*;

import common.Player;

public class Server {

	public static final int PORT = 1234;
	public static int counter = 0;
	private ServerSocket serverSocket;

	public static void main(String[] args) throws Exception{
		new Server().runServer();
	}

	public void runServer() throws Exception {
		if(serverSocket == null){
			serverSocket = new ServerSocket (PORT);
		}
		System.out.println("Starting Server...");
		System.out.println("Server started at: "+serverSocket.getInetAddress());
		while(true){
			Socket socket = serverSocket.accept();
			counter++;
			System.out.println("Connection from: "+socket.getInetAddress());
			System.out.println("Client Nr : "+counter);
			new ServerThread(socket).start();

		}
	}


	//ArrayList regPlayer updaten (entweder Player hinzufügen, oder PCName updaten)
	public static void updateList(Player p, String PCName){
		if(server.ServerThread.regPlayers.contains(p)){
			p.setPCName(PCName);
		}else{
			server.ServerThread.regPlayers.add(p);
		}
	}
//
//	public String getIP(){
//		if(serverSocket == null)
//	}
}
