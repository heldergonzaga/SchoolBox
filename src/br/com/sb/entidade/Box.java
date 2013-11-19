package br.com.sb.entidade;

public class Box {

	Integer idBox;
	String senha;
	Integer numero;
	Localizacao localizacao;
	
	public Box(){
		setLocalizacao(new Localizacao());
	}
	
	public Integer getIdBox() {
		return idBox;
	}
	public void setIdBox(Integer idBox) {
		this.idBox = idBox;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
	
}
