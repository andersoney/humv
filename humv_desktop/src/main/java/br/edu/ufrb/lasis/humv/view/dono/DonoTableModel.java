package br.edu.ufrb.lasis.humv.view.dono;

import br.edu.ufrb.lasis.humv.entity.Dono;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luiz
 */
public class DonoTableModel extends AbstractTableModel {

    String[] titulos;
    List<Dono> donos;

    
    public DonoTableModel(List<Dono> donos) {
        this.donos = donos;
        titulos = new String[2];
        titulos[0] = "Nome";
        titulos[1] = "CPF/CNPJ";
    }


    public void AdicionarDonos(List<Dono> donos) {
        this.donos.addAll(donos);
    }

    public DonoTableModel() {
        titulos = new String[2];
        titulos[0] = "Nome";
        titulos[1] = "CPF/CNPJ";
        donos = new ArrayList<Dono>();
    }

    public Dono getDonoSelecionado(int index) {
        if (index >= 0 && index < donos.size()) {
            return donos.get(index);
        } else {
            return null;
        }

    }

    public void addDono(Dono dono) {
        this.donos.add(dono);
        this.fireTableDataChanged();
    }

    public List<Dono> getDonos() {
        return donos;
    }

    public String getColumnName(int column) {
        if (column > 0 || column < titulos.length) {
            return this.titulos[column];
        } else {
            return null;
        }
    }

    public int getRowCount() {
        return donos.size();
    }

    public int getColumnCount() {
        return titulos.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.donos.get(rowIndex).getNome();
            case 1:
                String idStr;
                if(donos.get(rowIndex).getTipoId().equalsIgnoreCase("cpf")){
                    idStr = MaskUtils.formatarStringCPF(this.donos.get(rowIndex).getId());
                }else{
                    idStr = MaskUtils.formatarStringCNPJ(this.donos.get(rowIndex).getId());
                }     
                return idStr;
        }
        return null;
    }    
}
