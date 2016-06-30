
package br.edu.ufrb.lasis.humv.utils;

import javax.swing.JOptionPane;

/**
 * Utilitário: Menssagens de validações.
 *
 * @author Luiz Antônio Pereira
 * 
 * @version 1
 *
 * @since 26 de junho de 2016
 *
 */

public class MessagesUtils {
    public static void sucessoCadastro(String string){
        String msg = "Cadastro do "+string+" efetuado com sucesso!";
        JOptionPane.showMessageDialog(null,msg , "Sucesso no cadastro", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void erroCadastro(String string){
        String msg = "O cadastro do "+string+" não pode ser efetuado. Tente novamente mais tarde.";
        JOptionPane.showMessageDialog(null,msg , "Erro no cadastro", JOptionPane.ERROR_MESSAGE);
    }
    public static void erroConexao(){
        String msg = "Falha na comunicação com a base de dados. Por favor contate o adminstrador.";
        JOptionPane.showMessageDialog(null,msg , "ERRO", JOptionPane.ERROR);
    }
    public static void validaCampoVazio(String string){
        String msg = "O campo "+string+" não pode ficar vazio!";
        JOptionPane.showMessageDialog(null,msg , "Campo vazio", JOptionPane.WARNING_MESSAGE);
    }
    public static void validaCampoInvalido(String string){
        String msg = string+" inválido! Por favor informe outro "+string+".";
        JOptionPane.showMessageDialog(null,msg , "Campo inválido", JOptionPane.WARNING_MESSAGE);
    }
    public static String buscaSemResultado(String string){
        return "Nenhum resultado correspondente foi encontrado para este "+string+"! Por favor informe outro "+string+".";
    }
    public static void sucessoAtualizacao(String string){
        String msg = "Atualização do "+string+" efetuada com sucesso!";
        JOptionPane.showMessageDialog(null,msg , "Sucesso na atualização", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void erroAtualizacao(String string){
        String msg = "A atualização do "+string+" não pode ser efetuada. Tente novamente mais tarde.";
        JOptionPane.showMessageDialog(null,msg , "Erro na atualização", JOptionPane.ERROR_MESSAGE);
    }
    public static void sucessoRemocao(String string){
        String msg = "Remocao do "+string+" efetuada com sucesso!";
        JOptionPane.showMessageDialog(null,msg , "Sucesso na remoção", JOptionPane.INFORMATION_MESSAGE);

    }
    public static void erroRemocao(String string){
        String msg = "A remoção do "+string+" não pode ser efetuada. Tente novamente mais tarde.";
        JOptionPane.showMessageDialog(null,msg , "Erro na atualização", JOptionPane.ERROR_MESSAGE);
    }
    public static int dialogoCancelar(String tarefa,String operacao){
        String msg = "Deseja cancelar "+tarefa+" do "+operacao+"?";
        int op = JOptionPane.showConfirmDialog(null, msg,"Cancelar?",JOptionPane.YES_NO_OPTION);
        return op;
    }

}