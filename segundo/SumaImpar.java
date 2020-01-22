package segundo;

import java.util.Scanner;

public class SumaImpar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int usuario = sc.nextInt();
		sc.close();
		int suma = 0;
		
		for(int i = 0; i < usuario; i++) {
			if (i % 2 != 0) {
				suma += i;
			}
		}
		System.out.println(suma);

	}

}
