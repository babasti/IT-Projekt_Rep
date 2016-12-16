package common;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import client.ClientThread;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2361871497549590976L;
	private String s;
	private ArrayList<Player> al;
	private ArrayList<Session> sessionList;
	private static Player[] players;
	private static ArrayList<Tile> startBoard = new ArrayList<Tile>();
	private static ArrayList<Card> cards = new ArrayList<Card>();
	private Player p;
	private String[] a;
	private String what;
	private int numOfPlayers;
	private Session session;
	@FXML
	private Button b_SpielStarten;
	private SStage stage;
	private Stage oldStage;

	public Game (Session session, SStage stage, String s){
		this.session = session;
		this.stage = stage;
		this.s = s;
		what = "spiel gestartet";
		//
		//		//Game wird gestartet				
		//		try {
		//			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("GameBoard.fxml"));
		//			Pane rootPane = (Pane) fxmlloader.load();
		//			stage = new SStage();
		//			stage.setScene(new Scene(rootPane));
		//
		//			//schliesst das alte GUI
		//			stage1.close();
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
	}

	public Game(Session session, SStage stage){
		this.session = session;
		this.stage = stage;
		what = "spiel gestartet";
	}

	public Button getButton(){
		return this.b_SpielStarten;
	}

	public Session getSession(){
		return this.session;
	}

	public Game(Session session, String s){
		this.session = session;
		this.s = s;
		if(s.equals("sitzung erstellt")){
			what = "sitzung erstellt";
		}
		if(s.equals("gestartete Sitzung")){
			what = "gestartete Sitzung";
		}
//		if(s.equals("spiel gestartet")){
//			what = "spiel gestartet";
//			try {
//				if(ClientThread.startedSession != null){
//					FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/client/GameBoard.fxml"));
//					Pane rootPane = (Pane)fxmlloader.load();
//					SStage stage = new SStage();
//					stage.setScene(new Scene(rootPane));
//					this.stage = stage;
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//
//			}
//
//		}
	}

	public Game(Session session, Player p){
		this.session = session;
		this.p = p;
		what = "Player ist Sitzung beigetreten";
	}

	public Game(String s){
		this.s = s;
		if(s.equals("arrayList regPlayers an Client")){
			what = "arrayList regPlayers an Client";
		}if(s.equals("arrayList openSessions an Client")){
			what = "arrayList openSessions an Client";
		}
	}

	public Game(ArrayList<Player> al){
		this.al = al;
		what = "arrayList regPlayers von Server";
	}

	public ArrayList<Player> getAl(){
		return this.al;
	}

	public Game(ArrayList<Session> sessionList, String s){
		if(s.equals("arrayList openSessions an Client")){
			what = "arrayList openSessions an Client";
			this.sessionList = sessionList;
		}
	}

	public ArrayList<Session> getSessionList(){
		return this.sessionList;
	}

	public Game(Player p){
		this.p = p;
		what = "Player an Server";
	}

	public Game(Player p, String s){
		this.p = p;
		this.s = s;
		if(s.equals("player hat sich eingeloggt")){
			what = "player hat sich eingeloggt";
		}
	}

	public Player getP(){
		return this.p;
	}

	public Game(String[] a){
		this.a = a;
		what = "PC Name und User an Server";
	}

	public String[] getA(){
		return this.a;
	}

	public String getWhat(){
		return this.what;
	}

	public static Player[] getPlayers(){
		return players;
	}

	public SStage getStage(){
		return stage;
	}

	public Stage getOldStage(){
		return this.oldStage;
	}

	public static void setStartBoard(ArrayList<Tile> startBoard){
		Game.startBoard = startBoard;
	}

	public static void setCards(ArrayList<Card> cards){
		Game.cards = cards;
	}


}
