package br.com.inteligencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.inteligencia.service.CadastrarCompras;
import br.com.inteligencia.service.ImportacaoService;

@Controller
public class ControllerHome {

	@Autowired
	private CadastrarCompras cadastroCompras;
	
	@Autowired
	private ImportacaoService importacaoService;
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(){
		return "home";
	}
	
	@RequestMapping(value="cadastro", method = RequestMethod.GET)
	public ModelAndView cadastrarCompras(){
		cadastroCompras.cadastro();
		return new ModelAndView("redirect:/home");
	}
	
	
	@RequestMapping(value="exportacao", method = RequestMethod.GET)
	public ModelAndView exportacao() throws Exception{
		
		ModelAndView model = new ModelAndView("arquivoApriori");
		
		
		model.addObject("arquivo", importacaoService.criarArquivoImportacaoAtributos());
		return model;
	}
	
	@RequestMapping(value="processar", method = RequestMethod.GET)
	public ModelAndView processarDados() throws Exception{
		ModelAndView model = new ModelAndView("resultadoApriori");
		model.addObject("apriori", importacaoService.processarDados());
		return model;
	}
	
	@RequestMapping(value="deletar", method = RequestMethod.GET)
	public ModelAndView deletarCompras(){
		cadastroCompras.deleteCompras();
		return new ModelAndView("redirect:/home");
	}
	
}
