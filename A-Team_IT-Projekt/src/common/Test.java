package common;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;

public class Test {

	public static void main(String[] args){

		Date d1 = new Date(92,0,15);
		Date d2 = new Date(91,1,25);
		Date d3 = new Date(57,10,1);

		Player p1 = new Player("Barbara","ananas",d1);
		System.out.println(Player.checkUser("Barbara"));
		Player p2 = new Player("alen","fhnw",d2);
		System.out.println(Player.checkUser("alen"));
		Player p3 = new Player("simi","naros",d3);
		System.out.println(Player.checkUser("simi"));

		//		System.out.println(p1);
		//		System.out.println(p2);
		//		System.out.println(p3);
	}

}

