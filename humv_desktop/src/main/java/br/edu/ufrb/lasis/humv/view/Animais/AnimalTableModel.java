/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.Animais;

import br.edu.ufrb.lasis.humv.entity.AnimalGrande;
import br.edu.ufrb.lasis.humv.entity.AnimalPequeno;
import br.edu.ufrb.lasis.humv.entity.Usuario;
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
    List<AnimalGrande> animais;
    private static final Logger LOG = Logger.getLogger(AnimalTableModel.class.getName());

    /**
     *
     * @param animais
     */
    public AnimalTableModel(List<AnimalGrande> animais) {
        this.animais = animais;
        titulos = new String[3];
        titulos[0] = "Nome";
        titulos[1] = "CPF";
        titulos[2] = "RGHumv";

    }


    /**
     *
     * @param animais1
     */
    public void AdicionarAnimais(List<AnimalGrande> animais1) {
        this.animais.addAll(animais1);
    }

    public AnimalTableModel() {
        titulos = new String[3];
        titulos[0] = "Nome";
        titulos[1] = "CPF";
        titulos[2] = "RGHumv";
        animais = new ArrayList<AnimalGrande>();
    }

    public AnimalGrande getUsuarioSelecionado(int index) {
        if (index >= 0 && index < animais.size()) {
            return animais.get(index);
        } else {
            return null;
        }

    }

    public void addAnimal(AnimalGrande animalGrande) {
        this.animais.add(animalGrande);
        this.fireTableDataChanged();
    }

    public List<AnimalGrande> getAnimais() {
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
