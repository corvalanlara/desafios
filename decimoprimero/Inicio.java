package decimoprimero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Inicio {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Persona> listado = loadCSV();
	
		Persona ella = listado.stream().filter(n -> n.nombre.equals("Giselle Marshall")).findAny().get();
		System.out.println(ella);
		
		Persona correo = listado.stream().filter(n -> n.correo.equals("imperdiet.non@enim.org")).findAny().get();
		System.out.println(correo);
		
		long ciudades = listado.stream().map(n -> n.ciudad).distinct().count();
		System.out.println(ciudades);
		
		long elite = listado.stream().filter(n -> n.correo.contains("elit")).count();
		System.out.println(elite);
		
		List<Integer> portres = listado.stream().map(n -> n.monto * 3).filter(n -> n > 29000).collect(Collectors.toList());
		System.out.println(portres);
		
		double promedio = listado.stream().mapToDouble(n -> n.monto).average().orElse(0);
		System.out.println(promedio);
		
		Persona menor = listado.stream().min(Comparator.comparingInt(Persona::getMonto)).get();
		System.out.println(menor);
		
		Persona mayor = listado.stream().max(Comparator.comparingInt(Persona::getMonto)).get();
		System.out.println(mayor);
	}
	
	private static List<Persona> loadCSV() throws IOException {
		 BufferedReader br = new BufferedReader(new FileReader("datos.csv"));
		 List<Persona> listado = br.lines().map(line -> line.split(","))
		 .map(values -> new Persona(values[0], values[1], values[2],
		Integer.parseInt(values[3])))
		 .collect(Collectors.toList());
		 br.close();
		 return listado;

	}
}
