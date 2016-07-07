package br.edu.ufrb.lasis.humv.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufrb.lasis.humv.dao.HelloDAO;
import br.edu.ufrb.lasis.humv.entity.Hello;

@Service
public class HelloServiceImpl {
	
	private final static Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);
    
    @Autowired
    private HelloDAO helloDAO;
    
    public List<Hello> getAllHello(String name) {
        try {
        	List<Hello> list = helloDAO.findAll();
			logger.info("[getAllHello] Realizando teste com o Hello RESTFul service.");
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[getAllHello] Erro ao realizar teste com o Hello RESTFul service.");
			return null;
		}
    }
    
    public Hello findById(Long id) {
        try {
        	Hello hello = helloDAO.findById(id);
			logger.info("[findById] Realizando teste com o Hello RESTFul service.");
			return hello;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("[findById] Erro ao realizar teste com o Hello RESTFul service.");
			return null;
		}
    }
    
    public Hello saveHello(Hello hello) {
    	Hello resultingHello = helloDAO.saveHello(hello);
    	logger.info("[saveHello] Realizando teste com o Hello RESTFul service.");
        return resultingHello;
    }

}
