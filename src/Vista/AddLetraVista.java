package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import Controlador.AddLetraControlador;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

public class AddLetraVista {

	private JPanel contentPane;
	public JFrame frame;
	private JPanel panel_1;
	private JLabel lblMensaje;
	private JButton btnInsertar;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JLabel lblTitulo;
	private JTextField textField;
	private JLabel lblArtista;
	private JTextField textField_1;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;
	private JLabel lblFalloAlIntroducir;
	private JPanel panel_2;
	private JButton btnVolver;

	/**
	 * Create the frame.
	 */
	public AddLetraVista() {
		AddLetraControlador alc = new AddLetraControlador();

	  frame = new JFrame();
	  frame.pack();
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	  int height = screenSize.height;
	  int width = screenSize.width;
	  frame.setSize(width/2, height/2);
	  frame.setLocationRelativeTo(null);
	  
	  frame.setTitle("MusLearn - Letras");
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		frame.setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(new LineBorder(new Color(238, 232, 170), 4, true));
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblTitulo = new JLabel("Titulo");
		panel.add(lblTitulo);
		
		alc.anyadirLetra(btnInsertar,textField, textField_1, textArea,lblFalloAlIntroducir);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		lblArtista = new JLabel("Artista");
		panel.add(lblArtista);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		lblMensaje = new JLabel("Introduce la letra de la canci\u00F3n abajo");
		panel_1.add(lblMensaje);
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		btnInsertar = new JButton("Insertar");
		panel_2.add(btnInsertar);
		
		lblFalloAlIntroducir = new JLabel("");
		panel_2.add(lblFalloAlIntroducir);

		lblFalloAlIntroducir.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		btnVolver = new JButton("Volver");

		panel_2.add(btnVolver);
		alc.volver(btnVolver,frame);
	}

}
