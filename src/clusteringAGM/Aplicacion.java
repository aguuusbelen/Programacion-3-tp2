package clusteringAGM;

import java.awt.Point;
import java.util.HashMap;

import javax.swing.JLabel;

public class Aplicacion {

	private Grafo grafo;
	private HashMap<String, Point> listaVertices;

	public Aplicacion() {
		grafo = new Grafo();
		listaVertices = new HashMap<>();
	}

	public void agregarVertice(String nombre, Integer posicionX, Integer posicionY) {
		Point coordenada = new Point(posicionX, posicionY);
		listaVertices.put(nombre, coordenada);
		System.out.print(listaVertices);
	}

}