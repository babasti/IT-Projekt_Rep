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

	public void run(){
		//common.Game game = null;
		try{
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
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
