package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Communication {

	public static void main(String[] args) {
		try {
			
			//startet Server
			ServerSocket server = new ServerSocket(1234);
			System.out.println("Server gestartet!");
			
			//Server wartet auf Nachrichten von Clients
			Socket client = server.accept();
			
			//Server schickt etwas an Client
			OutputStream out = client.getOutputStream();
			PrintWriter pw = new PrintWriter(out);
			
			//Client Daten empfangen
			InputStream in = client.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			//chat
			String s = null;
			
			while((s = br.readLine()) != null){
				System.out.println("Empfangen von Client:" + s);
			}
			pw.close();
			br.close();
			
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
