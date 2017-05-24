package Controlador;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
 
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
import Modelo.Conexion;
import Modelo.Idioma;
import Modelo.LetraModel;
import Modelo.UsuarioModel;
import Vista.InicioVista;
 
public class RankingControlador {
	
	public ArrayList<UsuarioModel> ranking(){
		ResultSet rs = null;
		Conexion cn = Conexion.getCon();
		Statement stmt;
		ArrayList<UsuarioModel> list = new ArrayList<UsuarioModel>();
		try {
String sql = "SELECT *,count(*) as numero FROM Letras l LEFT JOIN Usuarios u ON l.idUsuario = u.idUsuario group by l.idUsuario order by numero DESC";
			PreparedStatement preparedStatement = cn.getConexion().prepareStatement(sql);
			rs = preparedStatement.executeQuery(); 
			while(rs.next()){
				UsuarioModel usu = new UsuarioModel();
				usu.setAlias(rs.getString("usuario"));
				usu.setNumeroLetras(rs.getInt("numero"));
				list.add(usu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<LetraModel> ranking1(){
		ResultSet rs = null;
		Conexion cn = Conexion.getCon();
		Statement stmt;
		ArrayList<LetraModel> list1 = new ArrayList<LetraModel>();
		try {
String sql = "select urlBusqueda,count(*) as busquedas from Busquedas b group by b.urlbusqueda order by busquedas DESC";
			PreparedStatement preparedStatement = cn.getConexion().prepareStatement(sql);
			rs = preparedStatement.executeQuery(); 
			while(rs.next()){
				LetraModel letra = new LetraModel();
				letra.setUrlYoutube(rs.getString("urlBusqueda"));
				letra.setBusquedasGlobales(rs.getInt("busquedas"));
				list1.add(letra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list1;
	}
	
	
	public void volverMain(JButton button, JFrame frame){
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				InicioVista inc = new InicioVista();
				inc.frame.setVisible(true);
			}
		});	
	}
 
	public void exportarRank(JButton button, ArrayList<UsuarioModel> list, JLabel label) throws DocumentException{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
					DefaultPieDataset pieDataset = new DefaultPieDataset();
					for (int i=0; i<list.size();i++){
						pieDataset.setValue(list.get(i).getAlias()+" ("+list.get(i).getNumeroLetras()+")", new Integer(list.get(i).getNumeroLetras()));
					}
					
			        JFreeChart chart = ChartFactory.createPieChart3D(
			            Idioma.getIdioma().getProperty("introducciondeletras")+ timeStamp, 
			            pieDataset,
			            true, 
			            true, 
			            false 
			        );
					
	
			        try {
			            ChartUtilities.saveChartAsJPEG(new File("ranking_foto.jpg"), chart, 500, 300);
			        } catch (Exception r) {
			          
			        }
			        
					Document documento = new Document();
					FileOutputStream ficheroPdf = null;
					try {
						ficheroPdf = new FileOutputStream("ranking.pdf");
						try {
							PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
						} catch (DocumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			 
						label.setText(Idioma.getIdioma().getProperty("exportacionvalida"));
					} catch (FileNotFoundException r) {
						r.printStackTrace();
					}
			 
					documento.open();
			        try
			        {
			        	Image foto = Image.getInstance("ranking_foto.jpg");
			        	foto.scaleToFit(600, 600);
			        	foto.setAlignment(Chunk.ALIGN_MIDDLE);
			        	documento.add(foto);
			        }
			        catch ( Exception r ) {
			        	r.printStackTrace();
			        }
					documento.close();
			}
 
		});
	}
	
	public void exportarBusquedas(JButton button, ArrayList<LetraModel> list, JLabel label) throws DocumentException{
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				PerfilControlador xd = new PerfilControlador();
				String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
			    DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
				final String top = "Top 10";
					for (int i=0; i<10;i++){
					      dataset.addValue(list.get(i).getBusquedasGlobales() , xd.urlAtitulo(list.get(i).getUrlYoutube()) , top );
					}

					
			        JFreeChart chart = ChartFactory.createBarChart(
			                Idioma.getIdioma().getProperty("busq"), 
			                Idioma.getIdioma().getProperty("cancionesplural"), Idioma.getIdioma().getProperty("busq2"), 
			                dataset,PlotOrientation.VERTICAL, 
			                true, true, false);
					
	
			        try {
			            ChartUtilities.saveChartAsJPEG(new File("ranking_busquedas.jpg"), chart, 500, 300);
			        } catch (Exception r) {
			          
			        }
			        
					Document documento = new Document();
					FileOutputStream ficheroPdf = null;
					try {
						ficheroPdf = new FileOutputStream("busquedas.pdf");
						try {
							PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
						} catch (DocumentException e1) {
							e1.printStackTrace();
						}
			 
						label.setText(Idioma.getIdioma().getProperty("exportacionvalida"));
					} catch (FileNotFoundException r) {
						r.printStackTrace();
					}
			 
					documento.open();
			        try {
			        	Image foto = Image.getInstance("ranking_busquedas.jpg");
			        	foto.scaleToFit(600, 600);
			        	foto.setAlignment(Chunk.ALIGN_MIDDLE);
			        	documento.add(foto);
			        }catch ( Exception r ) {
			        	r.printStackTrace();
			        }
					documento.close();
			}
 
		});
	}
}
 
 
 
