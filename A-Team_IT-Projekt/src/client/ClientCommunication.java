package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientCommunication implements Serializable{
	String IP;
	int port;
	Object data;
	
	public static void main(String args[]){
		
	}

	public static void sendToServer(String IP, int port, Object data){


		try {
			Socket client = new Socket(IP, port);

			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			PrintWriter pw = new PrintWriter(out);

			//Client Daten empfangen
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			pw.print(data);
			pw.flush();

			pw.close();
			br.close();


		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}




}


