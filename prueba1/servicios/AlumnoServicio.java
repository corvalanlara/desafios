package servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.Alumno;
import modelos.Materia;

public class AlumnoServicio {

	Map<String, Alumno> listaAlumnos;
	
	private static AlumnoServicio alumnoServicio;
	
	public AlumnoServicio(Map<String, Alumno> listaAlumnos) {
		super();
		this.listaAlumnos = listaAlumnos;
	}

	public void crearAlumno(Alumno alumno) {
                alumnoServicio.addListaAlumnos(alumno.getRut(), alumno);
		System.out.println(alumno);
	}
	
	public void agregarMateria(String rutAlumno, Materia currentMate) {
		
	}
	
	public List<Materia> materiasPorAlumno(String rutAlumno) {
		return new ArrayList<Materia>();
	}
	
    public static synchronized AlumnoServicio obtenerSingleton(Map<String, Alumno> lista) {
        if (alumnoServicio == null){
            alumnoServicio = new AlumnoServicio(lista);
        }
        
        return alumnoServicio;
    }
    
    public static synchronized AlumnoServicio obtenerSingleton() {
    	return alumnoServicio;
    }

	@Override
	public String toString() {
		return "AlumnoServicio [listaAlumnos=" + listaAlumnos + "]";
	}

	public Map<String, Alumno> listarAlumnos() {
		return listaAlumnos;
	}
	
	public void addListaAlumnos(String rut, Alumno alumno) {
		listaAlumnos.put(rut, alumno);
	}
        
        public void addListaAListaAlumnos(Map<String, Alumno> lista) {
                listaAlumnos.putAll(lista);
        }

}
