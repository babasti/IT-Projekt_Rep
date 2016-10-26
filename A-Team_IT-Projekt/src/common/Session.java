package common;

public class Session {

	private Game game;
	private int numOfPlayers;
	private Player[] players;
	private String sessionName;

	public Session(String sessionName, int numOfPlayers){
		this.sessionName = sessionName;
		this.numOfPlayers = numOfPlayers;
		players = new Player[numOfPlayers];
		players[0] = 
	}
	
	public void startGame(Player[] players){
		Game game = new Game(players);
		//if current playername != player[0] disable button
	}
	
	
}
