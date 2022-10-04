package clusteringAGM;

import java.awt.Point;
import java.util.HashMap;

import javax.swing.JLabel;

public class Sistema {

	private Grafo grafo;
	private HashMap<String, Point> listaVertices;

	public Sistema() {
		grafo = new Grafo();
		listaVertices = new HashMap<String, Point>();
	}

	public void agregarVertice(String nombre, Integer posicionX, Integer posicionY) {
		Point coordenada = new Point(posicionX, posicionY);
		listaVertices.put(nombre, coordenada);

	}

	public void crearGrafo() {
		for (int i = 0; i < listaVertices.size(); ++i) {
			for (String vertice1 : listaVertices.keySet()) {
				for (String vertice2 : listaVertices.keySet()) {
					if (vertice1 != vertice2) {
						grafo.agregarArista(listaVertices.get(vertice1), listaVertices.get(vertice2));

					}

				}
			}
		}
		grafo.arbolGeneradorMinimo(); // Una vez que tengo el grafo completo, recorto para generar un arbol
	}

	public void generarClusters(Integer cantidad) {
		// TODO Auto-generated method stub

	}

	public HashMap<String, Point> getListaVertices() {
		return listaVertices;
	}

}
