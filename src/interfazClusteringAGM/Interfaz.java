package interfazClusteringAGM;

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
import javax.swing.JDialog;

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
				if (sistema.getGrafo().getVerticesGrafo().size() >= Integer.parseInt(textFieldCantClusters.getText())) {
				sistema.generarClusters(Integer.parseInt(textFieldCantClusters.getText()));
				InterfazResultado interfaz = new InterfazResultado(sistema);
				interfaz.getFrame().setVisible(true);
			} else {
				ModalCantidadDeClusters dialog = new ModalCantidadDeClusters(sistema.getGrafo().getVerticesGrafo().size(), Integer.parseInt(textFieldCantClusters.getText()));
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				textFieldCantClusters.setText("");
				
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(164, 144, 121, 30);
		getFrame().getContentPane().add(btnNewButton);
	}

	public JTextField getTextFieldCantClusters() {
		return textFieldCantClusters;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
