package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2361871497549590976L;
	private ImageContainer imageContainer;
	private AvatarContainer avatarContainer;
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
	private String PCName;
	private int numOfPlayers;
	private Session session;

	public Game(Session session, String s){
		this.session = session;
		this.s = s;
		if(s.equals("sitzung erstellt")){
			what = "sitzung erstellt";
		}
		if(s.equals("spiel gestartet")){
			what = "spiel gestartet";
		}
		if(s.equals("sitzung ist leer")){
			what = "sitzung ist leer";
		}
		if(s.equals("spielLaden")){
			what = "spielLaden";

			imageContainer = new ImageContainer();
			avatarContainer = new AvatarContainer();
			cards = setStartMoveCards();
			startBoard = setStartTiles();
			players = session.getPlayers();
			
			for(int i = 0; i < players.length; i++){
				for(int y = 0; y < 3; y++){
					players[i].getPlayerAvatars().add(avatarContainer.getAvatars().get(0));
					avatarContainer.getAvatars().remove(0);
				}
				initPlayerCards(players[i]);
			}


			int count = 0;
			for(int x = 0; x < players.length; x++){
				players[x].setAvatarColor(players[x].getPlayerAvatars().get(count));
			}

			currentPlayer = players[0];
			currentPlayerPosition = 0;
		}
	}

	public Game(Session session, Player p, String s){
		this.session = session;
		this.p = p;
		this.s = s;
		if(s.equals("Player ist Sitzung beigetreten")){
			what = "Player ist Sitzung beigetreten";
		}if(s.equals("Player aus Sitzung ausgetreten")){
			what = "Player aus Sitzung ausgetreten";
		}
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
	
	public Game(ArrayList<Session> sessionList, String s){
		if(s.equals("arrayList openSessions an Client")){
			what = "arrayList openSessions an Client";
			this.sessionList = sessionList;
		}
	}
	
	public Game(ArrayList<Player> al, Player p, String s){
		this.al = al;
		this.p = p;
		this.s = s;
		what = "spieler hat sich registriert";
	}

	public Game(Player p, String s, String PCName){
		this.p = p;
		this.s = s;
		this.PCName = PCName;
		if(s.equals("player hat sich eingeloggt")){
			what = "player hat sich eingeloggt";
		}
	}
	
	public Game(String[] a){
		this.a = a;
		what = "PC Name und User an Server";
	}
	
	public Session getSession(){
		return this.session;
	}

	public ArrayList<Player> getAl(){
		return this.al;
	}

	public ArrayList<Session> getSessionList(){
		return this.sessionList;
	}

	public Player getP(){
		return this.p;
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

	public void setSession(Session session){
		this.session = session;
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

	public void initPlayerCards(Player player){
		for(int i = 0; i < 5; i++){
			player.getPlayerCards().add(cards.get(0));
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

	//damit der currentPlayer nach Spielzug auf den nächsten Player in der Liste
	//gesetzt wird
	public void setCurrentPlayerPosition(){
		if(currentPlayerPosition == players.length-1){
			currentPlayerPosition = 0;
		}else{
			currentPlayerPosition++;
		}
	}
	
	public void setCurrentPlayerPosition(int currentPlayerPosition){
		this.currentPlayerPosition = currentPlayerPosition;
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

	public void setStartBoard(ArrayList<Tile> board){
		this.startBoard = board;
	}
	
	public void setCards(ArrayList<Card> cards){
		this.cards = cards;
	}
	
	public void setWhat(String what){
		this.what = what;
	}

}
