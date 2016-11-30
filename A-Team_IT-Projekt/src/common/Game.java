package common;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game implements Serializable {
	private ArrayList<Player> al;
	private Player p;
	private String[] a;
	private String what;
	
	public Game(ArrayList<Player> al){
		this.al = al;
		what = "arrayList";
	}
	
	public ArrayList<Player> getAl(){
		return this.al;
	}
	
	public Game(Player p){
		this.p = p;
		what = "player";
	}
	
	public Player getP(){
		return this.p;
	}
	
	public Game(String[] a){
		this.a = a;
		what = "array";
	}
	
	public String[] getA(){
		return this.a;
	}
	
	public String getWhat(){
		return this.what;
	}
	

}
