package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.BanckController;
import model.*;
import util.NumberGenerator;

public class Interface {
	
	public void menu() {
			BanckController backInit = new BanckController();
			backInit.openFile();
			backInit.readFile();
			backInit.closeFileInput();
			
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
						Owner owner = createHolder(scanner);
						backInit.setListAccount(createAccount(scanner,owner));
	                    break;
	                case 2:
	                    realizarTransaccion(backInit);
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

			backInit.createFile();
			backInit.save();
			backInit.closeFile();
			accountReport(backInit.getListAccount());
	    }

	private void listarTransacciones() {
		// TODO Auto-generated method stub
		
	}

	private void realizarTransaccion(BanckController bancoController) {

	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Ingrese el ID o número de cuenta del cliente:");
	    String idOrNumber = scanner.nextLine();
	    Account account = bancoController.getAccountByIdOrNumber(idOrNumber);
	    
	    if (account == null) {
	        System.out.println("No se encontró la cuenta.");
	        return;
	    }

	    // Pedir la operación y el monto
	    System.out.println("Ingrese '1' para depositar o '2' para retirar:");
	    int operacion = scanner.nextInt();
	    scanner.nextLine(); 
	    System.out.println("Ingrese el monto de la transacción:");
	    double monto = scanner.nextDouble();
	    scanner.nextLine();

	    // Realizar la transacción y guardar los cambios
	    if (operacion == 1) {
	        account.deposit(monto);
	        System.out.println("Se ha depositado " + monto + " a la cuenta " + account.getNumber());
	    } else if (operacion == 2) {
	        try {
	            account.withdraw(monto);
	            System.out.println("Se ha retirado " + monto + " de la cuenta " + account.getNumber());
	        } catch (IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	            return;
	        }
	    } else {
	        System.out.println("Operación no válida.");
	        return;
	    }

	    // Guardar los cambios en el archivo
	    if (!bancoController.save()) {
	        System.out.println("Error al guardar los cambios en el archivo.");
	    }
	}

	private Owner createHolder(Scanner scanner) {
		System.out.println("\n-- Crear cuenta --");
		System.out.print("\nIngresa tus nombres: ");
		String name = scanner.nextLine();
		System.out.print("\nIngresa tus apellidos: ");
		String lastname = scanner.nextLine();
		System.out.print("\nIngresa tu identificacion: ");
		String id = scanner.nextLine();

		return new Owner(id, name, lastname);
	}
	
	private Account createAccount(Scanner scanner, Owner owner){

		String number = NumberGenerator.generateAccountNumber();
	
		System.out.print("Tipo de cuenta (CURRENT/SAVINGS): ");

		String accountType = scanner.nextLine();

		TypeAccount typeAccount;
		if (accountType.equalsIgnoreCase("CURRENT")) 
			typeAccount = TypeAccount.CURRENT;
		else if (accountType.equalsIgnoreCase("SAVINGS")) 
			typeAccount = TypeAccount.SAVINGS;
		else {
			System.out.println("Tipo de cuenta inválido.");
			return null; 
		}
		return new Account(number, owner, typeAccount);
	}

	private void accountReport(ArrayList<Account> accounts){
		
		for (Account account : accounts) {
			System.out.printf("| %35s | %15s | %15s | %15s |%n", 
			"account " + account.getTypeAccount(), "Nº: " + account.getNumber(), "", "");

			System.out.printf("| %35s | %15s | %15s | %15s |%n", 
			"Holder: " + account.getOwnre().getName() + " " + account.getOwnre().getLastname(), "Saldo: " + account.getBalance(), "", "");

			System.out.printf("| %35s | %15s | %15s | %15s |%n", 
			"Id: " + account.getOwnre().getId(), "", "", "");
		}
	}
}
