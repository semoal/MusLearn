package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Vista.AddLetraVista;
import Vista.LyricsVista;
import Vista.RankingVista;

public class VistaControlador {
	/**
	 * Función que dirige al usuario a añadir letras
	 * @param goMain recibe elJButton que va a ser clickeado
	 */
	public void goMain(JButton addLetra){
		addLetra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLetraVista frame = new AddLetraVista();
				frame.setVisible(true);
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
				RankingVista window = new RankingVista();
				window.frmRankingMuslearn.setVisible(true);
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
