package desafiolatam.prueba1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import servicios.AlumnoServicio;

import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

public class AlumnoServicioTest {
	
	AlumnoServicio alumnoServicio;
	Materia matematicas;
	Materia lenguaje;
	Alumno mapu;
	
	@BeforeEach
	public void setup() {
		matematicas = new Materia(MateriaEnum.MATEMATICAS);
		lenguaje = new Materia(MateriaEnum.LENGUAJE);
		String rut = "17.399.074-K";
		mapu = new Alumno(rut, "Daniel", "Corvalán", "Melipilla");
		mapu.addMaterias(MateriaEnum.CIENCIA);
		Map<String, Alumno> lista = new HashMap<>();
		lista.put(rut, mapu);
		alumnoServicio = AlumnoServicio.obtenerSingleton(lista);
	}
	
	@Test
	public void obtenerSingletonTest() {
		//Test para chequear que funcione el singleton.
		assertSame(alumnoServicio, AlumnoServicio.obtenerSingleton());
	}
	
	@Test
	public void agregarMateriaTest() {
		//Agregar Materias es implementado en la clase Alumno
		assertEquals(mapu.getMaterias().get(0).getEnum(), MateriaEnum.CIENCIA);
	}
	
	@Test
	public void crearAlumnoTest() {
		//Crear alumno es el constructor de la clase Alumno. Excluye el atributo materias.
		Alumno estudiante = new Alumno("17.399.074-K", "Daniel", "Corvalán", "Melipilla");
		assertTrue(new ReflectionEquals(mapu, "materias").matches(estudiante));
	}
	
	@Test
	public void listarAlumnosTest() {
		//ListarAlumnos es un método del singleton alumnoServicio
		assertTrue(alumnoServicio.listarAlumnos().size() == 1);
	}
	
	@Test
	public void materiasPorAlunmoTest() {
		//Obtengo materias desde la clase Alumno
		assertTrue(mapu.getMaterias().size() == 1);
	}
	
}
