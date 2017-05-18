package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JTextField;

import Modelo.Conexion;
import Modelo.UsuarioModel;

public class InvitadoControlador {

	private boolean ok = true;
	//Método que va realizar todo cuando le de click el usuario
	public void creaInvitado(JButton button,JTextField alias){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!alias.getText().isEmpty()){
					invitado(alias);
					if(ok){
						alias.setText("");
						//error.setText("Letra introducida correctamente");
					}
				}else{
					//error.setText("Falta algún campo por introducir");
				}
			}
		});
	}
	
	//Metodo que me genera el objecto USUARIO
	public void invitado(JTextField alias){
		UsuarioModel us = new UsuarioModel();
		us.setAlias(alias.getText());
		us.setPassword("");
		us.setRol("invitado");
		us.setFecharegistro(new Date());
		insertInvitado(us);
	}
	//Metodo que haga el insert
	public void insertInvitado(UsuarioModel us){
		ResultSet rs = null;
		Conexion cn = Conexion.getCon();
		Statement stmt;
		try {
			String sql = "INSERT INTO Usuarios (usuario,contrasenya, rol, fecharegistro) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = cn.getConexion().prepareStatement(sql);
			preparedStatement.setString(1, us.getAlias());
			preparedStatement.setString(2, us.getPassword());
			preparedStatement.setString(3, us.getRol());
			preparedStatement.setDate(4, new java.sql.Date(us.getFecharegistro().getTime()));
			preparedStatement.executeUpdate(); 
			this.ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
			this.ok = false;
		}
	}
	
}
