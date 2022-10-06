package clusteringAGM;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Grafo {

	private List<Vertice> grafo; /* List que contiene los nodos del grafo */	
	private HashMap <Arista, Integer> listaAristas; //<String, Integer>	
	private HashMap <Arista, Integer> grafoAGM;

	/**
	 * <b>Constructor: </b></br>
	 * <u>Constructor de grafo.</u>
	 * 
	 **/

	public Grafo() {
		grafo = new LinkedList<Vertice>();
		listaAristas = new HashMap<>();
	}

	public void agregarArista(Point vertice1, Point vertice2) {
		Arista arista = new Arista(vertice1, vertice2);
		Integer peso = (int) arista.getPeso();
		listaAristas.put(arista, peso);
	}	
	
	public HashMap<Arista, Integer> getListaAristas() {
		return listaAristas;
	}

	public boolean existeAristaEnGrafo(Point point1, Point point2) {
		for (Arista arista : listaAristas.keySet()) {
			if ((point1 == arista.getCoor1() && point2 == arista.getCoor2()) || 
					(point2 == arista.getCoor1() && point1 == arista.getCoor2())) {
				return true;
			}
		}
		return false;
	}
	
// https://es.wikibooks.org/wiki/Programaci%C3%B3n_en_Java/Ap%C3%A9ndices/Implementaci%C3%B3n_del_Algoritmo_de_Kruskal_en_Java
	public void arbolGeneradorMinimo(int cantidadVertices) {
		List<Point> listaVertices = new ArrayList<>();
		while(listaVertices.size() < cantidadVertices) {
			
		}
/*		for(Arista arista: listaAristas.keySet()) {
		}*/
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

            for(String nombresDeVecino : nombresDeVecinos) {
                nodoParaInsertarVecinos.insertarVecinoConPeso(nombresDeVecino, null);
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
