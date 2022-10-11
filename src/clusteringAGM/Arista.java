package clusteringAGM;

import java.awt.Point;

public class Arista {
	
	private double peso; 
	private Vertice vertice1; 
	private Vertice vertice2;
	
	/**
	 * <b>Constructor: </b></br>
	 * <u>Constructor de Arista.</u>
	 *
	 **/
	
	public Arista(Vertice vertice1, Vertice vertice2) throws Exception {
		if(vertice1 == null || vertice2 == null)
			throw new Exception("Alguno de los vertices, es nulo. No se puede crear la arista.");
		
		this.vertice1 = vertice1;
		this.vertice2 = vertice2;
	}
	
	/**
	 * <b>calcularDistancia(): </b></br>
	 * <u>Metodo que calcula el peso de una arista.<u>
	 *
	 **/
	
	public void calcularDistancia(){
		Point coordenadaDeVertice1 = vertice1.getcoordenadaVertice();
		Point coordenadaDeVertice2 = vertice2.getcoordenadaVertice();
		double diferenciaEnX = coordenadaDeVertice1.x - coordenadaDeVertice2.x;
		double diferenciaEnY = coordenadaDeVertice2.y - coordenadaDeVertice1.y;
		double distancia = Math.sqrt(Math.pow(diferenciaEnX, 2) + Math.pow(diferenciaEnY, 2));
		peso = distancia;
	}

	// Getters & Setters
	
	/**
	 * <b>getPeso(): </b> Devuelve el peso de la arista.
	 **/
	public double getPeso() {
		return peso;
	}
	
	/**
	 * <b>getCoordenada1(): </b> Devuelve coordenada del vertice 1.
	 **/
	public Point getCoordenada1() {
		return vertice1.getcoordenadaVertice();
	}

	/**
	 * <b>getCoordenada2(): </b> Devuelve coordenada del vertice 2.
	 **/
	public Point getCoordenada2() {
		return vertice2.getcoordenadaVertice();
	}
	
	/**
	 * <b>getVertice1Artista(): </b> Devuelve el vertice 1 de la arista.
	 **/
	public Vertice getVertice1Artista() {
		return this.vertice1;
	}
	
	/**
	 * <b>getVertice2Artista(): </b> Devuelve el vertice 2 de la arista.
	 **/
	public Vertice getVertice2Artista() {
		return this.vertice2;
	}
	
}
