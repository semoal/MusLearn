package Inicio;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;

import Vista.AccesoVista2;
import Vista.LoginVista2;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Font;

public class Splash2 {

	public JFrame frame;
	public Splash2() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		Color customBlue = Color.decode("#24457c");
		frame.getContentPane().setBackground(customBlue);
		frame.setBackground(customBlue);
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		JLabel lblCargando = new JLabel("CARGANDO...");
		lblCargando.setFont(new Font("Lucida Grande", Font.PLAIN, 58));
		lblCargando.setForeground(Color.WHITE);
		lblCargando.setBounds(6, 301, 412, 99);
		frame.getContentPane().add(lblCargando);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(customBlue);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Splash2.class.getResource("/Imagen/splash.gif")));
		lblNewLabel.setBounds(0, 0, 650, 400);
		frame.getContentPane().add(lblNewLabel);
		iniciarHilo(lblCargando);
	}
	private void iniciarHilo(JLabel lblCargando){
		Thread hilo = new Thread (new Runnable() {
			public void run() {
			int x = 0;
				try {
					while (x<100){
						x++;
						lblCargando.setText(x+"%");
						Thread.sleep(30);
					}	
					frame.dispose();
					AccesoVista2 window = new AccesoVista2();
					window.frame.setVisible(true);
				} catch (Exception e) {
				}
			
			}
		});
		hilo.start();
	}
}
