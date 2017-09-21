package com.rossos.cryptography;
import java.util.Scanner;

/**
 * @author Daniel Rossos
 *
 */
public abstract class Driver {
	// TODO fix vernam
	public final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args) {

		boolean running = true;
		while (running) {
			int encOrDec = -1;

			System.out.println("Encode or Decode Message?");
			String decodeOrEncode = keyboard.nextLine().trim().toUpperCase();
			if (decodeOrEncode.equals("DECODE"))
				encOrDec = Cipher.DECODE;
			else if (decodeOrEncode.equals("ENCODE"))
				encOrDec = Cipher.ENCODE;

			System.out.println("What type of cipher?");
			System.out.println("1. Polybius Square\n2. CaesarCipher\n3. Vernam\n4. ROT 13\n5. Vigenere");
			String answer = keyboard.nextLine().trim();

			Cipher test;
			if (answer.equals("1") || answer.equals("Polybius Square")) {
				test = new PolybiusSquare(encOrDec, getPhrase(encOrDec));
				System.out.println("Encoded: " + test.getDecoded());
				System.out.println("Decoded: " + test.getEncoded());
			} else if (answer.equals("2") || answer.equals("CaesarCipher")) {
				test = new CaesarCipher(encOrDec, getPhrase(encOrDec), getCaesarShift());
				System.out.println("Encoded: " + test.getDecoded());
				System.out.println("Decoded: " + test.getEncoded());
			} else if (answer.equals("3") || answer.equals("Vernam (UNDER CONSTRUCTION)"))
				System.out.println("Unavalible for now");
			else if (answer.equals("4") || answer.equals("ROT 13")) {
				test = new CaesarCipher(encOrDec, getPhrase(encOrDec), 13);
				System.out.println("Encoded: " + test.getDecoded());
				System.out.println("Decoded: " + test.getEncoded());
			}
			else if (answer.equals("5") || answer.equals("Vigenere"))
				new Vigenere(encOrDec, getPhrase(encOrDec), getVigKey());
			else
				System.out.println("That is not a valid option");
		}

	}

	private static String getVigKey() {
		System.out.println("Enter in the key phrase");
		return keyboard.nextLine().trim().toUpperCase();
	}

	private static int getCaesarShift() {
		System.out.println("Enter in the shift");
		return Integer.parseInt(keyboard.nextLine().trim());
	}

	private static String getPhrase(int encOrDec) {
		if (encOrDec == Cipher.ENCODE) {
			System.out.println("Enter in decoded message: ");
			return keyboard.nextLine().trim().toUpperCase();
		} else {
			System.out.println("Enter encoded message:");
			return keyboard.nextLine().trim().toUpperCase();
		}
	}

}
