package com.rossos.cryptography;

import java.util.Scanner;

public class PolybiusSquare {
	static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static String[][] PSQUARE = new String[5][5];
	public PolybiusSquare (int option) {
		Scanner keyboard = new Scanner(System.in);
		if (option == 1){
		String decoded = "";
		System.out.println("Enter Encoded Message: ");
		String encoded = keyboard.nextLine().toUpperCase();
		//poly squares only 5 by 5 
		//String [][] pSquare = new String [getHighest(1,encoded)][getHighest(0,encoded)];
		fillAlpha(PSQUARE);
		decoded = decode(PSQUARE,encoded,decoded);
		System.out.println("Decoded Message: ");
		System.out.println(decoded);
		}
		
		if (option == 2){
			System.out.println("Enter Decoded Message: ");
			String decoded = keyboard.nextLine().toUpperCase();
			fillAlpha(PSQUARE);
			String encoded = endcode(decoded);
			System.out.println("Encoded Message is: ");
			System.out.println(encoded);
		}
	}

	private String endcode(String decoded) {
		String encoded = "";
		for (int i  = 0; i < decoded.length(); i++){
			for (int j = 0; j < PSQUARE.length; j++){
				for (int k = 0; k < PSQUARE[0].length; k++){
					if (PSQUARE[j][k].equals(decoded.substring(i,i+1)))
						encoded += "" + (k+1) + (j+1);
				}
			}
		}
		return encoded;
		
	}

	private String decode(String[][] pSquare, String encoded, String decoded) {
		for (int i = 0; i < encoded.length()-1; i+=2){
			decoded += pSquare[Integer.parseInt(encoded.substring(i+1, i+2))-1][Integer.parseInt(encoded.substring(i,i+1))-1];
		}
		return decoded;
		
	}

	private static void fillAlpha(String[][] pSquare) {
		int counter = 0;
		for (int i  = 0; i < pSquare.length; i++){
			for (int k = 0; k < pSquare[0].length; k++){
				pSquare[i][k] = ALPHABET.substring(counter, counter+1);
				counter++;
				if(ALPHABET.charAt(counter) == 'j')
					i++;
			}
		}
		
	}

	private static int getHighest(int oddEven, String encoded) {
		int highest = 0;
		for (int i = oddEven; i < encoded.length(); i+=2){
			if (Integer.parseInt(encoded.substring(i, i+1)) > highest)
				highest = Integer.parseInt(encoded.substring(i, i+1));
		}
		return highest;
	}

}
