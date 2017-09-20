package br.com.fiap.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.model.Veiculo;

@Repository
public class VeiculoDAOImpl 
		extends GenericDAOImpl<Veiculo, Integer> implements VeiculoDAO {

}
