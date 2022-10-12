package clusteringAGM;

import java.util.LinkedList;

public class Sistema {

	private Grafo grafo;
	 
	
	/**
	 * <b>Constructor: </b></br>
	 * <u>Constructor de Sistema.</u>
	 * 
	 **/
	
	public Sistema(){
		grafo = new Grafo();
		
	}

	/**
	 * <b>agregarVertice(): </b></br>
	 * <u>Metodo que inserta un nuevo vertice en el grafo con su posicion correspondiente.</u>
	 * 
	 * @param nombreDelVertice
	 * <i>Nombre del vertice.</i>
	 * @param posicionX
	 * <i>Coordenada del vertice en X.</i>
	 * @param posicionY
	 * <i>Coordenada del vertice en Y.</i>
	 **/
	
	public void agregarVertice(String nombreDelVertice, double posicionX, double posicionY) {
		try{
			grafo.insertarVertice(nombreDelVertice, posicionX, posicionY);
		} catch(Exception e) { e.printStackTrace(); }
		
	}
	
	public void crearGrafoAGM() {
		grafo.CrearGrafo();
		grafo.transformarArbolGeneradorMinimo();
	}
	

	public void generarClusters(Integer cantidad) {
		grafo.generarClusters(cantidad);
	}

	public Grafo getGrafo() {
		return grafo;
	}
}
