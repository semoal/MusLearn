package Controlador;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.mysql.jdbc.Statement;
import com.omt.lyrics.SearchLyrics;
import com.omt.lyrics.beans.Lyrics;
import com.omt.lyrics.beans.LyricsServiceBean;
import com.omt.lyrics.beans.SearchLyricsBean;
import com.omt.lyrics.exception.SearchLyricsException;
import com.omt.lyrics.util.Sites;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import Modelo.Conexion;
import Modelo.Idioma;
import Modelo.LetraModel;
import Modelo.UsuarioModel;
import Vista.InicioVista2;

public class LyricsControlador {
	private String tituloCancionTemp;
	private String[] tituloCancion;
	private String urlYoutube;
	private String url;
	private boolean buscar;
	private boolean done;
	
	/*
	 * AcciÃ³n del boton que realiza todo lo necesario para sacar el video y las lyrics
	 */
	public void ejecutaTodo(JButton btnBuscar,JTextField input,JTextArea textArea,JPanel panel,Browser browser,JLabel loading){
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    loading.setVisible(true);
				new Thread(new Runnable(){
				    @Override
				    public void run(){
				    	urlAtitulo(input);
						if(buscar){
							videoACancion(input,textArea);
							meteVideo(input,panel,browser);
							tituloAlyrics(tituloCancion,textArea);
							busqueda(input);
							done = true;
						}else{
							textArea.setText(Idioma.getIdioma().getProperty("urlnovalida"));
						}
				       if(done){
				         SwingUtilities.invokeLater(new Runnable(){
				             @Override public void run(){
				                loading.setVisible(false);      
				           }
				          });
				       }
				    }
				}).start();
			}
		});
	}
	/*Boton para exportar a .txt  */
	public void exportarText(JButton button,JTextArea textArea, JLabel label){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fichero = tituloCancion[0]+"-"+tituloCancion[1]+".txt";
				File x = new File(fichero);
				if(!x.exists()){
					try {
						BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
						bw.write(textArea.getText());
						bw.close();
						label.setVisible(true);
						label.setText(Idioma.getIdioma().getProperty("exportacionvalida"));
					} catch (IOException oy) {
						oy.printStackTrace();
						label.setVisible(true);
						label.setText(Idioma.getIdioma().getProperty("exportacioninvalida"));
					}
				}else {
					label.setVisible(true);
					label.setText(Idioma.getIdioma().getProperty("archivoyaexiste"));
				}
			}
		});
		
	}
	/*
	 * MÃ©todo que le pasamos por parametro el String de youtube y hace la conversion a JSON para poder obtener el titulo de este
	 */
	public String urlAtitulo(JTextField url){
		String youtubeUrl = url.getText();
		try {
	        if (youtubeUrl != null && youtubeUrl.contains("www.youtube.com")) {
	            URL embededURL = new URL("http://www.youtube.com/oembed?url=" +
	                youtubeUrl + "&format=json"
	            );
	            this.tituloCancionTemp= new JSONObject(IOUtils.toString(embededURL)).getString("title");
	        	this.buscar = true;
	        }else{
	        	this.buscar = false;
	        }

	    } catch (Exception e) {
	    }
	    return null;
	}
	/*
	 * Pasamos una url de youtube del usuario al titulo de este
	 */
	public void videoACancion(JTextField input,JTextArea textArea){
		this.urlYoutube = input.getText();		
		this.tituloCancionTemp = this.tituloCancionTemp.replaceAll("\\([^()]*\\)", "");
		this.tituloCancionTemp = this.tituloCancionTemp.replaceAll("\\[([^\\]]*)\\]", "");
		this.tituloCancion = this.tituloCancionTemp.split("-",0);
	}
	/*
	 * Metemos la url del video de youtube en un iframe que lo mostrarÃ¡
	 */
	public void meteVideo(JTextField input,JPanel panel,Browser browser){
		if(!input.getText().isEmpty()){
			 String videoUrlTemp= input.getText();
		     String videoUrl = videoUrlTemp.replace("watch?v=","embed/");
		     String x = "<iframe width=\"100%\" height=\"345\" src=\""+videoUrl+"?rel=0&autoplay=1 allowfullscreen\"></iframe>";
		     browser.loadHTML(x);
		}
	}
	/*
	 * Hacemos la llamada a la api con sus lyrics
	 */
	public void tituloAlyrics(String[] tituloCancion,JTextArea textArea){
		 SearchLyrics searchLyrics = new SearchLyrics();
		 LyricsServiceBean bean = new LyricsServiceBean();
		 List<Lyrics> lyrics;
		 boolean ok = false;
		 ok=false;
		 try {
			 if(this.tituloCancion.length>1){
				 bean.setSongArtist(this.tituloCancion[0].trim());
				 bean.setSongName(this.tituloCancion[1].trim());
				 System.out.println("Artista:"+this.tituloCancion[0]);
				 System.out.println("Cancion:"+this.tituloCancion[1]);
			 }else{
				 textArea.setText(Idioma.getIdioma().getProperty("nohayletra")); 
			 }
			 lyrics = searchLyrics.searchLyrics(bean);
			 if(!lyrics.isEmpty()){
				 for (Lyrics lyric : lyrics) {
					 String clean = replaceAcutesHTML(lyric.getText());
					 textArea.setText(clean);
				     textArea.setCaretPosition(0);
				     ok=true;
				 } 
			 }else if(ok==false){
				 bean.setSongArtist(this.tituloCancion[1].trim());
				 bean.setSongName(this.tituloCancion[0].trim());		
				 System.out.println("Artista:"+this.tituloCancion[1]);
				 System.out.println("Cancion:"+this.tituloCancion[0]);
				 System.out.println("ultimo if");
				 lyrics = searchLyrics.searchLyrics(bean);
				 if(!lyrics.isEmpty()){
					 for (Lyrics lyric : lyrics) {
						 String clean = replaceAcutesHTML(lyric.getText());
						 textArea.setText(clean);
					     textArea.setCaretPosition(0);
					     ok=true;
					 }  
				 }else{
					 consultaEnLetras(textArea,tituloCancion);
					 ok=true;
				 }	 
			 }
		 } catch (SearchLyricsException e) {
		 }
	}
	/*
	 * MÃ©todo que realiza un insert de la busqueda que hace el usuario 
	 */
	public void busqueda(JTextField input){
		ResultSet rs = null;
		Statement stmt;
    	String textoInput = input.getText();
    	
		try {
			String sql = "INSERT INTO Busquedas (idUsuario, urlbusqueda,fechaBusqueda) VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = Conexion.getCon().getConexion().prepareStatement(sql);
			preparedStatement.setInt(1, UsuarioModel.getUser().getidUsuario());
			System.out.println( UsuarioModel.getUser().getidUsuario());
			preparedStatement.setString(2, textoInput);
			preparedStatement.setDate(3, new java.sql.Date(Calendar.getInstance().getTime().getTime())  );
			preparedStatement.executeUpdate(); 
		} catch (SQLIntegrityConstraintViolationException z) {
			System.out.println(z);
		} catch (SQLException ok) {
			System.out.println(ok);
		}
	}
	//Consultamos si en nuestra base de datos tenemos una letra para la cancion que se ha buscado y no se encuentra en la api
	public void consultaEnLetras(JTextArea textarea, String[] tituloCancion){
		ResultSet rs = null;
	    PreparedStatement stmt;
	    String query = "SELECT * FROM `Letras` where artista like ? and titulo like ? LIMIT 1";
		try {
			stmt = Conexion.getCon().getConexion().prepareStatement(query);
			stmt.setString(1, this.tituloCancion[0].trim());
			stmt.setString(2, this.tituloCancion[1].trim());
			rs = stmt.executeQuery();
			if(rs.next()){
				creaObjeto(rs,textarea);
			}else{
	  			textarea.setText(Idioma.getIdioma().getProperty("quieresintroducirletra"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	//Insertamos la letra que hemos consultado en la base de datos en el textarea
	public void creaObjeto(ResultSet rs,JTextArea textArea){
    	LetraModel letra = new LetraModel();
        try {
        	letra.setLetra(rs.getString("letra"));
        	textArea.setText(letra.getLetra());
		    textArea.setCaretPosition(0);
        } catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void volver(JButton button, JFrame frame){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				done = false;
				InicioVista2 inc = new InicioVista2();
				inc.frame.setVisible(true);
			}
		});
	}
	
	/* Conversor de texto con caracteres especiales para la api */
	public String replaceAcutesHTML(String str) {

		str = str.replaceAll("&aacute;","á");
		str = str.replaceAll("&eacute;","é");
		str = str.replaceAll("&iacute;","í");
		str = str.replaceAll("&oacute;","ó");
		str = str.replaceAll("&uacute;","ú");
		str = str.replaceAll("&Aacute;","Á");
		str = str.replaceAll("&Eacute;","É");
		str = str.replaceAll("&Iacute;","Í");
		str = str.replaceAll("&Oacute;","Ó");
		str = str.replaceAll("&Uacute;","Ú");
		str = str.replaceAll("&ntilde;","ñ");
		str = str.replaceAll("&Ntilde;","Ñ");

		return str;
	}
}