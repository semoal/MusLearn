package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mysql.jdbc.Statement;

import Modelo.Conexion;
import Modelo.Idioma;
import Modelo.LetraModel;
import Modelo.UsuarioModel;
import Vista.AccesoVista;
import Vista.InicioVista;

public class AddLetraControlador {
	private boolean ok;
	
	public void anyadirLetra(JButton button,JTextField titulo,JTextField artista ,JTextArea letra,JLabel error){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!titulo.getText().isEmpty() && !artista.getText().isEmpty() && !letra.getText().isEmpty()){
					creaLetra(titulo,artista,letra);
					if(ok){
						titulo.setText("");
						artista.setText("");
						error.setText(Idioma.getIdioma().getProperty("insercionletraok"));
					}
				}else{
					error.setText(Idioma.getIdioma().getProperty("errorinsercionletra"));
				}
			}
		});
	}
	
	public void creaLetra(JTextField titulo,JTextField artista ,JTextArea letra){
		LetraModel lm = new LetraModel();
		//USUARIO QUE INTRODUCE LA LETRA 
		lm.setIdUsuario(UsuarioModel.getUser().getidUsuario());
		lm.setTitulo(titulo.getText());
		lm.setArtista(artista.getText());
		lm.setLetra(letra.getText());
		lm.setFechainsercion(new Date());
		insertaLetra(lm);
	}
	
	public void insertaLetra(LetraModel lm){
		ResultSet rs = null;
		Conexion cn = Conexion.getCon();
		Statement stmt;
		try {
			String sql = "INSERT INTO Letras (idUsuario, titulo, artista, letra,fechainsercion) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = cn.getConexion().prepareStatement(sql);
			preparedStatement.setInt(1, UsuarioModel.getUser().getidUsuario());
			preparedStatement.setString(2, lm.getTitulo());
			preparedStatement.setString(3,lm.getArtista());
			preparedStatement.setString(4, lm.getLetra());
			preparedStatement.setDate(5, new java.sql.Date(lm.getFechainsercion().getTime()));
			preparedStatement.executeUpdate(); 
			this.ok = true;
		} catch (SQLException e) {
			e.printStackTrace();
			this.ok = false;
		}
	}
	
	public void volver(JButton btnVolver,JFrame x){
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				x.dispose();
				InicioVista inc = new InicioVista();
				inc.frame.setVisible(true);
			}
		});
	}
	
}
