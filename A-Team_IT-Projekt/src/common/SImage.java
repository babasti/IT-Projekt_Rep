package common;

import java.io.InputStream;
import java.io.Serializable;

import javafx.scene.image.Image;

public class SImage extends Image implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3999766578638350771L;

	public SImage(InputStream inputStream){
		super(inputStream);
	}
}
