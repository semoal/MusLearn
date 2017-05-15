package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VistaControlador {
	/**
	 * Función que dirige al usuario a la venta principal
	 * @param goMain recibe elJButton que va a ser clickeado
	 */
	public static void goMain(JButton goMain){
		goMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Yendo al main");
			}
		});
	}
}
