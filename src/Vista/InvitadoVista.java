package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.InvitadoControlador;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class InvitadoVista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private JPanel panel_1;
	private JLabel lblAvisoCon;
	private JPanel panel_2;
	private JButton btnContinuar;
	private JButton btnVolver;
	private Component horizontalStrut;
	private JLabel lblAdemsNoPodra;
	private Component verticalStrut_2;
	private Component verticalStrut_3;



	/**
	 * Create the frame.
	 */
	public InvitadoVista() {
		InvitadoControlador ic = new InvitadoControlador();
		
		setTitle("MusLearn - Sesi\u00F3n Invitado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		verticalStrut = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_1);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblIntroduceAlias = new JLabel("Introduce Alias :");
		panel.add(lblIntroduceAlias);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		lblAvisoCon = new JLabel("AVISO : Con la sesi\u00F3n Invitado solo podr\u00E1 buscar tres canciones.");
		lblAvisoCon.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAvisoCon.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblAvisoCon);
		
		lblAdemsNoPodra = new JLabel(" Adem\u00E1s no podr\u00E1 insertar la letra de las canciones.");
		lblAdemsNoPodra.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblAdemsNoPodra);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_2);
		
		verticalStrut_3 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_3);
		
		panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		contentPane.add(panel_2);
		
		btnContinuar = new JButton("Continuar");
		panel_2.add(btnContinuar);
		
		horizontalStrut = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut);
		
		btnVolver = new JButton("Volver");
		panel_2.add(btnVolver);
		
		ic.creaInvitado(btnContinuar,textField);
	}

}