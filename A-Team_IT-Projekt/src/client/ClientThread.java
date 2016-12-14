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
import common.Session;

public class ClientThread extends Thread implements Serializable{
	private static Socket socket;
	private static ObjectOutputStream objectOutputStream;
	private static ObjectInputStream objectInputStream;
	public static ArrayList<Player> regPlayers;
	public static ArrayList<Session> sessionList;

	ClientThread(Socket socket){
		this.socket = socket;
	}

	public void run(){
		Game g;
		try{
			synchronized(objectOutputStream = new ObjectOutputStream(socket.getOutputStream())){
				synchronized(objectInputStream = new ObjectInputStream(socket.getInputStream())){
					sendToServer(new Game("arrayList regPlayers an Client"));
					while(true){
						while((g = (Game)objectInputStream.readObject()) != null){
							if(g.getWhat().equals("arrayList regPlayers von Server")){
								regPlayers = g.getAl();
							}if(g.getWhat().equals("sitzung erstellt")){
								if(!LobbyController.sessionAlreadyExist(g.getSession().getSessionName())){
									LobbyController.offeneSitzungen.getItems().addAll(g.getSession().getSessionName());
									LobbyController.offeneSitzungenList.add(g.getSession().getSessionName());
									LobbyController.openSessions.add(g.getSession());
								}
							}if(g.getWhat().equals("Player ist Sitzung beigetreten")){
								for(Session s:LobbyController.openSessions){
									if(s.getSessionName().equals(g.getSession().getSessionName())){
										s.setPlayers(g.getSession().getPlayers());
									}
								}
								g.getSession().getSessionName();
								LobbyController.offeneSitzungen.getItems();
								Player[] playersInSession = g.getSession().getPlayers();
								g.getSession().setPlayers(playersInSession);
								LobbyController.fehlermeldung.setText(g.getP().getUserName()+" ist der Sitzung "+g.getSession().getSessionName()+" beigetreten.");
							}if(g.getWhat().equals("spiel gestartet")){
								Stage stage = g.getStage();
								stage.show();
								//schliesst das alte GUI
								Stage stage1 = (Stage)LobbyController.offeneSitzungen.getScene().getWindow();
								stage1.close();
							}//Wenn Lobby gestartet wird, erhält Client arrayList mit den offenen Sitzungen
							 //um diese in der ListView anzuzeigen
							if(g.getWhat().equals("arrayList openSessions an Client")){
								sessionList = g.getSessionList();
								for(Session s:sessionList){
									LobbyController.offeneSitzungen.getItems().addAll(s.getSessionName());
									LobbyController.offeneSitzungenList.add(s.getSessionName());
									LobbyController.openSessions.add(s);
								}
							}
							objectOutputStream.flush();
						}
						socket.close();
						objectInputStream.close();
						objectOutputStream.close();

					}
				}
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
}


