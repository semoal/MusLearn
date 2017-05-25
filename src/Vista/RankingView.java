package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.DocumentException;

import Controlador.PerfilControlador;
import Controlador.RankingControlador;
import Modelo.Idioma;
import Modelo.LetraModel;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

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
	    frame.setTitle("MusLearn - Ranking de letras");
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
		
		JLabel lblStatus = new JLabel();
		lblStatus.setForeground(Color.RED);
		lblStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(lblStatus);
		
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		//tabla top
		
		table = new JTable();
		table.setEnabled(false);
		table.setBackground(Color.LIGHT_GRAY);
		scrollPane_1.setViewportView(table);
		
		ArrayList<UsuarioModel> list = rk.ranking();
		
		DefaultTableModel model = new DefaultTableModel(new Object[]{Idioma.getIdioma().getProperty("alias"), Idioma.getIdioma().getProperty("insercionesletras")},0);

		for(int i=0;i<list.size();i++){
			model.addRow(new Object[]{list.get(i).getAlias(),list.get(i).getNumeroLetras()});
		}
		
		//exportar
		
		List<String> export = new ArrayList<String>();
		int row =  model.getRowCount();
        for (int x = 0; x < row; x++){
        	
              export.add(model.getValueAt(x, 0).toString() +" "+ model.getValueAt(x, 1).toString());
        }
        
        //url mas buscada
        ArrayList<LetraModel> list1 = rk.ranking1();
        PerfilControlador pc = new PerfilControlador();
        
        DefaultTableModel model1 = new DefaultTableModel(new Object[]{Idioma.getIdioma().getProperty("cancion"), Idioma.getIdioma().getProperty("numerobusquedas")},0);
       
        for(int x=0;x<list1.size();x++){
			model1.addRow(new Object[]{pc.urlAtitulo(list1.get(x).getUrlYoutube()),list1.get(x).getBusquedasGlobales()});
		}
        
        
        JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {Idioma.getIdioma().getProperty("topusuarios"), Idioma.getIdioma().getProperty("videomasbuscado")}));
		frame.getContentPane().add(comboBox);
		
		//default
		table.setModel(model);
		
		
		
		JPanel panel2 = new JPanel();
		frame.getContentPane().add(panel2);
		
		JButton btnExportar = new JButton(Idioma.getIdioma().getProperty("exportar"));
		panel2.add(btnExportar);
		btnExportar.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton btnVolver = new JButton(Idioma.getIdioma().getProperty("volver"));
		panel2.add(btnVolver);
		btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 String opcion = (String) comboBox.getSelectedItem();
					if(opcion == Idioma.getIdioma().getProperty("topusuarios")){
						lblNewLabel.setText("Ranking");
						table.setModel(model);
						btnExportar.enable();
						btnExportar.setEnabled(true);
						try {
							rk.exportarRank(btnExportar, list,lblStatus);
						} catch (DocumentException e1) {
							e1.printStackTrace();
						}
					}else if(opcion == Idioma.getIdioma().getProperty("videomasbuscado")){
						lblNewLabel.setText("TOP 10");
						table.setModel(model1);
						btnExportar.enable();
						btnExportar.setEnabled(true);
						try {
							rk.exportarBusquedas(btnExportar, list1,lblStatus);
						} catch (DocumentException e1) {
						}
					}
					} catch(Exception ioe) {ioe.printStackTrace();}
				
			}
		});
		
		
		//Acción boton volver main
		rk.volverMain(btnVolver,frame);
		try {
			rk.exportarRank(btnExportar, list,lblStatus);
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

}
