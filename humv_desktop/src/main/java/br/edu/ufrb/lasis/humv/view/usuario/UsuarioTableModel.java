/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.usuario;

import br.edu.ufrb.lasis.humv.entity.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author tassi
 */
public class UsuarioTableModel extends AbstractTableModel {

    private List<Usuario> lista;

    public UsuarioTableModel(List<Usuario> lista) {
        this.lista = lista;
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
        String[] nomesColunas = new String[]{"Nome", "E-mail", "SIAPE", "Perfil"};
        return nomesColunas[column];
    }

}
