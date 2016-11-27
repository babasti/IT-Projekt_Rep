package server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import common.Player;

public class Server {
	public static ArrayList<Player> regPlayers;
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
		//Singleton
		if(regPlayers == null){
			regPlayers = new ArrayList<Player>();

			//alle User aus dem File werden in eine ArrayList geschrieben
			try{
				Scanner scan = new Scanner(new File("RegisteredPlayers.txt"));

				while(scan.hasNextLine()){
					String[] next = scan.nextLine().split(":");
					String[] d = next[2].split("-");
					Date date = new Date(Integer.parseInt(d[2]), Integer.parseInt(d[1]), Integer.parseInt(d[0]));
					regPlayers.add(new Player(next[0], next[1], date, next[3]));
				}

				for(int i=0; i<regPlayers.size(); i++){
					System.out.println(regPlayers.get(i));
				}
			}catch(Exception e){
			}
		}
		System.out.println("Starting Server...");
		System.out.println("Server started at: "+serverSocket.getInetAddress());
		while(true){
			Socket socket = serverSocket.accept();
			counter++;
			System.out.println("Connection from: "+socket.getRemoteSocketAddress());
			System.out.println("Client Nr : "+counter);
			new ServerThread(socket).start();
		}
	}

	//Player hinzufügen
	public static void updateList(Player p){
			server.Server.regPlayers.add(p);
	}
}
