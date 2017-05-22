package Modelo;

import java.io.IOException;
import java.util.Properties;

public class Idioma extends Properties{
	public Idioma(String idioma){
		 
        //Modificar si quieres a�adir mas idiomas
        //Cambia el nombre de los ficheros o a�ade los necesarios
        switch(idioma){
            case "Espa�ol":
                    getProperties("espanol.properties");
                    break;
            case "Ingl�s":
                    getProperties("ingles.properties");
                    break;
            default:
                    getProperties("espanol.properties");
        }
 
    }
 
    private void getProperties(String idioma) {
        try {
            this.load( getClass().getResourceAsStream(idioma) );
        } catch (IOException ex) {
 
        }
   }

}
