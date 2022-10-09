package clusteringAGM;

import java.util.LinkedList;

public class Sistema {

	private Grafo grafo;
	private LinkedList<String> listaVertices; /* Una lista SOLO de nombres de vertices agregados al sistema. */
	
	/**
	 * <b>Constructor: </b></br>
	 * <u>Constructor de Sistema.</u>
	 * 
	 **/
	
	public Sistema(){
		grafo = new Grafo();
		listaVertices = new LinkedList<String>();
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
			listaVertices.add(nombreDelVertice);
			grafo.insertarVertice(nombreDelVertice, posicionX, posicionY);
		} catch(Exception e) { e.printStackTrace(); }
		
	}
	
	
	/**
	 * <b>unirElGrafo(): </b></br>
	 * <u>Metodo que crea las artistas del grafo (union de vertices del grafo).</u>
	 * 
	 **/
	
	public void unirElGrafo() {
		
		LinkedList<Vertice> listaDeVerticesDeGrafo = grafo.getVerticesGrafo();
		
		// Recorrido sobre vertices del grafo.
		// Metodo que recorre linkedlist de nombre de vertices agregados y compara y crea las aristas.
		for(int i = 0; i < listaDeVerticesDeGrafo.size(); i++)
			crearAristasDelGrafo(listaDeVerticesDeGrafo.get(i), listaDeVerticesDeGrafo);
		
		//grafo.arbolGeneradorMinimo();
	}
	
	public void crearGrafoAGM() {
		grafo.CrearGrafo();
		grafo.transformarArbolGeneradorMinimo();
	}
	
	/**
	 * <b>crearAristasDelGrafo(): </b></br>
	 * <u>Metodo que crea las aristas, pero verifica que no existan ya en el grafo esa arista.</u>
	 * 
	 * @param verticeDelGrafo
	 * <i>Vertice del que se le une a otro vertice, y crea las correspodientes aristas.</i>
	 * @param listaDeVertices
	 * <i>Lista de vertices del grafo.</i>
	 **/
	
	private void crearAristasDelGrafo(Vertice verticeDelGrafo, LinkedList<Vertice> listaDeVertices) {
		
		for(int i = 0; i < listaDeVertices.size(); i++){
			
			// Si el vertice es diferente a si mismo, se crea la arista correspondiente 
			// y ademas si la arista no existe previamente, la agrega.
			if(!verticeDelGrafo.getNombre().equals(listaDeVertices.get(i).getNombre()) && 
			   !grafo.existeAristaEnGrafo(verticeDelGrafo, listaDeVertices.get(i)))
				grafo.crearNuevaArista(verticeDelGrafo, listaDeVertices.get(i));
			
		}
		
	}
	
	public void generarClusters(Integer cantidad) {
		grafo.generarClusters(cantidad);
	}

//	public HashMap<String, Point> getListaVertices() {
//		return listaVertices;
//	}

}
