package Inicio;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Vista.AccesoVista;

public class SplashVista extends JFrame {
	private JPanel contentPane;
	private JLabel lblPorcentaje;
	private JProgressBar barraDeProgreso;


	public SplashVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(width/2, height/2);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JLabel lblCargandoMuslearn = new JLabel("Loading MusLearn...");
		lblCargandoMuslearn.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCargandoMuslearn.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargandoMuslearn.setFont(new Font("Mangal", Font.BOLD, 22));
		contentPane.add(lblCargandoMuslearn);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_1);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		contentPane.add(verticalStrut_2);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0};
		gbl_panel.rowHeights = new int[] {30, 30, 30};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Loading...");
		lblNewLabel.setFont(new Font("Mangal", Font.PLAIN, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		  GridBagConstraints gbc_progressBar = new GridBagConstraints();
		  gbc_progressBar.fill = GridBagConstraints.HORIZONTAL;
		  gbc_progressBar.gridwidth = 5;
		  gbc_progressBar.insets = new Insets(0, 0, 5, 0);
		  gbc_progressBar.gridx = 0;
		  gbc_progressBar.gridy = 1;
		 
		  barraDeProgreso = new JProgressBar();
		  GridBagConstraints gbc_barraDeProgreso = new GridBagConstraints();
		  gbc_barraDeProgreso.fill = GridBagConstraints.HORIZONTAL;
		  gbc_barraDeProgreso.gridwidth = 5;
		  gbc_barraDeProgreso.insets = new Insets(0, 0, 5, 5);
		  gbc_barraDeProgreso.gridx = 0;
		  gbc_barraDeProgreso.gridy = 1;
		  panel.add(barraDeProgreso, gbc_barraDeProgreso);
		
		 lblPorcentaje = new JLabel("0%");
		GridBagConstraints gbc_lblPorcentaje = new GridBagConstraints();
		gbc_lblPorcentaje.gridx = 4;
		gbc_lblPorcentaje.gridy = 2;
		panel.add(lblPorcentaje, gbc_lblPorcentaje);
		iniciarHilo();
	}
	
public void iniciarHilo(){
	Thread hilo = new Thread (new Runnable() {
		public void run() {
		int x = 0;
			try {
				while (x<=100){
					barraDeProgreso.setValue(x);
					lblPorcentaje.setText(x+"%");
					lblPorcentaje.setText(+x+"%");
					x++;
					Thread.sleep(50);
				}	
				dispose();
				AccesoVista window = new AccesoVista();
				window.frame.setVisible(true);
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		}
	});
	hilo.start();
}
}