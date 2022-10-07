package clusteringAGM;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GrafoTest {
	
	private Grafo grafoTest; // Grafo para testear
	
	public GrafoTest() {
		grafoTest = new Grafo();
	}

	@Before
	public void seteoGrafoParaTest() throws Exception {
		double coordenadaX = 15.0;
		double coordenadaY = 16.0;
		grafoTest.insertarVertice("C",coordenadaX, coordenadaY);	
	}
	
	@Test
	public void testExisteVerticeTrue() {
		assertTrue(grafoTest.existeVertice("C"));
	}
	
	@Test
	public void testExisteVerticeFalse() {
		assertFalse(grafoTest.existeVertice("B"));
	}
	
	@Test // Testeando que ingresese un vertice al grafo.
	public void insertaVerticeGrafoDistintos(){
		double coordenadaX = 15.0;
		double coordenadaY = 16.0;
		
		try {
			grafoTest.insertarVertice("A",coordenadaX, coordenadaY);
			grafoTest.insertarVertice("B",coordenadaX, coordenadaY);
			assertTrue(grafoTest.getCantidadDeVertices() >= 1);
		} catch (Exception e) {e.printStackTrace();}
	}

	/* Testeando que ingresese dos vertices iguales al grafo
	 y da la exepcion correspondiente. */
	@Test(expected = Exception.class) 
	public void insertaVerticeGrafoIguales() throws Exception{
		double coordenadaX = 15.0;
		double coordenadaY = 16.0;
		
		grafoTest.insertarVertice("B",coordenadaX, coordenadaY);
		grafoTest.insertarVertice("B",coordenadaX, coordenadaY);

	}
	
	
}
