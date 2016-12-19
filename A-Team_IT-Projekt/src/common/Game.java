package common;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import client.Client;
import client.ClientThread;
import client.ImageContainer;
import javafx.application.Platform;
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
	private ImageContainer imageContainer;
	private static Player[] players;
	private ArrayList<Tile> startBoard;
	private ArrayList<Card> cards;
	private ArrayList<Tile> proformaStartGameBoard;
	private Player currentPlayer;
	private int currentPlayerPosition;
	
	private String s;
	private ArrayList<Player> al;
	private ArrayList<Session> sessionList;
	private Player p;
	private String[] a;
	private String what;
	private int numOfPlayers;
	private Session session;

//
//	public Game (Session session, SStage stage, String s){
//		this.session = session;
//		this.s = s;
//		what = "spiel gestartet";
//	}


	public Session getSession(){
		return this.session;
	}

	public Game(Session session, String s){
		this.session = session;
		this.s = s;
		if(s.equals("sitzung erstellt")){
			what = "sitzung erstellt";
		}
		if(s.equals("spiel gestartet")){
			what = "spiel gestartet";
		}
		if(s.equals("spielLaden")){
			what = "spielLaden";
			
		imageContainer = new ImageContainer();
		cards = setStartMoveCards();
		startBoard = setStartTiles();
		players = session.getPlayers();
		currentPlayer = players[0];
		
		currentPlayerPosition = 0;
			
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

	public Player[] getPlayers(){
		return players;
	}

	
	public ArrayList<Card> setStartMoveCards(){

		ArrayList<Card> startMoveCards = new ArrayList<Card>(initCardArray());
		ArrayList<Card> proformaCards = new ArrayList<Card>(initCardArray());

		Random rand = new Random();
		int count = 105;

		for (int i = 0; i < startMoveCards.size(); i++){
			int x = rand.nextInt(count);
			startMoveCards.set(i, proformaCards.get(x));
			proformaCards.remove(x);
			count--;
		}
		return startMoveCards;
	}

	public ArrayList<Card> initCardArray(){
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<Card> tempCards = cardArrayToUse();

		int count = 0;


		for(int i = 0; i < tempCards.size(); i++){
			for(int f = 0; f <15; f++){
				cards.add((Card) tempCards.get(count));
			}
			count++;
		}
		return cards;

	}

	public ArrayList<Card> cardArrayToUse(){
		ArrayList<Card> cards = new ArrayList<Card>();
		for(Card card : imageContainer.getCards()) {
			cards.add(card);
		}
		return cards;
	}

	public void initPlayerCards(ArrayList<Card> cardss, Player player){
		for(int i = 0; i < 5; i++){
			player.playerCards.add(cards.get(0));
			cards.remove(0);
		}
	}
	
	public ArrayList<Tile> setStartTiles(){
		ArrayList<Tile> tileBoard = new ArrayList<Tile>(setTiles());
		ArrayList<Tile> proformaList = new ArrayList<Tile>(setTiles());

		Random rand = new Random();
		int count = 49;

		for (int i=0; i < tileBoard.size(); i++){
			int x = rand.nextInt(count);
			tileBoard.set(i, proformaList.get(x));
			proformaList.remove(x);
			count--;
		}
		return tileBoard;
	}
	
	public ArrayList<Tile> setTiles(){
		proformaStartGameBoard = new ArrayList<Tile>();
		proformaStartGameBoard.add(imageContainer.getWater());
		
		ArrayList<Tile> startGameBoard = new ArrayList<Tile>();
		for(Tile value : imageContainer.getTiles().values()) {
			startGameBoard.add(value);
		}
		return startGameBoard;
	}
	
	public ArrayList<Card> getCards(){
		return cards;
	}
	
	public Player getCurrentPlayer(){
		return currentPlayer;
	}
	
	//damit der currentPlayer nach Spielzug auf den nÃ¤chsten Player in der Liste
	//gesetzt wird
	public void setCurrentPlayerPosition(){
		if(currentPlayerPosition == players.length-1){
			currentPlayerPosition = 0;
		}else{
			currentPlayerPosition++;
		}
	}
	
	public void setCurrentPlayer(Player player){
		currentPlayer = player;
	}
	
	public ArrayList<Tile> getProformaStartGameBoard(){
		return proformaStartGameBoard;
	}

	public ArrayList<Tile> getStartBoard(){
		return startBoard;
	}
	
	public void setSession(Session session){
		this.session = session;
	}
	
	public static void showGame(){
		Platform.runLater(new Runnable(){
			public void run(){
				Client.loadGame();
			}
		});	
	}
}
