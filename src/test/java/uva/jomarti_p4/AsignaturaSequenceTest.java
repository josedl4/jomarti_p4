package uva.jomarti_p4;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.Hashtable;

import org.junit.Before;
import org.junit.Test;
import org.easymock.Mock;
import static org.easymock.EasyMock.*;


public class AsignaturaSequenceTest {

	@Mock
	private Prueba pruebaTest1;
	
	@Mock
	private Prueba pruebaTest2;
	
	@Mock
	private Prueba pruebaTest3;
	
	@Mock
	private Prueba pruebaTest4;
	
	
	private Asignatura asignaturaAux1, asignaturaAux2;
	private Hashtable<String, Double> listado1 = new Hashtable<String, Double>();
	private Hashtable<String, Double> listado2 = new Hashtable<String, Double>();
	private Hashtable<String, Double> listado3 = new Hashtable<String, Double>();
	private Hashtable<String, Double> listado4 = new Hashtable<String, Double>();
	
	
	@Before
	public void setupAsignatura() {
		asignaturaAux1 = new Asignatura("Nombre",
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
		
		replay(pruebaTest1);
		replay(pruebaTest2);
		replay(pruebaTest3);
		replay(pruebaTest4);
	}
	
	
	@Test
	public void secuenciaOperaciones() {
		asignaturaAux2 = new Asignatura("Nombre",
				"Descripcion sobre la asignatura", 10.0,
				new GregorianCalendar(2016, 07, 30), 
				new GregorianCalendar(2017, 12, 30));
		
		assertEquals(0, asignaturaAux2.cantidadPruebas());
		assertTrue(asignaturaAux2.esVacia());
		
		asignaturaAux1.addPrueba(pruebaTest1);
		asignaturaAux1.addPrueba(pruebaTest2);
		asignaturaAux1.addPrueba(pruebaTest3);
		
		asignaturaAux2.addPrueba(pruebaTest1);
		asignaturaAux2.addPrueba(pruebaTest2);
		asignaturaAux2.addPrueba(pruebaTest3);
	
		assertEquals(asignaturaAux1.getListadoPruebas(), asignaturaAux2.getListadoPruebas());
		assertEquals(asignaturaAux1.pesoRestante(), asignaturaAux2.pesoRestante(), 0.005);
		
		assertEquals(asignaturaAux1.calificacionesParciales(), 
				asignaturaAux2.calificacionesParciales());
		
		asignaturaAux1.addPrueba(pruebaTest4);
		asignaturaAux2.addPrueba(pruebaTest4);
		
		assertEquals(asignaturaAux1.calificacionesFinales(), 
				asignaturaAux2.calificacionesFinales());
	}

}
