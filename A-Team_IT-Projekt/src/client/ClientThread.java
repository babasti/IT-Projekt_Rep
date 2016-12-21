package client;

import java.io.IOException;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;

import javafx.application.Platform;
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
	private static int id;

	ClientThread(Socket socket){
		this.socket = socket;
	}

	public void run(){
		Object obj;
		try{
			sendToServer(new Game("arrayList regPlayers an Client"));
			while(true){
				synchronized(LoginController.objectInputStream){
					//Objekte einlesen
					obj = LoginController.objectInputStream.readObject();
					if(obj instanceof Game){
						game = (Game)obj;
						if(game.getWhat().equals("arrayList regPlayers von Server")){
							regPlayers = game.getAl();
						}
						if(game.getWhat().equals("player hat sich eingeloggt")){
							for(Player player:regPlayers){
								if(player.getUserName().equals(game.getP().getUserName())){
									player.setClientID(game.getP().getClientID());
								}
							}
						}
						if(game.getWhat().equals("client id")){
							this.id = game.getId();
						}if(game.getWhat().equals("sitzung erstellt")){
							if(!LobbyController.sessionAlreadyExist(game.getSession().getSessionName())){
								// hier fehler wegen clienthread und gui
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
							Platform.runLater(new Runnable(){
								public void run(){
									LobbyController.fehlermeldung.setText(game.getP().getUserName()+" ist der Sitzung "+game.getSession().getSessionName()+" beigetreten.");
								}
							});
						}if(game.getWhat().equals("spieler hat sich registriert")){
							regPlayers.add(game.getP());
						}
						if(game.getWhat().equals("spielLaden")){
							startedSession = game.getSession();

							GameController.showGame();

							//schliesst das alte GUI
							Platform.runLater(new Runnable(){
								public void run(){
									Stage stage1 = (Stage)LobbyController.offeneSitzungen.getScene().getWindow();
									stage1.close();
								}
							});

						}
						if(game.getWhat().equals("spielzugBeendet")){
							GameController.updateGame(game);

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
						//wenn Sitzung leer ist, wird sie aus der listview gelöscht
						if(game.getWhat().equals("sitzung ist leer")){
							String string = null;
							for (int i = 0; i < LobbyController.offeneSitzungenList.size(); i++){
								if(LobbyController.offeneSitzungenList.get(i).equals(game.getSession().getSessionName())){
									string = LobbyController.offeneSitzungenList.get(i);
								}
							}
							//wird hier nochmals übergeben, da stringToBeRemoved final sein muss
							final String stringToBeRemoved = string;
							Platform.runLater(new Runnable(){
								public void run(){
									LobbyController.offeneSitzungenList.remove(stringToBeRemoved);
								}
							});
							// Session aus ArrayList <Session> openSessions löschen
							Session sessionToBeRemoved = null;
							for(int b = 0; b < LobbyController.openSessions.size(); b++){
								if(LobbyController.openSessions.get(b).getSessionName().equals(game.getSession().getSessionName())){
									sessionToBeRemoved = LobbyController.openSessions.get(b);
								}
							}
							LobbyController.openSessions.remove(sessionToBeRemoved);
							//Item aus ListView <String> offeneSitzungen löschen
							for (int c = 0; c < LobbyController.offeneSitzungen.getItems().size();c++){
								if (LobbyController.offeneSitzungen.getItems().get(c).equals(game.getSession().getSessionName())){
									string = LobbyController.offeneSitzungen.getItems().get(c);
								}
							}
							final String toBeRemoved = string;
							Platform.runLater(new Runnable(){
								public void run(){
									LobbyController.offeneSitzungen.getItems().remove(toBeRemoved);
								}
							});
						}
						if(game.getWhat().equals("Player aus Sitzung ausgetreten")){
							for(Session session:LobbyController.openSessions){
								if(session.getSessionName().equals(game.getSession().getSessionName())){
									session.setPlayers(game.getSession().getPlayers());
								}
							}
							Platform.runLater(new Runnable(){
								public void run(){
									LobbyController.fehlermeldung.setText(game.getP().getUserName()+" ist aus der Sitzung "+game.getSession().getSessionName()+" ausgetreten.");
								}
							});
						}
					}
					//socket.close();
					//objectInputStream.close();
					//objectOutputStream.close();
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

	public static int getId(){
		return id;
	}

}




