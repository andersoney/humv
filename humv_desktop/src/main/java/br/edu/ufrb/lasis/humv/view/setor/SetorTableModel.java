/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.setor;

import br.edu.ufrb.lasis.humv.entity.Setor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luiz
 */
public class SetorTableModel extends AbstractTableModel {

    String[] titulos;
    List<Setor> setores;

    public SetorTableModel(List<Setor> setores) {
        initArrayTitulos();
        this.setores = setores;
    }

    public SetorTableModel() {
        initArrayTitulos();
        setores = new ArrayList<Setor>();
    }

    private void initArrayTitulos() {
        titulos = new String[2];
        titulos[0] = "Nome do setor";
        titulos[1] = "Código do setor";
    }

    public Setor getSetorSelecionado(int index) {
        if (index >= 0 && index < setores.size()) {
            return setores.get(index);
        } else {
            return null;
        }

    }

    public void addSetor(Setor setor) {
        this.setores.add(setor);
        this.fireTableDataChanged();
    }

    public List<Setor> getSetores() {
        return setores;
    }

    public String getColumnName(int column) {
        if (column > 0 || column < titulos.length) {
            return this.titulos[column];
        } else {
            return null;
        }
    }

    public int getRowCount() {
        return setores.size();
    }

    public int getColumnCount() {
        return titulos.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.setores.get(rowIndex).getNome();
            case 1:
                return this.setores.get(rowIndex).getCodigo();

        }
        return null;
    }
}
