package common;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2361871497549590976L;
	private String s;
	private ArrayList<Player> al;
	private Player p;
	private String[] a;
	private String what;
	private int numOfPlayers;
	
	public Game (Session session){
//		this.al = session.getPlayers();
		this.numOfPlayers = session.getNumOfPlayers();
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
