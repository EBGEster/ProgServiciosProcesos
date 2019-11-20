package server;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Servidor servidor = new Servidor();
		try {
			servidor.run();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Inicio");
//		List<Tortuga> tortugas = new ArrayList<Tortuga>();
//		for (int i=0; i<30; i++) {
//			tortugas.add(new Tortuga());
//		}
//		Carrera carrera = new Carrera(tortugas);
//		carrera.comenzar();
//		carrera.esperar();
//		
//		System.out.println(Carrera.getGanador());
//		System.out.println("Fin");
	}
	
}
