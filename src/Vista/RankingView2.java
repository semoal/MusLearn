package Vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.DocumentException;

import Controlador.PerfilControlador;
import Controlador.RankingControlador;
import Modelo.Idioma;
import Modelo.LetraModel;
import Modelo.UsuarioModel;
import javax.swing.ScrollPaneConstants;

public class RankingView2 {

	public JFrame frame;
	private JTable table;

	public RankingView2() {
		initialize();
	}

	private void initialize() {
		RankingControlador rk = new RankingControlador();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 670, 450);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		Color customGrey = Color.decode("#f3f5f6");
		Color greyCustom = Color.decode("#f3f5f6");
		
		JButton closeButton = new JButton("");
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(RankingView2.class.getResource("/Imagen/images.png")).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
		closeButton.setIcon(imageIcon);
		closeButton.setBorder(null);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(17, 77, 304, 37);
		frame.getContentPane().add(comboBox);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(6, 130, 658, 314);
		frame.getContentPane().add(scrollPane_1);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		table.setEnabled(false);
		table.setBackground(Color.WHITE);
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
		
		//default
		table.setModel(model);
		
		closeButton.setBounds(628, 17, 25, 37);
		frame.getContentPane().add(closeButton);
		
		JButton btnExportar = new JButton("");
		btnExportar.setBorder(null);
		btnExportar.setBackground((Color) null);
		btnExportar.setBounds(350, 17, 228, 43);
		frame.getContentPane().add(btnExportar);
		
		JLabel tituloUsuario = new JLabel(UsuarioModel.getUser().getAlias());
		tituloUsuario.setFont(new Font("Sinhala Sangam MN", Font.PLAIN, 27));
		tituloUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		tituloUsuario.setBounds(17, 17, 304, 43);
		frame.getContentPane().add(tituloUsuario);
		
		JLabel fondoTituloUsuario = new JLabel();
		fondoTituloUsuario.setIcon(new ImageIcon(RankingView2.class.getResource("/Imagen/textpane.png")));
		fondoTituloUsuario.setBounds(17, 17, 304, 43);
		frame.getContentPane().add(fondoTituloUsuario);
		
		JButton btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(new ImageIcon(RankingView2.class.getResource("/Imagen/volver.png")).getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		btnVolver.setBounds(590, 17, 36, 37);
		btnVolver.setBorder(null);
		btnVolver.setBackground(null);
		frame.getContentPane().add(btnVolver);
		

		JLabel lblIniciarSesin = new JLabel(Idioma.getIdioma().getProperty("exportar"));
		lblIniciarSesin.setForeground(Color.WHITE);
		lblIniciarSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesin.setBounds(350, 17, 228, 39);
		frame.getContentPane().add(lblIniciarSesin);
		
		JLabel imageiniciar = new JLabel("");
		imageiniciar.setIcon(new ImageIcon(new ImageIcon(RankingView2.class.getResource("/Imagen/loginbutton.png")).getImage().getScaledInstance(304,43, Image.SCALE_DEFAULT)));
		imageiniciar.setBounds(350, 17, 228, 39);
		frame.getContentPane().add(imageiniciar);
		
		JLabel lblStatus = new JLabel();
		lblStatus.setBounds(354, 67, 299, 37);
		frame.getContentPane().add(lblStatus);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(RankingView2.class.getResource("/Imagen/background.png")));
		lblNewLabel.setBounds(-18, -34, 708, 520);
		frame.getContentPane().add(lblNewLabel);
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {Idioma.getIdioma().getProperty("topusuarios"), Idioma.getIdioma().getProperty("videomasbuscado")}));
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
			e1.printStackTrace();
		}

		
	}
}
