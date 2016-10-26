/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.questionario;

import br.edu.ufrb.lasis.humv.entity.Parente;
import br.edu.ufrb.lasis.humv.utils.ValidationsUtils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Orion
 */
public class ParenteTableModel extends AbstractTableModel {

    List<Parente> parentes;

    private String[] colunas = new String[]{
        "Nome do parente", "Renda", "Ocupação"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public ParenteTableModel() {
        this.parentes = new ArrayList<Parente>();
    }

    public ParenteTableModel(ArrayList<Parente> documentos) {
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
                return obj.getNome();
            case 1:
                return "R$ " + ValidationsUtils.convertePrecoParaString(obj.getRenda());
            case 2:
                return obj.getOcupacao();
            default:
                return "";
        }
    }

    public List<Parente> getParentes() {
        return parentes;
    }

    public void setParentes(List<Parente> documentos) {
        this.parentes = documentos;
    }

    public Parente getParente(Integer rowIndex) {
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

    public void removerParentes(Integer rowIndex) {
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

}
