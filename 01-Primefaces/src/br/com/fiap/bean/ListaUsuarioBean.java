package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.entity.Usuario;

@ManagedBean
public class ListaUsuarioBean {

	private List<Usuario> lista;
	
	private UsuarioBO bo;

	private String nome;
	
	@PostConstruct
	private void init(){
		bo = new UsuarioBO();
		lista = bo.listar();
	}
	
	public void buscar(){
		lista = bo.buscarPorNome(nome);
	}

	public List<Usuario> getLista() {
		return lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
