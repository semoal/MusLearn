package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import Modelo.Conexion;
import Modelo.UsuarioModel;
import Vista.AccesoVista;
import Vista.RegistroVista;

public class RegistroControlador {
	private boolean ok = false;
	private String x;
	//Método que va realizar todo cuando le de click el usuario
	public void creaUsuario(JButton button,JTextField alias, JTextField password,JTextField pass2,JLabel error){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!alias.getText().isEmpty() && !password.getText().isEmpty() && !pass2.getText().isEmpty()){
					if(password.getText().equalsIgnoreCase(pass2.getText())){
						usuario(alias,password);
						if(ok){
							alias.setText("");
							password.setText("");
							pass2.setText("");
							error.setText("Registrado correctamente");
						}else{
							error.setText(x);
						}
					}else{
						error.setText("Las contraseñas no coinciden");
					}
				}else{
					error.setText("Falta algún campo por introducir");
				}
			}
		});
	}
	
	//Metodo que me genera el objecto USUARIO
	public void usuario(JTextField alias, JTextField password){
		UsuarioModel us = new UsuarioModel();
		us.setAlias(alias.getText());
		us.setPassword(password.getText());
		us.setFecharegistro(new Date());
		us.setRol("registrado");
		insertUsuario(us);
	}
	//Metodo que haga el insert
	public void insertUsuario(UsuarioModel us){
		ResultSet rs = null;
		Conexion cn = Conexion.getCon();
    	Statement stmt;
		try {
			String sql = "INSERT INTO Usuarios (usuario, contrasenya,fecharegistro,rol) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = cn.getConexion().prepareStatement(sql);
			preparedStatement.setString(1, us.getAlias());
			preparedStatement.setString(2, us.getPassword());
			preparedStatement.setDate(3, new java.sql.Date(us.getFecharegistro().getTime()));
			preparedStatement.setString(4, us.getRol());
			preparedStatement.executeUpdate(); 
			
			this.ok = true;
		} catch (SQLIntegrityConstraintViolationException e) {
		   this.ok = false;
		   this.x = "Usuario con ese nombre ya existe";
		} catch (SQLException e) {
		   this.ok = false;
		}
	}
	//Método para volver a acceso
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
