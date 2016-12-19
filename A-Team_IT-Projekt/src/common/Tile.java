package common;

import javafx.scene.image.*;
import java.io.Serializable;

import common.SImage;

public class Tile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3430502307470301817L;
	
	
	
	private SImage img;
	private int points;
	private String color;
	
	
	public Tile(SImage image, int points, String color){
		this.img = image;
		this.points = points;
		this.color = color;
	}

	public int getPoints(){
		return this.points;
	}
	
	public SImage getImage(){
		return this.img;
	}
	
	public String getColor(){
		return this.color;
	}
	
	
	
	
	
}
