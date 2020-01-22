package quinto;

import java.util.ArrayList;

public class SmartWatch {

	public static void main(String[] args) {
		System.out.println(promedio(args));
	}
	
	private static float promedio(String[] args) {
		ArrayList<Integer> conversos = new ArrayList<Integer>();
		int suma = 0;
		for(int i = 0; i < args.length; i++) {
			int num = Integer.parseInt(args[i]);
			if (num > 200 && num < 100000) {
				conversos.add(num);
				suma += num;
			}
		}
		return suma / conversos.size();
	}

}
