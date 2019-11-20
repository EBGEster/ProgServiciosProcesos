package client;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	static Scanner scanner = new Scanner(System.in);
	
	enum Opcion {
		INTRODUCIR_TORTUGA,
		ELIMINAR_TORTUGA,
		MOSTRAR_TORTUGAS,
		INICIAR_CARRERA,
		SALIR
	}
	
	 public static Opcion leerOpcion() {
		  System.out.print("Por favor, introduzca opcion: ");
		  Opcion opcion = Opcion.values()[scanner.nextInt()];
		  return opcion;
		 }

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		boolean salir = false;
		while(!salir) {
			Cliente cliente = new Cliente();
			escribeMenu();
			
			  Opcion opc = leerOpcion();
			  switch (opc) {
			   case INTRODUCIR_TORTUGA:
				   cliente.add(scanner.next(), scanner.nextInt());
				   System.out.println(cliente.leer());
				   //System.out.println("Hola! " + datos);
				   break;
			   case ELIMINAR_TORTUGA:
				   cliente.delete(scanner.nextInt());
					System.out.println(cliente.leer());
					System.out.println("Eliminando tortuga");
					break;
			   case MOSTRAR_TORTUGAS:
				    System.out.println("muestra tortugas");
				    cliente.show();
					System.out.println(cliente.leer());
				    break;
			   case INICIAR_CARRERA:
				   cliente.startRace();
				   System.out.println("Iniciar carrera");
				   System.out.println(cliente.leer());
				   break;
			   case SALIR:
				   System.out.println("salir");
				   cliente.salir();
				   System.out.println(cliente.leer());
				   salir = true;
				   break;
			  }
		}
		
	}
	
	 public static void escribeMenu() {
		  System.out.println(
		  "******************************************\n"+
		   "Elija una de las siguientes opciones\n" +
		   "0. INTRODUCIR TORTUGA\n" +
		   "1. ELIMINAR TORTUGA\n" +
		   "2. MOSTRAR TORTUGAS\n" +
		   "3. INICIAR CARRERA\n" +
		   "4. SALIR\n"+
		   "******************************************\n"
		  );
	 }

}
