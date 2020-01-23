package septimo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Cliente extends Persona {

	private ArrayList<Entrada> entradasCompradas = new ArrayList<Entrada>();
	
	public Cliente(String rut, LocalDate fechaNacimiento, String nombre) {
		super(rut, fechaNacimiento, nombre);
		System.out.println("Cliente creado");
	}

	public String toString() {
		return String.format("Cliente: %s", getNombre());
	}
	
	public int edad() {
		return calculateAge(this.getFechaNacimiento(), LocalDate.now());
	}
	
    private static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
    
    public void addEntradaComprada(Entrada entrada) {
    	this.entradasCompradas.add(entrada);
    }
    
    public ArrayList<Entrada> getEntradasCompradas() {
    	return this.entradasCompradas;
    }
   
}
