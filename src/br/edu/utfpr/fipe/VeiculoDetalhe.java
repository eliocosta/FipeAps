package br.edu.utfpr.fipe;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VeiculoDetalhe {
	
	@XmlAttribute(name="fipe_codigo")
	private String fipe_codigo;
	
	@XmlAttribute(name="name")
	private String name;
	
	@XmlAttribute(name="referencia")
	private String referencia;
	
	@XmlAttribute(name="ano_modelo")
	private String ano_modelo;
	
	@XmlAttribute(name="combustivel")
	private String combustivel;
	
	@XmlAttribute(name="preco")
	private String preco;

	
	public String getFipe_codigo() {
		return fipe_codigo;
	}

	public void setFipe_codigo(String fipe_codigo) {
		this.fipe_codigo = fipe_codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getAno_modelo() {
		return ano_modelo;
	}

	public void setAno_modelo(String ano_modelo) {
		this.ano_modelo = ano_modelo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
	
}

