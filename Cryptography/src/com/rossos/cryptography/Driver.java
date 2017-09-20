package com.rossos.cryptography;

import java.util.Scanner;

public class Driver {
	public final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
public static final int DECODE = 1;
public static final int ENCODE= 2; 
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean running = true;
		while (running){
			int encOrDec = 0;
		
			System.out.println("Encode or Decode Message?");
		String decodeOrEncode = keyboard.nextLine().trim();
		if (decodeOrEncode.equals("decode"))
			encOrDec = DECODE;
		else if(decodeOrEncode.equals("encode"))
			encOrDec = ENCODE;
		
		System.out.println("What type of cipher?");
		System.out.println("1. Polybius Square\n2. CaesarCipher\n3. Vernam\n4. ROT 13\n5. Vigenere");
		String answer = keyboard.nextLine().trim();
		
		if (answer.equals("1") || answer.equals("Polybius Square"))
			new PolybiusSquare(encOrDec);
		else if (answer.equals("2") || answer.equals("CaesarCipher"))
			new CaesarCipher(encOrDec);
		else if (answer.equals("3")||answer.equals("Vernam (UNDER CONSTRUCTION)"))
			new Vernam(encOrDec);
		else if (answer.equals("4")|| answer.equals("ROT 13"))
			new ROT13(encOrDec);
		else if (answer.equals("5") || answer.equals("Vigenere"))
			new Vigenere (encOrDec);
		else 
			System.out.println("That is not a valid option");
		}

	}

}
