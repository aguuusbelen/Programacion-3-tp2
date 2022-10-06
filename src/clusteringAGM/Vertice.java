package clusteringAGM;

import java.awt.Point;
import java.util.HashMap;
import java.util.Set;

public class Vertice {
	
	private String nombreDeVertice; // Nombre del vertice
	private Point coordenadaVertice; // Coordenadas del vertice.
	private HashMap<String, Integer> vecinosPesos; // ??? debemos conservar esto ???
	// Capaz deberia tener los pesos desde el mismo hacia los otros.
	
	/**
	 * <b>Constructor: </b></br>
	 * <u>Constructor de nodoGrafo.</u>
	 * 
	 * @param nombreDeNodo
	 * <i>Nombre para el nodo.</i>
	 * 
	 **/
	
	public Vertice(String nombreDeVertice){
		
		this.nombreDeVertice = nombreDeVertice;
		vecinosPesos = new HashMap<String, Integer>();
		coordenadaVertice = new Point();
		
	}
	
	/**
	 * <b>insertarCoordenadas: </b></br>
	 * <u>Setter de las coordenas del vertice.</u>
	 * 
	 * @param coordenadaX
	 * <i>Posicion del vertice en X. </i>
	 * @param coordenadaY
	 * <i>Posicion del vertice en Y. </i>
	 * 
	 **/
	
	public void insertarCoordenadas(double coordenadaX, double coordenadaY) {
		coordenadaVertice.setLocation(coordenadaX, coordenadaY);
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
		return nombreDeVertice;
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
	
	public Point getcoordenadaVertice() {
		return coordenadaVertice;
	}
}
