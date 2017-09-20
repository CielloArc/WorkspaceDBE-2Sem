package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.dao.VeiculoDAO;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.model.Veiculo;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
	
	@Autowired //Servidor vai injetar um objeto aqui
	private VeiculoDAO dao;
	
	@Transactional
	@PostMapping("excluir")
	public ModelAndView excluirForm(int codigo, RedirectAttributes redirect){
		try {
			dao.remover(codigo);
			redirect.addFlashAttribute("msg", "Excluido!");
		} catch (IdNotFoundException e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/veiculo/listar");
	}
	
	@Transactional
	@PostMapping("editar")
	public ModelAndView processarFormEdicao(@Valid Veiculo veiculo, BindingResult result, RedirectAttributes redirect){
		ModelAndView view;
		if(result.hasErrors()){
			view = new ModelAndView("veiculo/edicao");
		}else
		{
			try{
				dao.alterar(veiculo);
				redirect.addFlashAttribute("msg", "Atualizado!");
			}catch (Exception e) {
				e.printStackTrace();
				redirect.addFlashAttribute("msg", "Erro ao Atualizar");
			}finally {
				view = new ModelAndView("redirect:/veiculo/listar");
			}		
		}
		
		return view;
	}

	@GetMapping("editar/{id}")
	public ModelAndView abrirFormEdicao(@PathVariable("id") int codigo){
		Veiculo veiculo = dao.pesquisar(codigo);
		return new ModelAndView("veiculo/edicao")
							.addObject("veiculo",veiculo);
	}
	
	@GetMapping("cadastrar") //Abre a tela de formulário
	public ModelAndView abrirForm(){
		return new ModelAndView("veiculo/cadastro")
							.addObject("veiculo", new Veiculo());
	}
	
	@Transactional
	@PostMapping("cadastrar") //Processa as informações do formulário
	public ModelAndView processaForm(@Valid Veiculo veiculo, BindingResult result  ,RedirectAttributes redirect){
		ModelAndView retorno;
		
		if(result.hasErrors()){
			retorno = new ModelAndView("veiculo/cadastro");
		}else{
			try{
				//Cadastrar no banco
				dao.cadastrar(veiculo);
				//Retorno.. redirecionar para o método listar				
				redirect.addFlashAttribute("msg", "Cadastrado com sucesso!");
			}catch(Exception e)
			{
				e.printStackTrace();
				redirect.addFlashAttribute("msg", "Erro ao cadastrar!");
			}finally {
				retorno = new ModelAndView("redirect:/veiculo/listar");
			}		
		}
		return retorno;
	}
	
	@GetMapping("listar")
	public ModelAndView listarVeiculos(){
		ModelAndView retorno = new ModelAndView("veiculo/lista");
		retorno.addObject("veiculos",dao.listar());
		return retorno;
	}
	
}




