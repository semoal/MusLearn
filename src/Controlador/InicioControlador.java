package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Modelo.UsuarioModel;
import Vista.AddLetraVista;
import Vista.LyricsVista;
import Vista.RankingView;

public class InicioControlador {
	/**
	 * Función que dirige al usuario a añadir letras
	 * @param goMain recibe elJButton que va a ser clickeado
	 */
	public void goMain(JButton addLetra){
		if(UsuarioModel.getUser().getRol().equalsIgnoreCase("invitado")){
			//no puede darle a este boton
			addLetra.setEnabled(false);
		}else{
			addLetra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					AddLetraVista z = new AddLetraVista();
					z.frame.setVisible(true);
				}
			});
		}
	}
	/**
	 * Función que dirige al usuario a la ventana de estadisticas
	 * @param goMain recibe elJButton que va a ser clickeado
	 */
	public void goRanking(JButton ranking){
		ranking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RankingView window = new RankingView();
				window.frame.setVisible(true);
			}
		});
	}
	/**
	 * Función que dirige al usuario a la ventana principal
	 * @param goMain recibe elJButton que va a ser clickeado
	 */
	public void goLetra(JButton ranking){
		ranking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LyricsVista window = new LyricsVista();
				window.frame.setVisible(true);
			}
		});	
	}
}
