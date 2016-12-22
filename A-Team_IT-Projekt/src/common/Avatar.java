package common;

import java.io.Serializable;

import client.CreateAvatarID;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Avatar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1888238068864877584L;
	
	private String color;
	transient private Circle circle;
	private int avatarID;
	public static int count = 0;
	
	public Avatar(String color){
		this.color = color;
		this.setAvatarID(count);
	}

	public String getColor() {
		return color;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public int getAvatarID() {
		return avatarID;
	}

	public void setAvatarID(int avatarID) {
		this.avatarID = avatarID;
	}

	public int getCount() {
		return count;
	}

	public static void setCount() {
		count++;
	}
	
	
}
