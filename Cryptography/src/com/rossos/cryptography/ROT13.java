package com.rossos.cryptography;

import java.util.Scanner;

public class ROT13 {
	
	/*
	 * This class is currently irrelevant with current version
	 * ROT13 is only modification of caesar so not needed for own class
	 */

	public ROT13(int choice) {
		
		Scanner keyboard = new Scanner(System.in);
		if (choice == Driver.ENCODE) {
			System.out.println("Enter in decoded message");
			String decoded = keyboard.nextLine().toUpperCase().trim();
			String encoded = "";
			for (int i = 0; i < decoded.length(); i++) {
				char x = (char) (decoded.charAt(i) + 13);
				if (x > 90)
					x -= 26;
				encoded += x;
			}
			
			System.out.println("Encoded Message is " + encoded);
		}
		if (choice == Driver.DECODE) {
			System.out.println("Enter in encoded message");
			String encoded = keyboard.nextLine().toUpperCase().trim();
			String decoded = "";
			for (int i = 0; i < encoded.length(); i++) {
				char x = (char) (encoded.charAt(i) - 13);
				if (x < 65)
					x += 26;
				decoded += x;
			}
			
			System.out.println("Decoded Message is " + decoded);
		}
	}
	
}
