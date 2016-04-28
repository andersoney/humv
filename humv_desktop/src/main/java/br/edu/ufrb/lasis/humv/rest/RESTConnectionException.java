/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.rest;

import com.sun.jersey.api.client.ClientResponse;

/**
 *
 * @author tassiovale
 */
public class RESTConnectionException extends Exception {
    
    private ClientResponse response;
    
    public RESTConnectionException(ClientResponse response, String message){
        super(message);
        this.response = response;
    }

    public ClientResponse getResponse() {
        return response;
    }

    public void setResponse(ClientResponse response) {
        this.response = response;
    }
    
}
