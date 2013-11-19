package br.com.sb.entidade;

public class Localizacao {

	Integer idLocalizacao;
	String nome;
	Instituicao instituicao;
	
	public Localizacao(){
		setInstituicao(new Instituicao());
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	public Integer getIdLocalizacao() {
		return idLocalizacao;
	}
	public void setIdLocalizacao(Integer idLocalizacao) {
		this.idLocalizacao = idLocalizacao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
