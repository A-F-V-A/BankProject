package view;

import java.util.Scanner;

public class Interface {
	


	public void menu() {
	       Scanner scanner = new Scanner(System.in);
	        int option = 0;

	        do {
	            System.out.println("\n-- Menú Principal --");
	            System.out.println("1. Crear cuenta");
	            System.out.println("2. Realizar transacción");
	            System.out.println("3. Listar");
	            System.out.println("4. Salir");

	            System.out.print("\nIngrese una opción: ");
	            option = scanner.nextInt();

	            switch (option) {
	                case 1:
	                    crearCuenta();
	                    break;
	                case 2:
	                    realizarTransaccion();
	                    break;
	                case 3:
	                	listarTransacciones();
	                    break;
	                case 4:
	                    System.out.println("Saliendo del programa...");
	                    break;
	                default:
	                    System.out.println("Opción inválida. Inténtelo de nuevo.");
	                    break;
	            }
	        } while (option != 4);
	    }

	private void listarTransacciones() {
		// TODO Auto-generated method stub
		
	}

	private void realizarTransaccion() {
		// TODO Auto-generated method stub
		
	}

	private void crearCuenta() {
		// TODO Auto-generated method stub
		
	}
	
}
