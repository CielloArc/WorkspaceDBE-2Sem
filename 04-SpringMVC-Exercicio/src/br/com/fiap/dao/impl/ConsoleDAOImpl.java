package br.com.fiap.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.dao.ConsoleDAO;
import br.com.fiap.model.Console;

@Repository
public class ConsoleDAOImpl extends GenericDAOImpl<Console, Integer> implements ConsoleDAO{

}
