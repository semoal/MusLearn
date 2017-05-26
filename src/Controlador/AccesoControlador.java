package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Modelo.UsuarioModel;
import Vista.InvitadoVista2;
import Vista.LoginVista2;
import Vista.RegistroVista2;

public class AccesoControlador {

	public void irAcceder(JButton button,JFrame x){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LoginVista lc = new LoginVista();
				//lc.frame.setVisible(true);
				LoginVista2 xd = new LoginVista2();
				xd.frame.setVisible(true);
				
				x.dispose();

			}
		});
	}
	public void irRegistro(JButton button,JFrame x){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroVista2 window = new RegistroVista2();
				window.frame.setVisible(true); 
				//RegistroVista frame = new RegistroVista();
                //frame.frame.setVisible(true);
 				 x.dispose();
			}
		});
	}
	public void irInvitado(JButton button,JFrame x){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//InvitadoVista frame = new InvitadoVista();
				//frame.frame.setVisible(true);
				InvitadoVista2 window = new InvitadoVista2();
				window.frame.setVisible(true);
				x.dispose();
			}
		});
	}
	
}
