package client;

import java.io.InputStream;
import java.net.URL;



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
}
