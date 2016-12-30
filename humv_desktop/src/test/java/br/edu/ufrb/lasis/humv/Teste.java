/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv;

import br.edu.ufrb.lasis.humv.view.atendimentosocial.CadastrarAtendimentoSocialJPanel;
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
public class Teste {

    static {
        System.setProperty("logback.configurationFile", "logback.xml");
    }

    public Teste() {
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
        CadastrarAtendimentoSocialJPanel as = new CadastrarAtendimentoSocialJPanel();
        assertTrue(true);
    }
}
