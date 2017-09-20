package com.rossos.cryptography;

import java.util.Scanner;

public class Vigenere {
	public Vigenere(int choice) {

		Scanner keyboard = new Scanner(System.in);
		if (choice == Driver.ENCODE) {
			System.out.println("Enter decoded message");
			String decoded = keyboard.nextLine();
			System.out.println("Enter in key phrase");
			String key  = keyboard.nextLine();
			int keyIndex = 0;
			String encoded = "";
			for (int i = 0; i < decoded.length();i++){
				char x = (char) (decoded.charAt(i) + (key.charAt(keyIndex)-65));
				if (x > 90)
					x -= 26;
				encoded += x;
				keyIndex++;
				if (keyIndex == key.length())
					keyIndex = 0;
			}
			
			System.out.println("Encoded message is: " + encoded);
		}
		if (choice == Driver.DECODE) {
			System.out.println("Enter encoded message");
			String encoded = keyboard.nextLine();
			System.out.println("Enter in key phrase");
			String key  = keyboard.nextLine();
			int keyIndex = 0;
			String decoded = "";
			for (int i = 0; i < encoded.length();i++){
				char x = (char) (encoded.charAt(i) - (key.charAt(keyIndex)-65));
				if (x < 65)
					x += 26;
				decoded += x;
				keyIndex++;
				if (keyIndex == key.length())
					keyIndex = 0;
			}
			System.out.println("Encoded message is: " + decoded);
	}
	}
}