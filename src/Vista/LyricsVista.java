package Vista;

import java.awt.EventQueue;
import java.awt.Point;

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
        //Browser browser = new Browser();
        //BrowserView view = new BrowserView(browser);

        JPanel panel = new JPanel(new BorderLayout());
        //panel.add(view, BorderLayout.CENTER);

        JFrame frame = new JFrame();
        frame.setTitle("MusLearn - Lyrics and a lot of more");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JPanel panel_1 = new JPanel();
        frame.getContentPane().add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
        
        textField_2 = new JTextField();
        panel_1.add(textField_2);
        textField_2.setColumns(10);
        
        JButton btnNewButton = new JButton("Buscar y exportar");
        panel_1.add(btnNewButton);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        JPanel panel_2 = new JPanel();
        frame.getContentPane().add(panel_2, BorderLayout.EAST);
        panel_2.setPreferredSize(new Dimension(300,150));
        panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JScrollPane scrollPane = new JScrollPane();
        panel_2.add(scrollPane);
    

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setEnabled(false);
        textArea_1.setEditable(false);
        scrollPane.setViewportView(textArea_1);
        
//<<<<<<< HEAD
//=======
        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3);
        
        JButton btnExportar = new JButton("Exportar");
        panel_3.add(btnExportar);
        
//>>>>>>> 8ded5d71cb0b07389e394f16969f7d0748a10931
        JTextArea textArea = new JTextArea();
        panel.add(textArea, BorderLayout.EAST);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        //lc.ejecutaTodo(btnNewButton,textField_2,textArea_1,panel,browser);
	}
}
