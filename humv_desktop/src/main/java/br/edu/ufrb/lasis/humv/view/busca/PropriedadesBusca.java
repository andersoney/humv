/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.busca;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author tassi
 */
public abstract class PropriedadesBusca implements ActionListener, KeyListener {

    public static final String OPCAO_VISUALIZAR = "Visualizar";
    public static final String OPCAO_ALTERAR = "Alterar";
    public static final String OPCAO_REMOVER = "Remover";
    public static final String OPCAO_CADASTRAR = "Cadastro";

    private String tipoOperacao;
    private JButton botaoBusca, botaoOperacao;
    private JTable tabelaResultado;

    public PropriedadesBusca(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public abstract void buscar();

    public void configurarBusca(JTextField campoBusca, JButton botaoBusca, JTable tabelaResultado) {
        campoBusca.addKeyListener(this);
        this.setBotaoBusca(botaoBusca);
        this.getBotaoBusca().addActionListener(this);
        this.getBotaoBusca().addKeyListener(this);
        this.setTabelaResultado(tabelaResultado);
    }

    public void configurarBotaoOperacaoPosBusca(JButton botaoOperacao) {
        this.setBotaoOperacao(botaoOperacao);
        this.getBotaoOperacao().setText(this.getTipoOperacao());
        this.getBotaoOperacao().addActionListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            buscar();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public String getTipoOperacao() {
        return this.tipoOperacao;
    }

    public void setTipoOPeracao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public JButton getBotaoBusca() {
        return botaoBusca;
    }

    public void setBotaoBusca(JButton botaoBusca) {
        this.botaoBusca = botaoBusca;
    }

    public JButton getBotaoOperacao() {
        return botaoOperacao;
    }

    public void setBotaoOperacao(JButton botaoOperacao) {
        this.botaoOperacao = botaoOperacao;
    }

    public JTable getTabelaResultado() {
        return tabelaResultado;
    }

    public void setTabelaResultado(JTable tabelaResultado) {
        this.tabelaResultado = tabelaResultado;
    }

    public int getIndexLinhaSelecionada() {
        return this.getTabelaResultado().getSelectedRow();
    }

}
