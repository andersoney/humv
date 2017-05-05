/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.projeto;

import br.edu.ufrb.lasis.humv.entity.Projeto;
import br.edu.ufrb.lasis.humv.view.setor.SetorTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luiz
 */
public class ProjetoTableModel extends AbstractTableModel {

    String[] titulos;
    List<Projeto> projetos;
    private static final Logger LOG = Logger.getLogger(SetorTableModel.class.getName());

    public ProjetoTableModel(List<Projeto> projetos) {
        initArrayTitulos();
        this.projetos = projetos;
    }

    public ProjetoTableModel() {
        initArrayTitulos();
        projetos = new ArrayList<Projeto>();
    }

    private void initArrayTitulos() {
        titulos = new String[2];
        titulos[0] = "Nome do projeto";
        titulos[1] = "Código do orientador";
    }

    public Projeto getProjetoSelecionado(int index) {
        if (index >= 0 && index < projetos.size()) {
            return projetos.get(index);
        } else {
            return null;
        }

    }

    public void addProjeto(Projeto projeto) {
        this.projetos.add(projeto);
        this.fireTableDataChanged();
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public String getColumnName(int column) {
        if (column > 0 || column < titulos.length) {
            return this.titulos[column];
        } else {
            return null;
        }
    }

    public int getRowCount() {
        return projetos.size();
    }

    public int getColumnCount() {
        return titulos.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.projetos.get(rowIndex).getNome();
            case 1:
                return this.projetos.get(rowIndex).getResponsavel().getNome();

        }
        return null;
    }

}
