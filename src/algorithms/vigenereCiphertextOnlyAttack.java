package algorithms;

import java.util.Scanner;

public class vigenereCiphertextOnlyAttack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = sc.next();
		System.out.print("Enter the maximum period for attack: ");
		int period = sc.nextInt();
		
		int [] resultSet = new int[period];
		
		for (int i = 0; i < period; i++) {
			int temp = 0;
			for (int j = 0; j < text.length()-i-1; j++) {
				if (text.charAt(j) == text.charAt(j+i+1)) {
					temp++;
				}
			}
			resultSet[i] = temp;
		}
		
		for (int i = 0; i < resultSet.length; i++) {
			System.out.println("Key " + (i+1) + ": " + resultSet[i]);
		}
		System.out.print("Select period for frequency analysis: ");
		period = sc.nextInt();
		
		System.out.println("Frequency tables: \n\n\n");
		
		for (int j = 0; j < period; j++) {
			System.out.println("\n\nFrequency table: " + (j+1) +"\n");
			int [] frequencycounter = new int[26];
			for (int i = 0; i < (text.length()/period); i++) {
				if (text.length() < period*i+j) {
					break;
				}
				int temp = (int) text.charAt(period*i+j) - 97;
				frequencycounter[temp]++;
			}
			
			for (int i = 0; i < frequencycounter.length; i++) {
				int temp = 97+i;
				char c = (char) temp;
				System.out.println(c + ": " + frequencycounter[i]);
			}
		}
		sc.close();
	}
}
