package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.entity.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Usuario> buscarPorNome(String nome) {
		return em.createQuery("from Usuario u where u.nome like :n",
			Usuario.class).setParameter("n", "%"+nome+"%").getResultList();
	}

}
