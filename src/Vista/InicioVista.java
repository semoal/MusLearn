package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import Controlador.InicioControlador;
import Modelo.Idioma;
import Modelo.UsuarioModel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InicioVista {

	public JFrame frame;

	/**
	 * Create the application.
	 */
	public InicioVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		InicioControlador vc = new InicioControlador();
		frame =  new JFrame();
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage(InicioVista.class.getResource("/Imagen/je.png")));
		frame.setTitle("MusLearn - DAM");
		frame.getContentPane().setBackground(new Color(238, 238, 238));
	    frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = screenSize.height;
	    int width = screenSize.width;
	    frame.setSize(width/2, height/2);
	    frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		frame.getContentPane().add(verticalStrut);
	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/sergiomoreno/Documents/workspace/MusLearn/je.png"));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(lblNewLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		frame.getContentPane().add(verticalStrut_1);
		
		JLabel lblNewLabel_2 = new JLabel(Idioma.getIdioma().getProperty("bienvenido")+" "+UsuarioModel.getUser().getAlias()+", "+Idioma.getIdioma().getProperty("espero"));
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel tutorial = new JLabel("");
		tutorial.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(tutorial);
		
		JLabel lblNewLabel_1 = new JLabel(Idioma.getIdioma().getProperty("descripcion"));
		lblNewLabel_1.setBackground(new Color(192, 192, 192));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Kohinoor Bangla", Font.PLAIN, 13));
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(lblNewLabel_1);
		
	    JLabel loading = new JLabel(Idioma.getIdioma().getProperty("cargando")+"... ", new ImageIcon(LoginVista.class.getResource("/Imagen/loader.gif")), JLabel.CENTER);
	    loading.setAlignmentX(Component.CENTER_ALIGNMENT);
	    loading.setVisible(false);
	    frame.getContentPane().add(loading);
		
		Component verticalGlue = Box.createVerticalGlue();
		frame.getContentPane().add(verticalGlue);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		
		JButton goMain = new JButton(Idioma.getIdioma().getProperty("video&letras"));
		panel.add(goMain);
		vc.goLetra(goMain,loading,frame);
		int busquedas = UsuarioModel.getUser().getBusquedas();
		int max = 5;
		int total = max - busquedas;
		if(UsuarioModel.getUser().getBusquedas()>=5 && UsuarioModel.getUser().getRol().equalsIgnoreCase("invitado")){
			goMain.setEnabled(false);
		}else{
			goMain.setEnabled(true);
		}
		if(UsuarioModel.getUser().getRol().equalsIgnoreCase("invitado")){tutorial.setText("Los usuarios invitados, solo pueden realizar 5 busquedas y no pueden añadir letras \n Te quedan: "+total+" busquedas");}
		JButton ranking = new JButton(Idioma.getIdioma().getProperty("estadisticas"));
		panel.add(ranking);
		vc.goRanking(ranking,loading,frame);
		
		JButton addletra = new JButton(Idioma.getIdioma().getProperty("anyadirletras"));
		panel.add(addletra);
		vc.goMain(addletra,loading,frame);
		
		JButton button = new JButton(Idioma.getIdioma().getProperty("perfil"));
		panel.add(button);	
		vc.irPerfil(button,loading,frame);
	}

}
