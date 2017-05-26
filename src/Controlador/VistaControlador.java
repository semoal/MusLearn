package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vista.AnyadirLetra2;
import Vista.LyricsVista2;
import Vista.RankingView2;

public class VistaControlador {
	/**
	 * Función que dirige al usuario a añadir letras
	 * @param goMain recibe elJButton que va a ser clickeado
	 */
	public void goMain(JButton addLetra){
		addLetra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnyadirLetra2 frame = new AnyadirLetra2();
				frame.frame.setVisible(true);
			}
		});
	}
	/**
	 * Función que dirige al usuario a la ventana de estadisticas
	 * @param goMain recibe elJButton que va a ser clickeado
	 */
	public void goRanking(JButton ranking){
		ranking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RankingView2 window = new RankingView2();
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
				LyricsVista2 window = new LyricsVista2();
				window.frame.setVisible(true);
			}
		});
	}

}
