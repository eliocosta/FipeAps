package br.edu.utfpr.fipe;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Veiculo {

	@XmlAttribute(name="id")
	private int codigo;
	
	@XmlAttribute(name="fipe_name")
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString(){
	  return nome;
	}
}
