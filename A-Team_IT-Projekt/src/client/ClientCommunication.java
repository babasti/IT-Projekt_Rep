package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientCommunication {

	public static void main(String[] args) {

		try {

			Socket client = new Socket("localHost", 1234);
			System.out.println("Client wurde gestartet!");

			OutputStream out = client.getOutputStream();
			PrintWriter pw = new PrintWriter(out);

			//Client Daten empfangen
			InputStream in = client.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			pw.write("Hallo Server");
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
