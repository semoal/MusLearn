package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Controlador.RankingControlador;
import Modelo.UsuarioModel;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RankingView {

	public JFrame frame;
	private JTable table;


	/**
	 * Create the application.
	 */
	public RankingView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		RankingControlador rk = new RankingControlador();
		frame = new JFrame();
	    frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = screenSize.height;
	    int width = screenSize.width;
	    frame.setSize(width/2, height/2);
	    frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JLabel lblNewLabel = new JLabel("Ranking");
		lblNewLabel.setFont(new Font("LondonBetween", Font.PLAIN, 40));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		table.setEnabled(false);
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane_1.setViewportView(table);
		
		ArrayList<UsuarioModel> list = rk.ranking();
		
		DefaultTableModel model = new DefaultTableModel(new Object[]{"Alias","Letras"},0);

		for(int i=0;i<list.size();i++){
			model.addRow(new Object[]{list.get(i).getAlias(),list.get(i).getNumeroLetras()});
		}
		table.setModel(model);
		
		JPanel panel2 = new JPanel();
		frame.getContentPane().add(panel2);
		
		JButton btnExportar = new JButton("Exportar");
		panel2.add(btnExportar);
		btnExportar.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton btnVolver = new JButton("Volver");
		panel2.add(btnVolver);
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Acción botón exportar PDF
		rk.exportarPDF(btnExportar);
		//Acción boton volver main
		rk.volverMain(btnVolver,frame);
	}

}
