package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	public static Conexion con = null;
	private Connection conexion;
	
	public Conexion() {
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		}catch(Exception e){
			System.err.println(e);
		}
		try{
			String cadenaDeConnexio = "jdbc:mysql://54.186.208.69/proyecto?user=admin&password=admin";
			conexion= DriverManager.getConnection(cadenaDeConnexio);
		}catch(Exception e){
			System.err.println("Error connectant a mysql/educa amb user=root");
		}
	
	}

	public static Conexion getCon(){
		if(con==null){
			con = new Conexion();
		}
		return con;
	}	
	public Connection getConexion() {
		return conexion;
	}
	private void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	
}