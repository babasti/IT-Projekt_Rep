package common;

import java.io.Serializable;

public class Avatar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1888238068864877584L;
	
	private String color;
	private SCircle circle;
	
	public Avatar(String color, SCircle circle){
		this.color = color;
		this.circle = circle;
	}

	public String getColor() {
		return color;
	}


	public SCircle getCircle() {
		return circle;
	}

}
