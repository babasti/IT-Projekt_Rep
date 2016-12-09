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
	private static final long serialVersionUID = -2361871497549590976L;
	private String s;
	private ArrayList<Player> al;
	private Player[] players;
	private Player p;
	private String[] a;
	private String what;
	private int numOfPlayers;
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
	
	public Game(Session session){
		this.session = session;
		this.players = session.getPlayers();
		this.numOfPlayers = session.getNumOfPlayers();
		what = "game gestartet";
	}
	
	public Session getSession(){
		return this.session;
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


}
