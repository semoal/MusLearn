package Vista;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Controlador.AccesoControlador;
import Modelo.Idioma;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AccesoVista2 {

	public JFrame frame;
	public JButton btnGuest;
	public JButton btnLogin;
	public JButton btnRegister;

	public AccesoVista2() {
		initialize();
	}

	private void initialize() {
		AccesoControlador ac = new AccesoControlador();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 666, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JButton closeButton = new JButton("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(AccesoVista2.class.getResource("/Imagen/images.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		closeButton.setIcon(imageIcon);
		closeButton.setBorder(null);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(AccesoVista2.class.getResource("/Imagen/je.png")));
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBounds(217, 47, 249, 254);
		frame.getContentPane().add(image);
		
		//Ir invitado
		JLabel lblGuest = new JLabel("Guest");
		lblGuest.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuest.setForeground(Color.WHITE);
		lblGuest.setBounds(470, 356, 170, 43);
		frame.getContentPane().add(lblGuest);
		
		btnGuest = new JButton("");
		btnGuest.setBorder(null);
		btnGuest.setBackground((Color) null);
		btnGuest.setBounds(470, 356, 170, 43);
		frame.getContentPane().add(btnGuest);
		//Ir registro
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setBounds(254, 356, 170, 43);
		frame.getContentPane().add(lblRegister);
		
		btnRegister = new JButton("");
		btnRegister.setBorder(null);
		btnRegister.setBackground((Color) null);
		btnRegister.setBounds(254, 356, 170, 43);
		frame.getContentPane().add(btnRegister);
		closeButton.setBounds(628, 17, 25, 37);
		frame.getContentPane().add(closeButton);
		//Ir login
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(43, 356, 170, 43);
		frame.getContentPane().add(lblLogin);
		
		btnLogin = new JButton("");
		btnLogin.setBorder(null);
		btnLogin.setBackground((Color) null);
		btnLogin.setBounds(43, 356, 170, 43);
		frame.getContentPane().add(btnLogin);
		ac.irAcceder(btnLogin, frame);
		ac.irInvitado(btnGuest, frame);
		ac.irRegistro(btnRegister, frame);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setSelectedItem(Idioma.getIdioma().idim);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  Idioma.getIdioma().setIdioma((String) comboBox.getSelectedItem());
					  lblGuest.setText(Idioma.getIdioma().getProperty("invitado"));
					  lblLogin.setText(Idioma.getIdioma().getProperty("acceder"));
					  lblRegister.setText(Idioma.getIdioma().getProperty("registrarse"));
					  btnGuest.setBackground(null);
					  btnGuest.setBorder(null);
					  btnLogin.setBackground(null);
					  btnLogin.setBorder(null);
					  btnRegister.setBackground(null);
					  btnRegister.setBorder(null);
					  frame.repaint();
					  frame.invalidate();
					} catch(Exception ioe) {ioe.printStackTrace();}
				
			}
		});
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ingles", "Espanol"}));
		comboBox.setBounds(263, 290, 170, 27);
		frame.getContentPane().add(comboBox);
		
		JLabel btn1label = new JLabel("");
		btn1label.setHorizontalAlignment(SwingConstants.CENTER);
		btn1label.setIcon(new ImageIcon(new ImageIcon(AccesoVista2.class.getResource("/Imagen/loginbutton.png")).getImage().getScaledInstance(170,43, Image.SCALE_DEFAULT)));
		btn1label.setBounds(43, 356, 170, 43);
		frame.getContentPane().add(btn1label);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(new ImageIcon(AccesoVista2.class.getResource("/Imagen/loginbutton.png")).getImage().getScaledInstance(170,43, Image.SCALE_DEFAULT)));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(254, 356, 170, 43);
		frame.getContentPane().add(label_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(new ImageIcon(AccesoVista2.class.getResource("/Imagen/loginbutton.png")).getImage().getScaledInstance(170,43, Image.SCALE_DEFAULT)));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(470, 356, 170, 43);
		frame.getContentPane().add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AccesoVista2.class.getResource("/Imagen/background.png")));
		label.setBounds(0, -30, 666, 511);
		frame.getContentPane().add(label);
	}
}
