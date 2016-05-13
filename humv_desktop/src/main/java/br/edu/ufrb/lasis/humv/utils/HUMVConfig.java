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
public class HUMVConfig {

    private static String vetBackendUrl = null;
    public static final String PERFIL_ADMINISTRADOR = "Administrador";
    public static final String PERFIL_RECEPCIONISTA = "Recepcionista";
    public static final String PERFIL_VETERINARIO = "Médico";
    public static final String PERFIL_FARMACEUTICO = "Farmacêutico";

    public static String getVetBackendURL() {
        if (vetBackendUrl == null) {
            vetBackendUrl = getConfigValue("vet.backend.url");
        }
        return vetBackendUrl;
    }

    private static String getConfigValue(String configParam) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("arquivos/config.properties"));
            return properties.getProperty(configParam);
        } catch (IOException ex) {
            Logger.getLogger(HUMVConfig.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
