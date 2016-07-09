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
public class MessageUtils {

    public static void erroResposta(String resposta) {
        JOptionPane.showMessageDialog(null, resposta, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void sucessoCadastro(String tipoObjeto) {
        String msg = "Registro de " + tipoObjeto + " efetuado com sucesso!";
        JOptionPane.showMessageDialog(null, msg, "Registro de " + tipoObjeto, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void erroCadastro(String tipoObjeto) {
        String msg = "O cadastro de " + tipoObjeto + " não pode ser efetuado. Tente novamente mais tarde.";
        JOptionPane.showMessageDialog(null, msg, "Erro no cadastro", JOptionPane.ERROR_MESSAGE);
    }

    public static void erroConexao() {
        String msg = "Falha na comunicação com a base de dados. Por favor contate o administrador do sistema.";
        JOptionPane.showMessageDialog(null, msg, "ERRO", JOptionPane.ERROR_MESSAGE);
    }

    public static void validaCampoVazio(String tipoObjeto) {
        String msg = "O campo " + tipoObjeto + " não pode permanecer vazio!";
        JOptionPane.showMessageDialog(null, msg, "Campo vazio", JOptionPane.WARNING_MESSAGE);
    }

    public static void validaCampoInvalido(String tipoObjeto) {
        String msg = tipoObjeto + " inválido! Por favor informe outro " + tipoObjeto + ".";
        JOptionPane.showMessageDialog(null, msg, "Campo inválido", JOptionPane.WARNING_MESSAGE);
    }

    public static String buscaSemResultado(String tipoObjeto) {
        return "Nenhum resultado correspondente foi encontrado para este " + tipoObjeto + "! Por favor informe outro " + tipoObjeto + ".";
    }

    public static void sucessoAtualizacao(String tipoObjeto) {
        String msg = "Atualização de " + tipoObjeto + " efetuada com sucesso!";
        JOptionPane.showMessageDialog(null, msg, "Sucesso na atualização", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void erroAtualizacao(String tipoObjeto) {
        String msg = "A atualização de " + tipoObjeto + " não pode ser efetuada. Tente novamente mais tarde.";
        JOptionPane.showMessageDialog(null, msg, "Erro na atualização", JOptionPane.ERROR_MESSAGE);
    }

    public static void sucessoRemocao(String tipoObjeto) {
        String msg = "Remoção de " + tipoObjeto + " efetuada com sucesso!";
        JOptionPane.showMessageDialog(null, msg, "Sucesso na remoção", JOptionPane.INFORMATION_MESSAGE);

    }

    public static void erroRemocao(String tipoObjeto) {
        String msg = "A remoção de " + tipoObjeto + " não pode ser efetuada. Tente novamente mais tarde.";
        JOptionPane.showMessageDialog(null, msg, "Erro na atualização", JOptionPane.ERROR_MESSAGE);
    }

    public static void valorInvalido(String campo) {
        String msg = "O campo " + campo + " possui valor inválido. Por favor, forneça outro valor.";
        JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.WARNING_MESSAGE);
    }

    public static int dialogoCancelar(String tarefa, String operacao) {
        String msg = "Deseja cancelar " + tarefa + " de " + operacao + "?";
        int op = JOptionPane.showConfirmDialog(null, msg, "Cancelar?", JOptionPane.YES_NO_OPTION);
        return op;
    }

    public static boolean dialogoRemoverAlterar(String operacao, String tipo, String nome) {
        String msg = "Deseja " + operacao + " o " + tipo + " " + nome + "?";
        int op = JOptionPane.showConfirmDialog(null, msg, "Cancelar?", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

}
