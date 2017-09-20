package com.rossos.cryptography;

import java.util.Scanner;

public class CaesarCipher {
	
	public CaesarCipher (int choice){
		Scanner keyboard  = new Scanner(System.in);
		
		if (choice == Driver.ENCODE){
			System.out.println("Enter in decoded message: ");
			String decoded = keyboard.nextLine().trim().toUpperCase();
			System.out.println("Enter in the shift");
			int shift  = Integer.parseInt(keyboard.nextLine().trim());
			String encoded = "";
			
			encoded = applyShift(decoded, encoded, shift);
			
			System.out.println("This is the encoded message: ");
			System.out.println(encoded);
			
		}
		
		if (choice == Driver.DECODE){
			System.out.println("Enter encoded message:");
			String encoded = keyboard.nextLine().trim().toUpperCase();
			System.out.println("Enter a shift you want to check ");
			int shift = Integer.parseInt( keyboard.nextLine().trim().toUpperCase());
			String decoded= "";
			boolean decoding = true;
			
		
				//never leaves
				decoded = reduceShift(decoded, encoded, shift);
				
				
				
			
			System.out.println("The decoded message with a shift of "+ shift+ " is: ");
			System.out.println(decoded);
			
		}
	
}

public String applyShift (String encoded, String decoded, int shift){
	for (int i  = 0; i < decoded.length(); i++){
		char currentChar = decoded.charAt(i);
		for (int k  = 0; k < shift; k++){
			 currentChar = (char) (currentChar+1);
			 if (currentChar == 91)
				 currentChar = 	(char)65;
		}
		encoded += "" + currentChar;
	}
	return encoded;
	
}

public String reduceShift (String encoded, String decoded, int shift){
	for (int i  = 0; i < decoded.length(); i++){
		char currentChar = decoded.charAt(i);
		for (int k  = 0; k < shift; k++){
			 currentChar = (char) (currentChar-1);
			 if (currentChar == 64)
				 currentChar = 	(char)90;
		}
		encoded += "" + currentChar;
	}
	return encoded;
	
}

}
