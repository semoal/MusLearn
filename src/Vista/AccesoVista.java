package Vista;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import Controlador.AccesoControlador;

import javax.swing.JButton;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccesoVista {

	public JFrame frame;


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
		
		JButton btnAcceder = new JButton("Acceder");
		ac.irAcceder(btnAcceder,frame);
		panel.add(btnAcceder);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		ac.irRegistro(btnRegistrarse,frame);
		panel.add(btnRegistrarse);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		JButton btnInvitado = new JButton("Invitado");
		ac.irInvitado(btnInvitado,frame);
		panel.add(btnInvitado);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel Imagen = new JLabel("");
		Imagen.setIcon(new ImageIcon("C:\\Users\\jose\\Desktop\\imgres.jpg"));
		panel_1.add(Imagen);
		Imagen.setPreferredSize(new Dimension(250,250));
	}

}