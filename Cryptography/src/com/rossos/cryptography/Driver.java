package com.rossos.cryptography;

import java.util.Scanner;

public class Driver {
	//TODO ONLY CAESAR HAS BEEN UPDATED TO NEWER DESIGN OF CLASSES AND SUBCLASSES
	public final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final int DECODE = 1;
	public static final int ENCODE = 0;
	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		boolean running = true;
		while (running) {
			int encOrDec = 0;

			System.out.println("Encode or Decode Message?");
			String decodeOrEncode = keyboard.nextLine().trim();
			if (decodeOrEncode.equals("decode"))
				encOrDec = DECODE;
			else if (decodeOrEncode.equals("encode"))
				encOrDec = ENCODE;

			System.out.println("What type of cipher?");
			System.out.println("1. Polybius Square\n2. CaesarCipher\n3. Vernam\n4. ROT 13\n5. Vigenere");
			String answer = keyboard.nextLine().trim();

			
			CaesarCipher test;
			if (answer.equals("1") || answer.equals("Polybius Square")) {
				//new PolybiusSquare(encOrDec, getPhrase(encOrDec), getCaesarShift());
			} else if (answer.equals("2") || answer.equals("CaesarCipher")) {
			test = new CaesarCipher(encOrDec,  getPhrase(encOrDec), getCaesarShift());
			System.out.println("Encoded: " + test.getDecoded());
			System.out.println("Decoded: " +test.getEncoded());
			}
			else if (answer.equals("3") || answer.equals("Vernam (UNDER CONSTRUCTION)"))
				new Vernam(encOrDec);
			else if (answer.equals("4") || answer.equals("ROT 13"))
				new ROT13(encOrDec);
			else if (answer.equals("5") || answer.equals("Vigenere"))
				new Vigenere(encOrDec);
			else
				System.out.println("That is not a valid option");
		}

	}

	private static int getCaesarShift() {
		System.out.println("Enter in the shift");
		return Integer.parseInt(keyboard.nextLine().trim());
	}

	private static String getPhrase(int encOrDec) {
		if (encOrDec == ENCODE) {
			System.out.println("Enter in decoded message: ");
			return keyboard.nextLine().trim().toUpperCase();
		} else {
			System.out.println("Enter encoded message:");
			return keyboard.nextLine().trim().toUpperCase();
		}
	}

}
