package server;

import java.io.*;

import client.LobbyController;
import common.Game;
import common.Player;

import java.lang.reflect.Array;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ServerThread implements Serializable, Runnable{
	private static Socket socket = null;
	public static ObjectOutputStream objectOutputStream;
	public static ObjectInputStream objectInputStream;
	ServerThread(Socket socket){
		this.socket = socket;
	}

	public void run(){
		Game g;
		try{
			synchronized(objectInputStream = new ObjectInputStream(socket.getInputStream())){
				synchronized (objectOutputStream = new ObjectOutputStream(socket.getOutputStream())){
					Server.openOutputStreams.add(objectOutputStream);
					while(true){	
						while((g = (Game)objectInputStream.readObject()) != null){
							//wenn ein client arrayList der Player anfragt
							if(g.getWhat().equals("arrayList regPlayers an Client")){
								sendToAllClients(new Game(Server.regPlayers));
							}
							if(g.getWhat().equals("arrayList openSessions an Client")){
								sendToClient(new Game(Server.openSessions, "arrayList openSessions an Client"));
							}
							//wenn gesendetes Game-Objekt player enthält, wird er der arraylist hinzugefügt	
							if(g.getWhat().equals("Player an Server")){
								//wenn Benutzer sich einlogged, wird alreadyLoggedIn auf true gesetzt
								ArrayList<String> names = new ArrayList<String>();
								for(Player p:Server.regPlayers){
									names.add(p.getUserName());
								}
								if(names.contains(g.getP().getUserName())){
									for(Player p:Server.regPlayers){
										if(g.getP().getUserName().equals(p.getUserName())){
											p.setAlreadyLoggedIn(true);
										}
									}

								}else{
									Server.regPlayers.add(g.getP());
								}					
								sendToAllClients(new Game(Server.regPlayers));
								Server.arrayListToFile();
							}
							//wenn gesendetes Game-Objekt ein Array enthält wird der PCName des Users updated
							if(g.getWhat().equals("PC Name und User an Server")){
								Player p = Player.getPlayerUser(g.getA()[0]);
								p.setPCName(g.getA()[1]);
								Server.arrayListToFile();
							}if(g.getWhat().equals("spiel gestartet")){
								sendToAllClients(new Game(g.getSession(), g.getStage()));
							}if(g.getWhat().equals("sitzung erstellt")){
								sendToAllClients(new Game(g.getSession(),"sitzung erstellt"));
								Server.openSessions.add(g.getSession());
							}if(g.getWhat().equals("Player ist Sitzung beigetreten")){
								sendToAllClients(new Game(g.getSession(),g.getP()));
							}
							objectOutputStream.flush();
						}
						Server.arrayListToFile();
						socket.close();
						objectInputStream.close();
						objectOutputStream.close();
					}

				}
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void sendToClient(Game g){
		try {
			objectOutputStream.writeObject(g);
			objectOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void sendToAllClients(Game g){
		for(ObjectOutputStream oos:Server.openOutputStreams){
			try {
				oos.writeObject(g);
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}



