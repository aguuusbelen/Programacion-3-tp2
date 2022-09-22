package interfazClusteringAGM;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class interfazClusAGM {

		private JFrame frame;
		private JTextField ingeresoDePuntosGrafo;
		private JTextField ingeresoDeUnionPuntoGrafo;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						interfazClusAGM window = new interfazClusAGM();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public interfazClusAGM() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 1080, 520);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			
			
			// JTextField de ingresa de puntos del grafo
			ingeresoDePuntosGrafo = new JTextField();
			ingeresoDePuntosGrafo.setBounds(229, 23, 70, 25);
			ingeresoDePuntosGrafo.setColumns(1);
			
			// JTextField de ingresa de puntos del grafo
			ingeresoDeUnionPuntoGrafo = new JTextField();
			ingeresoDeUnionPuntoGrafo.setBounds(229, 52, 70, 25);
			ingeresoDeUnionPuntoGrafo.setColumns(1);
												
			// Label para nuevo punto
			JLabel ingreseNuevoPunto = new JLabel("Ingrese nombre de nuevo punto: ");
			ingreseNuevoPunto.setBounds(12, 27, 229, 17);

			// Label para uniones
			JLabel ingreseUniones = new JLabel("Ingrese uniones del nuevo punto: ");
			ingreseUniones.setBounds(12, 56, 265, 17);
			
			//Ingreso de elementos en interfaz
			frame.getContentPane().add(ingreseUniones);
			frame.getContentPane().add(ingreseNuevoPunto);
			frame.getContentPane().add(ingeresoDePuntosGrafo);					
			frame.getContentPane().add(ingeresoDeUnionPuntoGrafo);
			
			
			
		}
}
