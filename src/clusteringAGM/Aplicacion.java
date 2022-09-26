package clusteringAGM;

import java.awt.Point;
import java.util.HashMap;

import javax.swing.JLabel;

public class Aplicacion {

	private Grafo grafo;
	private HashMap<String, Point> listaVertices;

	public Aplicacion() {

		listaVertices = new HashMap<>();
	}

	public void agregarVertice(String nombre, Integer posicionX, Integer posicionY) {
		Point coordenada = new Point(posicionX, posicionY);
		listaVertices.put(nombre, coordenada);

	}

	public void crearGrafo() {
		grafo = new Grafo(listaVertices.size());
		// tengo que recorrer listaVertices y agregar cada coordenada (x,y)
		// https://www.discoduroderoer.es/formas-de-recorrer-un-hashmap-en-java/

		for (int i = 0; i < listaVertices.size(); ++i) {
			for (String clave : listaVertices.keySet()) {
				grafo.agregarArista(listaVertices.get(clave));
			}
		}
	}

	public HashMap<String, Point> getListaVertices() {
		return listaVertices;
	}

}
