package common;

import java.io.InputStream;
import java.io.Serializable;

import javafx.scene.image.Image;

public class SImage extends Image implements Serializable{

	public SImage(InputStream inputStream){
		super(inputStream);
	}
}
