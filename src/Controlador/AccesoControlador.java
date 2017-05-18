package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Modelo.UsuarioModel;
import Vista.InvitadoVista;
import Vista.LoginVista;
import Vista.LyricsVista;
import Vista.RegistroVista;

public class AccesoControlador {

	public void irAcceder(JButton button,JFrame x){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginVista lc = new LoginVista();
				lc.frame.setVisible(true);
				x.dispose();

			}
		});
	}
	public void irRegistro(JButton button,JFrame x){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 RegistroVista frame = new RegistroVista();
                 frame.frame.setVisible(true);
 				 x.dispose();
			}
		});
	}
	public void irInvitado(JButton button,JFrame x){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvitadoVista frame = new InvitadoVista();
				frame.frame.setVisible(true);
				x.dispose();
			}
		});
	}
	
}
