/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.questionario;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import br.edu.ufrb.lasis.humv.entity.QuestionarioSocioeconomico;
import br.edu.ufrb.lasis.humv.utils.MaskUtils;
import br.edu.ufrb.lasis.humv.utils.ValidationsUtils;
import java.util.List;

/**
 *
 * @author Orion
 */
public class QuestionarioSocialTableModel extends AbstractTableModel {

    String[] coluna = new String[]{"Nome do Dono", "CPF", "Última modificação"};
    List<QuestionarioSocioeconomico> questionarios;

    public QuestionarioSocialTableModel() {
        this.questionarios = new ArrayList<QuestionarioSocioeconomico>();
    }

    @Override
    public int getRowCount() {
        return questionarios.size();
    }

    @Override
    public String getColumnName(int column) {
        return coluna[column];
    }

    @Override
    public int getColumnCount() {
        return coluna.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        QuestionarioSocioeconomico obj = questionarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return obj.getDono().getNome();
            case 1:
                return MaskUtils.formatarCPF_CNPJ(obj.getDono().getCpfCnpj(), obj.getDono().getTipoDocumento());
            case 2:
                return ValidationsUtils.obterDataString(obj.getDataResposta());
            default:
                return "";
        }
    }

    public QuestionarioSocioeconomico getQuestionario(Integer index) {
        return questionarios.get(index);
    }

    public void remove(Integer index) {
        QuestionarioSocioeconomico quest = questionarios.get(index);
        questionarios.remove(quest);
        fireTableDataChanged();
    }

    public void add(QuestionarioSocioeconomico addQuest) {
        questionarios.add(addQuest);
        fireTableDataChanged();
    }

    public List<QuestionarioSocioeconomico> getQuestionarios() {
        return questionarios;
    }

    public void setQuestionarios(List<QuestionarioSocioeconomico> questionarios) {
        this.questionarios = questionarios;
    }

}
