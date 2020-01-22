package septimo;

import java.time.LocalDate;

public class Cliente extends Persona {
	
	public Cliente(String rut, LocalDate fechaNacimiento, String nombre) {
		super(rut, fechaNacimiento, nombre);
	}

	public String toString() {
		return String.format("Cliente: %s", getNombre());
	}
	
	
}
