package common;

import java.io.Serializable;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Avatar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1888238068864877584L;
	
	private String color;
	transient private Circle circle;
	
	public Avatar(String color){		
		this.color = color;
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
	
	
}
