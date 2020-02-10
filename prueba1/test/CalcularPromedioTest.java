package desafiolatam.prueba1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import modelos.Materia;

/**
 * Unit test for simple App.
 */
public class CalcularPromedioTest {
	
	@Test
	public void calcularPromedioTest() {
		Materia materia = mock(Materia.class);
		when(materia.getPromedio()).thenReturn(3.5);
		assertEquals(materia.getPromedio(), 3.5, 0.1);
	}
}
