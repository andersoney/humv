/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.animal;

import br.edu.ufrb.lasis.humv.entity.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andersoney
 */
public class AnimalTableModel extends AbstractTableModel {

    String[] titulos;
    List<Animal> animais;
    private static final Logger LOG = Logger.getLogger(AnimalTableModel.class.getName());

    /**
     *
     * @param animais
     */
    public AnimalTableModel(List<Animal> animais) {
        this.animais = animais;
        titulos = new String[3];
        titulos[0] = "Nome do animal";
        titulos[1] = "CPF do dono";
        titulos[2] = "RGHUMV";
    }


    /**
     *
     * @param animais
     */
    public void AdicionarAnimais(List<Animal> animais) {
        this.animais.addAll(animais);
    }

    public AnimalTableModel() {
        titulos = new String[3];
        titulos[0] = "Nome do animal";
        titulos[1] = "CPF do dono";
        titulos[2] = "RGHUMV";
        animais = new ArrayList<Animal>();
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
                return this.animais.get(rowIndex).getCpfDono();
            case 2:
                return this.animais.get(rowIndex).getRghumv();
        }
        return null;
    }
}
