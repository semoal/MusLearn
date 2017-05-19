package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import Modelo.Conexion;
import Modelo.LetraModel;
import Modelo.UsuarioModel;
import java.awt.datatransfer.*;
import java.awt.Toolkit;

public class PerfilControlador {
	public ArrayList<LetraModel> getLetrasBuscadas(){
		ResultSet rs = null;
		Conexion cn = Conexion.getCon();
		Statement stmt;
		ArrayList<LetraModel> list = new ArrayList<LetraModel>();
		try {
String sql = "SELECT * FROM Busquedas b left join Usuarios u on u.idUsuario=b.idUsuario where u.idUsuario=?";
			PreparedStatement preparedStatement = cn.getConexion().prepareStatement(sql);
			preparedStatement.setInt(1, UsuarioModel.getUser().getidUsuario());
			rs = preparedStatement.executeQuery(); 
			while(rs.next()){
				LetraModel letra = new LetraModel();
				letra.setFechainsercion(rs.getDate("fechaBusqueda"));
				letra.setUrlYoutube(rs.getString("urlbusqueda"));
				list.add(letra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String urlAtitulo(String url){
		String youtubeUrl = url;
		try {
	        if (youtubeUrl != null && youtubeUrl.contains("www.youtube.com")) {
	            URL embededURL = new URL("http://www.youtube.com/oembed?url=" +
	                youtubeUrl + "&format=json"
	            );
	           return new JSONObject(IOUtils.toString(embededURL)).getString("title");
	        }else{
	        }

	    } catch (Exception e) {
	    }
	    return null;
	}
	
	public void copiarUrl(JButton button, JTable table_1,JLabel copy){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				String urlCopy = table_1.getValueAt(row, 0).toString();
				StringSelection stringSelection = new StringSelection(urlCopy);
				Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
				clpbrd.setContents(stringSelection, null);
				if(!urlCopy.isEmpty()){
					copy.setText("Enlace copiado correctamente");
				}
			}
		});
	}
	public void volverMain(JButton button, JFrame frame){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});	
	}
}
