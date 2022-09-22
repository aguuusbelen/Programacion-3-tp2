package clusteringAGM;

import java.util.HashMap;
import java.util.Set;

public class nodoGrafo {

	private String nombreDeNodo;
	private HashMap<String, Integer> vecinosPesos;
	
	public nodoGrafo(String nombreDeNodo) {
		this.nombreDeNodo = nombreDeNodo;
		vecinosPesos = new HashMap<>();
	}
	
	// Inserta un vecino del nodo y su peso
	public void insertarVecinoConPeso(String nombreDeNodoVecino, Integer peso) {
		
		vecinosPesos.put(nombreDeNodoVecino, peso);
		
	}
	
	//Get del nombre del nodo
	public String getNombre() {
		return nombreDeNodo;
	}
	
	//Get peso de vecino
	public int getVecinoPeso(String nombreDeNodoVecino) {
		
		int valor = vecinosPesos.get(nombreDeNodoVecino);
		
		return valor;
	}
	
	//Devuelve los vecinos del vertice
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
