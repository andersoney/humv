package br.edu.ufrb.lasis.humv.view.procedimento;

import br.edu.ufrb.lasis.humv.entity.Procedimento;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andersoney
 */
public class ProcedimentoTableModel extends AbstractTableModel {

    String[] titulos;
    List<Procedimento> procedimentos;
    private static final Logger LOG = Logger.getLogger(ProcedimentoTableModel.class.getName());

    public ProcedimentoTableModel(List<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
        titulos = new String[4];
        titulos[0] = "Codigo";
        titulos[1] = "Nome";
        titulos[2] = "Setor";
        titulos[3] = "Valor R$";
    }


    public void AdicionarProcedimentos(List<Procedimento> procedimentos) {
        this.procedimentos.addAll(procedimentos);
    }

    public ProcedimentoTableModel() {
        titulos = new String[4];
        titulos[0] = "Codigo";
        titulos[1] = "Nome";
        titulos[2] = "Setor";
        titulos[3] = "Valor R$";
        procedimentos = new ArrayList<Procedimento>();
    }

    public Procedimento getProcedimentoSelecionado(int index) {
        if (index >= 0 && index < procedimentos.size()) {
            return procedimentos.get(index);
        } else {
            return null;
        }

    }

    public void addProcedimento(Procedimento procedimento) {
        this.procedimentos.add(procedimento);
        this.fireTableDataChanged();
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
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
        return procedimentos.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.procedimentos.get(rowIndex).getCodigo();
            case 1:
                return this.procedimentos.get(rowIndex).getNome();
            case 2:
                return this.procedimentos.get(rowIndex).getCodSetor();
            case 3:
                return this.procedimentos.get(rowIndex).getValor();
        }
        return null;
    }
}
