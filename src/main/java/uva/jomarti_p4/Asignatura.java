package uva.jomarti_p4;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;

@SuppressWarnings("unused")
public class Asignatura {
	
	private String nombre;
	private String descripcion;
	private double calificacionMax;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	
	private ArrayList<Prueba> pruebas = new ArrayList<Prueba>();
	
	
	/**
	 * Constructor de la clase asignatura con los valores necesarios para la creación.
	 * 
	 * @param nombre	Nombre de la asignatura.
	 * @param descripcion	Descripción de la asignatura.
	 * @param calificacionMax	Calificación maxima de la asignatura.
	 * @param fechaInicio	Fecha de Inicio de la asignatura.
	 * @param fechaFin		Fehca de Fin de la asignatura.
	 * 
	 * @throws IllegalArgumentException Si el nombre tiene valor null.
	 * @throws IllegalArgumentException Si la descripcion tiene valor null.
	 * @throws IllegalArgumentException Si la nota tiene un valor =< que 0,
	 * solo valores estrictamentes mayores que 0.
	 * @throws IllegalArgumentException Si la fecha de inicio tiene valor null.
	 * @throws IllegalArgumentException Si la fecha de fin tiene valor null.
	 * @throws IllegalArgumentException Si la fecha de fin es anterior a la
	 * de inicio tiene valor null.
	 */
	public Asignatura(String nombre, String descripcion, double calificacionMax,
			GregorianCalendar fechaInicio, GregorianCalendar fechaFin) {
		// TODO Auto-generated constructor stub
	}


	/**
	 * Get que devuelve el nombre de la asignatura.
	 * 
	 * @return nombre Nombre de la signatura.
	 */
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * Get que devuelve la descricion de la asignatura.
	 * 
	 * @return descripcion Descripcion de la asignatura.
	 */
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * Get que devuelve la calificacion maxima de la asignatura.
	 * 
	 * @return notaMax Nota maxima de la asignatura.
	 */
	public double getCalificacionMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	/**
	 * Get que devuelve la fecha de inicio de la asignatura.
	 * 
	 * @return fechaInicio Fecha de inicio de la asignatura.
	 */
	public GregorianCalendar getFechaInicio() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * Get que devuelve la fecha de fin de la asignatura.
	 * 
	 * @return fechaFin Fecha de fin de la asignatura.
	 */
	public GregorianCalendar getFechaFin() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * Devulve true en caso de estar vacia (no tener ninguna prueba) o
	 * false en caso contrario (tener pruebas añadidas).
	 * 
	 * @return result Estado de estar vacia.
	 */
	public boolean esVacia() {
		// TODO Auto-generated method stub
		return false;		// Fake Implementation
	}


	/**
	 * Devuelve la cantidad de pruebas asociadas a la asignatura.
	 * 
	 * @return result Cantidad pruebas asociadas.
	 */
	public int cantidadPruebas() {
		// TODO Auto-generated method stub
		return -1;
	}


	/**
	 * Añade una nueva prueba mas a la asignatura. 
	 * 
	 * @param prueba Nueva prueba asociada a la asignatura.
	 * 
	 * @throws IllegalArgumentException Si la prueba pasada como argumento tiene valor null.
	 * @throws IllegalArgumentException Si la prueba pasada como argumento ya esta asociada.
	 * @throws IllegalArgumentException Si la prueba pasada como argumento excede la suma de
	 * todos los pesos de las distintas pruebas. 
	 * @throws IllegalArgumentException Si la fecha de la prueba esta fuera del rango de la
	 * fecha de la asignatura.
	 */
	public void addPrueba(Prueba prueba) {
		// TODO Auto-generated method stub	
	}


	/**
	 * Devuelve el listado de las pruebas asociadas.
	 * 
	 * @return listadoPruebas Listado de las pruebas asociadas a la asignatura.
	 */
	public ArrayList<Prueba> getListadoPruebas() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * Devuelve el peso restante que nos queda por añadir para poder completar las
	 * pruebas asociadas a nuestras asignaturas.
	 * 
	 * @return pesoRestante Peso restante para alcanzar el valor 1 entre las disitintas pruebas.
	 */
	public double pesoRestante() {
		// TODO Auto-generated method stub
		return -1.0;
	}


	/**
	 * Genera un listado de las calificaciones parciles de todos los alumnos pertenecientes
	 * a la asignatura con su calificación actual, mediante las pruebas que se le han evaluado.
	 * 
	 * @return calificacionesParciales Listado de las calificaciones parciales en el momento que
	 * se llama a la función.
	 */
	public Hashtable<String, Double> calificacionesParciales() {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * Genera un listado de las calificaciones finales de todos los alumnos pertenecientes
	 * a la asignatura con su calificación final en la asignatura, mediante el conjunto de 
	 * todas las pruebas. Unicamente puede ser usado cuando el conjunto de pruebas sume el
	 * peso 1 en la asignatura y todas se hayan calificado por completo.
	 * 
	 * @return calificacionesFinales Listado de las calificaciones finales de todos los alumnos
	 * pertenecientes a dicha asignatura. 
	 * 
	 * @throws IllegalStateException Si el conjunto de pruebas no suma un peso de valor 1.
	 * @throws IllegalStateException Si no todas las asignaturas se han calificado por completo.
	 */
	public Hashtable<String, Double> calificacionesFinales() {
		// TODO Auto-generated method stub
		return null;
	}
}