package uva.jomarti_p4;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class AsignaturaTDD {

	@Test
	public void testAsignatura() {
		Asignatura asignatura = new Asignatura("Nombre",
				"Descripcion sobre la asignatura", 10.0,
				new GregorianCalendar(2016, 12, 31), 
				new GregorianCalendar(2017, 12, 31));
		
		assertEquals("Nombre", asignatura.getNombre());
		assertEquals("Descripcion sobre la asignatura", asignatura.getDescripcion());
		assertTrue(10.0 == asignatura.getCalificacionMax());
		assertEquals(new GregorianCalendar(2016, 12, 31), asignatura.getFechaInicio());
		assertEquals(new GregorianCalendar(2017, 12, 31), asignatura.getFechaFin());
	}

}
