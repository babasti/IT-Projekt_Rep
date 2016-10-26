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
		
		//Player, der Session erstellt hat, wird an erster Stelle
		//zum Player-Array hinzugefügt
		for(Player p:Player.registeredPlayers){
			if(p.getPCName().equals(System.getProperty("user.name"))){
				players[0] = p;
			}
		}
	}

	public void startGame(Player[] players){
		Game game = new Game(players);
		//Button "Session starten" muss disabled werden, wenn 
		//players[0] und User nicht übereinstimmen
	}


}
