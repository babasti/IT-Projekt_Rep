package common;

public class Tile {
	
	private String color;
	private int points;
	
	public Tile(String color, int points){
		this.color = color;
		this.points = points;
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public String getColor(){
		return this.color;
	}
	
}
