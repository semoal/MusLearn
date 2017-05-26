package Vista;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import Controlador.InicioControlador;
import Modelo.Idioma;
import Modelo.UsuarioModel;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InicioVista2 {

	public JFrame frame;
	public JButton btnGuest;
	public JButton btnLogin;
	public JButton btnRegister;

	public InicioVista2() {
		initialize();
	}

	private void initialize() {
		InicioControlador ic = new InicioControlador();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 666, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/images.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		
		JButton closeButton = new JButton("");
		closeButton.setIcon(imageIcon);
		closeButton.setBorder(null);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		
		JLabel lblLoading = new JLabel("Loading ...");
		lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoading.setIcon(new ImageIcon(InicioVista2.class.getResource("/Imagen/loader.gif")));
		lblLoading.setBounds(263, 257, 162, 54);
		lblLoading.setVisible(false);
		frame.getContentPane().add(lblLoading);
		closeButton.setBounds(628, 17, 25, 37);
		frame.getContentPane().add(closeButton);
		
		JLabel label_2 = new JLabel(Idioma.getIdioma().getProperty("anyadirletras"));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(478, 279, 170, 43);
		frame.getContentPane().add(label_2);
		
		JButton lyrics = new JButton("");
		lyrics.setBorder(null);
		lyrics.setBackground((Color) null);
		lyrics.setBounds(478, 279, 170, 43);
		frame.getContentPane().add(lyrics);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/loginbutton.png"));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(478, 279, 170, 43);
		frame.getContentPane().add(label_4);
		
		JLabel image = new JLabel("");
		image.setIcon(new ImageIcon(AccesoVista2.class.getResource("/Imagen/je.png")));
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBounds(217, 47, 249, 254);
		frame.getContentPane().add(image);
		
		//Ir invitado
		JLabel lblGuest = new JLabel(Idioma.getIdioma().getProperty("estadisticas"));
		lblGuest.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuest.setForeground(Color.WHITE);
		lblGuest.setBounds(478, 83, 170, 43);
		frame.getContentPane().add(lblGuest);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/loginbutton.png").getImage().getScaledInstance(170,43, Image.SCALE_DEFAULT)));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(478, 83, 170, 43);
		frame.getContentPane().add(label_1);
		
		btnGuest = new JButton("");
		btnGuest.setBorder(null);
		btnGuest.setBackground((Color) null);
		btnGuest.setBounds(478, 83, 170, 43);
		frame.getContentPane().add(btnGuest);
		//Ir registro
		JLabel lblRegister = new JLabel(Idioma.getIdioma().getProperty("perfil"));
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setForeground(Color.WHITE);
		lblRegister.setBounds(22, 279, 162, 43);
		frame.getContentPane().add(lblRegister);
		
		btnRegister = new JButton("");
		btnRegister.setBorder(null);
		btnRegister.setBackground((Color) null);
		btnRegister.setBounds(22, 279, 170, 43);
		frame.getContentPane().add(btnRegister);
		
		JLabel label_3 = new JLabel();
		label_3.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/loginbutton.png").getImage().getScaledInstance(170,43, Image.SCALE_DEFAULT)));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(22, 279, 170, 43);
		frame.getContentPane().add(label_3);
		
		//Ir login
		JLabel lblLogin = new JLabel(Idioma.getIdioma().getProperty("video&letras"));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(22, 83, 162, 43);
		frame.getContentPane().add(lblLogin);
		
		btnLogin = new JButton("");
		btnLogin.setBorder(null);
		btnLogin.setBackground((Color) null);
		btnLogin.setBounds(22, 83, 170, 43);
		frame.getContentPane().add(btnLogin);
		
		JButton button2 = new JButton("");
		button2.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/volver.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		button2.setBounds(590, 17, 36, 37);
		button2.setBorder(null);
		button2.setBackground(null);
		frame.getContentPane().add(button2);
		ic.logout(button2, frame);
		
		JLabel btn1label = new JLabel("");
		btn1label.setHorizontalAlignment(SwingConstants.CENTER);
		btn1label.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/loginbutton.png").getImage().getScaledInstance(170,43, Image.SCALE_DEFAULT)));
		btn1label.setBounds(22, 83, 170, 43);
		frame.getContentPane().add(btn1label);
		
		JLabel info2 = new JLabel("");
		info2.setHorizontalAlignment(SwingConstants.CENTER);
		info2.setBounds(0, 334, 666, 32);
		frame.getContentPane().add(info2);
		
		JLabel info = new JLabel("");
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setBounds(0, 378, 666, 24);
		frame.getContentPane().add(info);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/background.png"));
		label.setBounds(0, -30, 666, 511);
		frame.getContentPane().add(label);
		
		int busquedas = UsuarioModel.getUser().getBusquedas();
		int max = 5;
		int total = max - busquedas;
		if(UsuarioModel.getUser().getBusquedas()>=5 && UsuarioModel.getUser().getRol().equalsIgnoreCase("invitado")){
			btnLogin.setEnabled(false);
			btn1label.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/loginbuttondisabled.png").getImage().getScaledInstance(170,43, Image.SCALE_DEFAULT)));
		}else{
			btnLogin.setEnabled(true);
			btn1label.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/loginbutton.png").getImage().getScaledInstance(170,43, Image.SCALE_DEFAULT)));
		}
		if(UsuarioModel.getUser().getRol().equalsIgnoreCase("invitado")){
			info.setText(Idioma.getIdioma().getProperty("invitadocheck"));
			info2.setText(Idioma.getIdioma().getProperty("tequedan")+" "+total+" "+Idioma.getIdioma().getProperty("busquedas2"));
			label_4.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/loginbuttondisabled.png").getImage().getScaledInstance(170,43, Image.SCALE_DEFAULT)));

		}
		
		ic.goMain(lyrics, lblLoading, frame);
		ic.goLetra(btnLogin, lblLoading, frame);
		ic.goRanking(btnGuest, lblLoading, frame);
		ic.irPerfil(btnRegister, lblLoading, frame);
	}
}
