package decimo;

import java.util.ArrayList;

public class Inicio {

	public static void main(String[] args) {
		ArrayList<Recurso> lista = new ArrayList<Recurso>();
		//LIBRO String nombre, boolean reservado, int codigo, Cliente prestadoA, int paginas, String imprenta
		lista.add(new Libro("Harry Potter", false, 2000, 200, "Gredos"));
		//PELI String nombre, boolean reservado, int codigo, int duracion, String calidad
		lista.add(new Pelicula("John Doe", false, 3000, 480, "4K"));
		
		Stock stock = Stock.obtenerSingleton(lista);
		System.out.println(stock);
		
		Recurso recurso = Recurso.buscar("Harry Potter", stock);
		System.out.println(recurso);

	}

}
