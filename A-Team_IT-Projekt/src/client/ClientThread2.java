package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import common.Game;
import common.Player;

public class ClientThread2 extends Thread{
	private static Socket socket;
	private static ObjectOutputStream objectOutputStream;
	private static ObjectInputStream objectInputStream;
	public static ArrayList<Player> regPlayers;
	private boolean running;

	ClientThread2(Socket socket){
		this.socket = socket;
		running = true;
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
				}else if(g.getWhat().equals("sitzung erstellt")){
					if(!LobbyController.sessionAlreadyExist(g.getSession().getSessionName())){
						LobbyController.offeneSitzungen.getItems().addAll(g.getSession().getSessionName());
						LobbyController.offeneSitzungenList.add(g.getSession().getSessionName());
						LobbyController.openSessions.add(g.getSession());
					}
				}else if(g.getWhat().equals("Player ist Sitzung beigetreten")){
					boolean alreadyInSession = false;
					Player[] playersInSession = g.getSession().getPlayers();
					for(Player p:playersInSession){
						if(g.getP().getUserName().equals(p.getUserName())){
							alreadyInSession = true;
						}
					}
					if(!alreadyInSession){
						int index = LobbyController.getIndexPlayerArray(playersInSession);
						playersInSession[index] = g.getP();
						g.getSession().setPlayers(playersInSession);
					}	
				}else if(g.getWhat().equals("game gestartet")){
					FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("GameBoard.fxml"));
					Pane rootPane = (Pane) fxmlloader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(rootPane));
					stage.show();

					//schliesst das alte GUI
					Stage stage1 = (Stage)LobbyController.offeneSitzungen.getScene().getWindow();
					stage1.close();
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
			Game.writeObject(objectOutputStream, g);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
