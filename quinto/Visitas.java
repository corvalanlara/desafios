package quinto;

public class Visitas {

	public static void main(String[] args) {
		float notaFinal = promedio(args);
		System.out.println(notaFinal);

	}
	
	private static float promedio(String[] args) {
		int suma = 0;
		for(String nota: args) {
			suma += Integer.parseInt(nota);
		}
		return suma / args.length;
	}

}
