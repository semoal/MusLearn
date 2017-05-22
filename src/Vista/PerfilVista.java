package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.PerfilControlador;
import Modelo.Idioma;
import Modelo.LetraModel;
import Modelo.UsuarioModel;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PerfilVista {

	public JFrame frame;
	private JTable table_1;
	public PerfilVista() {
		initialize();
	}

	private void initialize() {
		PerfilControlador pc = new PerfilControlador();
		frame = new JFrame();
		frame.pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width/2, height/2);
		frame.setLocationRelativeTo(null);
		frame.setTitle("MusLearn - Perfil");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel username = new JLabel(UsuarioModel.getUser().getAlias());
		username.setFont(new Font("LondonTwo", Font.BOLD, 17));
		panel.add(username);
		username.setAlignmentX(Component.CENTER_ALIGNMENT);
		username.setBackground(SystemColor.textHighlight);
		
		JLabel lblTusUltimasBusquedas_1 = new JLabel(Idioma.getIdioma().getProperty("tusultimas"));
		lblTusUltimasBusquedas_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(lblTusUltimasBusquedas_1);
		
		JLabel copy = new JLabel("");
		copy.setForeground(Color.RED);
		copy.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(copy);
		
		JLabel numeroBusquedas = new JLabel(Idioma.getIdioma().getProperty("hashecho")+UsuarioModel.getUser().getBusquedas()+Idioma.getIdioma().getProperty("busquedas"));
		copy.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(numeroBusquedas);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table_1);
		
		ArrayList<LetraModel> list = pc.getLetrasBuscadas();
		
		DefaultTableModel model = new DefaultTableModel(new Object[]{"Url",Idioma.getIdioma().getProperty("fecha"),Idioma.getIdioma().getProperty("titulo")},0);

		for(int i=0;i<list.size();i++){
			model.addRow(new Object[]{list.get(i).getUrlYoutube(),list.get(i).getFechainsercion(),pc.urlAtitulo(list.get(i).getUrlYoutube())});
		}
		table_1.setModel(model);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JButton btnVolver = new JButton(Idioma.getIdioma().getProperty("volver"));
		panel_2.add(btnVolver);
		pc.volverMain(btnVolver, frame);
		
		JButton btnCopiarUrl = new JButton(Idioma.getIdioma().getProperty("copiarurl"));
		pc.copiarUrl(btnCopiarUrl,table_1,copy);
		panel_2.add(btnCopiarUrl);
		
		JButton btnCerrarApp = new JButton(Idioma.getIdioma().getProperty("cerrar"));
		panel_2.add(btnCerrarApp);
	}

}
