package controller;

import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.Account;

public class BanckController {
	
	private ArrayList<Account> listAccount;
	private ObjectOutputStream exit;
	
	public boolean createFile() {
		try {
			exit = new ObjectOutputStream(Files.newOutputStream(Paths.get("Banco.dat")));
			
			
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error : Funtion ::createFile:: menssage: ");
			return false;
		}
	}
	

}
