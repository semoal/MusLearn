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
	
	public void ejecutaTodo(JButton btnBuscar,JTextField input,JTextArea textArea,JPanel panel,Browser browser){
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				urlAtitulo(urlYoutube);
				videoACancion(input,textArea);
				meteVideo(input,panel,browser);
			}
		});
	}
	public void videoACancion(JTextField input,JTextArea textArea){
		this.urlYoutube = input.getText();
		System.out.println(this.tituloCancionTemp);
		if(this.tituloCancionTemp.contains("(Official)") || 
		   this.tituloCancionTemp.contains("[Official Video]") || 
		   this.tituloCancionTemp.contains("(Official Video)") ||
		   this.tituloCancionTemp.contains("(Lyric Video)")
		){
			this.tituloCancionTemp = this.tituloCancionTemp.replace("(Official)", "");
			this.tituloCancionTemp = this.tituloCancionTemp.replace("[Official Video]", "");
			this.tituloCancionTemp = this.tituloCancionTemp.replace("(Official Video)", "");
			this.tituloCancionTemp = this.tituloCancionTemp.replace("(Lyric Video)", "");
			this.tituloCancion = this.tituloCancionTemp.split("-",0);
		}else{
			this.tituloCancion = this.tituloCancionTemp.split("-",0);
		}
		tituloAlyrics(this.tituloCancion,textArea);
	}

	public void meteVideo(JTextField input,JPanel panel,Browser browser){
		if(!input.getText().isEmpty()){
			 String videoUrlTemp= input.getText();
		     String videoUrl = videoUrlTemp.replace("watch?v=","embed/");
		     String x = "<iframe width=\"420\" height=\"345\" src=\""+videoUrl+"?autoplay=1\"></iframe>";
		     browser.loadHTML(x);
		}
	}
	/*
	 * Método que le pasamos por parametro el String de youtube y hace la conversion a JSON para poder obtener el titulo de este
	 */
	private String urlAtitulo(String youtubeUrl){
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
	 * Hacemos la llamada a la api con sus lyrics
	 */
	private void tituloAlyrics(String[] tituloCancion,JTextArea textArea){
		 SearchLyrics searchLyrics = new SearchLyrics();
		 LyricsServiceBean bean = new LyricsServiceBean();
		 bean.setSongName(this.tituloCancion[1]);
		 bean.setSongArtist(this.tituloCancion[0]);
		 System.out.println(this.tituloCancion[0] + "-" +this.tituloCancion[1] );
		 List<Lyrics> lyrics;
		 try {
			 lyrics = searchLyrics.searchLyrics(bean);
			 for (Lyrics lyric : lyrics) {
				 textArea.setText(lyric.getText());
				 System.out.println(lyric.getText());
			 }
		 } catch (SearchLyricsException e) {
			 e.printStackTrace();
		 }
	}
}