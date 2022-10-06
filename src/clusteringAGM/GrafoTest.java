package clusteringAGM;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class GrafoTest {
	
	private Grafo grafoTest;
	
	public GrafoTest() {
		grafoTest = new Grafo();
	}

	
	@Test // Testeando que ingresese un vertice al grafo.
	public void insertaVerticeGrafo() {
		
		double coordenadaX = 15.0;
		double coordenadaY = 16.0;
		grafoTest.insertarVertice("A",coordenadaX, coordenadaY);
		
		assertTrue(grafoTest.getCantidadDeVertices() >= 1);
	}

	
}
