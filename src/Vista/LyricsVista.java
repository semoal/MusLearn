package Vista;

import java.awt.EventQueue;

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
import javax.swing.JTextPane;

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

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(view, BorderLayout.CENTER);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        
        textField_2 = new JTextField();
        panel.add(textField_2, BorderLayout.NORTH);
        textField_2.setColumns(10);
        
        JButton btnNewButton = new JButton("Buscar");
        panel.add(btnNewButton, BorderLayout.SOUTH);
        
        JTextArea textArea = new JTextArea();
        panel.add(textArea, BorderLayout.EAST);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        lc.ejecutaTodo(btnNewButton,textField_2,textArea,panel,browser);
	}
}
