/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.Animais;

import br.edu.ufrb.lasis.humv.HUMVApp;
import br.edu.ufrb.lasis.humv.entity.AnimalGrande;
import br.edu.ufrb.lasis.humv.entity.AnimalPequeno;
import br.edu.ufrb.lasis.humv.rest.RESTConnectionException;
import br.edu.ufrb.lasis.humv.rest.RESTMethods;
import br.edu.ufrb.lasis.humv.view.busca.PropriedadesBusca;
import com.sun.jersey.api.client.ClientResponse;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.codehaus.jackson.type.TypeReference;

/**
 *
 * @author Andersoney
 */
public class PropriedadeBuscarAnimais extends PropriedadesBusca {

    private final AnimalTableModel animalTableModel;
    private static final Logger LOG = Logger.getLogger(PropriedadeBuscarAnimais.class.getName());
    AnimalTableModel tableModel;

    public PropriedadeBuscarAnimais(String tipoOperacao) {
        super(tipoOperacao);
        animalTableModel = new AnimalTableModel();
        super.setTabelaResultado(new JTable(animalTableModel));
    }

    @Override
    public void buscar() {
        HUMVApp.exibirMensagemCarregamento();
        try {
            ClientResponse response = RESTMethods.get("/api/animalGrande");

            List<AnimalGrande> lista = (List<AnimalGrande>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<AnimalGrande>>() {
            });
            tableModel = new AnimalTableModel(lista);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(super.getTabelaResultado(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
            LOG.warning(ex.getMessage());
        }
        try {
            ClientResponse response = RESTMethods.get("/api/animalPequeno");

            List<AnimalPequeno> lista = (List<AnimalPequeno>) RESTMethods.getObjectFromJSON(response, new TypeReference<List<AnimalPequeno>>() {
            });
            tableModel.getAnimais().addAll(lista);
            super.getTabelaResultado().setModel(tableModel);
            super.getTabelaResultado().revalidate();
        } catch (RESTConnectionException | IOException ex) {
            JOptionPane.showMessageDialog(super.getTabelaResultado(), "Erro ao conectar-se com banco de dados. Por favor, tente novamente mais tarde.", "Falha na autenticação", JOptionPane.ERROR_MESSAGE);
            LOG.warning(ex.getMessage());
        }
        HUMVApp.esconderMensagemCarregamento();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Verificar condições para busca.
        if (e.getSource().equals(this.getBotaoBusca())) {
            this.buscar();
            LOG.info("Botao buscar para:" + this.getTipoOperacao());
        } else if (e.getSource().equals(this.getBotaoOperacao()) && this.getTipoOperacao().equals(OPCAO_VISUALIZAR)) {
            LOG.info("Clicado no botão operação para:" + this.getTipoOperacao());
            HUMVApp.exibirMensagemCarregamento();
            AnimalGrande atual = this.tableModel.getAnimais().get(this.getTabelaResultado().getSelectedRow());
            HUMVApp.setNovoPainelCentral(new CadastroAnimals(null, atual, OPCAO_VISUALIZAR));
            HUMVApp.esconderMensagemCarregamento();
        } else if (e.getSource().equals(this.getBotaoOperacao()) && this.getTipoOperacao().equals(OPCAO_ALTERAR)) {
            LOG.log(Level.INFO, "Clicado no bot\u00e3o opera\u00e7\u00e3o para:{0}", this.getTipoOperacao());
            HUMVApp.exibirMensagemCarregamento();
            AnimalGrande atual = this.tableModel.getAnimais().get(this.getTabelaResultado().getSelectedRow());
            HUMVApp.setNovoPainelCentral(new CadastroAnimals(null, atual, OPCAO_ALTERAR));
            HUMVApp.esconderMensagemCarregamento();
        } else if (e.getSource().equals(this.getBotaoOperacao()) && this.getTipoOperacao().equals(PropriedadesBusca.OPCAO_REMOVER)) {
            LOG.log(Level.INFO, "Clicado no bot\u00e3o opera\u00e7\u00e3o para:{0}", this.getTipoOperacao());
            HUMVApp.exibirMensagemCarregamento();
            AnimalGrande atual = this.tableModel.getAnimais().get(this.getTabelaResultado().getSelectedRow());
            HUMVApp.setNovoPainelCentral(new CadastroAnimals(null, atual, OPCAO_REMOVER));
            HUMVApp.esconderMensagemCarregamento();
        }
    }

}
