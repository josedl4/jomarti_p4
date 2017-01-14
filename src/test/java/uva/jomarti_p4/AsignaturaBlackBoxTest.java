package uva.jomarti_p4;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class AsignaturaBlackBoxTest {

	private Asignatura asignaturaAux;
	private Prueba pruebaAux1, pruebaAux2;

	@Before
	public void setupAsignatura() {
		asignaturaAux = new Asignatura("Nombre",
				"Descripcion sobre la asignatura", 10.0,
				new GregorianCalendar(2016, 12, 31), 
				new GregorianCalendar(2017, 12, 31));
	}
	
	@Before
	public void setupPrueba() {
		pruebaAux1 = new Prueba(new Date(), "Test 1", "Test del tema 1...", 10, 0.1);
		pruebaAux2 = new Prueba(new Date(), "Examen Final", "Examen final de la asignatura",
				10, 1);
		
		pruebaAux1.calificar("id001", 5, new Date());
		pruebaAux1.calificar("id002", 9.5, new Date());
		
		pruebaAux2.calificar("id001", 5, new Date());
		pruebaAux2.calificar("id002", 9.5, new Date());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsignaturaNombreNull() {
		Asignatura asignatura = new Asignatura(null,
				"Descripcion sobre la asignatura", 10.0,
				new GregorianCalendar(2016, 12, 31), 
				new GregorianCalendar(2017, 12, 31));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsignaturaDecripcionNull() {
		Asignatura asignatura = new Asignatura("Nombre",
				null, 10.0,
				new GregorianCalendar(2016, 12, 31), 
				new GregorianCalendar(2017, 12, 31));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsignaturaNotaMaxErronea() {
		Asignatura asignatura = new Asignatura("Nombre",
				"Descripcion sobre la asignatura", 0.0,
				new GregorianCalendar(2016, 12, 31), 
				new GregorianCalendar(2017, 12, 31));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsignaturaFechaInicioNull() {
		Asignatura asignatura = new Asignatura("Nombre",
				"Descripcion sobre la asignatura", 10.0,
				null, new GregorianCalendar(2017, 12, 31));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsignaturaFechaFinNull() {
		Asignatura asignatura = new Asignatura("Nombre",
				"Descripcion sobre la asignatura", 10.0,
				new GregorianCalendar(2016, 12, 31), null);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsignaturaEstadoFechasIncorrecto() {
		Asignatura asignatura = new Asignatura("Nombre",
				"Descripcion sobre la asignatura", 10.0,
				new GregorianCalendar(2016, 12, 31),
				new GregorianCalendar(2015, 12, 31));
	}

}
