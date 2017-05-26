package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controlador.PerfilControlador;
import Modelo.Idioma;
import Modelo.LetraModel;
import Modelo.UsuarioModel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;

public class PerfilVista2 {

	public JFrame frame;
	private JTable table;

	public PerfilVista2() {
		initialize();
	}

	private void initialize() {
		PerfilControlador pc = new PerfilControlador();
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 670, 450);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		Color customGrey = Color.decode("#f3f5f6");
		Color greyCustom = Color.decode("#f3f5f6");
		
		JButton closeButton = new JButton("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(PerfilVista2.class.getResource("/Imagen/images.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		closeButton.setIcon(imageIcon);
		closeButton.setBorder(null);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(17, 130, 636, 314);
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		ArrayList<LetraModel> list = pc.getLetrasBuscadas();
		
		DefaultTableModel model = new DefaultTableModel(new Object[]{"Url",Idioma.getIdioma().getProperty("fecha"),Idioma.getIdioma().getProperty("titulo")},0);

		for(int i=0;i<list.size();i++){
			model.addRow(new Object[]{list.get(i).getUrlYoutube(),list.get(i).getFechainsercion(),pc.urlAtitulo(list.get(i).getUrlYoutube())});
		}
		table.setModel(model);
		
		closeButton.setBounds(628, 17, 25, 37);
		frame.getContentPane().add(closeButton);
		
		JButton button_1 = new JButton("");
		button_1.setBorder(null);
		button_1.setBackground((Color) null);
		button_1.setBounds(350, 17, 228, 43);
		frame.getContentPane().add(button_1);
		
		JLabel tituloUsuario = new JLabel(UsuarioModel.getUser().getAlias());
		tituloUsuario.setFont(new Font("Sinhala Sangam MN", Font.PLAIN, 27));
		tituloUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		tituloUsuario.setBounds(17, 17, 304, 43);
		frame.getContentPane().add(tituloUsuario);
		
		JLabel fondoTituloUsuario = new JLabel();
		fondoTituloUsuario.setIcon(new ImageIcon(PerfilVista2.class.getResource("/Imagen/textpane.png")));
		fondoTituloUsuario.setBounds(17, 17, 304, 43);
		frame.getContentPane().add(fondoTituloUsuario);
		
		JLabel busquedasRest = new JLabel(Idioma.getIdioma().getProperty("hashecho")+" "+UsuarioModel.getUser().getBusquedas()+" "+Idioma.getIdioma().getProperty("busquedas"));
		busquedasRest.setHorizontalAlignment(SwingConstants.CENTER);
		busquedasRest.setFont(new Font("Sinhala Sangam MN", Font.PLAIN, 20));
		busquedasRest.setBounds(17, 72, 304, 43);
		frame.getContentPane().add(busquedasRest);
		
		JLabel fondobusquedas = new JLabel();
		fondobusquedas.setIcon(new ImageIcon(PerfilVista2.class.getResource("/Imagen/textpane.png")));
		fondobusquedas.setBounds(17, 72, 304, 43);
		frame.getContentPane().add(fondobusquedas);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(new ImageIcon(PerfilVista2.class.getResource("/Imagen/volver.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		button.setBounds(590, 17, 36, 37);
		button.setBorder(null);
		button.setBackground(null);
		frame.getContentPane().add(button);
		pc.volverMain(button, frame);
		

		JLabel lblIniciarSesin = new JLabel(Idioma.getIdioma().getProperty("copiarurl"));
		lblIniciarSesin.setForeground(Color.WHITE);
		lblIniciarSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesin.setBounds(350, 17, 228, 39);
		frame.getContentPane().add(lblIniciarSesin);
		
		JLabel imageiniciar = new JLabel("");
		imageiniciar.setIcon(new ImageIcon(new ImageIcon(PerfilVista2.class.getResource("/Imagen/loginbutton.png")).getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		imageiniciar.setBounds(350, 17, 228, 39);
		frame.getContentPane().add(imageiniciar);
		
		JLabel lblStatus = new JLabel();
		lblStatus.setBounds(354, 67, 299, 37);
		frame.getContentPane().add(lblStatus);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(PerfilVista2.class.getResource("/Imagen/background.png")));
		lblNewLabel.setBounds(-18, -34, 708, 520);
		frame.getContentPane().add(lblNewLabel);
		
		pc.copiarUrl(button_1, table, lblStatus);
		
		
	}
}
