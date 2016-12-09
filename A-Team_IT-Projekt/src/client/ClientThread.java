package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import common.Game;
import common.Player;

public class ClientThread extends Thread implements Serializable{
	private static Socket socket;
	private static ObjectOutputStream objectOutputStream;
	private static ObjectInputStream objectInputStream;
	public static ArrayList<Player> regPlayers;

	ClientThread(Socket socket){
		this.socket = socket;
	}

	public void run(){
		Game g;
		try{
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectInputStream = new ObjectInputStream(socket.getInputStream());
			sendToServer(new Game("ich brauche die Arraylist"));

			while((g = (Game)objectInputStream.readObject()) != null){
				if(g.getWhat().equals("arrayList regPlayers von Server")){
					regPlayers = g.getAl();
				}else if(true){
					//andere nachrichten die client empfangen kann
				}
			}
			socket.close();
			objectInputStream.close();
			objectOutputStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//sendet Objekt an Server
	public static void sendToServer(Game g){
		try {
			objectOutputStream.writeObject(g);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
