package common;

import java.io.Serializable;


public class SCircle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4449092372326722994L;
	
	private String circle;

	public SCircle(){
		this.circle = "Circle";
	}
	
	public String getCircle(){
		return this.circle;
	}
	
}
