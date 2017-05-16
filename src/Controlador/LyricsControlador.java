package Controlador;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	/*
	 * Acción del boton que realiza todo lo necesario para sacar el video y las lyrics
	 */
	public void ejecutaTodo(JButton btnBuscar,JTextField input,JTextArea textArea,JPanel panel,Browser browser){
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				urlAtitulo(urlYoutube);
				videoACancion(input,textArea);
				meteVideo(input,panel,browser);
				tituloAlyrics(tituloCancion,textArea);

			}
		});
	}
	/*
	 * Método que le pasamos por parametro el String de youtube y hace la conversion a JSON para poder obtener el titulo de este
	 */
	public String urlAtitulo(String youtubeUrl){
	    try {
	        if (youtubeUrl != null) {
	            URL embededURL = new URL("http://www.youtube.com/oembed?url=" +
	                youtubeUrl + "&format=json"
	            );
	            this.tituloCancionTemp= new JSONObject(IOUtils.toString(embededURL)).getString("title");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
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
		 bean.setSongName(this.tituloCancion[1]);
		 bean.setSongArtist(this.tituloCancion[0]);
		 System.out.println(this.tituloCancion[0] + "-" +this.tituloCancion[1] );
		 List<Lyrics> lyrics;
		 try {
			 lyrics = searchLyrics.searchLyrics(bean);
			 for (Lyrics lyric : lyrics) {
				 String clean = replaceAcutesHTML(lyric.getText());
				 textArea.setText(clean);
				 System.out.println(lyric.getText());
			 }
		 } catch (SearchLyricsException e) {
			 textArea.setText("No hemos encontrado letra para esa cancion");
			 e.printStackTrace();
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