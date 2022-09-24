package clusteringAGM;

import java.util.HashMap;
import java.util.Set;

public class Vertice {
	
	private int posicionX;
	private int posicionY;
	private String nombreDeNodo; /* Nombre del nodo. */
	private HashMap<String, Integer> vecinosPesos; /* Vecinos del nodo, con sus pesos. */
	
	/**
	 * <b>Constructor: </b></br>
	 * <u>Constructor de nodoGrafo.</u>
	 * 
	 * @param nombreDeNodo
	 * <i>Nombre para el nodo.</i>
	 * 
	 **/
	
	public Vertice(String nombreDeNodo) {
		this.nombreDeNodo = nombreDeNodo;
		vecinosPesos = new HashMap<>();
	}
	
	/**
	 * <b>insertarVecinoConPeso(): </b></br>
	 * <u>metodo que inserta nodos vecinos y peso en el nodo.</u>
	 **/
	
	public void insertarVecinoConPeso(String nombreDeNodoVecino, Integer peso) {
		
		vecinosPesos.put(nombreDeNodoVecino, peso);
		
	}
	
	/**
	 * <b>getNombre: </b></br>
	 * <u>Devuelve el nombre del nodo.</u>
	 * 
	 * @return String con nombre del nodo.
	 **/
	
	public String getNombre() {
		return nombreDeNodo;
	}
	
	/**
	 * <b>getVecinoPeso(): </b></br>
	 * <u>Metodo que devuelve el peso o distancia de un vecino desde el nodo.</u>
	 * 
	 * @param nombreDeNodoVecino
	 * <u>Nombre para el nodo.</u>
	 * @return int con valor del peso o distancia.
	 * 
	 **/
	
	public int getVecinoPeso(String nombreDeNodoVecino) {
		
		int valor = vecinosPesos.get(nombreDeNodoVecino);
		
		return valor;
	}
	
	/**
	 * <b>darVecinos():</b></br>
	 * <u>Metodo que devuelve los nombres de los vecinos del nodo.</u>
	 * 
	 * @return String[] vecinos con nombres de los vecinos del nodo.
	 * 
	 **/
	
	public String[] darVecinos() {
		
		 Set<String> keys = vecinosPesos.keySet();
		 int cantidadDeVecinos = keys.size();
		 
		 String[] vecinos = new String[cantidadDeVecinos];
		 
		 int i = 0;
	        for(String key : keys) {
	            vecinos[i] = key;
	            i++;
	        }
		
		return vecinos;
	}
	
}
