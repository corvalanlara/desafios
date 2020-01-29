package decimo;

import java.util.ArrayList;

import decimo.Menu;

public class Inicio {

	public static void main(String[] args) {
		ArrayList<Recurso> lista = new ArrayList<Recurso>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		Cliente cliente = new Cliente("Daniel","17399074K", "buena");
		clientes.add(cliente);
		
		//LIBRO String nombre, boolean reservado, int codigo, Cliente prestadoA, int paginas, String imprenta
		lista.add(new Libro("Harry Potter", false, 2000, null, 200, "Gredos"));
		
		//PELI String nombre, boolean reservado, int codigo, int duracion, String calidad
		lista.add(new Pelicula("John Doe", false, 3000, null, 480, "4K"));
		
		Stock stock = Stock.obtenerSingleton(lista);
		
	while(true) {
		Cliente registrado = Menu.Login(clientes);
		
		while (true) {
			int respuesta = Menu.Inicio();
			
			switch (respuesta) {
			case 1:
				Recurso buscado = Menu.buscarArticulo();
				System.out.println(buscado);
				break;
			case 2:
				System.out.println(Menu.reservarArticulo(registrado));

				break;
			case 3:
				System.out.println("¡Nos vemos, " + registrado.nombre + "!");
				break;
			
			}
		}
	}

	}

}
