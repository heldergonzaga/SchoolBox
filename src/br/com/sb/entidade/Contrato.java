package br.com.sb.entidade;

import java.sql.Date;

public class Contrato {

	Integer idContrato;
	Integer idUsuario;
	Integer idBox;
	Date dataInicial;
	Date dataFinal;
	String termoDeAdesao;
	String renovacaoAuto;
	String periodo;
	String valorPeriodo;
	
	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdBox() {
		return idBox;
	}
	public void setIdBox(Integer idBox) {
		this.idBox = idBox;
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
