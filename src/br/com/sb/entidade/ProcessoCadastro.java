package br.com.sb.entidade;

import java.util.ArrayList;
import java.util.List;

public class ProcessoCadastro {
	
	Usuario usuario;
	List<Box> listaBoxesCadastrados= new ArrayList<Box>();
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Box> getListaBoxesCadastrados() {
		return listaBoxesCadastrados;
	}
	public void setListaBoxesCadastrados(List<Box> listaBoxesCadastrados) {
		this.listaBoxesCadastrados = listaBoxesCadastrados;
	}
	
	
}
