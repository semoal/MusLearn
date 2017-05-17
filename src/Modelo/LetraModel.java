package Modelo;

import java.util.Date;

public class LetraModel {
	private int idUsuario;
	private String titulo;
	private String artista;
	private String letra;
	private Date fechainsercion;
	
	public LetraModel() {
		this.idUsuario = 0;
		this.titulo = "";
		this.artista = "";
		this.letra = "";
		this.fechainsercion = null;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public Date getFechainsercion() {
		return fechainsercion;
	}

	public void setFechainsercion(Date fechainsercion) {
		this.fechainsercion = fechainsercion;
	}

}
