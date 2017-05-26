package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Modelo.Conexion;
import Modelo.Idioma;
import Modelo.UsuarioModel;
import Vista.AccesoVista2;

public class InvitadoControlador {

	private boolean ok = true;
	private JLabel error;
	//Método que va realizar todo cuando le de click el usuario
	public void creaInvitado(JButton button,JTextField alias,JLabel error){
		this.error = error;
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!alias.getText().isEmpty()){
					invitado(alias);
					if(ok){
						alias.setText("");
					}
				}else{
					error.setText(Idioma.getIdioma().getProperty("errorinsercionletra"));
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
		Statement stmt;
		try {
			String sql = "INSERT INTO Usuarios (usuario,contrasenya, rol, fecharegistro) VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStatement = Conexion.getCon().getConexion().prepareStatement(sql);
			preparedStatement.setString(1, us.getAlias());
			preparedStatement.setString(2, us.getPassword());
			preparedStatement.setString(3, us.getRol());
			preparedStatement.setDate(4, new java.sql.Date(us.getFecharegistro().getTime()));
			preparedStatement.executeUpdate(); 
			this.ok = true;
			this.error.setText(Idioma.getIdioma().getProperty("invitadonombrecorrecto"));
		}catch (SQLIntegrityConstraintViolationException e) {
		   this.ok = false;
		   this.error.setText(Idioma.getIdioma().getProperty("invitadonombreincorrecto"));
		}catch (SQLException e) {
			e.printStackTrace();
			this.ok = false;
			this.error.setText(Idioma.getIdioma().getProperty("consultanovalida"));
		}
	}
	
	//Método para volver a acceso
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
