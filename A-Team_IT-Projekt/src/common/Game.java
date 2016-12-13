package common;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

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
	private String s;
	private ArrayList<Player> al;
	private static Player[] players;
	private Player p;
	private String[] a;
	private String what;
	private static int numOfPlayers;
	private Session session;
	@FXML
	private Button b_SpielStarten;

	public Game (Session session, Button b){
		this.b_SpielStarten = b;
		this.session = session;

		//Game wird gestartet				
		try {
			FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("GameBoard.fxml"));
			Pane rootPane = (Pane) fxmlloader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(rootPane));
			stage.show();

			//schliesst das alte GUI
			Stage stage1 = (Stage)b_SpielStarten.getScene().getWindow();
			stage1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//Nachricht, dass Game gestartet wurde vom Sitzungsersteller
	public Game(Session session){
		this.session = session;
		this.players = session.getPlayers();
		this.numOfPlayers = session.getNumOfPlayers();
		what = "game gestartet";
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
		if(s.equals("spiel gestartet")){
			what = "spiel gestartet";
		}
		if(s.equals("Player ist Sitzung beigetreten")){
			what = "Player ist Sitzung beigetreten";
			
		}
	}

	public Game(Session session, Player p){
		this.session = session;
		this.p = p;
		what = "Player ist Sitzung beigetreten";
	}

	public Game(String s){
		this.s = s;
		what = "arrayList regPlayers an Client";
	}

	public Game(ArrayList<Player> al){
		this.al = al;
		what = "arrayList regPlayers von Server";
	}

	public ArrayList<Player> getAl(){
		return this.al;
	}

	public Game(Player p){
		this.p = p;
		what = "Player an Server";
	}

	public void setP(Player p){
		this.p = p;
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
	
	public static int getNumOfPlayers(){
		return numOfPlayers;
	}
	
	public static void writeObject(java.io.ObjectOutputStream stream, Game game) throws IOException{
		stream.writeObject((Game) game);
	}
	
	public static Game readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException{
		Game g = (Game) stream.readObject();
		return g;
	}
}
