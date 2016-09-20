/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tassiovale
 */
public class HUMVConfigUtils {

    private static Properties properties = null;

    private static Properties getProperties() {
        if (properties == null) {
            try {
                properties = new Properties();
                properties.load(new FileInputStream("arquivos/config.properties"));
            } catch (IOException ex) {
                Logger.getLogger(HUMVConfigUtils.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return properties;
    }

    private static String getConfigValue(String configParam) {
        return getProperties().getProperty(configParam);
    }

    public static String getVetBackendURL() {
        return getConfigValue("humv.backend.url");
    }
    
    public static String getAtendimentoInicioMatutino() {
        return getConfigValue("humv.atendimento.matutino.inicio");
    }
    
    public static String getAtendimentoTerminoMatutino() {
        return getConfigValue("humv.atendimento.matutino.termino");
    }
    
    public static String getAtendimentoInicioVespertino() {
        return getConfigValue("humv.atendimento.vespertino.inicio");
    }
    
    public static String getAtendimentoTerminoVespertino() {
        return getConfigValue("humv.atendimento.vespertino.termino");
    }
    
    public static String getAtendimentoDuracao() {
        return getConfigValue("humv.atendimento.duracao");
    }

}
