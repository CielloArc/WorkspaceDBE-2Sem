package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Usuario;

public interface UsuarioDAO 
					extends GenericDAO<Usuario, Integer>{

	List<Usuario> buscarPorNome(String nome);
	List<String> buscaPorNomeUsuario(String nome);	
	long buscarPorNivel(int nivel);
	long contarPorMesAniversario(int mes);
}