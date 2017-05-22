package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Modelo.Conexion;
import Modelo.UsuarioModel;
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
				InicioVista inc = new InicioVista();
				inc.frame.setVisible(true);
			}
		});	
	}
	
	public void exportarRank(JButton button,List<String>export,JLabel label){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
				String fichero = "ranking-"+timeStamp+".txt";
				File x = new File(fichero);
				if(!x.exists()){
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
						bw.write("Ranking con fecha en: "+timeStamp);
						bw.newLine();
						for(int i=0;i<export.size();i++){
							bw.write(export.get(i));
							bw.newLine();
						}
						bw.newLine();
						bw.close();
						label.setText("Status: exportacion correcta");
					} catch (IOException oy) {
						oy.printStackTrace();
						label.setText("Status: exportacion erronea");
					}
				}else {
					label.setText("Status: el archivo ya existe");
				}
				
			}
		});		
	}
	
}
