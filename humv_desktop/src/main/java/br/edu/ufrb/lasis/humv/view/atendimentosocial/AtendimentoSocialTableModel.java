package br.edu.ufrb.lasis.humv.view.atendimentosocial;

import br.edu.ufrb.lasis.humv.entity.AtendimentoSocial;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luiz Toni
 */
public class AtendimentoSocialTableModel extends AbstractTableModel {

    String[] titulos;
    List<AtendimentoSocial> atendimentosSociais;

    public AtendimentoSocialTableModel(List<AtendimentoSocial> atendimentosSociais) {
        initArrayTitulos();
        this.atendimentosSociais = atendimentosSociais;
    }

    public AtendimentoSocialTableModel() {
        initArrayTitulos();
        atendimentosSociais = new ArrayList<AtendimentoSocial>();
    }

    private void initArrayTitulos() {
        titulos = new String[4];
        titulos[0] = "Dono";
        titulos[1] = "CPF/CNPJ";
        titulos[2] = "Animal";
        titulos[3] = "RGHUMV";
    }

    public AtendimentoSocial getAtendimentoSocialSelecionado(int index) {
        if (index >= 0 && index < atendimentosSociais.size()) {
            return atendimentosSociais.get(index);
        } else {
            return null;
        }

    }

    public void addAtendimentoSocial(AtendimentoSocial atendimentoSocial) {
        this.atendimentosSociais.add(atendimentoSocial);
        this.fireTableDataChanged();
    }

    public List<AtendimentoSocial> getAtendimentosSociais() {
        return atendimentosSociais;
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
        return atendimentosSociais.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.atendimentosSociais.get(rowIndex).getAnimal().getDono().getNome();
            case 1:
                if (this.atendimentosSociais.get(rowIndex).getAnimal().getDono().getTipoDocumento().equalsIgnoreCase("CPF")) {
                    return MaskUtils.formatarStringCPF(this.atendimentosSociais.get(rowIndex).getAnimal().getDono().getCpfCnpj());
                } else {
                    return MaskUtils.formatarStringCNPJ(this.atendimentosSociais.get(rowIndex).getAnimal().getDono().getCpfCnpj());
                }

            case 2:
                return this.atendimentosSociais.get(rowIndex).getAnimal().getNome();
            case 3:
                return this.atendimentosSociais.get(rowIndex).getAnimal().getRghumv();

        }
        return null;
    }
}
