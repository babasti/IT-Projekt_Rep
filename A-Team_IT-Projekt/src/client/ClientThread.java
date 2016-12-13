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

public class ClientThread extends Thread{
	private static Socket socket;
	private static ObjectOutputStream objectOutputStream;
	private static ObjectInputStream objectInputStream;
	public static ArrayList<Player> regPlayers;
	private boolean running;

	ClientThread(Socket socket){
		this.socket = socket;
		running = true;
	}

	public void run(){
		while(running)
			try{
				objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
				objectInputStream = new ObjectInputStream(socket.getInputStream());
				sendToServer(new Game("ich brauche die Arraylist"));

				while(running){
					receiveMessage();
				}

			}catch(Exception e){
				e.printStackTrace();
			}
	}

	//sendet Objekt an Server
	public static void sendToServer(Game g){
		try {
			ClientThread.objectOutputStream.writeObject(g);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void receiveMessage() throws IOException{
		try{
			Game g = (Game) objectInputStream.readObject();
			if(g.getWhat().equals("arrayList regPlayers von Server")){
				regPlayers = g.getAl();
			}else if(g.getWhat().equals("sitzung erstellt")){
				if(!LobbyController.sessionAlreadyExist(g.getSession().getSessionName())){
					LobbyController.offeneSitzungen.getItems().addAll(g.getSession().getSessionName());
					LobbyController.offeneSitzungenList.add(g.getSession().getSessionName());
					LobbyController.openSessions.add(g.getSession());
				}
			}else if(g.getWhat().equals("Player ist Sitzung beigetreten")){
				ArrayList<Player> playersInSession = g.getSession().getPlayersList();
				playersInSession.add(g.getP());
				g.getSession().setPlayersList(playersInSession);	
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
		}catch(Exception e){
			running = false;
			socket.close();
			objectInputStream.close();
			objectOutputStream.close();
			e.printStackTrace();
		}
	}
}


