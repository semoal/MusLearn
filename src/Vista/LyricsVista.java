package Vista;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import Controlador.LyricsControlador;

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

public class LyricsVista {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public LyricsVista() {
		initialize();
	}

	private void initialize() {
		LyricsControlador lc = new LyricsControlador();
        Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);
        frame = new JFrame();
	    frame.pack();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = screenSize.height;
	    int width = screenSize.width;
	    frame.setSize(width/2, height/2);
	    frame.setLocationRelativeTo(null);
        frame.setTitle("MusLearn - Lyrics and a lot of more");
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(view, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
        
        textField_2 = new JTextField();
        panel_1.add(textField_2);
        textField_2.setColumns(10);
        
        JButton btnNewButton = new JButton("Buscar");
        panel_1.add(btnNewButton);
        
        JButton btnExportar = new JButton("Exportar");
        panel_1.add(btnExportar);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        JPanel panel_2 = new JPanel();
        frame.getContentPane().add(panel_2, BorderLayout.EAST);
        panel_2.setPreferredSize(new Dimension(300,150));
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JScrollPane scrollPane = new JScrollPane();
        panel_2.add(scrollPane);
    

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setRows(25);
        textArea_1.setColumns(24);
        textArea_1.setEditable(false);
        scrollPane.setViewportView(textArea_1);
        
        JLabel lblStatus = new JLabel("Status: ");
        panel_2.add(lblStatus);
        

        JTextArea textArea = new JTextArea();
        panel.add(textArea, BorderLayout.EAST);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //Boton de exportar
        lc.exportarText(btnExportar, textArea_1,lblStatus);
        //boTON DE BUSCAR EN LA API
        lc.ejecutaTodo(btnNewButton,textField_2,textArea_1,panel,browser);
	}
}
