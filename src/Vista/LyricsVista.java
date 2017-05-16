package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.LyricsControlador;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Component;

public class LyricsVista {

	public JFrame frame;
	private JTextField textField;

	public LyricsVista() {
		initialize();
	}

	private void initialize() {
		LyricsControlador lc = new LyricsControlador();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		
		JLabel lblBuscaUrl = new JLabel("Busca URL:");
		panel.add(lblBuscaUrl);
		
		textField = new JTextField();
		textField.setToolTipText("Introduce el url del video");
		panel.add(textField);
		textField.setColumns(22);
		
		JButton btnBuscar = new JButton("Buscar");
		panel.add(btnBuscar);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEnabled(false);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setColumns(30);
		textArea.setRows(12);
		
		lc.ejecutaTodo(btnBuscar,textField,textArea);

	}

}
