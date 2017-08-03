package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.dao.impl.UsuarioDAOImpl;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class UsuarioBO {

	private EntityManagerFactory fabrica = 
			EntityManagerFactorySingleton.getInstance();
	
	public List<Usuario> listar(){
		EntityManager em = fabrica.createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		List<Usuario> lista = dao.listar();
		em.close();
		return lista;
	}
	
	
	public Usuario buscar(int codigo) {
		EntityManager em = fabrica.createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		Usuario usuario = dao.pesquisar(codigo);
		em.close();
		return usuario;
	}

	public void cadastrar(Usuario consultor) throws DBException {
		EntityManager em = fabrica.createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		dao.cadastrar(consultor);
		try {
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}finally {
			em.close();
		}
	}

	public void atualizar(Usuario consultor) throws DBException {
		EntityManager em = fabrica.createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		dao.alterar(consultor);
		try {
			dao.salvar();
		} catch (DBException e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		}finally {
			em.close();
		}
	}

	public void remover(int codigo) throws DBException {
		EntityManager em = fabrica.createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		try {
			dao.remover(codigo);
			dao.salvar();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException(e.getMessage());
		} finally {
			em.close();
		}
	}

	public List<Usuario> buscarPorNome(String nome) {
		UsuarioDAO dao = new UsuarioDAOImpl(EntityManagerFactorySingleton
							.getInstance().createEntityManager());
		return dao.buscarPorNome(nome);
	}
	
}






