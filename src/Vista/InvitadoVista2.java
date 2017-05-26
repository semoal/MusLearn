package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Controlador.InvitadoControlador;
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

public class InvitadoVista2 {

	public JFrame frame;
	private JTextField txtUsuario;

	public InvitadoVista2() {
		initialize();
	}

	private void initialize() {
		InvitadoControlador ic = new InvitadoControlador();
 		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 670, 450);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setText(Idioma.getIdioma().getProperty("introducealias"));
		txtUsuario.setToolTipText("");
		Color greyCustom = Color.decode("#f3f5f6");
		
		JButton closeButton = new JButton("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(InvitadoVista2.class.getResource("/Imagen/images.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		closeButton.setIcon(imageIcon);
		closeButton.setBorder(null);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		
		JLabel label_2 = new JLabel(Idioma.getIdioma().getProperty("aviso2"));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setAlignmentX(0.5f);
		label_2.setBounds(35, 227, 605, 50);
		frame.getContentPane().add(label_2);
		
		JLabel label = new JLabel(Idioma.getIdioma().getProperty("aviso1"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setAlignmentX(0.5f);
		label.setBounds(25, 186, 628, 30);
		frame.getContentPane().add(label);
				
		
		closeButton.setBounds(628, 17, 25, 37);
		frame.getContentPane().add(closeButton);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(new ImageIcon(InvitadoVista2.class.getResource("/Imagen/volver.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		button.setBounds(590, 17, 36, 37);
		button.setBorder(null);
		button.setBackground(null);
		frame.getContentPane().add(button);
		ic.volverAcceso(button,frame);

		txtUsuario.setForeground(Color.DARK_GRAY);
		txtUsuario.setBackground(greyCustom);
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(192, 115, 297, 43);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);	
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(InvitadoVista2.class.getResource("/Imagen/textpane.png")).getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(185, 115, 304, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton loginButton = new JButton("");
		loginButton.setBackground(null);
		loginButton.setBorder(null);
		loginButton.setBounds(199, 383, 289, 43);
		frame.getContentPane().add(loginButton);

		JLabel lblIniciarSesin = new JLabel(Idioma.getIdioma().getProperty("continuar"));
		lblIniciarSesin.setForeground(Color.WHITE);
		lblIniciarSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesin.setBounds(192, 383, 296, 43);
		frame.getContentPane().add(lblIniciarSesin);
		
		JLabel imageiniciar = new JLabel("");
		imageiniciar.setIcon(new ImageIcon(new ImageIcon(InvitadoVista2.class.getResource("/Imagen/loginbutton.png")).getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		imageiniciar.setBounds(192, 383, 304, 43);
		frame.getContentPane().add(imageiniciar);
		
		JLabel error = new JLabel("");
		error.setHorizontalAlignment(SwingConstants.CENTER);
		error.setBounds(171, 289, 329, 16);
		frame.getContentPane().add(error);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(InvitadoVista2.class.getResource("/Imagen/background.png")));
		lblNewLabel.setBounds(-18, -34, 708, 520);
		frame.getContentPane().add(lblNewLabel);
		
		ic.creaInvitado(loginButton, txtUsuario, error);

	}
}
