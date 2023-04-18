package view;

import java.text.SimpleDateFormat;
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
						accountReport(backInit.getListAccount());
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

	}
	
	private Owner createHolder(Scanner scanner) {
	    System.out.println("\n-- Crear cuenta --");
	    System.out.print("\nIngresa tus nombres: ");
	    scanner.nextLine(); 
	    String name = scanner.nextLine().toUpperCase();
	    System.out.print("\nIngresa tus apellidos: ");
	    String lastname = scanner.nextLine().toUpperCase();
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

		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		for (Account account : accounts) {
			System.out.println("--------------------------------------------------------------------------------------------------------------------\n");
			System.out.printf("| %43s | %20s | %20s | %20s |%n", 
			"account " + account.getTypeAccount(), "Nº: " + account.getNumber(), "","");

			System.out.printf("| %43s | %43s | %20s |%n", 
			"Holder: " + account.getOwnre().getName() + " " + account.getOwnre().getLastname(), "Saldo: " + account.getBalance(), "");

			System.out.printf("| %20s | %20s | %20s | %20s | %20s |%n", 
			"Id: " + account.getOwnre().getId(), "", "", "", "");

			System.out.println("\n");

			for (Transactions tr : account.gettransactions()) {

				System.out.printf("| %20s | %20s | %20s | %20s | %20s |%n", 
				"INITIAL BALANCE", "TYPE OF TRANSACTION", "TRANSACTION VALUE", "DATE/TIME","FINAL BALANCE");
				System.out.printf("| %20s | %20s | %20s | %20s | %20s |%n", 
				tr.getInitialBalance(), tr.getTypeTransactions(),tr.getTransaction(),formatoFecha.format(tr.getDate()),tr.getFinalBalance());
			}

			System.out.println("--------------------------------------------------------------------------------------------------------------------\n");
		}
	}
}
