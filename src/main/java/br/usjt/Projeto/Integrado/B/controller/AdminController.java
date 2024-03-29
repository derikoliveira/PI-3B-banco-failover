package br.usjt.Projeto.Integrado.B.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.Projeto.Integrado.B.model.Questao;
import br.usjt.Projeto.Integrado.B.service.QuestaoService;

@Controller
public class AdminController {
	
	@Autowired
	QuestaoService service;
	
	@GetMapping("/admin")
	public ModelAndView Index() {
		return new ModelAndView("/admin/index");
	}
	
	@GetMapping("/quiz")
	public ModelAndView Quiz() {
		ModelAndView mv = new ModelAndView("/admin/quiz");
		
		Questao questao = service.buscarQuestao((long) 1);
		mv.addObject("questao", questao);
		
		return mv;
	}
	
	@PostMapping("/quiz")
	public ModelAndView Quiz(Questao questaoRespondida) {
		ModelAndView mv;
		
		if(service.questaoCorreta(questaoRespondida))
		{
			Questao questaoNova = service.buscarQuestao(questaoRespondida.getId() + 1);
		    
		    if(questaoNova != null)
		    {
		      mv = new ModelAndView("/admin/quiz");
		      mv.addObject("questao", questaoNova);
		    }
		    else
		      mv = new ModelAndView("/admin/quiz_vitoria");
		}
		else
			mv = new ModelAndView("/admin/quiz_derrota");
		
		return mv;
	}
	
	@GetMapping("/status")
	public ModelAndView Status() {
		return new ModelAndView("/admin/status");
	}
}
