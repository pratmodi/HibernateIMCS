package com.prateek.main;

import java.util.Scanner;

import com.prateek.entities.Account;
import com.prateek.entities.AccountType;
import com.prateek.entities.Bank;
import com.prateek.entities.Patron;
import com.prateek.repositories.BankRepository;



public class Main {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for add, 2 to remove, 3 to update Patron, 4 to find patron name by id"
				+ "5 to find patron id by name, 7 to add new bank, 8 to delete bank by id, 9 to update bank name by id"
				+ "10 to find bank by id, 11 to list of banks by ids, 12 to update account, 13 to delete acccount by id"
				+ "14 to find account by id ");
		Scanner sc1 = new Scanner(System.in);
		int z = sc1.nextInt();
		switch (z) {
		case 1:
			
			System.out.println("Enter the id of the patron to be inserted -");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the name of the patron to be inserted -");
			String name = sc.nextLine();
			System.out.println("Upload the image of the patron to be inserted here-");
			byte[] image = null; /*= sc.nextByte();*/

			Patron p = new Patron(id, name, null);
			
			BankRepository br = new BankRepository();
			br.add(p);
			
			break;
			
		case 2:
			System.out.println("Enter the id of the patron to be Deleted -");
			int id2 = sc.nextInt();
			Patron p2 = new Patron(id2, null, null);
			BankRepository br2 = new BankRepository();
			br2.remove(p2);
			break;
			
		case 3:
			System.out.println("Enter the id of the patron to be Updated -");
			int id3 = sc.nextInt();
			Patron p3 = new Patron(id3, null, null);
			BankRepository br3 = new BankRepository();
			br3.update(p3);
			break;
			
		case 4:
			System.out.println("Enter id of the patron to find the name - ");
			int id4 = sc.nextInt();
			BankRepository br4 = new BankRepository();
			br4.findPatron(id4);
			break;
			
		case 5:
			System.out.println("Enter the name of the patron to find its ID - ");
			String id5 = sc.nextLine();
			BankRepository br5 = new BankRepository();
			br5.findPatron(id5);
			break;
			
		case 6:
/*			System.out.println("Enter the id of the account -");
			int u = sc.nextInt();
			System.out.println("Enter the id of the Bank");
			int t = sc.nextInt();
			System.out.println("Enter the name of the Bank");
			String name1 = sc.nextLine();
			Bank b = new Bank(t, name1);
			//Patron p1 = new Patron(id4, name1, image)
			
			System.out.println("Enter the id of the patron to be inserted -");
			int id6 = sc.nextInt();
			//sc.nextLine();
			System.out.println("Enter the name of the patron to be inserted -");
			String name6 = sc.nextLine();
			System.out.println("Upload the image of the patron to be inserted here-");
			byte[] image6 = null; = sc.nextByte();

			Patron p6 = new Patron(id6, name6, image6);
			
			Account acc = new Account(u, b, p6);
			System.out.println("Enter the id of the transaxction - ");
			int n = sc.nextInt();
			System.out.println("Enter the Account  of the transaxction - ");
			int m = sc.nextInt();
			System.out.println("Enter the amount of the transaxction - ");
			int l = sc.nextInt();
			System.out.println("Enter the accountType of the transaxction - ");
			int o = sc.nextInt();
			AccountType acctype1 = AccountType.CREDIT;
			AccountType acctype2 = AccountType.DEBIT;
			Transaction tt = new Transaction(n, acc, l, acctype1);
			BankRepository br6 = new BankRepository();
			br6.transact(tt);
			*/
			Bank b = new Bank(546,"SBI");
			Patron pp = new Patron(342, "ravi", "Any String you want".getBytes()); 
			//Account acc = new Account(176, b, pp);
			AccountType acctype = AccountType.CREDIT;		
			//Transaction tt = new Transaction(145, acc, 3456, acctype);
			BankRepository br6 = new BankRepository();
			//br6.transact(tt);
			
			break;
			
		case 7:
			System.out.println("Enter the id of the bank-");
			int id7=sc.nextInt();
			System.out.println("Enter the name of the bank-");
			String name7=sc.nextLine();
			
			Bank bb = new Bank(id7, name7);
			BankRepository br7 = new BankRepository();
			br7.add(bb);
			break;
		case 8:
			
			System.out.println("Enter the id of the bank to be deleted-");
			int id8=sc.nextInt();
			Bank bb1 = new Bank(id8, null);
			BankRepository br8 = new BankRepository();
			br8.remove(bb1);
			break;
		
		case 9:
			System.out.println("Enter the id of the bank to update its name");
			int id9 = sc.nextInt();
			System.out.println("Enter the name of the bank to update");
			String str9 = sc.nextLine();
			Bank bb2 = new Bank(id9, str9);
			BankRepository br9 = new BankRepository();
			br9.update(bb2);
			break;
			
		case 10:
			System.out.println("Enter the id of the bank to find");
			int id10 = sc.nextInt();
			Bank bb3 = new Bank(id10, null);
			BankRepository br10 = new BankRepository();
			br10.findBank(bb3);

			break;
		
		case 11:
			System.out.println("Enter the name of the banks to find their Ids -");
			String id11 = sc.nextLine();
			Bank bb4 = new Bank(0,id11);
			BankRepository br11 = new BankRepository();
			br11.findBank(id11);

			break;	
			
		/*case 12:
			System.out.println("Enter the account id");
			int id12 = sc.nextInt();
			System.out.println("Enter the bank id");
			int id13 = sc.nextInt();
			System.out.println("Enter the patron id");
			int id14 = sc.nextInt();
			
			Account a = new Account(id12, null, null);
			BankRepository br12 = new BankRepository();
			br12.update(a);
			
		case 13:
			System.out.println("Enter the account id to be deleted");
			int id15 = sc.nextInt();
			Account a13 = new Account(id15, null, null);
			BankRepository br13 = new BankRepository();
			br13.delete(a13);
			break;
			
		case 14:
			System.out.println("Enter the account id to be found-");
			int id16 = sc.nextInt();
			Account a14 = new Account(id16, null, null);
			BankRepository br14 = new BankRepository();
			br14.findAccount(id16);
			break;*/
			
		default:	
			break;
		}
		
		
		
		
	}

}
