package interfazClusteringAGM;

import javax.swing.JFrame;

import clusteringAGM.Arista;
import clusteringAGM.Sistema;
import clusteringAGM.Vertice;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JSeparator;

public class InterfazResultado {

	private Sistema sistema;
	private JFrame frame;

	public InterfazResultado(Sistema sistema) {
		this.sistema = sistema;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		dibujarAristas();
		dibujarVertices();
		frame.revalidate();
		frame.repaint();
	}

	private void dibujarVertices() {
		for(Vertice vertice: sistema.getGrafo().getVerticesGrafo()) {
			dibujarVertice(vertice);
		}
	}

	private void dibujarVertice(Vertice vertice) {
		Panel panel = new Panel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(vertice.getcoordenadaVertice().x, vertice.getcoordenadaVertice().y, 10, 10);
		frame.getContentPane().add(panel);
	}

	private void dibujarAristas() {
		for(Arista arista: sistema.getGrafo().getListaAristas()) {
			dibujarArista(arista);
		}
	}

	private void dibujarArista(Arista arista) {
		// Dejamos en coorX la coordenada que esta mas a la izquierda
		int coorX = 5;
		int coorXDestino = 5;
		int coorY = 5;
		int coorYDestino = 5;
		if (arista.getCoordenada1().x < arista.getCoordenada2().x) {
			coorX += arista.getCoordenada1().x;
			coorY += arista.getCoordenada1().y;
			coorXDestino += arista.getCoordenada2().x;
			coorYDestino += arista.getCoordenada2().y;
		} else {
			coorX += arista.getCoordenada2().x;
			coorY += arista.getCoordenada2().y;
			coorXDestino += arista.getCoordenada1().x;
			coorYDestino += arista.getCoordenada1().y;
		}
		// 1. X1 < X2 && Y1 < Y2 => (x++, y--)
		// 2. x1 < x2 && y1 > y2 => (x++, y++)
		
		// Calulamos la diferencia para sumar el eje X, cada cierto porcentaje:
		double difX = coorXDestino - coorX;
		double difY = (coorY < coorYDestino) ? coorYDestino - coorY : coorY - coorYDestino;
		double porcentajeDeAumentoParaX = difX / difY;
		double porcentajeDeAumentoParaY = difY / difX;
		double contadorAumentoX = porcentajeDeAumentoParaX;
		double contadorAumentoY = porcentajeDeAumentoParaY;
		
		while(coorX != coorXDestino || coorY != coorYDestino) {
			JSeparator separator = new JSeparator();
			separator.setBounds(coorX, coorY, 1, 1);
			separator.setBackground(Color.BLUE);
			frame.getContentPane().add(separator);
			if (porcentajeDeAumentoParaX < porcentajeDeAumentoParaY) {
				if (contadorAumentoX >= 1){
					coorX++;
					contadorAumentoX--;
				}
				contadorAumentoX += porcentajeDeAumentoParaX;
				if (coorY < coorYDestino) {
					coorY++;
				} else if (coorY > coorYDestino) {
					coorY--;
				}
			} else if (porcentajeDeAumentoParaX > porcentajeDeAumentoParaY) {
				if (contadorAumentoY >= 1){
					if (coorY < coorYDestino) {
						coorY++;
					} else if (coorY > coorYDestino) {
						coorY--;
					}
					contadorAumentoY--;
				}
				contadorAumentoY += porcentajeDeAumentoParaY;
				if (coorX != coorXDestino) {
					coorX++;
				}
			} else {
				coorX++;
				if (coorY < coorYDestino) {
					coorY++;
				} else if (coorY > coorYDestino) {
					coorY--;
				}
			}
		}
	}

	public JFrame getFrame() {
		return frame;
	}
}
