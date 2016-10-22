/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.questionario;

import br.edu.ufrb.lasis.humv.entity.Documentacao;
import br.edu.ufrb.lasis.humv.entity.Parente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Orion
 */
public class AbstractTableModelParente extends AbstractTableModel {

    ArrayList<Parente> parentes;

    private String[] colunas = new String[]{
        "Nome do Cliente", "Nome", "Renda", "Ocupação"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public AbstractTableModelParente() {
        this.parentes = new ArrayList<Parente>();
    }

    public AbstractTableModelParente(ArrayList<Parente> documentos) {
        this.parentes = documentos;
    }

    @Override
    public int getRowCount() {
        return this.parentes.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length; //To change body of generated methods, choose Tools | Templates.
    }
    /*private String nomeClienteCadastrado;
    
     private String nome;
     private int idade;
     private String parentesco;
     private double renda;
     private Integer escolaridade;
     private String ocupacao;*/

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Parente obj = parentes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return obj.getNomeClienteCadastrado();
            case 1:
                return obj.getNome();
            case 2:
                return obj.getRenda();
            case 3:
                return obj.getOcupacao();
            default:
                LOG.warning(AbstractTableModelParente.class.getName() + "Tentando acessar coluna a mais.");
                return null;
        }
    }

    public ArrayList<Parente> getDocumentos() {
        return parentes;
    }

    public void setDocumentos(ArrayList<Parente> documentos) {
        this.parentes = documentos;
    }

    public Parente getDocumento(Integer rowIndex) {
        return this.parentes.get(rowIndex);
    }

    public void addParente(Parente obj) {

        for (int i = 0; i < parentes.size(); i++) {
            Parente as = parentes.get(i);
            if (as.getNome().equals(obj.getNome()) && as.getOcupacao().equals(obj.getOcupacao())) {
                return;
            }
        }

        this.parentes.add(obj);
        fireTableDataChanged();
    }

    public void removerDocumento(Integer rowIndex) {
        this.parentes.remove(parentes.get(rowIndex));
        fireTableDataChanged();
    }

    public Double getRendaPerCapita() {
        double rendaTotal = 0;
        for (Parente parente : parentes) {
            rendaTotal += parente.getRenda();
        }
        Double rendaPerCapta = (Double) rendaTotal / parentes.size();
        return rendaPerCapta;
    }

    public Double getRendaTotal() {
        double rendaTotal = 0;
        for (Parente parente : parentes) {
            rendaTotal += parente.getRenda();
        }
        return rendaTotal;
    }

    private static final Logger LOG = Logger.getLogger(AbstractTableModelDocumentacao.class.getName());

}
