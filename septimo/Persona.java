package septimo;

import java.time.LocalDate;

public class Persona {
	
	public String rut;
	public LocalDate fechaNacimiento;
	public String nombre;
	
	public Persona(String rut, LocalDate fechaNacimiento, String nombre) {
		this.rut = rut;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
	}
}
