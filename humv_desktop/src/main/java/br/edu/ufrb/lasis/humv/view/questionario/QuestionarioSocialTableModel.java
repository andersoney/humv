/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.questionario;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import br.edu.ufrb.lasis.humv.entity.QuestionarioSocioeconomico;
import java.util.logging.Logger;

/**
 *
 * @author Orion
 */
public class QuestionarioSocialTableModel extends AbstractTableModel {

    String[] coluna = new String[]{"Nome do Dono", "CPF"};
    ArrayList<QuestionarioSocioeconomico> questionarios;
    private static final Logger LOG = Logger.getLogger(QuestionarioSocialTableModel.class.getName());

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
                return obj.getDono().getCep();
            default:
                LOG.warning("Valor da coluna Invalido.\n"
                        + "Provavelmente há colunas alem das necessarias para Exibição\n"
                        + "");
                return "Valor da coluna Invalido.\n"
                        + "Provavelmente há colunas alem das necessarias para Exibição\n"
                        + "";
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

    public ArrayList<QuestionarioSocioeconomico> getQuestionarios() {
        return questionarios;
    }

    public void setQuestionarios(ArrayList<QuestionarioSocioeconomico> questionarios) {
        this.questionarios = questionarios;
    }

}
