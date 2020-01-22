package septimo;

import java.time.LocalDate;
import java.time.Month;

public class Inicio {

	public static void main(String[] args) {
		Vendedor persona = new Vendedor("17399074K", LocalDate.of(1990, Month.MAY, 10), "Daniel Corvalán", 3);
		System.out.println(persona);
	}

}
