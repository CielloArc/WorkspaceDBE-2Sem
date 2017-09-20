package br.com.fiap.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.model.Paciente;

@Repository
public class PacienteDAOImpl extends GenericDAOImpl<Paciente, Integer> implements PacienteDAO{

}
