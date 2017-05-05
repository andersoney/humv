/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.usuario;

import br.edu.ufrb.lasis.humv.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tassi
 */
public class UsuarioTableModel extends AbstractTableModel {
    
    String[] titulos;
    private List<Usuario> lista;

    public UsuarioTableModel() {
        initArrayTitulos();
        this.lista = new ArrayList<Usuario>();
    }
    
    public UsuarioTableModel(List<Usuario> lista) {
        initArrayTitulos();
        this.lista = lista;
    }

    private void initArrayTitulos() {
        titulos = new String[4];
        titulos[0] = "Nome";
        titulos[1] = "E-mail";
        titulos[2] = "SIAPE";
        titulos[2] = "Perfil";
    }

    public Usuario getUsuarioSelecionado(int index) {
        if (index >= 0 && index < lista.size()) {
            return lista.get(index);
        } else {
            return null;
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        //Colunas: nome, e-mail, SIAPE e perfil
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Usuario u = lista.get(rowIndex);
        
        String perfil;
        switch(u.getPerfil()){
            case 0:
                perfil = "Administrador";
                break;
            case 1:
                perfil = "Recepcionista";
                break;
            case 2:
                perfil = "Médico";
                break;
            case 3:
                perfil = "Farmacêutico";
                break;
            default:
                perfil = "Assistente Social";
        }
        
        Object[] valores = new Object[]{u.getNome(), u.getEmail(), u.getSiape(), perfil};
        return valores[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        if (column > 0 || column < titulos.length) {
            return this.titulos[column];
        } else {
            return null;
        }
    }

}
