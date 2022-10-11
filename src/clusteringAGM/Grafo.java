package clusteringAGM;

import java.util.LinkedList;

public class Grafo {

	private LinkedList<Vertice> listaVertices; 
	private LinkedList<Arista> listaAristas; 
	
	/**
	 * <b>Constructor: </b></br>
	 * <u>Constructor de grafo.</u>
	 * 
	 **/

	public Grafo() {
		listaVertices = new LinkedList<Vertice>();
		listaAristas = new LinkedList<Arista>();
	}

	/**
	 * <b>insertarVertice(): </b></br>
	 * <u>Metodo que inserta un nuevo vertice en el grafo con su posicion
	 * correspondiente.</u>
	 * 
	 * @param nombreDelVertice <i>Nombre del vertice.</i>
	 * @param coordenadaX      <i>Coordenada del vertice en X.</i>
	 * @param coordenadaY      <i>Coordenada del vertice en Y.</i>
	 * @throws Exception El nombre ya existe en el grafo
	 **/
	
	public void insertarVertice(String nombreDelVertice, double coordenadaX, double coordenadaY) throws Exception {

		if (existeVertice(nombreDelVertice) && nombreDelVertice != null)
			throw new Exception("El nombre ya existe en el grafo o es nulo.");

		Vertice nuevoVertice = new Vertice(nombreDelVertice);
		nuevoVertice.insertarCoordenadas(coordenadaX, coordenadaY);
		listaVertices.add(nuevoVertice);
	}

	/**
	 * <b>crearNuevaArista(): </b></br>
	 * <u>Metodo que une dos vertice en el grafo, y crea la arista
	 * correspondiente.</u>
	 * 
	 * @param vertice1 <i>Nombre del Vertice 1 de la arista.</i>
	 * @param vertice2 <i>Nombre del Vertice 2 de la arista.</i>
	 **/
	
	public void crearNuevaArista(Vertice vertice1, Vertice vertice2) {
		try{
			Arista nuevaArista = new Arista(vertice1, vertice2);
			nuevaArista.calcularDistancia();
			listaAristas.add(nuevaArista);
		} 
		catch(Exception e) {e.printStackTrace();}	
	}

	/**
	 * <b>existeAristaEnGrafo(): </b></br>
	 * <u>Metodo que devuelve si existe o no una arista en el grafo.</u>
	 * 
	 * @param vertice1 <i>Nombre del Vertice 1 de la arista.</i>
	 * @param vertice2 <i>Nombre del Vertice 2 de la arista.</i>
	 * @return True o False segun exista la arista en el grafo.
	 **/
	
	public boolean existeAristaEnGrafo(Vertice vertice1, Vertice vertice2) {
		boolean existeArista = false;
		for (int i = 0; i < listaAristas.size(); i++) {
			Arista arista = listaAristas.get(i);
			if (arista.getVertice1Artista() == vertice1 && arista.getVertice2Artista() == vertice2)
				existeArista = true;
		}
		return existeArista;
	}

	/**
	 * <b>existeVertice(): </b></br>
	 * <u>Metodo que devuelve si existe o no un vertice en el grafo.</u>
	 * 
	 * @param nombreDeVertice <i>Nombre del Vertice.</i>
	 * @return Retorna si el vertice existe true, si no false.
	 **/
	
	public boolean existeVertice(String nombreDeVertice) {
		boolean existe = false;
		for (int i = 0; i < listaVertices.size(); i++) {
			if (listaVertices.get(i).getNombre().equals(nombreDeVertice))
				existe = true;
		}
		return existe;
	}
	
	/**
	 * <b>CrearGrafo(): </b></br>
	 * <u>Metodo que une el grafo, creando las aristas de este.</u>
	 * 
	 **/
	
	public void CrearGrafo() {
		for (int i = 0; i < listaVertices.size() - 1; i++) {
			for (int j = i; j < listaVertices.size(); j++) {
				if (listaVertices.get(i) != listaVertices.get(j)
						&& !existeAristaEnGrafo(listaVertices.get(i), listaVertices.get(j))) {
					crearNuevaArista(listaVertices.get(i), listaVertices.get(j));
				}
			}
		}
	}
	
	public void transformarArbolGeneradorMinimo() {
		LinkedList<Vertice> listaVerticesAGM = new LinkedList<>();
		LinkedList<Arista> listaAristasAGM = new LinkedList<>();
		int indiceVertice = 0;
		Vertice verticeMin = listaVertices.get(indiceVertice);
		listaVerticesAGM.add(verticeMin);
		while (listaVerticesAGM.size() < listaVertices.size()) {
			Arista aristaMin = null;
			for (Arista arista : listaAristas) {
				if (listaVerticesAGM.contains(arista.getVertice1Artista())
						&& (aristaMin == null || aristaMin.getPeso() > arista.getPeso())
						&& !listaAristasAGM.contains(arista)) {
					aristaMin = arista;
					verticeMin = arista.getVertice2Artista();
				} else if (listaVerticesAGM.contains(arista.getVertice2Artista())
						&& (aristaMin == null || aristaMin.getPeso() > arista.getPeso())
						&& !listaAristasAGM.contains(arista)) {
					aristaMin = arista;
					verticeMin = arista.getVertice1Artista();
				}
			}
			listaVerticesAGM.add(verticeMin);
			listaAristasAGM.add(aristaMin);
			indiceVertice++;
		}
		listaVertices = listaVerticesAGM;
		listaAristas = listaAristasAGM;
	}
	
	public void generarClusters(Integer cantidad) {
		int contador = 0;
		while(cantidad - 1 > contador) {
			int indiceAristaMax = 0;
			for (int i = 0; i < listaAristas.size(); i++) {
				if (listaAristas.get(i).getPeso() > listaAristas.get(indiceAristaMax).getPeso()) {
					indiceAristaMax = i;
				}
			}
			eliminarArista(indiceAristaMax);
			contador++;
		}
	}
	
	
	public void eliminarArista(int indiceArista) {
		listaAristas.remove(indiceArista);
	}

	// Getters && Setters

	/**
	 * <b>getCantidadDeVertices():</b> Devuelve la cantidad de vertices del grafo.
	 **/

	public int getCantidadDeVertices() {
		return listaVertices.size();
	}

	/**
	 * <b>getVerticesGrafo(): </b> Devuelve los vertices del grafo.
	 **/

	public LinkedList<Vertice> getVerticesGrafo() {
		return listaVertices;
	}

	/**
	 * <b>getListaAristas(): </b>Devuelve la lista de aristas del grafo.
	 **/

	public LinkedList<Arista> getListaAristas() {
		return listaAristas;
	}
}
