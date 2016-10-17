package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.scene.control.Button;

public class ServerCommunication implements Serializable{

	public static void main(String[] args) {
		try {

			//startet Server
			ServerSocket server = new ServerSocket(1234);
			System.out.println("Server gestartet!");

			//Server wartet auf Nachrichten von Clients
			Socket client = server.accept();

			//Server schickt etwas an Client
			ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
			PrintWriter pw = new PrintWriter(out);

			//Client Daten empfangen
			ObjectInputStream in = new ObjectInputStream(client.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			System.out.println("banana");

			Button b = (Button)in.readObject();
			System.out.println(b.getText());
			b.setText(String.valueOf((Integer.parseInt(b.getText())+1)));
			System.out.println(b.getText());

			pw.close();


		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}

	}

}
