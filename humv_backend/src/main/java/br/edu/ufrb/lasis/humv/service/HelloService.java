package br.edu.ufrb.lasis.humv.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.edu.ufrb.lasis.humv.entity.Hello;
import br.edu.ufrb.lasis.humv.impl.HelloServiceImpl;

@RestController
@RequestMapping(value = "/api/hello")
@Secured("ROLE_ADMIN")
public class HelloService {
	
	@Autowired
	private HelloServiceImpl helloServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public List<Hello> getAllHello(@RequestParam(value="name", defaultValue="World") String name){
		return helloServiceImpl.getAllHello(name);
	}
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Hello findById(@PathVariable("id") final Long id){
    	return helloServiceImpl.findById(id);
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Hello saveHello(@RequestBody Hello hello){
    	return helloServiceImpl.saveHello(hello);
    }

	public HelloServiceImpl getHelloServiceImpl() {
		return helloServiceImpl;
	}

	public void setHelloServiceImpl(HelloServiceImpl helloServiceImpl) {
		this.helloServiceImpl = helloServiceImpl;
	}

}
