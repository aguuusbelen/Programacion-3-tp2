package interfazClusteringAGM;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import clusteringAGM.Sistema;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class InterfazClusAGM {

	private JFrame frame;
	private JTextField textFieldPosX;
	private JTextField nombreVerticeGrafo;
	private JTextField textFieldPosY;
	private Sistema sistema;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazClusAGM window = new InterfazClusAGM();
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
	public InterfazClusAGM() {
		sistema = new Sistema();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 510, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// JtextField donde se ingresa el nombre de cada vertice del grafo
		nombreVerticeGrafo = new JTextField();
		nombreVerticeGrafo.setBounds(304, 52, 70, 25);
		nombreVerticeGrafo.setColumns(1);

		// Label para nuevo punto
		JLabel nuevoPunto = new JLabel("Ingrese nombre de nuevo punto: ");
		nuevoPunto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nuevoPunto.setBounds(47, 54, 247, 17);

		JLabel ingreseCoordenadas = new JLabel("Ingrese las coordenadas del punto: ");
		ingreseCoordenadas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ingreseCoordenadas.setBounds(47, 90, 345, 17);

		JLabel posicionX = new JLabel("Posici\u00F3n X:");
		posicionX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		posicionX.setBounds(156, 128, 86, 33);
		frame.getContentPane().add(posicionX);

		textFieldPosX = new JTextField();
		textFieldPosX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (!((int) e.getKeyChar() > 47 && (int) e.getKeyChar() < 58)) {
					e.consume();
				}
			}
		});
		textFieldPosX.setBounds(266, 130, 60, 33);
		textFieldPosX.setColumns(1);

		JLabel posicionY = new JLabel("Posici\u00F3n Y: ");
		posicionY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		posicionY.setBounds(156, 179, 86, 33);
		frame.getContentPane().add(posicionY);

		textFieldPosY = new JTextField();
		textFieldPosY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (!((int) e.getKeyChar() > 47 && (int) e.getKeyChar() < 58)) {
					e.consume();
				}
			}
		});
		textFieldPosY.setColumns(1);
		textFieldPosY.setBounds(266, 181, 60, 33);
		frame.getContentPane().add(textFieldPosY);

		// Ingreso de elementos en interfaz
		frame.getContentPane().add(ingreseCoordenadas);
		frame.getContentPane().add(nuevoPunto);
		frame.getContentPane().add(textFieldPosX);
		frame.getContentPane().add(nombreVerticeGrafo);

		JButton agregarVertice = new JButton("Agregar punto");
		agregarVertice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.agregarVertice(nombreVerticeGrafo.getText(), Integer.parseInt(textFieldPosX.getText()),
						Integer.parseInt(textFieldPosY.getText()));
				nombreVerticeGrafo.setText("");
				textFieldPosX.setText("");
				textFieldPosY.setText("");
			}
		}); 
		agregarVertice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		agregarVertice.setBounds(178, 252, 148, 46);
		frame.getContentPane().add(agregarVertice);
                
		JButton btnCrearGrafo = new JButton("Continuar");
		btnCrearGrafo.setBackground(new Color(152, 251, 152));
		btnCrearGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//sistema.crearGrafo();
				Interfaz interfaz = new Interfaz(sistema);
				interfaz.getFrame().setVisible(true);
				
			}
		});
		btnCrearGrafo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCrearGrafo.setBounds(178, 322, 148, 46);
		frame.getContentPane().add(btnCrearGrafo);
    
        } 

 }

