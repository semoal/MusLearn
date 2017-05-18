package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vista.InvitadoVista;
import Vista.LyricsVista;
import Vista.RegistroVista;

public class AccesoControlador {

	public void irAcceder(JButton button){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LyricsVista lc = new LyricsVista();
				lc.frame.setVisible(true);
			}
		});
	}
	public void irRegistro(JButton button){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 RegistroVista frame = new RegistroVista();
                 frame.setVisible(true);
			}
		});
	}
	public void irInvitado(JButton button){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvitadoVista frame = new InvitadoVista();
				frame.setVisible(true);
			}
		});
	}
	
}
