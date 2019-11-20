package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	private final int PUERTO = 2000;
	private final String HOST = "localhost";
	private Socket socket;
	private PrintWriter output;
	private BufferedReader input;
	
	public Cliente() throws IOException {
		socket = new Socket(HOST, PUERTO);
		output = new PrintWriter(socket.getOutputStream(), true);
		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	
	public void add(String nombre, int dorsal) throws IOException {
		
		output.println("ADD " + nombre + " " + String.valueOf(dorsal));
	}
	
	public void show() throws IOException {
		output.println("SHOW");
	}
	
	public void delete(int posicion) throws IOException {
		output.println("DELETE " + posicion);
	}
	
	public void startRace() throws IOException {
		output.println("START ");
	}
	
	public void salir() throws IOException {
		output.println("CLOSE " );
	}
	
	public String leer() throws IOException {
		return input.readLine();
		
	}
	
}
