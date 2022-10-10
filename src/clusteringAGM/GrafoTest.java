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
		grafoTest.insertarVertice("A", 5.0, 5.0);
		grafoTest.insertarVertice("B", 7.0, 10.0);
		grafoTest.insertarVertice("C", 12.0, 7.0);
		grafoTest.insertarVertice("D", 6.0, 1.0);
	}
	
	@Test
	public void testExisteVerticeTrue() {
		assertTrue(grafoTest.existeVertice("C"));
	}
	
	@Test
	public void testExisteVerticeFalse() {
		assertFalse(grafoTest.existeVertice("E"));
	}
	
	@Test // Testeando que ingresese un vertice al grafo.
	public void insertaVerticeGrafoDistintos(){
		double coordenadaX = 15.0;
		double coordenadaY = 16.0;
		
		try {
			grafoTest.insertarVertice("E", coordenadaX, coordenadaY);
			grafoTest.insertarVertice("F", coordenadaX, coordenadaY);
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

	@Test
	public void testTransformarArbolGeneradorMinimo() {
		grafoTest.CrearGrafo();
		grafoTest.transformarArbolGeneradorMinimo();
		assertTrue(grafoTest.getListaAristas().get(0).getPeso() == 4.123105625617661);
		assertTrue(grafoTest.getListaAristas().get(1).getPeso() == 5.385164807134504);
		assertTrue(grafoTest.getListaAristas().get(2).getPeso() == 5.830951894845301);
		assertTrue(grafoTest.getListaAristas().size() == 3);
		assertTrue(grafoTest.getVerticesGrafo().size() == 4);
	}
}
