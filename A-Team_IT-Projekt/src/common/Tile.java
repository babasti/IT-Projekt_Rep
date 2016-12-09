package common;

import java.io.Serializable;

import javafx.scene.image.Image;

public class Tile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3430502307470301817L;
	
	
	
	private Image img;
	private int points;
	private String color;
	
	
	
	
	
	public Tile(Image img, int points, String color){
		this.img = img;
		this.points = points;
		this.color = color;
	}

	public int getPoints(){
		return this.points;
	}
	
	public Image getImage(){
		return this.img;
	}
	
	public String getColor(){
		return this.color;
	}
	
	
	
	
	
}
