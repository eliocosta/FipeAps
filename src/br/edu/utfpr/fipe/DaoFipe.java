package br.edu.utfpr.fipe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class DaoFipe {
	
	public List<Marca> getMarcas(){
		
		try {
			// https://fipeapi.appspot.com/api/1/carros/marcas.json
			URL url = new URL("http://www.fipe.tk/api/marcas.php");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			if(con.getResponseCode() != 200) {
				System.out.println("http error " + con.getResponseCode());
			}
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			
			Map<String, Object> prop = new HashMap<String, Object>(2);
			prop.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
			
			// caso tenha objeto raiz no json
			prop.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
			
			JAXBContext context = JAXBContext.newInstance(
					new Class[] {Marca.class}, prop);
			
			Unmarshaller deserialize = context.createUnmarshaller();
			
			List<Marca> marcas = (List<Marca>) deserialize.unmarshal(
					new StreamSource(reader), Marca.class).getValue();
			
			return marcas;
			
//			for(Marca m : marcas) {
//				System.out.println(m.getCodigo() + " - " + m.getNome());
//			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Veiculo> getVeiculos(int idMarca){
		
		try {
			URL url = new URL("http://www.fipe.tk/api/veiculos.php?cod=" + idMarca);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			if(con.getResponseCode() != 200) {
				System.out.println("http error " + con.getResponseCode());
			}
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			
			Map<String, Object> prop = new HashMap<String, Object>(2);
			prop.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
			
			// caso tenha objeto raiz no json
			prop.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
			
			JAXBContext context = JAXBContext.newInstance(
					new Class[] {Veiculo.class}, prop);
			
			Unmarshaller deserialize = context.createUnmarshaller();
			
			List<Veiculo> veiculos = (List<Veiculo>) deserialize.unmarshal(
					new StreamSource(reader), Veiculo.class).getValue();
			
			return veiculos;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Ano> getAnos(int idVeiculo){
		
		try {
			URL url = new URL("http://www.fipe.tk/api/veiculo.php?cod=" + idVeiculo);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			if(con.getResponseCode() != 200) {
				System.out.println("http error " + con.getResponseCode());
			}
			
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			
			Map<String, Object> prop = new HashMap<String, Object>(2);
			prop.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
			
			// caso tenha objeto raiz no json
			prop.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
			
			JAXBContext context = JAXBContext.newInstance(
					new Class[] {Ano.class}, prop);
			
			Unmarshaller deserialize = context.createUnmarshaller();
			
			List<Ano> anos = (List<Ano>) deserialize.unmarshal(
					new StreamSource(reader), Ano.class).getValue();
			
			return anos;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
