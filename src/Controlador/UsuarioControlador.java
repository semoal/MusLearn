package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import Modelo.Conexion;
import Modelo.UsuarioModel;

public class UsuarioControlador {
	
	private boolean ok = true;
	//Método que va realizar todo cuando le de click el usuario
	public void creaUsuario(JButton button,JTextField alias, JTextField password){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!alias.getText().isEmpty() && !password.getText().isEmpty()){
					usuario(alias,password);
					if(ok){
						alias.setText("");
						password.setText("");
						//error.setText("Letra introducida correctamente");
					}
				}else{
					//error.setText("Falta algún campo por introducir");
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
		insertUsuario(us);
	}
	//Metodo que haga el insert
	public void insertUsuario(UsuarioModel us){
		ResultSet rs = null;
    	Statement stmt;
		try {
			String sql = "INSERT INTO usuarios (alias, contrasenya) VALUES (?, ?)";
			PreparedStatement preparedStatement = Conexion.getCon().getConexion().prepareStatement(sql);
			preparedStatement.setString(1, us.getAlias());
			preparedStatement.setDate(2, new java.sql.Date(us.getFecharegistro().getTime()));
			preparedStatement.executeUpdate(); 
			this.ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
			this.ok = false;
		}
	}
	
}
