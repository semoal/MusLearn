package Vista;
 
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class RegistroVista extends JFrame {
 
    //private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
      private JPanel contentPane;
        private JTextField textFieldUser;
        private JPasswordField passwordField_1;
        private JPasswordField passwordField_2;
 
 
    /**
     * Create the frame.
     */
    public RegistroVista() {
        setTitle("MusLearn - Registro");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 450, 300);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
            
            JPanel panel_2 = new JPanel();
            contentPane.add(panel_2);
             panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
            
             JLabel lblMensaje = new JLabel("Escribe tus credenciales");
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
            panel_1.add(panel_4);
            
            JLabel lblVuelveAEscribir = new JLabel("Repite contrase\u00F1a:");
            panel_4.add(lblVuelveAEscribir);
            
            passwordField_2 = new JPasswordField();
            passwordField_2.setColumns(20);
            panel_4.add(passwordField_2);
            
            Component verticalStrut_7 = Box.createVerticalStrut(20);
            panel_4.add(verticalStrut_7);
            
            Component horizontalStrut_2 = Box.createHorizontalStrut(20);
            panel_4.add(horizontalStrut_2);
            
            Component horizontalStrut_1 = Box.createHorizontalStrut(20);
            panel_4.add(horizontalStrut_1);
            
            Component verticalStrut_6 = Box.createVerticalStrut(20);
            panel_4.add(verticalStrut_6);
            
            Component verticalStrut_5 = Box.createVerticalStrut(20);
            panel_4.add(verticalStrut_5);
            
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
            
             JButton btnVolver = new JButton("Volver");
             panel_7.add(btnVolver);
              
              Component horizontalGlue_5 = Box.createHorizontalGlue();
              panel_7.add(horizontalGlue_5);
             
              JButton btnRegistrarse = new JButton("Registrarse");
              panel_7.add(btnRegistrarse);
        }
     
    }