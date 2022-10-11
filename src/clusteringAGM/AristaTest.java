package clusteringAGM;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class AristaTest {

	Arista aristaTest;
	Vertice vertice1;
	Vertice vertice2;
	
	@Before
	public void test() throws Exception{
		vertice1 = new Vertice("A");
		vertice1.insertarCoordenadas(15.0, 25.0);
		vertice2 = new Vertice("B");
		vertice2.insertarCoordenadas(25.0, 8.0);
		aristaTest = new Arista(vertice1, vertice2);
	}

	@Test /* Testeo de funcion calcular Distancia/Peso de Arista. */
	public void testCalcularPesoTrue() {
		aristaTest.calcularDistancia();
		assertTrue(aristaTest.getPeso() == 19.72308292331602);	
	}
}
