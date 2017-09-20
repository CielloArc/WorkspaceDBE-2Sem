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

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.model.Paciente;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	@Autowired
	private PacienteDAO dao;
	
	@GetMapping("cadastrar")
	public ModelAndView abrirFormCadastro(){
		return new ModelAndView("paciente/cadastro").addObject("paciente", new Paciente());
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView processarForm(@Valid Paciente paciente, BindingResult result, RedirectAttributes attributes){
		ModelAndView view;
		
		if(result.hasErrors()){
			view = new ModelAndView("paciente/cadastro");
		}else{
			try {
				dao.cadastrar(paciente);
				attributes.addFlashAttribute("msg", "Cadastrado com sucesso");
				} catch (Exception e) {
				e.printStackTrace();
				attributes.addFlashAttribute("msg", "Erro ao cadastrar");
			}finally {
				view = new ModelAndView("redirect:/paciente/listar");
			}
		}		
		return view;
	}
	
	@GetMapping("listar")
	public ModelAndView listarPacientes(){
		return new ModelAndView("paciente/lista").addObject("pacientes", dao.listar());
	}
}
