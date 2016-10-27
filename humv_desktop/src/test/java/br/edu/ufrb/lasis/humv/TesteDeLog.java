/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv;

import br.edu.ufrb.lasis.humv.log.FabricaDeLog;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Orion
 */
public class TesteDeLog {

    private final Logger log = FabricaDeLog.getLog(TesteDeLog.class);

    public TesteDeLog() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
        log.trace("Tracer mensagem");
        log.debug("Debug mensagem");
        log.info("Info mensagem");
        log.warn("Warn mensagem");
        log.error("Erro mensagem");
        log.fatal("fatal mensagem");
        assertTrue(true);
    }
}
