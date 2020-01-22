package segundo;

import java.util.Scanner;

public class SoloPares {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int usuario = sc.nextInt();
		sc.close();
		for(int i = 0; i < usuario * 2; i++) {
			if (i % 2 == 0) {
				System.out.println("Interación " + i);
			}
		}

	}

}
