package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.LoginControlador;

import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class LoginVista{
	public JFrame frame;
 private JTextField textField;
 private JPasswordField passwordField;
 private JPanel contentPane;
 private JTextField textFieldUser;
 private JPasswordField passwordField_1;


 /**
  * Create the frame.
  */
 public LoginVista() {
  LoginControlador lg = new LoginControlador();
  frame = new JFrame();
  frame.pack();
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int height = screenSize.height;
  int width = screenSize.width;
  frame.setSize(width/2, height/2);
  frame.setLocationRelativeTo(null);
  
  frame.setTitle("MusLearn - Login");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  frame.setContentPane(contentPane);
  contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

  JPanel panel_2 = new JPanel();
  contentPane.add(panel_2);
  panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

  JLabel lblMensaje = new JLabel("Inicia sesión");
  panel_2.add(lblMensaje);

  Component verticalStrut_8 = Box.createVerticalStrut(20);
  contentPane.add(verticalStrut_8);

  Component verticalStrut_9 = Box.createVerticalStrut(20);
  contentPane.add(verticalStrut_9);

  JPanel panel = new JPanel();
  contentPane.add(panel);

  JPanel panel_1 = new JPanel();
  panel.add(panel_1);
  panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

  JPanel panel_3 = new JPanel();
  panel_3.setAlignmentY(Component.TOP_ALIGNMENT);
  panel_1.add(panel_3);
  panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));

  JPanel panel_5 = new JPanel();
  panel_3.add(panel_5);

  JLabel lblUser = new JLabel("Usuario:");
  panel_5.add(lblUser);

  textFieldUser = new JTextField();
  panel_5.add(textFieldUser);
  textFieldUser.setColumns(20);

  Component verticalStrut_1 = Box.createVerticalStrut(20);
  panel_5.add(verticalStrut_1);

  Component verticalStrut_2 = Box.createVerticalStrut(20);
  panel_5.add(verticalStrut_2);

  Component verticalStrut_3 = Box.createVerticalStrut(20);
  panel_5.add(verticalStrut_3);

  JPanel panel_6 = new JPanel();
  panel_3.add(panel_6);

  JLabel lblPass = new JLabel("Contrase\u00F1a:");
  panel_6.add(lblPass);
  

  passwordField_1 = new JPasswordField();
  passwordField_1.setColumns(20);
  panel_6.add(passwordField_1);

  Component horizontalStrut = Box.createHorizontalStrut(20);
  panel_6.add(horizontalStrut);

  Component verticalStrut_4 = Box.createVerticalStrut(20);
  panel_6.add(verticalStrut_4);

  Component verticalStrut = Box.createVerticalStrut(20);
  panel_6.add(verticalStrut);
  
  JPanel panel_4 = new JPanel();
  contentPane.add(panel_4);
  
  JLabel loading = new JLabel("Cargando... ", new ImageIcon(LoginVista.class.getResource("/Imagen/loader.gif")), JLabel.CENTER);
  loading.setVisible(false);
  panel_4.add(loading);
  
  JLabel lblStatus = new JLabel();
  panel_4.add(lblStatus);
  JPanel panel_7 = new JPanel();
  contentPane.add(panel_7);
  panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

  Component horizontalGlue = Box.createHorizontalGlue();
  panel_7.add(horizontalGlue);

  Component horizontalGlue_1 = Box.createHorizontalGlue();
  panel_7.add(horizontalGlue_1);

  Component horizontalGlue_2 = Box.createHorizontalGlue();
  panel_7.add(horizontalGlue_2);

  Component horizontalGlue_3 = Box.createHorizontalGlue();
  panel_7.add(horizontalGlue_3);

  Component horizontalGlue_4 = Box.createHorizontalGlue();
  panel_7.add(horizontalGlue_4);
  JComboBox comboBox = new JComboBox();
  panel.add(comboBox);
  comboBox.setModel(new DefaultComboBoxModel(new String[] {"Usuario registrado", "Usuario invitado"}));
  JButton btnRegistrarse = new JButton("Iniciar sesión");
  panel_7.add(btnRegistrarse);
  comboBox.addActionListener(
          new ActionListener(){
              public void actionPerformed(ActionEvent e){
                  JComboBox combo = (JComboBox)e.getSource();
                  String currentUser = (String)combo.getSelectedItem();
                  if(currentUser.equalsIgnoreCase("Usuario registrado")){
                	  passwordField_1.enable();
                	  passwordField_1.setEnabled(true);
                	  passwordField_1.setBackground(Color.white);
                  }else{
                	  Color greyCustom = Color.decode("#c1c1bf");
                	  passwordField_1.disable();
                	  passwordField_1.setText("");
                	  passwordField_1.setEnabled(false);
                	  passwordField_1.setBackground(greyCustom);
                  }
              }
          }            
  );

  //Botón de iniciar sesion
  lg.ejecutaTodo(btnRegistrarse,textFieldUser,passwordField_1,lblStatus,loading,frame);
  JButton btnVolver = new JButton("Volver");
  panel_7.add(btnVolver);
  lg.volverAcceso(btnVolver,frame);
  

  
 }

}