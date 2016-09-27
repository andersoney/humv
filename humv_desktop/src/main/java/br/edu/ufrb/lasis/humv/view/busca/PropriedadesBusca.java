/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.busca;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author tassi
 */
public abstract class PropriedadesBusca implements ActionListener, KeyListener {

    public static final String OPCAO_VISUALIZAR_ALTERAR = "Visualizar/Alterar";
    public static final String OPCAO_REMOVER = "Remover";
    public static final String OPCAO_CADASTRAR = "Cadastrar";
    public static final String OPCAO_SELECIONAR = "Selecionar";

    private String tipoOperacao;
    private JButton botaoBusca, botaoOperacao, botaoImprimirTabela, botaoCancelar;
    private JTable tabelaResultado;
    private JTextField campoPalavraChave;
    private JFrame jFrame = null;

    public PropriedadesBusca(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public PropriedadesBusca(String tipoOperacao, JFrame jFrame) {
        this.tipoOperacao = tipoOperacao;
        this.jFrame = jFrame;
    }

    public abstract void buscar();

    public void configurarBusca(JTextField campoBusca, JButton botaoBusca, JButton botaoImprimir, JButton botaoCancelar, JTable tabelaResultado) {
        campoBusca.addKeyListener(this);
        this.setCampoPalavraChave(campoBusca);

        this.setBotaoBusca(botaoBusca);
        this.getBotaoBusca().addActionListener(this);
        this.getBotaoBusca().addKeyListener(this);

        this.setBotaoImprimirTabela(botaoImprimir);
        this.getBotaoImprimirTabela().addActionListener(this);

        this.setBotaoCancelar(botaoCancelar);
        this.getBotaoCancelar().addActionListener(this);

        this.setTabelaResultado(tabelaResultado);
    }

    public void configurarBotaoOperacaoPosBusca(JButton botaoOperacao) {
        this.setBotaoOperacao(botaoOperacao);
        this.getBotaoOperacao().setText(this.getTipoOperacao());
        this.getBotaoOperacao().addActionListener(this);

        if (this.getTipoOperacao().equalsIgnoreCase(PropriedadesBusca.OPCAO_VISUALIZAR_ALTERAR)) {
            this.getBotaoOperacao().setIcon(new ImageIcon("imagens/small_visualizar.png"));
        } else if (this.getTipoOperacao().equalsIgnoreCase(PropriedadesBusca.OPCAO_REMOVER)) {
            this.getBotaoOperacao().setIcon(new ImageIcon("imagens/small_cancelar.png"));
        } else if (this.getTipoOperacao().equalsIgnoreCase(PropriedadesBusca.OPCAO_SELECIONAR)) {
            this.getBotaoOperacao().setIcon(new ImageIcon("imagens/small_salvar.png"));
        }
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

    public JButton getBotaoCancelar() {
        return botaoCancelar;
    }

    public void setBotaoCancelar(JButton botaoCancelar) {
        this.botaoCancelar = botaoCancelar;
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

    public JTextField getCampoPalavraChave() {
        return campoPalavraChave;
    }

    public void setCampoPalavraChave(JTextField campoPalavraChave) {
        this.campoPalavraChave = campoPalavraChave;
    }

    public JButton getBotaoImprimirTabela() {
        return botaoImprimirTabela;
    }

    public void setBotaoImprimirTabela(JButton botaoImprimirTabela) {
        this.botaoImprimirTabela = botaoImprimirTabela;
    }

    public JFrame getjFrame() {
        return jFrame;
    }

    public void setjFrame(JFrame jFrame) {
        this.jFrame = jFrame;
    }

}
