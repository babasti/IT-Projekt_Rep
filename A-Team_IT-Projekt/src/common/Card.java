package common;

import javafx.scene.image.Image;

public class Card{
	
	private String color;
	private Image img;
	
	public Card(String color, Image img){
		this.color = color;
		this.img = img;
	}
	
	public String getColor(){
		return this.color;
	}
	
	public Image getImage(){
		return this.img;
	}
	
	public String toString(){
		System.out.println(color);
		return this.color;
	}	
}