package Modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Idioma extends Properties{
	public static Idioma language = null;
	public FileInputStream  xd = null; 
	public String idim = null;
	
	public Idioma(String idioma){
        this.setIdioma(idioma);
 
    }
	
	
	public void setIdioma(String idioma){
		this.idim=idioma;
		switch(idioma){
	        case "Espanyol":
	                getProperties("espanol.properties");
	                break;
	        case "Ingles":
	                getProperties("ingles.properties");
	                break;
	        default:
	                getProperties("espanol.properties");
		}
	}
	
	public static Idioma getIdioma(){
		if(language==null){
			language=new Idioma("Ingles");
		}
		return language;
	}
 
    private void getProperties(String idioma) {
        try {
        
            this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {
 
        }
   }

}
