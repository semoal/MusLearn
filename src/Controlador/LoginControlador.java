package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Encriptacion.Encriptacion;
import Modelo.Conexion;
import Modelo.Idioma;
import Modelo.UsuarioModel;
import Vista.AccesoVista2;
import Vista.InicioVista2;

public class LoginControlador {
	private String usuario;
	private String pwd;
	private boolean done = false;

	JFrame frame;
	public void ejecutaTodo(JButton button,JTextField user,JTextField password,JLabel error,JLabel loading,JFrame frame){
		this.frame = frame;
		button.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		if(!user.getText().isEmpty()){
			  		loading.setVisible(true);
		  		}
		  		new Thread(new Runnable(){
				    @Override
				    public void run(){
				    	if(!user.getText().isEmpty()){
				  			usuario = user.getText();
				  			pwd = password.getText();
				  			consultaBD(error);
				  			done = true;
				  		}else{
				  			error.setText(Idioma.getIdioma().getProperty("loginusuarioincorrecto"));
				  		}	
				       if(done){
				         SwingUtilities.invokeLater(new Runnable(){
				             @Override public void run(){
				                loading.setVisible(false);      
				           }
				          });
				       }
				    }
				}).start();
		  	}
		  });
	}

	//textfield
	public void consultaBD(JLabel error){
		ResultSet rs = null;
	    PreparedStatement stmt;
    	Encriptacion md5 = new Encriptacion();

	    String query2 = "SELECT u.idUsuario,u.usuario,u.contrasenya,u.fecharegistro,u.rol,count(*) as busquedas "
	    		+ "FROM Busquedas l RIGHT JOIN Usuarios u ON l.idUsuario = u.idUsuario where u.usuario=? and u.contrasenya=? "
	    		+ "group by l.idUsuario";
		
		try {
			stmt = Conexion.getCon().getConexion().prepareStatement(query2);
			stmt.setString(1, this.usuario);
			if(pwd.isEmpty()){
				stmt.setString(2, this.pwd);
			}else{
				stmt.setString(2, md5.encriptar(this.pwd));
			}
			rs = stmt.executeQuery();
			if(rs.next()){
				creaObjeto(rs);
			}else{
	  			error.setText(Idioma.getIdioma().getProperty("logincontraseñaincorrecta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}
	
	public void creaObjeto(ResultSet rs){
    	UsuarioModel user = new UsuarioModel();
        try {
        	System.out.println(rs.getInt("idUsuario"));
        	user.setIdUsuario(rs.getInt(1));
			user.setAlias(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setFecharegistro(rs.getDate(4));
			user.setRol(rs.getString(5));
			user.setBusquedas(rs.getInt(6));
			UsuarioModel.setUser(user);
			InicioVista2 iv = new InicioVista2();
			iv.frame.setVisible(true);
			this.frame.setVisible(false);
			this.frame.dispose();
        } catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void volverAcceso(JButton button,JFrame x){
		button.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent e) {
		  		AccesoVista2 window = new AccesoVista2();
				window.frame.setVisible(true);
		  		x.dispose();
		  	}
		  });
	}
}



