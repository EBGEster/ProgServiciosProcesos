package server;

public class Tortuga implements Runnable{
	private String nombre;
	private int dorsal;
	
	public Tortuga(String nombre, int dorsal) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	@Override
	public String toString() {
		return "Tortuga [nombre=" + nombre + ", dorsal=" + dorsal + "]";
	}
	
	@Override
	public void run() {
		Carrera.correr(this);
	}
	
}
