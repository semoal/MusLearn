package Modelo;

import java.util.Date;

public class UsuarioModel {
	private String alias;
	private String password;
	private String salt;
	private Date fecharegistro;
	private String rol;
	
	public UsuarioModel() {
		this.alias = "";
		this.password = "";
		this.salt = "";
		this.fecharegistro = null;
		this.rol = "";
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(Date fecharegistro) {
		this.fecharegistro = fecharegistro;
	}
	
}
