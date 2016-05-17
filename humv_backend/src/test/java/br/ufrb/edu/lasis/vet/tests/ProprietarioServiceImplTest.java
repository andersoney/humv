package br.ufrb.edu.lasis.vet.tests;

import static org.junit.Assert.*;
import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.impl.ProprietarioServiceImpl;

import org.junit.Test;

/**Testes unitários de ProprietarioServiceImpl.
 * 
 *  @author Luiz Antônio Pereira
 *  
 *  @version 1
 *  
 *  @since 16 de maio de 2016
 * */


public class ProprietarioServiceImplTest {
	
	
	@Test
	public void testCadastrarNovoProprietario(){
		ProprietarioServiceImpl proprietarioServiceImpl = new ProprietarioServiceImpl();
		
		String resultadoEsperado = "Ok";
		
		Dono proprietario = new Dono();
		proprietario.setNome("José Silva");
		proprietario.setCpf("000.111.222-33");
		proprietario.setCep("44380-000");
		proprietario.setCidade("Cruz das Almas");
		proprietario.setEndereco("Rua da Estação, n 12, centro");
		proprietario.setEstado("Bahia");
		proprietario.setTelefone("(75) 3621-1414");
		
		String resultadoDevolvido = proprietarioServiceImpl.cadastrarProprietario(proprietario, "Luiz");
		assertEquals(resultadoEsperado,resultadoDevolvido,0);
		
	}
}
