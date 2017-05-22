package Vista;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import Controlador.AccesoControlador;
import Modelo.Idioma;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import Modelo.Idioma;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class AccesoVista {

	public JFrame frame;
	public JComboBox comboBox;

	/**
	 * Create the application.
	 */
	public AccesoVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AccesoControlador ac = new AccesoControlador();
		frame = new JFrame();
	    frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = screenSize.height;
	    int width = screenSize.width;
	    frame.setSize(width/2, height/2);
	    frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnAcceder = new JButton(Idioma.getIdioma().getProperty("acceder"));
		ac.irAcceder(btnAcceder,frame);
		panel.add(btnAcceder);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		JButton btnRegistrarse = new JButton(Idioma.getIdioma().getProperty("registrarse"));
		ac.irRegistro(btnRegistrarse,frame);
		panel.add(btnRegistrarse);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		JButton btnInvitado = new JButton(Idioma.getIdioma().getProperty("invitado"));
		ac.irInvitado(btnInvitado,frame);
		panel.add(btnInvitado);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel Imagen = new JLabel("");
		Imagen.setHorizontalAlignment(SwingConstants.CENTER);
		Imagen.setIcon(new ImageIcon(AccesoVista.class.getResource("/Imagen/je.png")));
		panel_1.add(Imagen);
		Imagen.setPreferredSize(new Dimension(250,250));
		
		comboBox = new JComboBox();
		comboBox.setSelectedItem(Idioma.getIdioma().idim);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  Idioma.getIdioma().setIdioma((String) comboBox.getSelectedItem());
					  btnInvitado.setText(Idioma.getIdioma().getProperty("invitado"));
					  btnAcceder.setText(Idioma.getIdioma().getProperty("acceder"));
					  btnRegistrarse.setText(Idioma.getIdioma().getProperty("registrarse"));
					  frame.repaint();
					  frame.invalidate();
					  System.out.println(Idioma.getIdioma().idim);
					} catch(Exception ioe) {ioe.printStackTrace();}
				
			}
		});
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Espanyol", "Ingles"}));
		frame.getContentPane().add(comboBox, BorderLayout.NORTH);
	}

}