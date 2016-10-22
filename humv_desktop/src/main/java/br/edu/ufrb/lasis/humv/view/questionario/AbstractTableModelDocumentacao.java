/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.view.questionario;

import br.edu.ufrb.lasis.humv.entity.Documentacao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Orion
 */
public class AbstractTableModelDocumentacao extends AbstractTableModel {

    ArrayList<Documentacao> documentos;

    private String[] colunas = new String[]{
        "Data de Entrega", "Nome do Recebinte", "Nome do documento"};

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public AbstractTableModelDocumentacao() {
        this.documentos = new ArrayList<Documentacao>();
    }

    public AbstractTableModelDocumentacao(ArrayList<Documentacao> documentos) {
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
                return obj.getNomeRecebinte();
            case 2:
                return obj.getNomeDocumento();
            default:
                LOG.warning(AbstractTableModelDocumentacao.class.getName()+"Tentando acessar coluna a mais.");
                return null;
        }
    }

    public ArrayList<Documentacao> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(ArrayList<Documentacao> documentos) {
        this.documentos = documentos;
    }

    public Documentacao getDocumento(Integer rowIndex) {
        return this.documentos.get(rowIndex);
    }

    public void addDocumento(Documentacao obj) {
        if (obj.getNomeDocumento().equals(Documentacao.RGDONO)) {
            for (int i = 0; i < documentos.size(); i++) {
                Documentacao as=documentos.get(i);
                if(as.getNomeDocumento().equals(obj.getNomeDocumento())){
                    return;
                }
            }
        }
        this.documentos.add(obj);
        fireTableDataChanged();
    }

    public void removerDocumento(Integer rowIndex) {
        System.out.println(""+documentos.size());
        this.documentos.remove(documentos.get(rowIndex));
        fireTableDataChanged();
    }

    private static final Logger LOG = Logger.getLogger(AbstractTableModelDocumentacao.class.getName());

}
