/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.animal;

import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andersoney
 */
public class AnimalTableModel extends AbstractTableModel {

    String[] titulos;
    List<Animal> animais;

    /**
     *
     * @param animais
     */
    public AnimalTableModel(List<Animal> animais) {
        initArrayTitulos();
        this.animais = animais;
    }

    public AnimalTableModel() {
        initArrayTitulos();
        animais = new ArrayList<Animal>();
    }

    private void initArrayTitulos() {
        titulos = new String[5];
        titulos[0] = "Nome do animal";
        titulos[1] = "RGHUMV";
        titulos[2] = "Nome do dono";
        titulos[3] = "Tipo documento";
        titulos[4] = "Número documento";
    }

    public Animal getUsuarioSelecionado(int index) {
        if (index >= 0 && index < animais.size()) {
            return animais.get(index);
        } else {
            return null;
        }

    }

    public void addAnimal(Animal animalGrande) {
        this.animais.add(animalGrande);
        this.fireTableDataChanged();
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    @Override
    public String getColumnName(int column) {
        if (column > 0 || column < titulos.length) {
            return this.titulos[column];
        } else {
            return null;
        }
    }

    @Override
    public int getRowCount() {
        return animais.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.animais.get(rowIndex).getNome();
            case 1:
                return this.animais.get(rowIndex).getRghumv();
            case 2:
                return this.animais.get(rowIndex).getDono().getNome();
            case 3:
                return this.animais.get(rowIndex).getDono().getTipoDocumento();
            case 4:
                if (this.animais.get(rowIndex).getDono().getTipoDocumento().equalsIgnoreCase("CPF")) {
                    return MaskUtils.formatarStringCPF(this.animais.get(rowIndex).getDono().getCpfCnpj());
                } else {
                    return MaskUtils.formatarStringCNPJ(this.animais.get(rowIndex).getDono().getCpfCnpj());
                }
        }
        return null;
    }
}
