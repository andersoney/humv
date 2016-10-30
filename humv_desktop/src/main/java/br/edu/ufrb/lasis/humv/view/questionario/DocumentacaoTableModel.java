/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.questionario;

import br.edu.ufrb.lasis.humv.entity.DocumentoComprovante;
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

    List<DocumentoComprovante> documentos;

    private String[] colunas = new String[]{
        "Data de entrega", "Identificador do recebinte", "Nome do documento"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public DocumentacaoTableModel() {
        this.documentos = new ArrayList<DocumentoComprovante>();
    }

    public DocumentacaoTableModel(ArrayList<DocumentoComprovante> documentos) {
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
        DocumentoComprovante obj = documentos.get(rowIndex);
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

    public List<DocumentoComprovante> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<DocumentoComprovante> documentos) {
        this.documentos = documentos;
        fireTableDataChanged();
    }

    public DocumentoComprovante getDocumento(Integer rowIndex) {
        return this.documentos.get(rowIndex);
    }

    public void addDocumento(DocumentoComprovante obj) {
        if (obj.getNomeDocumento().equals(DocumentoComprovante.RG_DONO)) {
            for (int i = 0; i < documentos.size(); i++) {
                DocumentoComprovante as = documentos.get(i);
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
