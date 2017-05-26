package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Controlador.AddLetraControlador;
import Modelo.Idioma;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AnyadirLetra2 {

	public JFrame frame;
	private JTextField txtUsuario;
	private JTextField txtArtista;

	public AnyadirLetra2() {
		initialize();
	}

	private void initialize() {
		AddLetraControlador lc = new AddLetraControlador();
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 670, 450);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		Color customGrey = Color.decode("#f3f5f6");
		txtUsuario = new JTextField();
		txtUsuario.setText(Idioma.getIdioma().getProperty("artista"));
		txtUsuario.setToolTipText("");
		Color greyCustom = Color.decode("#f3f5f6");
		
		JButton closeButton = new JButton("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(AnyadirLetra2.class.getResource("/Imagen/images.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		closeButton.setIcon(imageIcon);
		closeButton.setBorder(null);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		
		JLabel lblCargando = new JLabel((Idioma.getIdioma().getProperty("cargando")));
		lblCargando.setBackground(Color.LIGHT_GRAY);
		lblCargando.setIcon(new ImageIcon(LoginVista2.class.getResource("/Imagen/loader.gif")));
		lblCargando.setVisible(false);
		
		txtArtista = new JTextField();
		txtArtista.setToolTipText("");
		txtArtista.setText(Idioma.getIdioma().getProperty("titulo"));
		txtArtista.setForeground(Color.LIGHT_GRAY);
		txtArtista.setColumns(10);
		txtArtista.setBorder(null);
		txtArtista.setBackground(new Color(243, 245, 246));
		txtArtista.setBounds(24, 75, 286, 29);
		frame.getContentPane().add(txtArtista);
		
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(AnyadirLetra2.class.getResource("/Imagen/textpane.png")));
		label.setBounds(17, 68, 304, 43);
		frame.getContentPane().add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 133, 617, 298);
		scrollPane.setBorder(null);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setBackground(customGrey);
		textArea.setForeground(Color.LIGHT_GRAY);
		lblCargando.setBounds(482, 17, 102, 37);
		frame.getContentPane().add(lblCargando);
						
		JLabel lblStatus = new JLabel("");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setBounds(350, 74, 297, 37);
		frame.getContentPane().add(lblStatus);		
		
		closeButton.setBounds(628, 17, 25, 37);
		frame.getContentPane().add(closeButton);
		
		JButton button_1 = new JButton("");
		button_1.setBorder(null);
		button_1.setBackground((Color) null);
		button_1.setBounds(350, 17, 139, 43);
		frame.getContentPane().add(button_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(new ImageIcon(AnyadirLetra2.class.getResource("/Imagen/volver.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		button.setBounds(590, 17, 36, 37);
		button.setBorder(null);
		button.setBackground(null);
		frame.getContentPane().add(button);
		lc.volver(button, frame);

		txtUsuario.setForeground(Color.LIGHT_GRAY);
		txtUsuario.setBackground(greyCustom);
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(24, 23, 286, 29);
		frame.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		

		JLabel lblIniciarSesin = new JLabel(Idioma.getIdioma().getProperty("anyadircancion"));
		lblIniciarSesin.setForeground(Color.WHITE);
		lblIniciarSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesin.setBounds(350, 17, 139, 39);
		frame.getContentPane().add(lblIniciarSesin);
		
		JLabel imageiniciar = new JLabel("");
		imageiniciar.setIcon(new ImageIcon(new ImageIcon(AnyadirLetra2.class.getResource("/Imagen/loginbutton.png")).getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		imageiniciar.setBounds(350, 17, 139, 39);
		frame.getContentPane().add(imageiniciar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(AnyadirLetra2.class.getResource("/Imagen/textpane.png")).getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		lblNewLabel_1.setBounds(17, 17, 304, 43);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(AnyadirLetra2.class.getResource("/Imagen/background.png")));
		lblNewLabel.setBounds(-18, -34, 708, 520);
		frame.getContentPane().add(lblNewLabel);
		
		lc.anyadirLetra(button_1, txtArtista, txtUsuario, textArea, lblStatus);
		
		
	}
}
