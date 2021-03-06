package Modelo;

import java.util.Date;

public class UsuarioModel {
	private static UsuarioModel current_user;
	private int idUsuario;
	private String alias;
	private String password;
	private Date fecharegistro;
	private String rol;
	private int numeroLetras;
	private int busquedas;
	
	public UsuarioModel() {
		this.idUsuario = 0;
		this.alias = "";
		this.password = "";
		this.fecharegistro = null;
		this.rol = "";
		this.numeroLetras = 0;
		this.busquedas = 0;
	}
	public static UsuarioModel getUser(){
		return current_user;
	}
	
	public static void setUser(UsuarioModel user){
		current_user = user;
	}
	
	public int getidUsuario(){
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario){
		this.idUsuario = idUsuario;
	}
	public int getBusquedas(){
		return busquedas;
	}
	
	public void setBusquedas(int busquedas){
		this.busquedas = busquedas;
	}
	
	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	public int getNumeroLetras() {
		return numeroLetras;
	}

	public void setNumeroLetras(int numeroLetras) {
		this.numeroLetras = numeroLetras;
	}
	
}
