package clusteringAGM;

import java.awt.Point;

public class Arista {
	private Point coor1;
	private Point coor2;
	private double peso;
	
	public Arista(Point coordenada1, Point coordenada2) {
		coor1 = coordenada1;
		coor2 = coordenada2;
		peso = calcularDistancia(coordenada1, coordenada2);
	}
	
	public double calcularDistancia(Point vertice1, Point vertice2) {
		
		double diferenciaX = vertice2.x - vertice1.x;
		double diferenciaY = vertice2.y - vertice1.y;
		double distancia = Math.sqrt(Math.pow(diferenciaX, 2) + Math.pow(diferenciaY, 2));
		
		return distancia;
	
	}

	public double getPeso() {
		return peso;
	}
	
	
}
