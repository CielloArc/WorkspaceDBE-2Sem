package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.dao.ConsoleDAO;
import br.com.fiap.model.Console;

@Controller
@RequestMapping("/console")
public class ConsoleController {

	@Autowired
	private ConsoleDAO dao;
	
	
	@GetMapping("cadastrar")
	public String abrirForm()
	{
		return "console/cadastro";
	}
	
	@PostMapping("cadastrar")
	@Transactional
	public ModelAndView cadastrar(Console console)
	{
		dao.cadastrar(console);
		ModelAndView view = new ModelAndView("console/cadastroSucesso");
		view.addObject("console", console);
		return view;
	}
	
	@GetMapping("listar")
	public ModelAndView listar()
	{
		ModelAndView view = new ModelAndView("console/lista");
		view.addObject("consoles", dao.listar());
		return view;
	}
	
	
}
