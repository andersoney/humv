package br.edu.ufrb.lasis.humv.view.procedimento;

import br.edu.ufrb.lasis.humv.view.setor.SetorListaJDialog;
import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.utils.InterfaceGraficaUtils;
import br.edu.ufrb.lasis.humv.entity.Procedimento;
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.utils.ResultadoBusca;
import br.edu.ufrb.lasis.humv.utils.ValidationsUtils;
import br.edu.ufrb.lasis.humv.view.busca.BuscaJPanel;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import br.edu.ufrb.lasis.humv.view.setor.CadastrarSetorJDialog;
import br.edu.ufrb.lasis.humv.view.setor.PropriedadesBuscaSetor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.sun.jersey.api.client.ClientResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz
 */
public class CadastrarProcedimentoJPanel extends javax.swing.JPanel implements ResultadoBusca {

    private Setor setor = null;
    private String nomeSetor;
    private final String servicoProcedimento = "/api/procedimento";
    private Procedimento procedimentoSelecionado;

    /**
     * Creates new form CadastroProcedimento
     */
    public CadastrarProcedimentoJPanel() {
        initComponents();
        customInitComponents();
    }

    public CadastrarProcedimentoJPanel(Procedimento procedimentoSelecionado) {
        this.procedimentoSelecionado = procedimentoSelecionado;
        initComponents();
        customInitComponents();
    }

    private void customInitComponents() {
        jTextFieldNome.setFocusable(true);

        if (procedimentoSelecionado != null) {
            jLabelTitulo.setText("ALTERAÇÃO DO PROCEDIMENTO");
            jTextFieldNome.setText(procedimentoSelecionado.getNome());
            jTextFieldCodigo.setText(procedimentoSelecionado.getCodigo().toString());
            jTextFieldPreco.setText("" + ValidationsUtils.convertePrecoParaString(procedimentoSelecionado.getValor()));
            setor = procedimentoSelecionado.getSetor();
            nomeSetor = procedimentoSelecionado.getSetor().getNome();
            jLabelNomeSetor.setText("Nome: " + nomeSetor);
        }
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public JLabel getjLabelNomeSetor() {
        return jLabelNomeSetor;
    }

    @Override
    public void setResultado(Object resultado) {
        this.setor = (Setor) resultado;
        this.jLabelNomeSetor.setText("Nome: " + setor.getCodigo().toString() + " - " + setor.getNome());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInformacoesSetor = new javax.swing.JPanel();
        jButtonCadastrarSetor = new javax.swing.JButton();
        jButtonPesqusar = new javax.swing.JButton();
        jLabelNomeSetor = new javax.swing.JLabel();
        jButtonExibirLista = new javax.swing.JButton();
        jPanelInformacoesProcedimento = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabelPreco = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        jPanelInformacoesSetor.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do setor"));

        jButtonCadastrarSetor.setIcon(new javax.swing.ImageIcon("imagens/small_cadastrar.png"));
        jButtonCadastrarSetor.setText("Novo");
        jButtonCadastrarSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarSetorActionPerformed(evt);
            }
        });

        jButtonPesqusar.setIcon(new javax.swing.ImageIcon("imagens/small_buscar.png"));
        jButtonPesqusar.setText("Buscar");
        jButtonPesqusar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesqusarActionPerformed(evt);
            }
        });

        jLabelNomeSetor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelNomeSetor.setText("Nome: ");

        jButtonExibirLista.setIcon(new javax.swing.ImageIcon("imagens/small_lista.png"));
        jButtonExibirLista.setText("Exibir lista");
        jButtonExibirLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExibirListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInformacoesSetorLayout = new javax.swing.GroupLayout(jPanelInformacoesSetor);
        jPanelInformacoesSetor.setLayout(jPanelInformacoesSetorLayout);
        jPanelInformacoesSetorLayout.setHorizontalGroup(
            jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesSetorLayout.createSequentialGroup()
                .addGroup(jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInformacoesSetorLayout.createSequentialGroup()
                        .addComponent(jButtonPesqusar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExibirLista, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCadastrarSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInformacoesSetorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelNomeSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelInformacoesSetorLayout.setVerticalGroup(
            jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesSetorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacoesSetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesqusar)
                    .addComponent(jButtonExibirLista)
                    .addComponent(jButtonCadastrarSetor))
                .addGap(18, 18, 18)
                .addComponent(jLabelNomeSetor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelInformacoesProcedimento.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do procedimento"));

        jLabelNome.setText("Nome:");

        jLabelCodigo.setText("Código:");

        jLabelPreco.setText("Preço R$ (ex.: 40,00):");

        javax.swing.GroupLayout jPanelInformacoesProcedimentoLayout = new javax.swing.GroupLayout(jPanelInformacoesProcedimento);
        jPanelInformacoesProcedimento.setLayout(jPanelInformacoesProcedimentoLayout);
        jPanelInformacoesProcedimentoLayout.setHorizontalGroup(
            jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesProcedimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome)
                    .addGroup(jPanelInformacoesProcedimentoLayout.createSequentialGroup()
                        .addGroup(jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome)
                            .addComponent(jLabelCodigo)
                            .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPreco))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelInformacoesProcedimentoLayout.setVerticalGroup(
            jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInformacoesProcedimentoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(jLabelPreco))
                .addGap(10, 10, 10)
                .addGroup(jPanelInformacoesProcedimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("CADASTRO DE PROCEDIMENTO");

        jButtonConfirmar.setIcon(new javax.swing.ImageIcon("imagens/small_salvar.png"));
        jButtonConfirmar.setText("Salvar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jButtonCancelar.setIcon(new javax.swing.ImageIcon("imagens/small_cancelar.png"));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConfirmar))
                            .addComponent(jPanelInformacoesProcedimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelInformacoesSetor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jPanelInformacoesSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jPanelInformacoesProcedimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonConfirmar)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        if (setor == null) {
            InterfaceGraficaUtils.validaCampoVazio("setor");
            return;
        }
        if (this.jTextFieldNome.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("nome");
            return;
        }
        String nome = this.jTextFieldNome.getText();
        if (this.jTextFieldCodigo.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("código");
            return;
        }
        BigInteger codigo = new BigInteger(jTextFieldCodigo.getText());
        if (jTextFieldPreco.getText().isEmpty()) {
            InterfaceGraficaUtils.validaCampoVazio("preço");
            return;
        }

        double valor = ValidationsUtils.converteStringParaPreco(jTextFieldPreco.getText());

        Procedimento procedimento = new Procedimento();
        procedimento.setValor(valor);
        procedimento.setCodigo(codigo);
        procedimento.setNome(nome);
        procedimento.setSetor(setor);
        try {
            ClientResponse response;
            if (procedimentoSelecionado == null) {
                response = RESTMethods.post(this.servicoProcedimento, procedimento);
            } else if (InterfaceGraficaUtils.dialogoRemoverAlterar("alterar", "procedimento", procedimentoSelecionado.getNome())) {
                response = RESTMethods.put(this.servicoProcedimento, procedimento);
            } else {
                return;
            }
            String resposta = response.getEntity(String.class);
            if (!resposta.equalsIgnoreCase("ok")) {
                InterfaceGraficaUtils.erroResposta(resposta);
            } else {
                if (procedimentoSelecionado == null) {
                    InterfaceGraficaUtils.sucessoCadastro("procedimento");
                } else {
                    InterfaceGraficaUtils.sucessoAtualizacao("procedimento");
                }
                HUMVApp.exibirMensagemCarregamento();
                HUMVApp.setPainelCentralComLogo();
                HUMVApp.esconderMensagemCarregamento();
            }
        } catch (RESTConnectionException ex) {
            InterfaceGraficaUtils.erroConexao();
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        boolean sair = InterfaceGraficaUtils.dialogoCancelar("o cadastro", "procedimento");
        if (sair) {
            System.gc();
            HUMVApp.setPainelCentralComLogo();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonCadastrarSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarSetorActionPerformed
        new CadastrarSetorJDialog(this).setVisible(true);
    }//GEN-LAST:event_jButtonCadastrarSetorActionPerformed

    private void jButtonExibirListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExibirListaActionPerformed
        try {
            ClientResponse response = RESTMethods.get("/api/setor");
            List<Setor> lista = (List<Setor>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<Setor>>() {
            });
            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não existem setores cadastrados.", "Lista de setores", JOptionPane.INFORMATION_MESSAGE);
            } else {
                new SetorListaJDialog(this, lista).setVisible(true);
            }
        } catch (RESTConnectionException | IOException ex) {
            InterfaceGraficaUtils.erroConexao();
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButtonExibirListaActionPerformed

    private void jButtonPesqusarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesqusarActionPerformed
        JFrame jFrame = new JFrame("Busca");
        PropriedadesBuscaSetor propriedadesBusca = new PropriedadesBuscaSetor(PropriedadesBusca.OPCAO_SELECIONAR, jFrame, this);
        BuscaJPanel buscaPanel = new BuscaJPanel("BUSCA DE SETOR", propriedadesBusca);
        jFrame.setContentPane(buscaPanel);
        InterfaceGraficaUtils.exibirJanela(jFrame);
    }//GEN-LAST:event_jButtonPesqusarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrarSetor;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonExibirLista;
    private javax.swing.JButton jButtonPesqusar;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeSetor;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelInformacoesProcedimento;
    private javax.swing.JPanel jPanelInformacoesSetor;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    // End of variables declaration//GEN-END:variables

}
