package uva.jomarti_p4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;
import org.easymock.Mock;
import static org.easymock.EasyMock.*;

public class TestWithMockObjects {

	@Mock
	private Prueba pruebaTest1;
	
	@Mock
	private Prueba pruebaTest2;
	
	@Mock
	private Prueba pruebaTest2Bis;
	
	@Mock
	private Prueba pruebaTest3;
	
	@Mock
	private Prueba pruebaTest4;
	
	@Mock
	private Prueba pruebaTest5;
	
	
	private Asignatura asignaturaAux;
	private Hashtable<String, Double> listado1 = new Hashtable<String, Double>();
	private Hashtable<String, Double> listado2 = new Hashtable<String, Double>();
	private Hashtable<String, Double> listado3 = new Hashtable<String, Double>();
	private Hashtable<String, Double> listado4 = new Hashtable<String, Double>();
	private Hashtable<String, Double> listado5 = new Hashtable<String, Double>();
	
	
	@Before
	public void setupAsignatura() {
		asignaturaAux = new Asignatura("Nombre",
				"Descripcion sobre la asignatura", 10.0,
				new GregorianCalendar(2016, 07, 30), 
				new GregorianCalendar(2017, 12, 30));
	}
	
	@Before
	public void setupListados() {
		listado1.put("id001", 5.0);
		listado1.put("id002", 0.0);
		listado1.put("id003", 4.0);
		listado1.put("id004", 2.5);
		
		listado2.put("id001", 3.5);
		listado2.put("id004", 2.5);
		
		listado3.put("id002", 0.0);
		listado3.put("id003", 4.0);
		listado3.put("id004", 2.5);
		
		listado4.put("id001", 100.0);
		listado4.put("id002", 9.0);
		listado4.put("id003", 80.0);
		listado4.put("id004", 50.0);
		
		listado5.put("id005", 7.4);
		listado5.put("id006", 6.0);
		listado5.put("id007", 9.4);
	}
	
	@Before
	public void setupPruebas() {
		pruebaTest1 = createMock(Prueba.class);
		expect(pruebaTest1.getNombre()).andReturn("Test tema 1").anyTimes();
		expect(pruebaTest1.getDescripcion()).andReturn("Test sobre el tema 1"
				+ " de la asignatura...").anyTimes();
		expect(pruebaTest1.getNotaMax()).andReturn(5.0).anyTimes();
		expect(pruebaTest1.getPeso()).andReturn(0.2).anyTimes();
		expect(pruebaTest1.getFecha()).andReturn(
				new GregorianCalendar(2016, 10, 2).getTime()).anyTimes();
		expect(pruebaTest1.isCompletamenteCalificada()).andReturn(true).anyTimes();
		expect(pruebaTest1.getCalificaciones()).andReturn(listado1).anyTimes();
		
		pruebaTest2 = createMock(Prueba.class);
		expect(pruebaTest2.getNombre()).andReturn("Test tema 2").anyTimes();
		expect(pruebaTest2.getDescripcion()).andReturn("Test sobre el tema 2"
				+ " de la asignatura...").anyTimes();
		expect(pruebaTest2.getNotaMax()).andReturn(5.0).anyTimes();
		expect(pruebaTest2.getPeso()).andReturn(0.2).anyTimes();
		expect(pruebaTest2.getFecha()).andReturn(
				new GregorianCalendar(2016, 11, 2).getTime()).anyTimes();
		expect(pruebaTest2.isCompletamenteCalificada()).andReturn(true).anyTimes();
		expect(pruebaTest2.getCalificaciones()).andReturn(listado2).anyTimes();
		
		pruebaTest2Bis = createMock(Prueba.class);
		expect(pruebaTest2Bis.getNombre()).andReturn("Test tema 2").anyTimes();
		expect(pruebaTest2Bis.getDescripcion()).andReturn("Test sobre el tema 2"
				+ " de la asignatura...").anyTimes();
		expect(pruebaTest2Bis.getNotaMax()).andReturn(5.0).anyTimes();
		expect(pruebaTest2Bis.getPeso()).andReturn(0.2).anyTimes();
		expect(pruebaTest2Bis.getFecha()).andReturn(
				new GregorianCalendar(2016, 11, 2).getTime()).anyTimes();
		expect(pruebaTest2Bis.isCompletamenteCalificada()).andReturn(true).anyTimes();
		expect(pruebaTest2Bis.getCalificaciones()).andReturn(new Hashtable<String, Double>()).anyTimes();
		
		pruebaTest3 = createMock(Prueba.class);
		expect(pruebaTest3.getNombre()).andReturn("Test tema 3").anyTimes();
		expect(pruebaTest3.getDescripcion()).andReturn("Test sobre el tema 3"
				+ " de la asignatura...").anyTimes();
		expect(pruebaTest3.getNotaMax()).andReturn(5.0).anyTimes();
		expect(pruebaTest3.getPeso()).andReturn(0.2).anyTimes();
		expect(pruebaTest3.getFecha()).andReturn(
				new GregorianCalendar(2016, 12, 2).getTime()).anyTimes();
		expect(pruebaTest3.isCompletamenteCalificada()).andReturn(true).anyTimes();
		expect(pruebaTest3.getCalificaciones()).andReturn(listado3).anyTimes();
		
		pruebaTest4 = createMock(Prueba.class);
		expect(pruebaTest4.getNombre()).andReturn("Parte Practica").anyTimes();
		expect(pruebaTest4.getDescripcion()).andReturn("Parte practica"
				+ " de la asignatura...").anyTimes();
		expect(pruebaTest4.getNotaMax()).andReturn(100.0).anyTimes();
		expect(pruebaTest4.getPeso()).andReturn(0.4).anyTimes();
		expect(pruebaTest4.getFecha()).andReturn(
				new GregorianCalendar(2017, 1, 10).getTime()).anyTimes();
		expect(pruebaTest4.isCompletamenteCalificada()).andReturn(true).anyTimes();
		expect(pruebaTest4.getCalificaciones()).andReturn(listado4).anyTimes();
		
		pruebaTest5 = createMock(Prueba.class);
		expect(pruebaTest5.getNombre()).andReturn("Examen Final 100%").anyTimes();
		expect(pruebaTest5.getDescripcion()).andReturn("Examen unico"
				+ " de la asignatura...").anyTimes();
		expect(pruebaTest5.getNotaMax()).andReturn(10.0).anyTimes();
		expect(pruebaTest5.getPeso()).andReturn(1.0).anyTimes();
		expect(pruebaTest5.getFecha()).andReturn(
				new GregorianCalendar(2017, 1, 16).getTime()).anyTimes();
		expect(pruebaTest5.isCompletamenteCalificada()).andReturn(true).anyTimes();
		expect(pruebaTest5.getCalificaciones()).andReturn(listado5).anyTimes();
		
		replay(pruebaTest1);
		replay(pruebaTest2);
		replay(pruebaTest2Bis);
		replay(pruebaTest3);
		replay(pruebaTest4);
		replay(pruebaTest5);
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
	public void testEsVacia() {
		assertTrue(asignaturaAux.esVacia());
	}
	
	
	@Test
	public void testNoEsVacia() {
		asignaturaAux.addPrueba(pruebaTest1);
		assertFalse(asignaturaAux.esVacia());
	}
	
	
	@Test
	public void testNumeroPruebas() {
		assertEquals(0, asignaturaAux.cantidadPruebas());
	}
	
	
	@Test
	public void testAñadirAsignatura() {
		asignaturaAux.addPrueba(pruebaTest1);
		assertFalse(asignaturaAux.esVacia());
		assertEquals(1, asignaturaAux.cantidadPruebas());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddPruebaNull() {
		asignaturaAux.addPrueba(null);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddPruebaRepetida() {
		asignaturaAux.addPrueba(pruebaTest1);
		asignaturaAux.addPrueba(pruebaTest1);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddPruebaSuperarPeso() {
		asignaturaAux.addPrueba(pruebaTest5);
		asignaturaAux.addPrueba(pruebaTest1);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddPruebaFueraRangoFechas() {
		Asignatura asignaturaTMP = new Asignatura("AS-01",
				"...", 10, new GregorianCalendar(2000, 1, 1),
				new GregorianCalendar(2001, 1, 1));
		
		asignaturaTMP.addPrueba(pruebaTest1);
	}
	
	
	@Test
	public void testListadoPruebas() {
		asignaturaAux.addPrueba(pruebaTest1);
		ArrayList<Prueba> listadoPruebas = asignaturaAux.getListadoPruebas();
		ArrayList<Prueba> listadoAux = new ArrayList<Prueba>();
		listadoAux.add(pruebaTest1);
		
		assertEquals(listadoAux, listadoPruebas);
	}
	
	
	@Test
	public void testListadoPruebasVacio() {
		ArrayList<Prueba> list = asignaturaAux.getListadoPruebas();
		
		assertEquals(new ArrayList<Prueba>(), list);
	}
	
	
	@Test
	public void testPesoRestante() {
		asignaturaAux.addPrueba(pruebaTest1);
		assertEquals(0.8, asignaturaAux.pesoRestante(), 0.005);
	}
	
	
	@Test
	public void testPesoRestanteSinPruebas() {
		assertEquals(1.0, asignaturaAux.pesoRestante(), 0.005);
	}
	
	
	@Test
	public void testListadoCalificacionesParcial() {
		asignaturaAux.addPrueba(pruebaTest1);
		asignaturaAux.addPrueba(pruebaTest2);
		Hashtable<String, Double> tablaCalificaciones = new Hashtable<String, Double>();
		tablaCalificaciones.put("id001", 3.4);
		tablaCalificaciones.put("id002", 0.0);
		tablaCalificaciones.put("id003", 1.6);
		tablaCalificaciones.put("id004", 2.0);
		assertEquals(tablaCalificaciones, asignaturaAux.calificacionesParciales());
	}
	
	
	@Test
	public void testListadoCalificacionesParcialSinPruebas() {
		assertEquals(new Hashtable<String, Double>(), 
				asignaturaAux.calificacionesParciales());
	}
	
	
	@Test
	public void testListadoCalificacionesParcialSinNotas() {
		asignaturaAux.addPrueba(pruebaTest2Bis);
		
		assertEquals(new Hashtable<String, Double>(), 
				asignaturaAux.calificacionesParciales());
	}
	
	
	@Test
	public void testListadoCalificacionesFinal() {
		asignaturaAux.addPrueba(pruebaTest5);
		assertEquals(listado5, asignaturaAux.calificacionesFinales());
	}
	
	
	@Test(expected=IllegalStateException.class)
	public void testListadoCalificacionesFinalesSinPruebas() {
		asignaturaAux.calificacionesFinales();
	}
	
	
	@Test(expected=IllegalStateException.class)
	public void testListadoCalificacionesFinalesSinPesoNecesario() {
		asignaturaAux.addPrueba(pruebaTest1);
		asignaturaAux.calificacionesFinales();
	}
	
	
	@Test(expected=IllegalStateException.class)
	public void testListadoCalificacionesFinalesVariasPruebas() {
		asignaturaAux.addPrueba(pruebaTest1);
		asignaturaAux.addPrueba(pruebaTest2);
		asignaturaAux.addPrueba(pruebaTest3);
		asignaturaAux.addPrueba(pruebaTest4);
		asignaturaAux.calificacionesFinales();
	}
	
	
	@Test(expected=IllegalStateException.class)
	public void testListadoCalificacionesFinalesSinFinalizarCalificacion() {
		asignaturaAux.addPrueba(pruebaTest1);
		asignaturaAux.addPrueba(pruebaTest2Bis);
		asignaturaAux.addPrueba(pruebaTest3);
		asignaturaAux.addPrueba(pruebaTest4);
		asignaturaAux.calificacionesFinales();
	}
}
