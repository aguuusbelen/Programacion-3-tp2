package clusteringAGM;

import java.util.LinkedList;

public class grafo {
		
		private LinkedList<nodoGrafo> grafo; /* LinkedList que contiene los nodos del grafo */
		
		
		/**
		 * <b>Constructor: </b></br>
		 * <u>Constructor de grafo.</u>
		 * 
		 **/
		
		public grafo() {
			grafo = new LinkedList<>();
		}
		
		/**
		 * <b>insertarNodo(): </b></br>
		 * <u>Metodo que inserta un nuevo nodo en el grafo.</u>
		 * 
		 **/
		
		public void insertarNodo(String nombreDelNodo) {
			
			nodoGrafo nodoGrafo = new nodoGrafo(nombreDelNodo);
			grafo.add(nodoGrafo);
			
		}
		
		/**
		 * <b>rellenarVecinosDeNodo(): </b></br>
		 * <u>Metodo que inserta los vecinos de un nodo.</u>
		 * 
		 * @param nombreDelNodo
		 * <u>Nombre del nodo al que le insertan sus vecinos.</u>
		 * 
		 * @param nombresDeVecinos
		 * <u>Array con nombres de los vecinos del nodo.</u>
		 * 
		 **/
		
		// ?? tengo que isertar pesos aca tambien ??
		public void rellenarVecinosDeNodo(String nombreDelNodo, String[] nombresDeVecinos) {
			
			int indexNodo = obtenerIndexDeNodo(nombreDelNodo);
			nodoGrafo nodoParaInsertarVecinos = grafo.get(indexNodo);
			
			for(int i = 0; i < nombresDeVecinos.length;i++) {
				nodoParaInsertarVecinos.insertarVecinoConPeso(nombresDeVecinos[i], null);
			}
			
		}
		
		/**
		 * <b>darVecinosDeNodo(): </b></br>
		 * <u>Metodo que busca el index del nodo en la lista.</u>
		 * 
		 * @param nombreDelNodo
		 * <u>Nombre del nodo del que se busca su index en la lista.</u>
		 *
		 *@return int del index correspondiente en la lista de nodos del grafo.
		 *
		 **/
		
		private int obtenerIndexDeNodo(String nombreDelNodo) {
			
			int index = 0;
			
			for(int i = 0; i < grafo.size(); i++){
				
				if(grafo.get(i).getNombre().equals(nombreDelNodo)) 
					index = i;
				
			}
			
			return index;
		}
}
