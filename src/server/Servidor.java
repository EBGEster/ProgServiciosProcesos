package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Servidor {
	
	private List<Tortuga> tortugas = new ArrayList<Tortuga>();
	private boolean conexion = true;

	public void run() throws IOException {
		int port = 2000;
		String respuesta = "";
		// Acepta conexiones en el puerto 'port'
		ServerSocket serverSocket = new ServerSocket(port);
		do {
			Socket socket = serverSocket.accept();
			
			// Leer datos entrada
			InputStream input = socket.getInputStream();
			BufferedReader streamReader = new BufferedReader(new InputStreamReader(input));
			//System.out.println(streamReader.readLine());
			String datos = streamReader.readLine(); 
			//System.out.println(datos);
			Scanner sc = new Scanner(datos);
			String operacion = sc.next();
			
			switch (operacion) {
			case "ADD":
				String nombre = sc.next();
				int dorsal = sc.nextInt();
				addTortuga(nombre, dorsal);
				respuesta = "Tortuga creada con éxito";
				break;
			case "SHOW":
				respuesta = "Las tortugas existentes son: " + showTortuga();
				showTortuga();
				break;
			case "DELETE":
				int posicion = sc.nextInt() - 1;
				deleteTortuga(posicion);
				respuesta = "Se ha eliminado la tortuga";
				break;
			case "START":
				startRace();
				respuesta = "La tortuga ganadora es: " + Carrera.getGanador();
				break;
			case "CLOSE":
				respuesta = "Conexión finalizada";
				conexion = false;
				break;
			default:
				break;	
			}
			sc.close();
			
			
			// Escribir datos salida
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			writer.println(respuesta);
			
			
			
		}while(conexion);
		
		serverSocket.close();
	}
	
	
	private boolean addTortuga(String nombre, int dorsal) {
		
		Tortuga tortuga = new Tortuga(nombre, dorsal);
		if ( !tortugas.contains(tortuga)) {
			
			return tortugas.add(tortuga);	
		}
		return false;
	} 
	
	private String showTortuga() {
		String lasTortugas = "";	
		Iterator<Tortuga> it = tortugas.listIterator();
		while(it.hasNext())
			lasTortugas += (it.next());
		return lasTortugas;
	}
	
	private void startRace() {
		Carrera carrera = new Carrera(tortugas);
		carrera.comenzar();
		carrera.esperar();
		
		System.out.println("La tortuga ganadora es: " + Carrera.getGanador());
		System.out.println("Fin");
	}
	
	private void deleteTortuga(int posicion) {
		
		tortugas.remove(posicion);
	}
}
