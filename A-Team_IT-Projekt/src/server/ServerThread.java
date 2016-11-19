package server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import common.Player;

public class ServerThread extends Thread {
	Socket socket = null;
	ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public static ArrayList<Player> regPlayers;


	public void run(){
		//common.Game game = null;
		regPlayers = new ArrayList<Player>();
	
		try{
			Scanner scan = new Scanner(new File("RegisteredPlayers.txt"));
			
			while(scan.hasNextLine()){
				String[] next = scan.nextLine().split(":");
				String[] d = next[2].split("-");
				Date date = new Date(Integer.parseInt(d[2]), Integer.parseInt(d[1]), Integer.parseInt(d[0]));
				regPlayers.add(new Player(next[0], next[1], date));			
			}

			for(int i=0; i<regPlayers.size(); i++){
				System.out.println(regPlayers.get(i));
			}
		}catch(Exception e){
		}
		

		try{
//			//schreibt alle User in File in eine ArrayList
//			//WICHTIG: müssen wenn Spiel beendet wurde wieder in File geschrieben werden
//			Scanner scan = new Scanner(new File("RegisteredPlayers.txt"));
//			ArrayList<Player> regPlayers = new ArrayList<Player>();
//
//			while(scan.hasNextLine()){
//				String[] next = scan.nextLine().split(":");
//				String[] d = next[2].split("-");
//				Date date = new Date(Integer.parseInt(d[2]), Integer.parseInt(d[1]), Integer.parseInt(d[0]));
//				regPlayers.add(new Player(next[0], next[1], date));
//			}
//
//			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//			while ((game = (common.Game)objectInputStream.readObject()) != null){
//				System.out.println(game.toSTring());
//
//				doSomething(game);
//				objectOutputStream.writeObject(game);
//				objectOutputStream.writeObject(regPlayers);
//
//				System.out.println("Object has been changed and sent.");
//
//			}

			socket.close();
		}catch (Exception e){
			e.printStackTrace();
		}


	}

//	private void doSomething (common.Game game){
//		System.out.println("nothing in method");
//	}

}
