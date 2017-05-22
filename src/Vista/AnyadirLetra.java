package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import Controlador.AddLetraControlador;
import Modelo.Idioma;

import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class AnyadirLetra {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Create the application.
	 */
	public AnyadirLetra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AddLetraControlador adc = new AddLetraControlador();
		frame = new JFrame();
		frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = screenSize.height;
	    int width = screenSize.width;
	    frame.setSize(width/2, height/2);
	    frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setVgap(2);
		panel.setBackground(UIManager.getColor("ToolTip.background"));
		frame.getContentPane().add(panel);
		
		JLabel lblTituloCancion = new JLabel(Idioma.getIdioma().getProperty("titulo"));
		panel.add(lblTituloCancion);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(Idioma.getIdioma().getProperty("artista"));
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel_1 = new JLabel(Idioma.getIdioma().getProperty("anyadirletra"));
		panel_1.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setColumns(30);
		textArea.setRows(10);
		scrollPane.setViewportView(textArea);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		
		JButton btnAadirCancion = new JButton(Idioma.getIdioma().getProperty("anyadircancion"));
		panel_2.add(btnAadirCancion);
		
		JButton btnVolver = new JButton(Idioma.getIdioma().getProperty("volver"));
		panel_2.add(btnVolver);
		adc.volver(btnVolver, frame);
		
		JLabel loading = new JLabel("");
		panel_2.add(loading);
		
		adc.anyadirLetra(btnAadirCancion, textField, textField_1, textArea, loading);
		
		adc.volver(btnVolver, frame);

	}

}
