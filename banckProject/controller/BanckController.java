package controller;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.Account;

public class BanckController {
	
	private ArrayList<Account> listAccount;
	private ObjectOutputStream exit;
	private ObjectInputStream input;

	public BanckController(){
		this.listAccount = new ArrayList<Account>();
	}

	public  ArrayList<Account> getListAccount(){
		return listAccount;
   }

	public  void setListAccount(Account account){
		this.listAccount.add(account);
	}

	
	public boolean openFile() {
		try {
			input = new ObjectInputStream(Files.newInputStream(Paths.get("Banco.dat")));
			return true;
		} catch (Exception e) {
			System.err.println("Error : Function ::openFile:: message: Error al abrir el archivo");
			return false;
		}
	}

	public boolean readFile() {
		try {
			listAccount = (ArrayList<Account>) input.readObject();
			return true;
		} catch (Exception e) {
			System.err.println("Error : Function ::readFile:: message: Error al leer el archivo");
			return false;
		}
	}

	public boolean closeFileInput() {
		try {
			if (input != null) {
				input.close();
			}
			return true;
		} catch (Exception e) {
			System.err.println("Error : Function ::closeFile:: message: Error al cerrar el archivo");
			return false;
		}
	}
	
	
	public boolean createFile() {
		try {
			exit = new ObjectOutputStream(Files.newOutputStream(Paths.get("Banco.dat")));
			return true;
		}catch (Exception e) {

			System.err.println("Error : Funtion ::createFile:: menssage: Error en crear en archivo");
			return false;
		}
	}
	
	public boolean save(){
		try {
			exit.writeObject(listAccount);
			return true;
		} catch (Exception e) {
			System.err.println("Error : Funtion ::save:: menssage: Error al guardar el archivo");
			return false;
		}
	}

	public boolean closeFile(){
		try {
			if(exit != null)
				exit.close();
			return true;
		} catch (Exception e) {
			System.err.println("Error : Funtion ::closeFile:: menssage: Error al cerrar el archivo");
			return false;
		}
	}

}
