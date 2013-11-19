package br.com.sb.entidade;

import java.sql.Date;

public class Contrato {

	Integer idContrato;
	Date dataInicial;
	Date dataFinal;
	String termoDeAdesao;
	String renovacaoAuto;
	String periodo;
	String valorPeriodo;
	Usuario usuario;
	Box box;
	
	public Contrato(){
		setBox(new Box());
		setUsuario(new Usuario());
	}
	
	public Box getBox() {
		return box;
	}
	public void setBox(Box box) {
		this.box = box;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getTermoDeAdesao() {
		return termoDeAdesao;
	}
	public void setTermoDeAdesao(String termoDeAdesao) {
		this.termoDeAdesao = termoDeAdesao;
	}
	public String getRenovacaoAuto() {
		return renovacaoAuto;
	}
	public void setRenovacaoAuto(String renovacaoAuto) {
		this.renovacaoAuto = renovacaoAuto;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getValorPeriodo() {
		return valorPeriodo;
	}
	public void setValorPeriodo(String valorPeriodo) {
		this.valorPeriodo = valorPeriodo;
	}
}
