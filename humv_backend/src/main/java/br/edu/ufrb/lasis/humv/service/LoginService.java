package br.edu.ufrb.lasis.humv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufrb.lasis.humv.impl.LoginServiceImpl;

@RestController
@RequestMapping(value = "/")
public class LoginService {
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(@RequestParam(value="username") String  username, @RequestParam(value="senha") String senha){
    	return loginServiceImpl.login(username, senha); 
    }
    
}
