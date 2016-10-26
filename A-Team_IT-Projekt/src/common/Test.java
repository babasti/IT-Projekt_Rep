package common;


import java.util.Date;

public class Test {

	public static void main(String[] args){
		System.out.println(System.getProperty("user.name"));
		@SuppressWarnings("deprecation")
		Date d = new Date(92,0,15);
		Player b = new Player("babs",d,"fhnw");
		Player c = new Player("alen",d,"alen");
		System.out.println(Player.registeredPlayers.size());
		
		
		System.out.println(b);
		
		System.out.println(Player.registeredPlayers);

		Player.registeredPlayers.clear();
		
		for(int i=0;i<Player.registeredPlayers.size(); i++){
			System.out.println(Player.registeredPlayers.get(i));
		}
		
	}

}

