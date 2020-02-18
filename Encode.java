import java.util.*;
import java.applet.*;
import java.awt.*;
import java.lang.*;

public class Encode extends Applet {
	int shift;
	int alphabetSize = 26;
	
	// Constructor
	public Encode(int numShift) {
		shift = numShift;
	}
	
	// Encodes a message by shifting each letter by shift amount
	public String encode(String messageToEncode) {
		char[] encode = messageToEncode.toCharArray();
		for(int i = 0; i < encode.length; i++) {
			
			// Only encodes a letter
			if(Character.isLetter(encode[i])) {
				
				// Shifts char by shift amount
				encode[i] = (char)(encode[i] + shift);
			
				// if the letter goes beyond alphabet, subtract or add by 26 to
				// make it into a letter of the alphabet
				if(encode[i] > 'z') {
					encode[i] = (char)(encode[i] - alphabetSize);
				}
			
				if(encode[i]< 'a') {
					encode[i] = (char)(encode[i] + alphabetSize);
				}
			}
			
		}
		
		return new String(encode);
		
	}
	
	// decodes an encoded message by shifting each letter by shift amount
	// in the opposite direction
	public String decode(String messageToDecode) {
		char[] decode = messageToDecode.toCharArray();
		for(int i = 0; i < decode.length; i++) {
			
			// Only encodes a letter
			if(Character.isLetter(decode[i])) {
				// Shifts char by shift amount
				decode[i] = (char)(decode[i] - shift);
						
				// if the letter goes beyond alphabet, subtract or add by 26 to
				// make it into a letter of the alphabet
				if(decode[i] > 'z') {
					decode[i] = (char)(decode[i] - alphabetSize);
				}
				
				if(decode[i]< 'a') {
					decode[i] = (char)(decode[i] + alphabetSize);
				}
			}
			
		}
		
		return new String(decode);
	}
	
	public static void main(String[] args){
		
		String option, message = "";
		int shift;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Set message shift: ");
		shift = scan.nextInt();
		Encode caeser = new Encode(shift);
		
		do {
			System.out.println("What would you like to do?");
			
			option = scan.nextLine();
			
			switch(option) {
				case "e":
					System.out.println("What is the message you would like to encode?");
					message = scan.nextLine();
					message = caeser.encode(message);
					System.out.println("Your encoded message is:\n" + message);
					break;
				case "d":
					System.out.println("What is the message you would like to decode?");
					message = scan.nextLine();
					message = caeser.decode(message);
					System.out.println("Your decoded message is:\n" + message);
					break;
			}
						
		} while(!option.equals("q"));
		scan.close();
	}
}
