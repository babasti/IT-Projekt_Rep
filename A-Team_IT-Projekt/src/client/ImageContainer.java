package client;

import java.io.Serializable;
import java.util.*;

import common.*;

public class ImageContainer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5251419899527119963L;
	private String imagePath = "/resource/";
	private ArrayList<String> colors;
	private ArrayList<Card> cards;
	private HashMap<String, Tile> tiles;
	private Tile waterTile;
	private String imageFormat = ".jpg";
	
	public ImageContainer(){
		cards = new ArrayList<Card>();		
		tiles = new HashMap<String, Tile>();
		colors = new ArrayList<String>();
		waterTile = new Tile(new SImage("/resource/wasser.JPG"), 0, "water");
		
		SetColors();
		SetCards();
		SetTiles();		
	}
	
	private void SetColors() {
		colors.add("blue");
		colors.add("brown");
		colors.add("green");
		colors.add("grey");
		colors.add("pink");
		colors.add("white");
		colors.add("yellow");	
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public HashMap<String, Tile> getTiles() {
		return tiles;
	}

	public void setTiles(HashMap<String, Tile> tiles) {
		this.tiles = tiles;
	}

	public Tile getWater() {
		return waterTile;
	}


	private String upperCaseTheFirstLetter(String str){		
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<str.toCharArray().length; i++){
			char chr = str.charAt(i);
			if(i==0){				
				stringBuilder.append(Character.toUpperCase(chr));
			}else{
				stringBuilder.append(chr);
			}
		}		
		return stringBuilder.toString();		
	}
	
	public void SetCards(){		
		for(String color : colors) {
			String imagePath = this.imagePath + "card_" + upperCaseTheFirstLetter(color) + imageFormat;
		    SImage img = new SImage(imagePath);
			cards.add(new Card(color, img));
		}		
	}
	
	private void SetTiles() {
		for(String color : colors ) {		    
	    	for(int y=1; y <= 7; y++){
	    		String imagePath =  this.imagePath + color + "_" + y + imageFormat;
	    		SImage img = new SImage(imagePath);
	    		Tile tile = new Tile(img, y, color);
				tiles.put(color + y, tile);
			}		    
		}
		
//		private SImage blue1 = new SImage(new Image(getClass().getResourceAsStream("/resource/blue_1.jpg")));		
	}	
}
