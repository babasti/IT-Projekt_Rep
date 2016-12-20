package server;

import java.io.*;

import client.ClientThread;
import client.LobbyController;
import common.Game;
import common.Player;
import common.Session;

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

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class ServerThread implements Serializable, Runnable{

	private static final long serialVersionUID = 858159327570071613L;
	private static Socket socket = null;
	ServerThread(Socket socket){
		this.socket = socket;
	}

	public void run(){
		Game g;
		Object obj;
		try{
			int counter = 0;
			while(true){
				synchronized(Server.objectInputStream){
					obj = Server.objectInputStream.readObject();
					if(obj instanceof Game){
						g = (Game)obj;
						//wenn ein client arrayList der Player anfragt
						if(g.getWhat().equals("arrayList regPlayers an Client")){
							sendToClient(new Game(Server.regPlayers));
						}
						if(g.getWhat().equals("arrayList openSessions an Client")){
							sendToClient(new Game(Server.openSessions, "arrayList openSessions an Client"));
						}
						//wenn gesendetes Game-Objekt player enthält, wird er der arraylist hinzugefügt	
						if(g.getWhat().equals("player hat sich eingeloggt")){
							//wenn Benutzer sich einlogged, wird alreadyLoggedIn auf true gesetzt
							ArrayList<String> names = new ArrayList<String>();
							for(Player p:Server.regPlayers){
								names.add(p.getUserName());
							}
							//nur Login
							if(names.contains(g.getP().getUserName())){
								for(Player p:Server.regPlayers){
									if(g.getP().getUserName().equals(p.getUserName())){
										sendToAllClients(g);
										Server.arrayListToFile();
									}
								}
								//neuer Player hat sich registriert
							}else{
								Server.regPlayers.add(g.getP());
								sendToAllClients(new Game(Server.regPlayers, g.getP(), "spieler hat sich registriert"));
								Server.arrayListToFile();
							}					
						}if(g.getWhat().equals("spiel gestartet")){							
							Game game = new Game(g.getSession(), "spielLaden");
							game.setSession(g.getSession());
							sendToAllClients(game);
							Server.startedSession = null;
						}if(g.getWhat().equals("sitzung erstellt")){
							sendToAllClients(g);
							Server.openSessions.add(g.getSession());
						}if(g.getWhat().equals("Player ist Sitzung beigetreten")){
							sendToAllClients(g);
						}if(g.getWhat().equals("sitzung ist leer")){
							Session sessionToBeRemoved = null;
							for(Session session:Server.openSessions){
								if(g.getSession().getSessionName().equals(session.getSessionName())){
									sessionToBeRemoved = session;
								}
							}
							Server.openSessions.remove(sessionToBeRemoved);
							sendToAllClients(g);
						}
						if(g.getWhat().equals("Player aus Sitzung ausgetreten")){
							sendToAllClients(g);
						}
					}
				}
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {		
				Server.objectInputStream.close();
				Server.objectOutputStream.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized static void sendToClient(Game g){
		try {
			Server.objectOutputStream.writeObject(g);
			Server.objectOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public synchronized static void sendToAllClients(Game g){
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



