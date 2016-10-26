/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.log;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

/**
 *
 * @author Orion
 */
public class FabricaDeLog {

    /**
     * Ordem dos log: trace>>debug>>info>>warn>>erro>>fatal. Atualmente
     * configurado para all.
     *
     * @param clazz
     * @return
     */
    public static Logger getLog(Class clazz) {
        Logger log = LogManager.getLogger(clazz);
        log.setLevel(Level.ALL);
        log.setAdditivity(true);
        ConsoleAppender app = new ConsoleAppender(new Layout(), "System.out");
        log.addAppender(app);
        return log;
    }
}
