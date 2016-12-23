package client;

import java.net.URL;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;



public class ResourceProvider {
	
	private static ResourceProvider instance;
	
	public static ResourceProvider getResourceProvider(){
		if(instance == null){
			return new ResourceProvider();
		}
		return instance;
	}
	
	private ResourceProvider(){}
	
	public URL getResource(String path){
		return getClass().getResource(path);
	}
	
	public Stage getButtonStage(Label label){
		return (Stage)label.getScene().getWindow();
	}
}
