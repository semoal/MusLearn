package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import Modelo.Conexion;
import Modelo.UsuarioModel;
import Vista.AddLetraVista;
import Vista.InicioVista;

public class RankingControlador {
	
	public ArrayList<UsuarioModel> ranking(){
		ResultSet rs = null;
		Conexion cn = Conexion.getCon();
		Statement stmt;
		ArrayList<UsuarioModel> list = new ArrayList<UsuarioModel>();
		try {
String sql = "SELECT *,count(*) as numero FROM Letras l LEFT JOIN Usuarios u ON l.idUsuario = u.idUsuario group by l.idUsuario order by numero DESC";
			PreparedStatement preparedStatement = cn.getConexion().prepareStatement(sql);
			rs = preparedStatement.executeQuery(); 
			while(rs.next()){
				UsuarioModel usu = new UsuarioModel();
				usu.setAlias(rs.getString("usuario"));
				usu.setNumeroLetras(rs.getInt("numero"));
				list.add(usu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public void volverMain(JButton button, JFrame frame){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});	
	}
	
	public void exportarPDF(JButton button){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exportar");
			}
		});	
	}
}
