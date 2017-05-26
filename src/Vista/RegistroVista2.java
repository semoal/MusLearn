package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Controlador.RegistroControlador;
import Modelo.Idioma;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

public class RegistroVista2 {

	public JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	public RegistroVista2() {
		initialize();
	}

	private void initialize() {
		RegistroControlador rg = new RegistroControlador();
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 670, 450);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("");
		Color greyCustom = Color.decode("#f3f5f6");
		
		JButton closeButton = new JButton("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/images.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		closeButton.setIcon(imageIcon);
		closeButton.setBorder(null);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		
		JLabel lblCargando = new JLabel((Idioma.getIdioma().getProperty("cargando")));
		lblCargando.setBackground(Color.LIGHT_GRAY);
		lblCargando.setIcon(new ImageIcon(LoginVista2.class.getResource("/Imagen/loader.gif")));
		lblCargando.setVisible(false);
		
		JLabel lblUsuario = new JLabel(Idioma.getIdioma().getProperty("usuario"));
		lblUsuario.setBounds(140, 128, 61, 16);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel(Idioma.getIdioma().getProperty("contrasenya"));
		lblContrasea.setBounds(117, 186, 84, 16);
		frame.getContentPane().add(lblContrasea);
		
		JLabel lblRepiteContrasea = new JLabel(Idioma.getIdioma().getProperty("repitecontr"));
		lblRepiteContrasea.setBounds(75, 246, 132, 16);
		frame.getContentPane().add(lblRepiteContrasea);
		lblCargando.setBounds(305, 63, 102, 37);
		frame.getContentPane().add(lblCargando);
		
				
				JLabel lblStatus = new JLabel("");
				lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
				lblStatus.setBounds(6, 407, 297, 37);
				frame.getContentPane().add(lblStatus);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/volver.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		button.setBounds(590, 17, 36, 37);
		button.setBorder(null);
		button.setBackground(null);
		frame.getContentPane().add(button);
		rg.volverAcceso(button, frame);
		
		closeButton.setBounds(628, 17, 25, 37);
		frame.getContentPane().add(closeButton);
		
		JButton loginButton = new JButton("");
		loginButton.setBackground(null);
		loginButton.setBorder(null);
		loginButton.setBounds(220, 296, 297, 43);
		frame.getContentPane().add(loginButton);

		txtUsuario.setForeground(Color.DARK_GRAY);
		txtUsuario.setBackground(greyCustom);
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(220, 122, 271, 29);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBorder(null);
		passwordField_1.setBackground(new Color(243, 245, 246));
		passwordField_1.setBounds(220, 240, 286, 29);
		frame.getContentPane().add(passwordField_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/textpane.png").getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		label_1.setBounds(213, 230, 304, 43);
		frame.getContentPane().add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(greyCustom);
		passwordField.setBorder(null);
		passwordField.setBounds(220, 180, 286, 29);
		frame.getContentPane().add(passwordField);
		

		JLabel lblIniciarSesin = new JLabel(Idioma.getIdioma().getProperty("registrarse"));
		lblIniciarSesin.setForeground(Color.WHITE);
		lblIniciarSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesin.setBounds(213, 296, 304, 43);
		frame.getContentPane().add(lblIniciarSesin);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/textpane.png").getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(213, 115, 304, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/textpane.png").getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		label.setBounds(213, 173, 304, 43);
		frame.getContentPane().add(label);
		
		JLabel imageiniciar = new JLabel("");
		imageiniciar.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/loginbutton.png").getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		imageiniciar.setBounds(213, 296, 304, 43);
		frame.getContentPane().add(imageiniciar);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/background.png"));
		lblNewLabel.setBounds(-18, -34, 708, 520);
		frame.getContentPane().add(lblNewLabel);
		
		rg.creaUsuario(loginButton, txtUsuario, passwordField, passwordField_1, lblStatus);
	}
}
