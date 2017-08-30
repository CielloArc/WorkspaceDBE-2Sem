package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.model.Veiculo;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired
	private VeiculoDAO dao;

	@GetMapping("cadastrar") //Abre a tela de formulário
	public String abrirForm(){
		return "veiculo/cadastro";
	}
	
	@Transactional
	@PostMapping("cadastrar") //Processa as informações do formulário
	public ModelAndView processaForm(Veiculo veiculo){
		System.out.println(veiculo.getModelo() + veiculo.getMarca()
				+ veiculo.getAno() + veiculo.getPlaca() + veiculo.getCor());		
		//Cadastrar no banco
		dao.cadastrar(veiculo);;
		//Retorno...
		ModelAndView retorno = new ModelAndView("veiculo/cadastroSucesso");
		retorno.addObject("v",veiculo);
		return retorno;
	}
	
	@GetMapping("listar")
	public ModelAndView listarVeiculos(){
		ModelAndView retorno = new ModelAndView("veiculo/lista");
		retorno.addObject("veiculos",dao.listar());
		return retorno;
	}
	
}




