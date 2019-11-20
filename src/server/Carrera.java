package server;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

	private List<Tortuga> tortugas;
	private List<Thread> hilosTortuga;
	private static Tortuga ganador;
	
	public Carrera(List<Tortuga> tortugas) {
		this.tortugas = tortugas;
		Carrera.ganador = null;
	}
	
	public void comenzar() {
		hilosTortuga = new ArrayList<Thread>();
		for (Tortuga t: tortugas) {
			System.out.println("Creando hilo tortuga " + t);
			hilosTortuga.add(new Thread(t));
		}
		for (Thread th: hilosTortuga) {
			th.start();
		}
	}
	
	public void esperar() {
		try {
			for (Thread t: hilosTortuga) {
				t.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void correr(Tortuga t) {
		final int max = 500;
		int paso = (int) (Math.random()*(max+1));
		try {
			for (int i = 0; i < max; i += paso) {Thread.sleep(10);}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setGanador(t);
	}
	
	/*
	 * Añadimos synchronized para que varias tortugas no puedan acceder al método simultáneamente
	 */
	public synchronized static void setGanador(Tortuga t) {
		System.out.println("Tortuga " + t + " llega a la final");
		if (ganador == null)
			ganador = t;
	}
	
	public static Tortuga getGanador() {
		return ganador;
	}
}
