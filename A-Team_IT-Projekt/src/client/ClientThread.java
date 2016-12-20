package client;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import common.Game;
import common.Player;
import common.Session;

public class ClientThread implements Runnable, Serializable{

	private static final long serialVersionUID = 1898421210671840445L;
	private Socket socket;
	public static ArrayList<Player> regPlayers;
	//offene Sitzungen
	public static ArrayList<Session> sessionList;
	public static Session startedSession;
	private static Game game;

	ClientThread(Socket socket){
		this.socket = socket;
	}

	public void run(){
		Object obj;
		try{
			synchronized(this){
				sendToServer(new Game("arrayList regPlayers an Client"));
				while(true){
					//Objekte einlesen
					obj = LoginController.objectInputStream.readObject();
					if(obj instanceof Game){
						game = (Game)obj;
						if(game.getWhat().equals("arrayList regPlayers von Server")){
							regPlayers = game.getAl();
						}if(game.getWhat().equals("sitzung erstellt")){
							if(!LobbyController.sessionAlreadyExist(game.getSession().getSessionName())){
								LobbyController.offeneSitzungen.getItems().addAll(game.getSession().getSessionName());
								LobbyController.offeneSitzungenList.add(game.getSession().getSessionName());
								LobbyController.openSessions.add(game.getSession());
							}
						}if(game.getWhat().equals("Player ist Sitzung beigetreten")){
							for(Session s:LobbyController.openSessions){
								//Player der verschickten Session werden der Session in openSessions hinzugefügt
								if(s.getSessionName().equals(game.getSession().getSessionName())){
									s.setPlayers(game.getSession().getPlayers());
								}
							}
							//LobbyController.setFehlermeldungText(g.getP().getUserName()+" ist der Sitzung "+g.getSession().getSessionName()+" beigetreten.");
						}if(game.getWhat().equals("player hat sich eingeloggt")){
							for(Player p:regPlayers){
								if(game.getP().getUserName().equals(p.getUserName())){
									p.setAlreadyLoggedIn(true);
								}
							}
						}if(game.getWhat().equals("spielLaden")){
							startedSession = game.getSession();

							GameController.showGame();

							//schliesst das alte GUI
							Platform.runLater(new Runnable(){
								public void run(){
									Stage stage1 = (Stage)LobbyController.offeneSitzungen.getScene().getWindow();
									stage1.close();
								}
							});
							//schliesst das alte GUI
						
						}
						if(game.getWhat().equals("spielzugBeendet")){
							updateGame();
						}
						
						//Wenn Lobby gestartet wird, erhält Client arrayList mit den offenen Sitzungen
						//um diese in der ListView anzuzeigen
						if(game.getWhat().equals("arrayList openSessions an Client")){
							sessionList = game.getSessionList();
							for(Session s:sessionList){
								LobbyController.offeneSitzungen.getItems().addAll(s.getSessionName());
								LobbyController.offeneSitzungenList.add(s.getSessionName());
								LobbyController.openSessions.add(s);
							}
						}
					}
					//									socket.close();
					//									objectInputStream.close();
					//									objectOutputStream.close();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	//sendet Objekt an Server
	public synchronized static void sendToServer(Game g){
		try {
			LoginController.objectOutputStream.writeObject(g);
			LoginController.objectOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Game getGame(){
		return game;
	}
}




