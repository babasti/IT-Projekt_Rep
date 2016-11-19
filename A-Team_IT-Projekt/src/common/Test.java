package common;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {

	public static void main(String[] args){

		client.Client.regPlayers = new ArrayList<Player>();

		Date d1 = new Date(92,0,15);
		Date d2 = new Date(91,1,25);
		Date d3 = new Date(57,10,1);

		Player p1 = new Player("Barbara","ananas",d1);
		client.Client.regPlayers.add(p1);
		System.out.println(Player.checkUser("Barbara"));
		Player p2 = new Player("alen","fhnw",d2);
		client.Client.regPlayers.add(p2);
		System.out.println(Player.checkUser("alen"));
		Player p3 = new Player("simi","naros",d3);
		client.Client.regPlayers.add(p3);
		System.out.println(Player.checkUser("simi"));




		//		System.out.println(p1);
		//		System.out.println(p2);
		//		System.out.println(p3);
		//
		//		try{
		//			Scanner scan = new Scanner(new File("RegisteredPlayers.txt"));
		//			ArrayList<Player> regPlayers = new ArrayList<Player>();
		//
		//			while(scan.hasNextLine()){
		//				String[] next = scan.nextLine().split(":");
		//				String[] d = next[2].split("-");
		//				Date date = new Date(Integer.parseInt(d[2]), Integer.parseInt(d[1]), Integer.parseInt(d[0]));
		//				regPlayers.add(new Player(next[0], next[1], date));
		//			}
		//		}catch(Exception e){
		//		}

	}
}



