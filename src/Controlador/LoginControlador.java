package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Modelo.Conexion;
import Modelo.UsuarioModel;
import Vista.AccesoVista;
import Vista.InicioVista;
import Vista.LoginVista;

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
				  			error.setText("Status: falta algun campo por introducir");
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
		Conexion con = Conexion.getCon();
	    PreparedStatement stmt;
	    String query = "SELECT * FROM Usuarios where usuario=? and contrasenya=?";
		try {
			stmt = con.getConexion().prepareStatement(query);
			stmt.setString(1, this.usuario);
			stmt.setString(2, this.pwd);
			rs = stmt.executeQuery();
			if(rs.next()){
				creaObjeto(rs);
			}else{
	  			error.setText("Status: usuario o contraseña incorrecta");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}
	
	public void creaObjeto(ResultSet rs){
    	UsuarioModel user = new UsuarioModel();
        try {
        	user.setIdUsuario(rs.getInt(1));
			user.setAlias(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setFecharegistro(rs.getDate(4));
			user.setRol(rs.getString(5));
			UsuarioModel.setUser(user);
			InicioVista iv = new InicioVista();
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
		  		AccesoVista window = new AccesoVista();
				window.frame.setVisible(true);
		  		x.dispose();
		  	}
		  });
	}
}



