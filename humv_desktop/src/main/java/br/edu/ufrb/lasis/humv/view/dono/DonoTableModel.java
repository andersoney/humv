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

    private String[] titulos;
    private List<Dono> donos;

    public DonoTableModel(List<Dono> donos) {
        initArrayTitulos();
        this.donos = donos;
    }

    public DonoTableModel() {
        initArrayTitulos();
        donos = new ArrayList<Dono>();
    }

    private void initArrayTitulos() {
        titulos = new String[3];
        titulos[0] = "Nome";
        titulos[1] = "Tipo do documento";
        titulos[2] = "Número do documento";
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
                return this.donos.get(rowIndex).getTipoDocumento();
            case 2:
                String id = donos.get(rowIndex).getCpfCnpj();
                String tipoId = donos.get(rowIndex).getTipoDocumento();
                return MaskUtils.formatarCPF_CNPJ(id, tipoId);
        }
        return null;
    }
}
