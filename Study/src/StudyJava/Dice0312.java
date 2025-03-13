package StudyJava;

import java.util.Random;

public class Dice0312 {

	public static void main(String[] args) {
		
		Random rd = new Random();
		
		int[] table = new int[6];
		for(int x = 0 ; x < 100 ; x++) {
			int Dice = rd.nextInt(6)+1;
			switch(Dice) {
			case 1 : table[Dice-1]++; break;
			case 2 : table[Dice-1]++; break;		
			case 3 : table[Dice-1]++; break;
			case 4 : table[Dice-1]++; break;
			case 5 : table[Dice-1]++; break;
			case 6 : table[Dice-1]++; break;
			default : break;
			}	
		}
		
			for(int i = 0 ; i < table.length ; i++) {
			System.out.println(table[i]);
		}

	}

}
