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
 
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistroVista frame = new RegistroVista();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
 
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
           
            JPanel panel = new JPanel();
            contentPane.add(panel);
           
            JLabel lblMensaje = new JLabel("Formulario para registrarse");
            panel.add(lblMensaje);
           
            JPanel panel_1 = new JPanel();
            contentPane.add(panel_1);
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
           
            JPanel panel_2 = new JPanel();
            FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
            flowLayout.setAlignment(FlowLayout.RIGHT);
            contentPane.add(panel_2);
           
            JButton btnVolver = new JButton("Volver");
            panel_2.add(btnVolver);
           
            JButton btnRegistrarse = new JButton("Registrarse");
            panel_2.add(btnRegistrarse);
        }
     
    }