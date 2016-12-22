package client;

import common.Avatar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class CreateCircle {
	
	private static CreateCircle instance;
	
	public static CreateCircle getCreateCircle(){
		if(instance == null){
			return new CreateCircle();
		}
		return instance;
	}
	
	private CreateCircle(){
		
	}
	
	public Circle createCircle(Avatar avatar){
		Circle circle = new Circle();
		circle.setRadius(10);
		circle.setStroke(Color.BLACK);
		circle.setVisible(true);
		circle.toFront();
		circle.setFill(CreateCircleColor.getCreateCircleColor().createColor(avatar.getColor()));
		circle.setId(String.valueOf(avatar.getAvatarID()));
		return circle;
	}

}