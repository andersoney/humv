/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.reports;

import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.entity.QuestionarioSocioeconomico;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.ClientResponse;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tassiovale
 */
public class QuestionarioSocioeconomicoReport {

    private final static Logger logger = LoggerFactory.getLogger(QuestionarioSocioeconomicoReport.class);
    private QuestionarioSocioeconomico questionario;
    private List<Animal> animais;

    public QuestionarioSocioeconomico getQuestionario() {
        return questionario;
    }

    public void setQuestionario(QuestionarioSocioeconomico questionario) {
        this.questionario = questionario;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public static QuestionarioSocioeconomicoReport fillReportObject(QuestionarioSocioeconomico questionario) {
        QuestionarioSocioeconomicoReport reportItem = new QuestionarioSocioeconomicoReport();
        reportItem.setQuestionario(questionario);
        try {
            ClientResponse response = RESTMethods.get("/api/animal/searchByDono/" + questionario.getDono().getId().toString());
            List<Animal> animais = (List<Animal>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Animal>>() {
            });
            reportItem.setAnimais(animais);
        } catch (RESTConnectionException | IOException ex) {
            logger.error("mensagem: " + ex.getMessage(), ex);
            return null;
        }
        return reportItem;
    }

}
