/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.questionario;

import br.edu.ufrb.lasis.humv.entity.Documentacao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Orion
 */
public class DocumentacaoTableModel extends AbstractTableModel {

    List<Documentacao> documentos;

    private String[] colunas = new String[]{
        "Data de entrega", "Identificador do recebinte", "Nome do documento"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public DocumentacaoTableModel() {
        this.documentos = new ArrayList<Documentacao>();
    }

    public DocumentacaoTableModel(ArrayList<Documentacao> documentos) {
        this.documentos = documentos;
    }

    @Override
    public int getRowCount() {
        return this.documentos.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Documentacao obj = documentos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                Date dataHoje = new Date();
                SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
                String data = formataData.format(dataHoje);
                return data;
            case 1:
                return obj.getNomeUsuarioRecebinte();
            case 2:
                return obj.getNomeDocumento();
            default:
                return "";
        }
    }

    public List<Documentacao> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documentacao> documentos) {
        this.documentos = documentos;
        fireTableDataChanged();
    }

    public Documentacao getDocumento(Integer rowIndex) {
        return this.documentos.get(rowIndex);
    }

    public void addDocumento(Documentacao obj) {
        if (obj.getNomeDocumento().equals(Documentacao.RG_DONO)) {
            for (int i = 0; i < documentos.size(); i++) {
                Documentacao as = documentos.get(i);
                if (as.getNomeDocumento().equals(obj.getNomeDocumento())) {
                    return;
                }
            }
        }
        this.documentos.add(obj);
        fireTableDataChanged();
    }

    public void removerDocumento(Integer rowIndex) {
        System.out.println("" + documentos.size());
        this.documentos.remove(documentos.get(rowIndex));
        fireTableDataChanged();
    }

}
