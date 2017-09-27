package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.FabricanteDAO;
import br.com.fiap.model.Fabricante;

@Controller
@RequestMapping("/fabricante")
public class FabricanteController {

	@Autowired
	private FabricanteDAO dao;
	
	@GetMapping("cadastrar")
	public ModelAndView abrirFormCadastro(){
		return new ModelAndView("fabricante/cadastro").addObject("fabricante", new Fabricante());
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarFormCadastro(@Valid Fabricante fabricante, BindingResult result, RedirectAttributes attributes){
		ModelAndView view;
		if(result.hasErrors()){
			view = new ModelAndView("fabricante/cadastro");
		}else{
			try {
				dao.cadastrar(fabricante);
				attributes.addFlashAttribute("msg", "Cadastrado com sucesso!");
			} catch (Exception e) {
				e.printStackTrace();
				attributes.addFlashAttribute("msg", "Erro ao cadastrar!");
				
			}finally {
				view = new ModelAndView("redirect:/fabricante/cadastrar");
			}		
		}		
		
		return view;
	}	
	
}
