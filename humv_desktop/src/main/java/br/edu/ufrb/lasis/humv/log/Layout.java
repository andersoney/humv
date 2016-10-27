/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.log;

import org.apache.log4j.PatternLayout;

/**
 *
 * @author Orion
 */
public class Layout extends PatternLayout {

    public Layout() {
        super("%d{HH:mm:ss.SSS} %5p - [%t - %F] - %msg%n");
    }

}
