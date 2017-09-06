package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.AcessorioDAO;
import br.com.fiap.model.Acessorio;

@Controller
@RequestMapping("/acessorio")
public class AcessorioController {

	@Autowired
	private AcessorioDAO dao;
	
	@GetMapping("cadastrar")
	public ModelAndView abrirForm()
	{
		ModelAndView view = new ModelAndView("acessorio/cadastraracessorio");
		view.addObject("acessorio", new Acessorio());		
		return view;
	}
	
	
	@Transactional
	@PostMapping
	public ModelAndView processarForm(Acessorio acessorio, RedirectAttributes attributes)
	{
		String msg = "";
		try{
			dao.cadastrar(acessorio);			
			msg = "Acessorio cadastrado com sucesso";
		}catch(Exception e)
		{
			e.printStackTrace();
			msg = "Erro ao cadastrar acessorio";
		}finally {
			attributes.addFlashAttribute("msg", msg);
		}		
			
		return new ModelAndView("redirect:/acessorio/listar");
	}
}
