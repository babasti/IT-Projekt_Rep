package common;

import java.io.Serializable;

public class Avatar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1888238068864877584L;
	
	private String color;
	
	public Avatar(String color){
		this.color = color;
	}

	public String getColor() {
		return color;
	}
	
	
}
