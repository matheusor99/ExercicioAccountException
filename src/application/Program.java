package application;

import java.util.Locale;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int numero = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = sc.nextDouble();
		
		Account acc = new Account(numero, holder, balance, withdrawLimit);
		
		System.out.println();
		
		try {
			System.out.print("Enter amount for withdraw: ");
			acc.withdraw(sc.nextDouble());
			System.out.print("New balance: " + String.format("%.2f", acc.getBalance()));
		} catch(AccountException e) {
			System.out.print("Withdraw error: " + e.getMessage());
		}
		
		sc.close();
	}

}
