package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Controlador.LoginControlador;
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

public class LoginActive {

	public JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField passwordField;

	public LoginActive() {
		initialize();
	}

	private void initialize() {
		LoginControlador lg = new LoginControlador();
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 670, 450);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setEnabled(false);
		txtUsuario.setEditable(false);
		txtUsuario.setText("Grupo2\\Administrador");
		txtUsuario.setToolTipText("");
		Color greyCustom = Color.decode("#f3f5f6");
		
		JButton closeButton = new JButton("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(LoginVista2.class.getResource("/Imagen/images.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
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
		lblCargando.setBounds(277, 63, 102, 37);
		frame.getContentPane().add(lblCargando);
		
				
		JLabel lblStatus = new JLabel("");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(6, 407, 297, 37);
		frame.getContentPane().add(lblStatus);
				
		
		closeButton.setBounds(628, 17, 25, 37);
		frame.getContentPane().add(closeButton);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(new ImageIcon(LoginVista2.class.getResource("/Imagen/volver.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		button.setBounds(590, 17, 36, 37);
		button.setBorder(null);
		button.setBackground(null);
		frame.getContentPane().add(button);
		lg.volverAcceso(button, frame);
		
		JButton loginButton = new JButton("");
		loginButton.setBackground(null);
		loginButton.setBorder(null);
		loginButton.setBounds(192, 237, 297, 43);
		frame.getContentPane().add(loginButton);

		txtUsuario.setForeground(Color.DARK_GRAY);
		txtUsuario.setBackground(greyCustom);
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(192, 121, 286, 29);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(greyCustom);
		passwordField.setBorder(null);
		passwordField.setBounds(192, 180, 286, 29);
		frame.getContentPane().add(passwordField);
		

		JLabel lblIniciarSesin = new JLabel(Idioma.getIdioma().getProperty("iniciar"));
		lblIniciarSesin.setForeground(Color.WHITE);
		lblIniciarSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesin.setBounds(185, 237, 327, 43);
		frame.getContentPane().add(lblIniciarSesin);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(LoginVista2.class.getResource("/Imagen/textpane.png")).getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(185, 115, 304, 43);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(new ImageIcon(LoginVista2.class.getResource("/Imagen/textpane.png")).getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		label.setBounds(185, 173, 304, 43);
		frame.getContentPane().add(label);
		
		JLabel imageiniciar = new JLabel("");
		imageiniciar.setIcon(new ImageIcon(new ImageIcon(LoginVista2.class.getResource("/Imagen/loginbutton.png")).getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		imageiniciar.setBounds(185, 237, 304, 43);
		frame.getContentPane().add(imageiniciar);
		
		lg.activeDirectoryLogin(loginButton, passwordField,lblCargando,lblStatus,frame);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(LoginVista2.class.getResource("/Imagen/background.png")));
		lblNewLabel.setBounds(-18, -34, 708, 520);
		frame.getContentPane().add(lblNewLabel);
	}
}
