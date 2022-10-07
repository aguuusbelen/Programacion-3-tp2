package clusteringAGM;

import java.awt.Point;

public class Arista {
	
	private double peso; // Peso de la arista
	private Vertice vertice1; //Vertice de la arista
	private Vertice vertice2; //Vertice de la arista
	
	
	public Arista(Vertice vertice1, Vertice vertice2) {
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
	}
	
	public void calcularDistancia(Point vertice1, Point vertice2) {
		
		double diferenciaX = vertice2.x - vertice1.x;
		double diferenciaY = vertice2.y - vertice1.y;
		double distancia = Math.sqrt(Math.pow(diferenciaX, 2) + Math.pow(diferenciaY, 2));
		
		peso = distancia;
	}

	// Getters && Setters
	public double getPeso() {
		return peso;
	}

	public Point getCoordenada1() {
		return vertice1.getcoordenadaVertice();
	}

	public Point getCoordenada2() {
		return vertice2.getcoordenadaVertice();
	}
	
	public Vertice getVertice1Artista() {
		return this.vertice1;
	}
	
	public Vertice getVertice2Artista() {
		return this.vertice2;
	}
	
}
