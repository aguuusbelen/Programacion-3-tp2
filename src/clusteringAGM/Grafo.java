package clusteringAGM;

import java.util.LinkedList;
import java.util.List;

public class Grafo {

	// Deberia cambiar el nombre a vertice por que no es un arbol.
	// private List<Vertice> grafo; /* List que contiene los nodos del grafo */
	private boolean[][] A; // matriz de adyacencia

	/**
	 * <b>Constructor: </b></br>
	 * <u>Constructor de grafo.</u>
	 * 
	 **/

	public Grafo(int vertices) {
		// grafo = new LinkedList<>();
		A = new boolean[vertices][vertices];
	}

	/**
	 * <b>insertarVertice (): </b></br>
	 * <u>Metodo que inserta un nuevo nodo en el grafo.</u>
	 * 
	 **/

	public void insertarVertice(String nombreDelVertice) {

		Vertice nodoGrafo = new Vertice(nombreDelVertice);
		grafo.add(nodoGrafo);

	}

	/**
	 * <b>rellenarVecinosDeNodo(): </b></br>
	 * <u>Metodo que inserta los vecinos de un nodo.</u>
	 * 
	 * @param nombreDelNodo    <u>Nombre del nodo al que le insertan sus
	 *                         vecinos.</u>
	 * 
	 * @param nombresDeVecinos <u>Array con nombres de los vecinos del nodo.</u>
	 * 
	 **/

	// ?? tengo que isertar pesos aca tambien ??
	public void rellenarVecinosDeVertice(String nombreDelNodo, String[] nombresDeVecinos) {

		int indexNodo = obtenerIndexDeNodo(nombreDelNodo);
		Vertice nodoParaInsertarVecinos = grafo.get(indexNodo);

		for (int i = 0; i < nombresDeVecinos.length; i++) {
			nodoParaInsertarVecinos.insertarVecinoConPeso(nombresDeVecinos[i], null);
		}

	}

	/**
	 * <b>obtenerVecinosDeVertice(): </b></br>
	 * <u>Metodo que da todos los vecinos de un vertice.</u>
	 * 
	 * @param nombreDeVertice <u>Nombre del vertice del que se busca sus
	 *                        vecinos.</u>
	 *
	 * @return Array de string de vecinos del correspondiente vertice del grafo.
	 *
	 **/

	public String[] obtenerVecinosDeVertice(String nombreDeNodo) {

		int indexNodo = obtenerIndexDeNodo(nombreDeNodo);
		Vertice nodoParaInsertarVecinos = grafo.get(indexNodo);

		String[] vecinosDeNodo = nodoParaInsertarVecinos.darVecinos();

		return vecinosDeNodo;

	}

	/**
	 * <b>darVecinosDeNodo(): </b></br>
	 * <u>Metodo que busca el index del nodo en la lista.</u>
	 * 
	 * @param nombreDelNodo <u>Nombre del nodo del que se busca su index en la
	 *                      lista.</u>
	 *
	 * @return int del index correspondiente en la lista de nodos del grafo.
	 *
	 **/

	private int obtenerIndexDeNodo(String nombreDelNodo) {

		int index = 0;

		for (int i = 0; i < grafo.size(); i++) {

			if (grafo.get(i).getNombre().equals(nombreDelNodo))
				index = i;

		}

		return index;
	}
}
