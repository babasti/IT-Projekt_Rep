package server;

import java.io.*;
import java.net.*;

public class Server {
	
	public static final int PORT = 1234;
	public static int counter = 0;

	public static void main(String[] args) throws Exception{
		new Server().runServer();
	}

	public void runServer() throws Exception {
		ServerSocket serverSocket = new ServerSocket (PORT);
		System.out.println("Starting Server...");
		System.out.println("Server started at: "+serverSocket.getInetAddress());
		while(true){
			Socket socket = serverSocket.accept();
			counter++;
			System.out.println("Connection from: "+socket.getInetAddress());
			System.out.println("Client Nr : "+counter);
			new ServerThread(socket).start();
		}
		
	}
	

}
