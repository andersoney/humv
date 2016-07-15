package br.edu.ufrb.lasis.humv.view.procedimento;

import br.edu.ufrb.lasis.humv.entity.Procedimento;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andersoney
 */
public class ProcedimentoTableModel extends AbstractTableModel {

    String[] titulos;
    List<Procedimento> procedimentos;

    public ProcedimentoTableModel(List<Procedimento> procedimentos) {
        initArrayTitulos();
        this.procedimentos = procedimentos;
    }

    public ProcedimentoTableModel() {
        initArrayTitulos();
        procedimentos = new ArrayList<Procedimento>();
    }
    
    private void initArrayTitulos(){
        titulos = new String[4];
        titulos[0] = "Código";
        titulos[1] = "Nome";
        titulos[2] = "Setor";
        titulos[3] = "Valor R$";
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
        Procedimento procedimento = this.procedimentos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return procedimento.getCodigo();
            case 1:
                return procedimento.getNome();
            case 2:
                return procedimento.getSetor().getCodigo() + " - " + procedimento.getSetor().getNome();
            case 3:
                return new DecimalFormat("#.00").format(procedimento.getValor());
        }
        return null;
    }
}
