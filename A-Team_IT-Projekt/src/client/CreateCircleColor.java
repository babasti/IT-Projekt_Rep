package client;

import javafx.scene.paint.Color;

public class CreateCircleColor {
	
	private static CreateCircleColor instance;
	
	public static CreateCircleColor getCreateCircleColor(){
		if(instance == null){
			return new CreateCircleColor();
		}
		return instance;
	}
	
	private CreateCircleColor(){
		
	}
	
	public Color createColor(String color){
		return Color.valueOf(color);
	}

}
