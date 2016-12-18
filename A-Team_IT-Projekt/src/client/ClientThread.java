package client;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import common.Game;
import common.Player;
import common.SStage;
import common.Session;

public class ClientThread implements Runnable, Serializable{

	private static final long serialVersionUID = 1898421210671840445L;
	private Socket socket;
	public static ArrayList<Player> regPlayers;
	//offene Sitzungen
	public static ArrayList<Session> sessionList;
	public static Session startedSession;

	ClientThread(Socket socket){
		this.socket = socket;
	}

	public void run(){
		Game g;
		Object obj;
		try{
			synchronized(this){
				sendToServer(new Game("arrayList regPlayers an Client"));
				while(true){
					//Objekte einlesen
					obj = LoginController.objectInputStream.readObject();
					if(obj instanceof Game){
						g = (Game)obj;
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
								//Player der verschickten Session werden der Session in openSessions hinzugefügt
								if(s.getSessionName().equals(g.getSession().getSessionName())){
									s.setPlayers(g.getSession().getPlayers());
								}
							}
							//LobbyController.setFehlermeldungText(g.getP().getUserName()+" ist der Sitzung "+g.getSession().getSessionName()+" beigetreten.");
						}if(g.getWhat().equals("player hat sich eingeloggt")){
							for(Player p:regPlayers){
								if(g.getP().getUserName().equals(p.getUserName())){
									p.setAlreadyLoggedIn(true);
								}
							}
						}if(g.getWhat().equals("spiel gestartet")){
							startedSession = g.getSession();
							SStage stage = g.getStage();
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
}




