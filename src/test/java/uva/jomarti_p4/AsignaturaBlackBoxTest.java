package uva.jomarti_p4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;

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
		asignaturaAux = new Asignatura(null,
				"Descripcion sobre la asignatura", 10.0,
				new GregorianCalendar(2016, 12, 31), 
				new GregorianCalendar(2017, 12, 31));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsignaturaDecripcionNull() {
		asignaturaAux = new Asignatura("Nombre",
				null, 10.0,
				new GregorianCalendar(2016, 12, 31), 
				new GregorianCalendar(2017, 12, 31));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsignaturaNotaMaxErronea() {
		asignaturaAux = new Asignatura("Nombre",
				"Descripcion sobre la asignatura", 0.0,
				new GregorianCalendar(2016, 12, 31), 
				new GregorianCalendar(2017, 12, 31));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsignaturaFechaInicioNull() {
		asignaturaAux = new Asignatura("Nombre",
				"Descripcion sobre la asignatura", 10.0,
				null, new GregorianCalendar(2017, 12, 31));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsignaturaFechaFinNull() {
		asignaturaAux = new Asignatura("Nombre",
				"Descripcion sobre la asignatura", 10.0,
				new GregorianCalendar(2016, 12, 31), null);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsignaturaEstadoFechasIncorrecto() {
		asignaturaAux = new Asignatura("Nombre",
				"Descripcion sobre la asignatura", 10.0,
				new GregorianCalendar(2016, 12, 31),
				new GregorianCalendar(2015, 12, 31));
	}

	
	@Test
	public void testNoEsVacia() {
		asignaturaAux.addPrueba(pruebaAux1);
		assertFalse(asignaturaAux.esVacia());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddPruebaNull() {
		asignaturaAux.addPrueba(null);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddPruebaRepetida() {
		asignaturaAux.addPrueba(pruebaAux1);
		asignaturaAux.addPrueba(pruebaAux1);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddPruebaSuperarPeso() {
		asignaturaAux.addPrueba(pruebaAux2);
		asignaturaAux.addPrueba(pruebaAux1);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddPruebaFueraRangoFechas() {
		Prueba prueba = new Prueba(new GregorianCalendar(2009, 1, 1).getTime(),
				"test de prueba", "Descripcion...", 10, 0.8);
		
		asignaturaAux.addPrueba(prueba);
	}
	
	
	@Test
	public void testListadoPruebasVacio() {
		ArrayList<Prueba> list = asignaturaAux.getListadoPruebas();
		
		assertEquals(new ArrayList<Prueba>(), list);
	}
	
	
	@Test
	public void testPesoRestanteSinPruebas() {
		assertEquals(1.0, asignaturaAux.pesoRestante(), 0.005);
	}
	
	
	@Test
	public void testListadoCalificacionesParcialSinPruebas() {
		assertEquals(new Hashtable<String, Double>(), 
				asignaturaAux.calificacionesParciales());
	}
	
	
	@Test
	public void testListadoCalificacionesParcialSinNotas() {
		Prueba prueba = new Prueba(new GregorianCalendar(2009, 1, 1).getTime(),
				"test de prueba", "Descripcion...", 10, 0.8);
		asignaturaAux.addPrueba(prueba);
		
		assertEquals(new Hashtable<String, Double>(), 
				asignaturaAux.calificacionesParciales());
	}
	
	
	@Test(expected=IllegalStateException.class)
	public void testListadoCalificacionesFinalesSinPruebas() {
		asignaturaAux.calificacionesFinales();
	}
	
	@Test(expected=IllegalStateException.class)
	public void testListadoCalificacionesFinalesSinPesoNecesario() {
		asignaturaAux.addPrueba(pruebaAux1);
		asignaturaAux.calificacionesFinales();
	}
}
