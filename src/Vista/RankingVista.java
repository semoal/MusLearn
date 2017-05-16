package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class RankingVista {

	public JFrame frmRankingMuslearn;
	private JTable table;


	/**
	 * Create the application.
	 */
	public RankingVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRankingMuslearn = new JFrame();
		//frmRankingMuslearn.setIconImage(Toolkit.getDefaultToolkit().getImage(RankingVista.class.getResource("/Imagen/je.png")));
		frmRankingMuslearn.setTitle("Ranking - MusLearn");
		frmRankingMuslearn.setBounds(100, 100, 450, 300);
		frmRankingMuslearn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRankingMuslearn.getContentPane().setLayout(new BoxLayout(frmRankingMuslearn.getContentPane(), BoxLayout.Y_AXIS));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Nombre completo", "N\u00BA Letras"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		
		JLabel lblNewLabel = new JLabel("Ranking");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		frmRankingMuslearn.getContentPane().add(lblNewLabel);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		frmRankingMuslearn.getContentPane().add(verticalStrut_1);
		frmRankingMuslearn.getContentPane().add(table);
		
		Component verticalGlue = Box.createVerticalGlue();
		frmRankingMuslearn.getContentPane().add(verticalGlue);
		
		JPanel panel = new JPanel();
		frmRankingMuslearn.getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnNewButton = new JButton("Exportar");
		panel.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		panel.add(btnVolver);
	}

}
