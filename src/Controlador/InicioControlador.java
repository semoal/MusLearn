package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import Modelo.UsuarioModel;
import Vista.AnyadirLetra;
import Vista.LyricsVista;
import Vista.PerfilVista;
import Vista.RankingView;

public class InicioControlador {
	
	public void goMain(JButton addLetra,JLabel x,JFrame frame){
		if(UsuarioModel.getUser().getRol().equalsIgnoreCase("invitado")){
			//no puede darle a este boton
			addLetra.setEnabled(false);
		}else{
			addLetra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					x.setVisible(true);
					new Thread(new Runnable(){
				    @Override
				    public void run(){
				    	AnyadirLetra window = new AnyadirLetra();
				    	frame.dispose();
						window.frame.setVisible(true);
				       if(window.frame.isVisible()){
				         SwingUtilities.invokeLater(new Runnable(){
				             @Override public void run(){
				                x.setVisible(false);      
				           }
				          });
				       }
				    }
					}).start();
				}
			});
		}
	}
	/**
	 * Función que dirige al usuario a la ventana de estadisticas
	 * @param goMain recibe elJButton que va a ser clickeado
	 */
	public void goRanking(JButton ranking,JLabel x,JFrame frame){
		ranking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x.setVisible(true);
				new Thread(new Runnable(){
			    @Override
			    public void run(){
			    	RankingView window = new RankingView();
					window.frame.setVisible(true);
			    	frame.dispose();
			       if(window.frame.isVisible()){
			         SwingUtilities.invokeLater(new Runnable(){
			             @Override public void run(){
			                x.setVisible(false);      
			           }
			          });
			       }
			    }
				}).start();
			}
		});
	}
	/**
	 * Función que dirige al usuario a la ventana principal
	 * @param goMain recibe elJButton que va a ser clickeado
	 */
	public void goLetra(JButton ranking,JLabel x,JFrame frame){
		ranking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x.setVisible(true);
				new Thread(new Runnable(){
			    @Override
			    public void run(){
			    	LyricsVista window = new LyricsVista();
					window.frame.setVisible(true);
			    	frame.dispose();
			       if(window.frame.isVisible()){
			         SwingUtilities.invokeLater(new Runnable(){
			             @Override public void run(){
			                x.setVisible(false);      
			           }
			          });
			       }
			    }
				}).start();
			}
		});	
	}
	
	public void irPerfil(JButton button,JLabel x,JFrame frame){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x.setVisible(true);
				new Thread(new Runnable(){
			    @Override
			    public void run(){
			    	PerfilVista window = new PerfilVista();
					window.frame.setVisible(true);
			    	frame.dispose();
			       if(window.frame.isVisible()){
			         SwingUtilities.invokeLater(new Runnable(){
			             @Override public void run(){
			                x.setVisible(false);      
			           }
			          });
			       }
			    }
				}).start();
			}
		});
	}
}
