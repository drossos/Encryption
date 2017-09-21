package com.rossos.cryptography;

import java.util.Scanner;

/**
 * @author Daniel Rossos
 *
 */
public class PolybiusSquare extends Cipher {
	//TODO consider adding a way to shif the alphabet to 
	//make is possible to shift the p.square
	static String ALPHABET = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
	static String[][] PSQUARE = new String[5][5];
	
	/**
	 * @param encOrDec int deciding to encode (0) or decode (1)
	 * @param phrase String for encoding or decoding
	 * @return instance of PolybiusSquare that has 
	 * been encoded and decoded against a standard 
	 * 5x5 alphabet grid. J's and I's have same 
	 * encoded value and encoded J's will decode to I's
	 */
	public PolybiusSquare (int encOrDec, String phrase) {
		super(encOrDec,phrase);
		fillAlpha(PSQUARE);
		
		if (encOrDec == Cipher.DECODE){
		super.setDecoded(decode(super.getEncoded(),super.getDecoded()));
		System.out.println("Decoded Message: ");
		System.out.println(super.getDecoded());
		}
		
		if (encOrDec == Cipher.ENCODE){
			super.setEncoded(endcode(super.getDecoded()));
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
			if (decoded.substring(i,i+1).equals("J"))
				encoded += "" + 4 + 2;
		}
		return encoded;
		
	}

	private String decode(String encoded, String decoded) {
		for (int i = 0; i < encoded.length()-1; i+=2){
			decoded += ""+PSQUARE[Integer.parseInt(encoded.substring(i+1, i+2))-1][Integer.parseInt(encoded.substring(i,i+1))-1];
		}
		return decoded;
		
	}

	private static void fillAlpha(String[][] pSquare) {
		int counter = 0;
		for (int i  = 0; i < pSquare.length; i++){
			for (int k = 0; k < pSquare[0].length; k++){
				pSquare[i][k] = ALPHABET.substring(counter, counter+1);
				counter++;
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
