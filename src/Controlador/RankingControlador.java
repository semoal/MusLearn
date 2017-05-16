package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Vista.AddLetraVista;
import Vista.InicioVista;

public class RankingControlador {
	
	
	public void volverMain(JButton button, JFrame x){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x.dispose();
			}
		});	
	}
	
	public void exportarPDF(JButton button){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exportar");
			}
		});	
	}
}
