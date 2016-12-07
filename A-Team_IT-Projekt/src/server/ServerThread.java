package server;

import java.io.*;

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

public class ServerThread extends Thread implements Serializable{
	private static Socket socket = null;
	private static ObjectOutputStream objectOutputStream;
	private static ObjectInputStream objectInputStream;
	ServerThread(Socket socket){
		this.socket = socket;
	}
	
	public void run(){
		Game g;
		try{
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			while((g = (Game)objectInputStream.readObject()) != null){
				//wenn ein client arrayList der Player anfragt
				if(g.getWhat().equals("string")){
					sendToClient(new Game(Server.regPlayers));
				}
				//wenn gesendetes Game-Objekt player enthält, wird er der arraylist hinzugefügt	
				else if(g.getWhat().equals("player")){		
					Server.regPlayers.add(g.getP());
					Server.arrayListToFile();
				}
				//wenn gesendetes Game-Objekt ein Array enthält wird der PCName des Users updated
				else if(g.getWhat().equals("array")){
					Player p = Player.getPlayerUser(g.getA()[0]);
					p.setPCName(g.getA()[1]);
					Server.arrayListToFile();
				}
			}
			Server.arrayListToFile();
			socket.close();
			objectInputStream.close();
			objectOutputStream.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void sendToClient(Game g){
		try {
			objectOutputStream.writeObject(g);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



