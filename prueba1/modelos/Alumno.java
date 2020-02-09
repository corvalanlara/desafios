package modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alumno {

	private String rut;
	private String nombre;
	private String apellido;
	private String direccion;
	public List<Materia> materias;
		
	public Alumno(String rut, String nombre, String apellido, String direccion) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.materias = new ArrayList<>();

	}

	@Override
	public String toString() {
		return "Alumno [rut=" + rut + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", materias=" + materias + "]";
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}
	
	public void addMaterias(MateriaEnum materia) {
		if(this.isMateria(materia) == -1) {
			this.materias.add(new Materia(materia));
		}
	}
	
	private int isMateria(MateriaEnum materia) {
		for (Materia actual: this.materias) {
			if(actual.nombre.equals(materia)) {
				return this.materias.indexOf(actual);
			}
		}
		
		return -1;
		
	}
	
	public void addNota(MateriaEnum materia, double nota) {
		if(this.isMateria(materia) != -1) {
			Materia actual = this.materias.get(this.isMateria(materia));
			actual.addNota(nota);
		}
	}
	
	public Map<MateriaEnum, Double> getPromedios() {
                Map<MateriaEnum, Double> mapa = new HashMap<MateriaEnum, Double>();
                for(Materia materia: materias) {
                        mapa.put(materia.getEnum(), materia.getPromedio());
                }
                return mapa;
        }
	
}
