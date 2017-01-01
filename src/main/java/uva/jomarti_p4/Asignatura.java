package uva.jomarti_p4;

import java.util.ArrayList;
import java.util.GregorianCalendar;

@SuppressWarnings("unused")
public class Asignatura {
	
	private String nombre;
	private String descripcion;
	private double calificacionMax;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	
	private ArrayList<Prueba> pruebas = new ArrayList<Prueba>();
	
	
	/**
	 * Constructor de la clase asignatura con los valores necesarios para la creación
	 * 
	 * @param nombre	Nombre de la asignatura
	 * @param descripcion	Descripción de la asignatura
	 * @param calificacionMax	Calificación maxima de la asignatura
	 * @param fechaInicio	Fecha de Inicio de la asignatura
	 * @param fechaFin		Fehca de Fin de la asignatura
	 */
	public Asignatura(String nombre, String descripcion, double calificacionMax,
			GregorianCalendar fechaInicio, GregorianCalendar fechaFin) {
		// TODO Auto-generated constructor stub
	}


	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}


	public double getCalificacionMax() {
		// TODO Auto-generated method stub
		return 0;
	}


	public GregorianCalendar getFechaInicio() {
		// TODO Auto-generated method stub
		return null;
	}


	public GregorianCalendar getFechaFin() {
		// TODO Auto-generated method stub
		return null;
	}

}
