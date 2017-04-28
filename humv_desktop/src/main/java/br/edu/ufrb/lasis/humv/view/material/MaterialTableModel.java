/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.material;


import br.edu.ufrb.lasis.humv.entity.Material;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luiz
 */
public class MaterialTableModel extends AbstractTableModel {

    String[] titulos;
    List<Material> materiais;

    public MaterialTableModel(List<Material> materiais) {
        initArrayTitulos();
        this.materiais = materiais;
    }

    public MaterialTableModel() {
        initArrayTitulos();
        materiais = new ArrayList<Material>();
    }

    private void initArrayTitulos() {
        titulos = new String[2];
        titulos[0] = "Discriminação do Material";
        titulos[1] = "Código do Material";
    }

    public Material getMaterialSelecionado(int index) {
        if (index >= 0 && index < materiais.size()) {
            return materiais.get(index);
        } else {
            return null;
        }

    }

    public void addMaterial(Material material) {
        this.materiais.add(material);
        this.fireTableDataChanged();
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public String getColumnName(int column) {
        if (column > 0 || column < titulos.length) {
            return this.titulos[column];
        } else {
            return null;
        }
    }

    public int getRowCount() {
        return materiais.size();
    }

    public int getColumnCount() {
        return titulos.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.materiais.get(rowIndex).getDiscriminacao();
            case 1:
                return this.materiais.get(rowIndex).getId();

        }
        return null;
    }
}
