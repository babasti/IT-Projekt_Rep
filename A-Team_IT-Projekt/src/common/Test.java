package common;


import java.util.Date;

public class Test {

	public static void main(String[] args){
		Date d1 = new Date(92,0,15);
		Date d2 = new Date(91,1,25);
		Date d3 = new Date(57,10,1);
		
		Player p1 = new Player("Barbara","ananas",d1);
		Player p2 = new Player("alen","fhnw",d2);
		Player p3 = new Player("simi","naros",d3);
		
		System.out.println(Player.getPassword("Barbara"));
		System.out.println(p2);
		System.out.println(p3);
	}

}

