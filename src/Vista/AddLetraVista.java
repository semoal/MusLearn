package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;

public class AddLetraVista extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAlias;
	private JTextField textFieldNombre;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private JPanel panel_1;
	private JTextField textField;
	private JLabel lblMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLetraVista frame = new AddLetraVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddLetraVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(new LineBorder(new Color(238, 232, 170), 4, true));
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblAlias = new JLabel("Alias");
		panel.add(lblAlias);
		
		textFieldAlias = new JTextField();
		panel.add(textFieldAlias);
		textFieldAlias.setColumns(10);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		JLabel lblNombre = new JLabel("Nombre Completo");
		panel.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		lblMensaje = new JLabel("Introduce la letra de la canci\u00F3n abajo");
		panel_1.add(lblMensaje);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(50);
	}

}
