package server;

import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import common.Game;
import common.Player;

public class Server {
	public static ArrayList<Player> regPlayers;
	public static ArrayList<ObjectOutputStream> openOutputStreams;
	public static final int PORT = 1234;
	public static int counter = 0;
	private ServerSocket serverSocket;

	public static void main(String[] args) throws Exception{
		new Server().runServer();
	}

	public void runServer() throws Exception {
		openOutputStreams = new ArrayList<ObjectOutputStream>();

		if(serverSocket == null){
			serverSocket = new ServerSocket (PORT);
		}
		//Singleton
		if(regPlayers == null){
			regPlayers = new ArrayList<Player>();
		}
		//alle User aus dem File werden in eine ArrayList geschrieben
		try{
			this.fileToArrayList();
		}catch(Exception e){
			e.printStackTrace();
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

	//in ArrayList werden alle registrierten Player aus dem File geschrieben
	public void fileToArrayList(){
		try{
			Scanner scan = new Scanner(new File("RegisteredPlayers.txt"));
			while(scan.hasNextLine()){
				String[] next = scan.nextLine().split(":");
				String[] d = next[2].split("-");
				Date date = new Date(Integer.parseInt(d[2])-1900, Integer.parseInt(d[1])-1, Integer.parseInt(d[0]));
				regPlayers.add(new Player(next[0], next[1], date, next[3]));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void arrayListToFile(){
		try{
			//File wird geleert
			FileWriter fw = new FileWriter("RegisteredPlayers.txt");
			fw.write("");
			fw.close();
			//Player aus ArrayList werden in File geschrieben
			FileWriter fwappend = new FileWriter("RegisteredPlayers.txt", true);
			BufferedWriter bw = new BufferedWriter(fwappend);
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

			for(Player p:Server.regPlayers){
				bw.write(p.getUserName()+":"+p.getPassword()+":"+dateFormat.format(p.getDateOfBirth())+":"+p.getPCName()+"\n");	
			}
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
