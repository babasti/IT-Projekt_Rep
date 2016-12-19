package client;

import java.io.InputStream;



public class FileProvider {
	
	private static FileProvider instance;
	
	public static FileProvider getFileProvider(){
		if(instance == null){
			return new FileProvider();
		}
		return instance;
	}
	
	private FileProvider(){}
	
	public InputStream getFile(String path){
		return getClass().getResourceAsStream(path);
	}
}
