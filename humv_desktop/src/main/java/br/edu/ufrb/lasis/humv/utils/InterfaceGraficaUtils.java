package br.edu.ufrb.lasis.humv.utils;

import java.awt.Toolkit;
import javax.swing.JFrame;
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
public class InterfaceGraficaUtils {

    public static String getMensagemSucessoResposta(String resposta) {
        return resposta;
    }

    public static void sucessoResposta(String resposta) {
        JOptionPane.showMessageDialog(null, resposta, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void erroResposta(String resposta) {
        JOptionPane.showMessageDialog(null, resposta, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void sucessoCadastro(String tipoObjeto) {
        String msg = "Registro de " + tipoObjeto + " efetuado com sucesso!";
        JOptionPane.showMessageDialog(null, msg, "Registro de " + tipoObjeto, JOptionPane.INFORMATION_MESSAGE);
    }
    public static void sucessoCadastro(String tipoObjeto,String tipoCodigo,  String id) {
        String msg = "Registro de " + tipoObjeto + " com "+tipoCodigo + " "+id +" efetuado com sucesso!";
        JOptionPane.showMessageDialog(null, msg, "Registro de " + tipoObjeto, JOptionPane.INFORMATION_MESSAGE);
    }

    public static String getMensagemErroCadastro(String tipoObjeto) {
        return "O cadastro de " + tipoObjeto + " não pode ser efetuado. Tente novamente mais tarde.";
    }

    public static void erroCadastro(String tipoObjeto) {
        String msg = "O cadastro de " + tipoObjeto + " não pode ser efetuado. Tente novamente mais tarde.";
        JOptionPane.showMessageDialog(null, msg, "Erro no cadastro", JOptionPane.ERROR_MESSAGE);
    }

    public static String getMensagemErroConexao() {
        return "Falha na comunicação com a base de dados. Por favor contate o administrador do sistema.";
    }

    public static void erroConexao() {
        String msg = "Falha na comunicação com a base de dados. Por favor contate o administrador do sistema.";
        JOptionPane.showMessageDialog(null, msg, "ERRO", JOptionPane.ERROR_MESSAGE);
    }

    public static String getMensagemValidaCampoVazio(String objeto) {
        return "O campo " + objeto + " não pode permanecer vazio!";
    }

    public static void validaCampoVazio(String tipoObjeto) {
        String msg = "O campo " + tipoObjeto + " não pode permanecer vazio!";
        JOptionPane.showMessageDialog(null, msg, "Campo vazio", JOptionPane.WARNING_MESSAGE);
    }

    public static String getMensagemValidarCampoInvalido(String tipoObjeto) {
        return tipoObjeto + " inválido! Por favor informe outro " + tipoObjeto + ".";
    }

    public static void validaCampoInvalido(String tipoObjeto) {
        String msg = tipoObjeto + " inválido! Por favor informe outro " + tipoObjeto + ".";
        JOptionPane.showMessageDialog(null, msg, "Campo inválido", JOptionPane.WARNING_MESSAGE);
    }

    public static String getMensagemBuscaSemResultado(String tipoObjeto) {
        return "Nenhum resultado correspondente foi encontrado para este " + tipoObjeto + "! Por favor informe outro " + tipoObjeto + ".";
    }

    public static String buscaSemResultado(String tipoObjeto) {
        return "Nenhum resultado correspondente foi encontrado para este " + tipoObjeto + "! Por favor informe outro " + tipoObjeto + ".";
    }

    public static String getMensagemSucessoAtualizacao(String tipoObjeto) {
        return "Atualização de " + tipoObjeto + " efetuada com sucesso!";
    }

    public static void sucessoAtualizacao(String tipoObjeto) {
        String msg = "Atualização de " + tipoObjeto + " efetuada com sucesso!";
        JOptionPane.showMessageDialog(null, msg, "Sucesso na atualização", JOptionPane.INFORMATION_MESSAGE);
    }

    public static String erroAtualização(String tipoObjeto) {
        return "A atualização de " + tipoObjeto + " não pode ser efetuada. Tente novamente mais tarde.";
    }

    public static void erroAtualizacao(String tipoObjeto) {
        String msg = "A atualização de " + tipoObjeto + " não pode ser efetuada. Tente novamente mais tarde.";
        JOptionPane.showMessageDialog(null, msg, "Erro na atualização", JOptionPane.ERROR_MESSAGE);
    }

    public static String getMensagemSucessoRemocao(String tipoObjeto) {
        return "Remoção de " + tipoObjeto + " efetuada com sucesso!";
    }

    public static void sucessoRemocao(String tipoObjeto) {
        String msg = "Remoção de " + tipoObjeto + " efetuada com sucesso!";
        JOptionPane.showMessageDialog(null, msg, "Sucesso na remoção", JOptionPane.INFORMATION_MESSAGE);

    }

    public static String getMensagemErroRemocao(String tipoObjeto) {
        String msg = "A remoção de " + tipoObjeto + " não pode ser efetuada. Tente novamente mais tarde.";
        return msg;
    }

    public static void erroRemocao(String tipoObjeto) {
        String msg = "A remoção de " + tipoObjeto + " não pode ser efetuada. Tente novamente mais tarde.";
        JOptionPane.showMessageDialog(null, msg, "Erro na atualização", JOptionPane.ERROR_MESSAGE);
    }

    public static String getMensagemValorInvalido(String campo) {
        String msg = "O campo " + campo + " possui valor inválido. Por favor, forneça outro valor.";
        return msg;
    }

    public static void valorInvalido(String campo) {
        String msg = "O campo " + campo + " possui valor inválido. Por favor, forneça outro valor.";
        JOptionPane.showMessageDialog(null, msg, "Valor inválido", JOptionPane.WARNING_MESSAGE);
    }

    public static boolean dialogoCancelar(String tarefa, String operacao) {
        String msg = "Deseja cancelar " + tarefa + " de " + operacao + "?";
        int op = JOptionPane.showConfirmDialog(null, msg, "Cancelar?", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean dialogoSair() {
        String msg = "Deseja realmente sair desta página?";
        int op = JOptionPane.showConfirmDialog(null, msg, "Cancelar?", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
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

    public static boolean dialogoMensagem(String titulo, String msg) {
        int op = JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    public static void semResultadosGeracaoRelatorio() {
        JOptionPane.showMessageDialog(null, "Não existe resultado para geração do relatório.\nPor favor, realize uma nova busca e solicite a geração do relatório.", "Busca sem resultados", JOptionPane.WARNING_MESSAGE);
    }

    public static void erroGeracaoRelatorio() {
        JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado na geração do relatório. Por favor, contacte o administrador do sistema.", "Erro no relatório", JOptionPane.ERROR_MESSAGE);
    }

    public static void sucessoGeracaoRelatorio() {
        JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso!", "Relatório", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void exibirJanela(JFrame jFrame) {
        jFrame.pack();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        jFrame.setLocation((width - jFrame.getWidth()) / 2, (height - jFrame.getHeight()) / 2);
        jFrame.setVisible(true);
    }

}
