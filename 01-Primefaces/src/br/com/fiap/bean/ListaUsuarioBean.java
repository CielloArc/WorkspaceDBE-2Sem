package br.com.fiap.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.DBException;

@ManagedBean
@ViewScoped
public class ListaUsuarioBean {

	private List<Usuario> lista;

	private UsuarioBO bo;

	private String nome;

	private int codigo;

	@PostConstruct
	private void init() {
		bo = new UsuarioBO();
		lista = bo.listar();
	}

	public void excluir() {
		FacesMessage msg = new FacesMessage();
		try {
			bo.remover(codigo);
			lista = bo.listar();
			msg = new FacesMessage("Removido");
		} catch (DBException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao Remover");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);		
	}

	public List<String> completarPorNome(String nome) {
		return bo.completaNomeCliente(nome);
	}

	public void buscar() {
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
