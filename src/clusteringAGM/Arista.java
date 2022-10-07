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
	
	public void calcularDistancia() {
		Point coordenadaDeVertice1 = vertice1.getcoordenadaVertice();
		Point coordenadaDeVertice2 = vertice2.getcoordenadaVertice();
		double diferenciaEnX = coordenadaDeVertice1.x - coordenadaDeVertice2.x;
		double diferenciaEnY = coordenadaDeVertice2.y - coordenadaDeVertice1.y;
		double distancia = Math.sqrt(Math.pow(diferenciaEnX, 2) + Math.pow(diferenciaEnY, 2));
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
