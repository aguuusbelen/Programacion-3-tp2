package interfazClusteringAGM;

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

public class Interfaz {

	private JFrame frame;
	private JTextField textFieldCantClusters;
	private Sistema sistema;
	/**
	 * Create the application.
	 */
	public Interfaz(Sistema sistema) {
		this.sistema = sistema;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		
		textFieldCantClusters = new JTextField();
		textFieldCantClusters.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				if (!((int) e.getKeyChar() > 47 && (int) e.getKeyChar() < 58)) {
					e.consume();
				}
			}
		});
		textFieldCantClusters.setBounds(282, 67, 96, 30);
		getFrame().getContentPane().add(textFieldCantClusters);
		textFieldCantClusters.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingrese cantidad de clusters:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(56, 67, 216, 30);
		getFrame().getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("LISTO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sistema.generarClusters(Integer.parseInt(textFieldCantClusters.getText()));
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(164, 144, 121, 30);
		getFrame().getContentPane().add(btnNewButton);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
