package segundo;

import java.util.Scanner;

public class SumaImparLimite {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = sc.nextInt();
		int max = sc.nextInt();
		sc.close();
		int suma = 0;
		
		for(int i = min; i < max; i++) {
			if (i % 2 != 0) {
				suma = suma + i;
			}
		}
		System.out.println(suma);

	}

}
