package common;

import java.io.Serializable;

import javafx.scene.image.*;


import javax.swing.ImageIcon;


public class SImage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3999766578638350771L;
	
	private String imagePath;
	
	
	public SImage(String imagePath){		
		this.imagePath = imagePath;
	}
	
	public String getimagePath(){
		return this.imagePath;
	}
	
}
