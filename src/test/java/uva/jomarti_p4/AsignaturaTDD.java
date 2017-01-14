package uva.jomarti_p4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class AsignaturaTDD {
	
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
	}
	
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
	
	
	@Test
	public void testEsVacia() {
		assertTrue(asignaturaAux.esVacia());
	}
	
	
	@Test
	public void testNumeroPruebas() {
		assertEquals(0, asignaturaAux.cantidadPruebas());
	}
	
	
	@Test
	public void testAñadirAsignatura() {
		asignaturaAux.addPrueba(pruebaAux1);
		assertFalse(asignaturaAux.esVacia());
		assertEquals(1, asignaturaAux.cantidadPruebas());
	}
	
	
	@Test
	public void testListadoPruebas() {
		asignaturaAux.addPrueba(pruebaAux1);
		ArrayList<Prueba> listadoPruebas = asignaturaAux.getListadoPruebas();
		ArrayList<Prueba> listadoAux = new ArrayList<Prueba>();
		listadoAux.add(pruebaAux1);
		
		assertEquals(listadoAux, listadoPruebas);
	}
	
	
	@Test
	public void testPesoRestante() {
		asignaturaAux.addPrueba(pruebaAux1);
		assertEquals(0.9, asignaturaAux.pesoRestante(), 0.005);
	}
	
	
	@Test
	public void testListadoCalificacionesParcial() {
		
	}
	
	
	@Test
	public void testListadoCalificacionesFinal() {
		
	}
}
