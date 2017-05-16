package Controlador;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import com.omt.lyrics.SearchLyrics;
import com.omt.lyrics.beans.Lyrics;
import com.omt.lyrics.beans.LyricsServiceBean;
import com.omt.lyrics.beans.SearchLyricsBean;
import com.omt.lyrics.exception.SearchLyricsException;
import com.omt.lyrics.util.Sites;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

public class LyricsControlador {
	private String tituloCancionTemp;
	private String[] tituloCancion;
	private String urlYoutube;
	private String url;
	private boolean buscar;
	
	/*
	 * Acción del boton que realiza todo lo necesario para sacar el video y las lyrics
	 */
	public void ejecutaTodo(JButton btnBuscar,JTextField input,JTextArea textArea,JPanel panel,Browser browser){
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				urlAtitulo(input);
				if(buscar){
					videoACancion(input,textArea);
					meteVideo(input,panel,browser);
					tituloAlyrics(tituloCancion,textArea);
					exportarText(btnBuscar,textArea);
				}else{
					textArea.setText("Url no valida lo siento");
				}
			}
		});
	}
	/*Boton para exportar a .txt  */
	public void exportarText(JButton button,JTextArea textArea){
		String fichero = this.tituloCancion[0]+"-"+this.tituloCancion[1]+".txt";
		File x = new File(fichero);
		if(!x.exists()){
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
				bw.write(textArea.getText());
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("ese fichero ya existe");
		}
		
	}
	/*
	 * Método que le pasamos por parametro el String de youtube y hace la conversion a JSON para poder obtener el titulo de este
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
		if(this.tituloCancionTemp.contains("(Official)") || 
		   this.tituloCancionTemp.contains("[Official Video]") || 
		   this.tituloCancionTemp.contains("(Official Video)") ||
		   this.tituloCancionTemp.contains("(Lyric Video)") ||
		   this.tituloCancionTemp.contains("(Official Audio)") ||
		   this.tituloCancionTemp.contains("(Video Oficial)")

		 )
		 {
			this.tituloCancionTemp = this.tituloCancionTemp.replace("(Official)", "");
			this.tituloCancionTemp = this.tituloCancionTemp.replace("[Official Video]", "");
			this.tituloCancionTemp = this.tituloCancionTemp.replace("(Official Video)", "");
			this.tituloCancionTemp = this.tituloCancionTemp.replace("(Lyric Video)", "");
			this.tituloCancionTemp = this.tituloCancionTemp.replace("(Official Audio)", "");
			this.tituloCancionTemp = this.tituloCancionTemp.replace("(Video Oficial)", "");
			this.tituloCancion = this.tituloCancionTemp.split("-",0);
		 
		 }else{
			this.tituloCancion = this.tituloCancionTemp.split("-",0);
		 } 
	}
	/*
	 * Metemos la url del video de youtube en un iframe que lo mostrará
	 */
	public void meteVideo(JTextField input,JPanel panel,Browser browser){
		if(!input.getText().isEmpty()){
			 String videoUrlTemp= input.getText();
		     String videoUrl = videoUrlTemp.replace("watch?v=","embed/");
		     String x = "<iframe width=\"420\" height=\"345\" src=\""+videoUrl+"?autoplay=1\"></iframe>";
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
		 try {
			 if(this.tituloCancion.length>1){
				 bean.setSongName(this.tituloCancion[1]);
				 bean.setSongArtist(this.tituloCancion[0]);
			 }else{
				 textArea.setText("No hemos encontrado letra para esa cancion"); 
			 }
			 lyrics = searchLyrics.searchLyrics(bean);
			 if(!lyrics.isEmpty()){
				 for (Lyrics lyric : lyrics) {
					 String clean = replaceAcutesHTML(lyric.getText());
					 textArea.setText(clean);
				     textArea.setCaretPosition(0);
				 } 
			 }else{
				 textArea.setText("No hemos encontrado letra para esa cancion");
			 }
			 
		 } catch (SearchLyricsException e) {
		 }
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