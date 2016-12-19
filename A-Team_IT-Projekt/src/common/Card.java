package common;

import java.io.Serializable;

import javafx.scene.image.*;
import common.SImage;

public class Card implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7184891939583129249L;
	private String color;
	private SImage img;
	
	public Card(String color, SImage image){
		this.color = color;
		this.img = image;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public SImage getImage(){
		return this.img;
	}
	
	public String toString(){
		System.out.println(color);
		return this.color;
	}	
}