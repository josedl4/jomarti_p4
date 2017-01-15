package uva.jomarti_p4;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Map.Entry;

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
		if(nombre.equals(null) || descripcion.equals(null) || calificacionMax <= 0
				|| fechaInicio.equals(null) || fechaFin.equals(null)) 
			throw new IllegalArgumentException("Los paramatro para crear la asignatura no son correctos.");
		if(fechaFin.before(fechaInicio))
			throw new IllegalArgumentException("Las fechas no son correctas al crear la noticia.");
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.calificacionMax = calificacionMax;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}


	/**
	 * Get que devuelve el nombre de la asignatura.
	 * 
	 * @return nombre Nombre de la signatura.
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * Get que devuelve la descricion de la asignatura.
	 * 
	 * @return descripcion Descripcion de la asignatura.
	 */
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return descripcion;
	}


	/**
	 * Get que devuelve la calificacion maxima de la asignatura.
	 * 
	 * @return notaMax Nota maxima de la asignatura.
	 */
	public double getCalificacionMax() {
		return calificacionMax;
	}

	
	/**
	 * Get que devuelve la fecha de inicio de la asignatura.
	 * 
	 * @return fechaInicio Fecha de inicio de la asignatura.
	 */
	public GregorianCalendar getFechaInicio() {
		return fechaInicio;
	}


	/**
	 * Get que devuelve la fecha de fin de la asignatura.
	 * 
	 * @return fechaFin Fecha de fin de la asignatura.
	 */
	public GregorianCalendar getFechaFin() {
		return fechaFin;
	}


	/**
	 * Devulve true en caso de estar vacia (no tener ninguna prueba) o
	 * false en caso contrario (tener pruebas añadidas).
	 * 
	 * @return result Estado de estar vacia.
	 */
	public boolean esVacia() {
		return pruebas.isEmpty();
	}


	/**
	 * Devuelve la cantidad de pruebas asociadas a la asignatura.
	 * 
	 * @return result Cantidad pruebas asociadas.
	 */
	public int cantidadPruebas() {
		return pruebas.size();
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
		return pruebas;
	}


	/**
	 * Devuelve el peso restante que nos queda por añadir para poder completar las
	 * pruebas asociadas a nuestras asignaturas.
	 * 
	 * @return pesoRestante Peso restante para alcanzar el valor 1 entre las disitintas pruebas.
	 */
	public double pesoRestante() {
		double pesoRestante = 0;
		
		for(Prueba p : pruebas)
			pesoRestante += p.getPeso();
		
		return pesoRestante;
	}


	/**
	 * Genera un listado de las calificaciones parciles de todos los alumnos pertenecientes
	 * a la asignatura con su calificación actual, mediante las pruebas que se le han evaluado.
	 * 
	 * @return calificacionesParciales Listado de las calificaciones parciales en el momento que
	 * se llama a la función.
	 */
	public Hashtable<String, Double> calificacionesParciales() {
		Hashtable<String, Double> listadoCalificaciones = new Hashtable<String, Double>();
		
		for (Prueba p : pruebas) {
			double notaPrueba = p.getNotaMax();
			double pesoPrueba = p.getPeso();
			
			for (Entry<String, Double> entry : p.getCalificaciones().entrySet()) {
				if(listadoCalificaciones.containsKey(entry.getKey()))
					listadoCalificaciones.put(entry.getKey(), 
							listadoCalificaciones.get(entry.getKey())
							+ ((entry.getValue()/notaPrueba) * pesoPrueba * getCalificacionMax()));
				else
					listadoCalificaciones.put(entry.getKey(), 
							(entry.getValue()/notaPrueba) * pesoPrueba * getCalificacionMax());
			}
		}
		
		return listadoCalificaciones;
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
	public Hashtable<String, Double> calificacionesFinales() throws IllegalStateException {
		if (pesoRestante() != 0.0)
			throw new IllegalStateException("La asignatura aun no tiene todo el peso"
					+ " repartido entre las pruebas.");
		
		for (Prueba p : pruebas) {
			if (!p.isCompletamenteCalificada())
				throw new IllegalStateException("Alguna de las pruebas no ta calificada completamente.");
		}
		
		return calificacionesParciales();
	}
}