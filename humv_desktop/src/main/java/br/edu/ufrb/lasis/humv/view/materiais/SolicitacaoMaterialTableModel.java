package br.edu.ufrb.lasis.humv.view.materiais;

import br.edu.ufrb.lasis.humv.entity.SolicitacaoMaterial;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SolicitacaoMaterialTableModel extends AbstractTableModel {

    String[] titulos;
    List<SolicitacaoMaterial> solicitacoesMateriais;

    public SolicitacaoMaterialTableModel(List<SolicitacaoMaterial> solicitacoesMateriais) {
        initArrayTitulos();
        this.solicitacoesMateriais = solicitacoesMateriais;
    }

    public SolicitacaoMaterialTableModel() {
        initArrayTitulos();
        solicitacoesMateriais = new ArrayList<SolicitacaoMaterial>();
    }

    private void initArrayTitulos() {
        titulos = new String[4];
        titulos[0] = "Identificador";
        titulos[1] = "Setor solicitante";
        titulos[2] = "Discriminação do material";
        titulos[3] = "Status";
    }

    public SolicitacaoMaterial getSolicitcaoMaterialSelecionado(int index) {
        if (index >= 0 && index < solicitacoesMateriais.size()) {
            return solicitacoesMateriais.get(index);
        } else {
            return null;
        }

    }

    public void addSolicitacaoMaterial(SolicitacaoMaterial solicitcaoMaterial) {
        this.solicitacoesMateriais.add(solicitcaoMaterial);
        this.fireTableDataChanged();
    }

    public List<SolicitacaoMaterial> getSolicitcoesMateriais() {
        return solicitacoesMateriais;
    }

    public String getColumnName(int column) {
        if (column > 0 || column < titulos.length) {
            return this.titulos[column];
        } else {
            return null;
        }
    }

    public int getRowCount() {
        return solicitacoesMateriais.size();
    }

    public int getColumnCount() {
        return titulos.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.solicitacoesMateriais.get(rowIndex).getId();
            case 1:
                return this.solicitacoesMateriais.get(rowIndex).getNomeSetor();
            case 2:
                return this.solicitacoesMateriais.get(rowIndex).getMaterial().getDiscriminacao();
            case 3:
                return this.solicitacoesMateriais.get(rowIndex).getSituacaoStatus();
        }
        return null;
    }
}