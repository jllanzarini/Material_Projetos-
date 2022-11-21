package com.aula.spring.com.aula.spring.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


import model.Pessoa;
import repository.PessoaRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@Controller
public class GreetingsController {
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
   /* @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    
    public String greetingText(@PathVariable String name) {
        return  name + "Está Louco pra Assistir o Jogo da Copa!";
    }*/
    
	@Autowired
	private PessoaRepository pessoarepository;
	
    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String salvar(Pessoa pessoa) {
    	pessoarepository.save(pessoa);
    	return "index";
    }
 
}
