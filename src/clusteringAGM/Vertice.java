package clusteringAGM;

import java.awt.Point;
import java.util.HashMap;
import java.util.Set;

public class Vertice {
	
	private String nombreDeVertice; // Nombre del vertice
	private Point coordenadaVertice; // Coordenadas del vertice.
	private HashMap<String, Integer> vecinosPesos;
	
	// Aristas del vertice
	
	// Despues que se crean todas las aristas, me fijo en cuales está implicado este vertice. Si esta 
	// en alguno de los dos vertices que pertenecen a una arista, la agregao en la lista de aristas 
	// del vertice dentro de esta clase.
	
	// Al tener las aristas puedo al recorrer los vertices mirar sus aristas y consultar
	// los pesos de estas y determinar cual es la de menor peso. Luego puedo marcarlo al vertice 
	// como ya recorrido/consultado.
	
	/**
	 * <b>Constructor: </b></br>
	 * <u>Constructor de nodoGrafo.</u>
	 * 
	 * @param nombreDeNodo
	 * <i>Nombre para el nodo.</i>
	 * 
	 **/
	
	public Vertice(String nombreDeVertice){
		
		coordenadaVertice = new Point();
		this.nombreDeVertice = nombreDeVertice;
		vecinosPesos = new HashMap<String, Integer>();
		
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
	 * <b>getNombre: </b></br>
	 * <u>Devuelve el nombre del nodo.</u>
	 * 
	 * @return String con nombre del nodo.
	 **/
	
	public String getNombre() {
		return nombreDeVertice;
	}
	
	public Point getcoordenadaVertice() {
		return coordenadaVertice;
	}

	@Override
	public boolean equals(Object obj) {
		Vertice otroVertice = (Vertice) obj;
		return nombreDeVertice.equals(otroVertice.getNombre());
	}
}
