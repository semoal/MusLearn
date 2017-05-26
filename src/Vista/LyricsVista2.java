package Vista;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import Controlador.LyricsControlador;
import Modelo.Idioma;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.JSplitPane;
import javax.swing.JEditorPane;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class LyricsVista2 {

	public JFrame frame;
	private JTextField urlfield;

	public LyricsVista2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		LyricsControlador lc = new LyricsControlador();
		Browser browser = new Browser();
		BrowserView view = new BrowserView(browser);
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 673, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-11, 64, 695, 308);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(SystemColor.window);
		panel_1.add(textArea_1, BorderLayout.EAST);
		
		panel_1.add(view, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 372, 673, 168);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JLabel lblCargando = new JLabel(Idioma.getIdioma().getProperty("cargando"));
		lblCargando.setBackground(UIManager.getColor("ToolTip.background"));
		lblCargando.setIcon(new ImageIcon(LyricsVista2.class.getResource("/Imagen/loader.gif")));
		lblCargando.setVisible(false);
		scrollPane.setColumnHeaderView(lblCargando);
		
		urlfield = new JTextField();
		urlfield.setToolTipText("");
		urlfield.setText("Url youtube");
		urlfield.setForeground(Color.DARK_GRAY);
		urlfield.setColumns(10);
		urlfield.setBorder(null);
		urlfield.setBackground(new Color(243, 245, 246));
		urlfield.setBounds(6, 21, 324, 31);
		frame.getContentPane().add(urlfield);
		
		JButton exportarBtn = new JButton("");
		exportarBtn.setBorder(null);
		exportarBtn.setBackground((Color) null);
		exportarBtn.setBounds(474, 21, 120, 31);
		frame.getContentPane().add(exportarBtn);
		
		JButton volver = new JButton("");
		volver.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/volver.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		volver.setBorder(null);
		volver.setBackground((Color) null);
		volver.setBounds(623, 21, 30, 31);
		frame.getContentPane().add(volver);
		lc.volver(volver, frame);
		
		JLabel exportarTitle = new JLabel(Idioma.getIdioma().getProperty("exportar"));
		exportarTitle.setHorizontalAlignment(SwingConstants.CENTER);
		exportarTitle.setForeground(Color.WHITE);
		exportarTitle.setBounds(475, 21, 119, 31);
		frame.getContentPane().add(exportarTitle);
		
		JLabel exportarLbl = new JLabel("");
		exportarLbl.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/loginbutton.png").getImage().getScaledInstance(119,31, Image.SCALE_DEFAULT)));
		exportarLbl.setBounds(475, 21, 119, 31);
		frame.getContentPane().add(exportarLbl);
		
		JButton buscarBtn = new JButton("");
		buscarBtn.setBorder(null);
		buscarBtn.setBackground((Color) null);
		buscarBtn.setBounds(342, 21, 120, 31);
		frame.getContentPane().add(buscarBtn);
		
		JLabel buscarTitle = new JLabel(Idioma.getIdioma().getProperty("buscar"));
		buscarTitle.setHorizontalAlignment(SwingConstants.CENTER);
		buscarTitle.setForeground(Color.WHITE);
		buscarTitle.setBounds(343, 21, 119, 31);
		frame.getContentPane().add(buscarTitle);
		
		JLabel buscarLbl = new JLabel("");
		buscarLbl.setIcon(new ImageIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/loginbutton.png").getImage().getScaledInstance(119,31, Image.SCALE_DEFAULT)));
		buscarLbl.setBounds(343, 21, 119, 31);
		frame.getContentPane().add(buscarLbl);
		
		JLabel background = new JLabel("");
		background.setHorizontalAlignment(SwingConstants.CENTER);
		background.setIcon(new ImageIcon("/Users/sergiomoreno/Desktop/pruebaframe/background.png"));
		background.setBounds(-34, -37, 740, 524);
		frame.getContentPane().add(background);
		
		lc.ejecutaTodo(buscarBtn, urlfield, textArea, panel_1, browser, lblCargando);

        // Boton de exportar
        lc.exportarText(exportarBtn, textArea, lblCargando);
	}
}
