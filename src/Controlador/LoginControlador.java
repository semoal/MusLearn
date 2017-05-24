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
		Conexion con = Conexion.getCon();
	    PreparedStatement stmt;
    	Encriptacion md5 = new Encriptacion();

	    String query = "SELECT * FROM Usuarios where usuario=? and contrasenya=?";
		//String sql2 = "SELECT *,count(*) as numero FROM Busquedas l RIGHT JOIN Usuarios u "
				//+ "ON l.idUsuario = u.idUsuario where u.usuario=? and u.contrasenya=? "
				//+ "group by l.idUsuario";
		try {
			stmt = con.getConexion().prepareStatement(query);
			stmt.setString(1, this.usuario);
			stmt.setString(2, md5.encriptar(this.pwd));
			rs = stmt.executeQuery();
			if(rs.next()){
				creaObjeto(rs);
			}else{
	  			error.setText(Idioma.getIdioma().getProperty("logincontrase�aincorrecta"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}
	
	public void creaObjeto(ResultSet rs){
    	UsuarioModel user = new UsuarioModel();
        try {
        	System.out.println(rs.getInt("idUsuario"));
        	user.setIdUsuario(rs.getInt("idUsuario"));
			user.setAlias(rs.getString("usuario"));
			user.setPassword(rs.getString("contrasenya"));
			user.setFecharegistro(rs.getDate("fecharegistro"));
			user.setRol(rs.getString("rol"));
			//user.setBusquedas(rs.getInt("numero"));
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



