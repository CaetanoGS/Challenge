package com.app.authors;

import java.io.IOException;
import java.util.Scanner;


public class Principal {

	public static void main(String[] args) throws IOException {
		
		String control = null;
		String firstName, lastName;
		
		Connection con = new Connection ();
		Scanner scan = new Scanner(System.in);
		
		while(control == null) {
			
			System.out.print("Type the author first name: ");
			firstName = scan.nextLine();
			System.out.print("Type the author last name: ");
			lastName = scan.nextLine();
			

			con.showData(firstName, lastName);

			
			
			System.out.print("Would you like to make one more consult (Yes/No) ?");
			
			if(scan.nextLine().toLowerCase().equals("yes"))
				control = null;
			
			else {
				control = "not null";
				System.out.println("----- Consult finished -----");
			}
			
			System.out.println("\n");
			
		}
		
		

	}

}
