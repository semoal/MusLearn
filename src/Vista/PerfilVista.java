package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;

import Modelo.UsuarioModel;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;

public class PerfilVista {

	public JFrame frame;

	public PerfilVista() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("MusLearn - Perfil");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel username = new JLabel(UsuarioModel.getUser().getAlias());
		username.setFont(new Font("LondonTwo", Font.BOLD, 17));
		panel.add(username);
		username.setAlignmentX(Component.CENTER_ALIGNMENT);
		username.setBackground(SystemColor.textHighlight);
		
		JLabel lblTusUltimasBusquedas_1 = new JLabel("Tus ultimas busquedas :");
		lblTusUltimasBusquedas_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.getContentPane().add(lblTusUltimasBusquedas_1);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124", "titulo - https://www.youtube.com/jejeje - 17/03/1124"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JButton btnVolver = new JButton("Volver");
		panel_2.add(btnVolver);
		
		JButton btnCopiarUrl = new JButton("Copiar URL");
		panel_2.add(btnCopiarUrl);
		
		JButton btnCerrarApp = new JButton("Cerrar APP");
		panel_2.add(btnCerrarApp);
	}

}
