package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.entity.Usuario;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Usuario> buscarPorNome(String nome) {
		return em.createQuery("from Usuario u where UPPER(u.nome) like UPPER (:n)",
			Usuario.class).setParameter("n", "%"+nome+"%").getResultList();
	}

	@Override
	public List<String> buscaPorNomeUsuario(String nome) {
		TypedQuery<String> query = em.createQuery("SELECT u.nome FROM Usuario u WHERE UPPER(u.nome) LIKE UPPER(:n)", String.class);
		query.setParameter("n", "%" + nome + "%");
		return query.getResultList();
	}
	
	@Override
	public long buscarPorNivel(int nivel){
		return em.createQuery("SELECT COUNT(u) FROM Usuario u WHERE u.nivel = :n", Long.class)
				.setParameter("n", nivel)
				.getSingleResult();
	}

	@Override
	public long contarPorMesAniversario(int mes) {
		return em.createQuery("SELECT COUNT(u) FROM Usuario u WHERE MONTH(u.dataNascimento) = :m", Long.class)
				.setParameter("m", mes)
				.getSingleResult();
	}

}
