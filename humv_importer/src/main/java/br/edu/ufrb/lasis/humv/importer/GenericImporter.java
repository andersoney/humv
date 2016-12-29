/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.importer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JTextArea;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author tassiovale
 */
public abstract class GenericImporter {

    private FileInputStream fileInputStream;
    private String caminhoArquivo;
    private JTextArea console;
    private Sheet tabela;

    public GenericImporter(String caminhoArquivo, JTextArea console) throws Exception {
        this.caminhoArquivo = caminhoArquivo;
        this.console = console;
        initImporter();
    }

    private void initImporter() throws Exception{
        fileInputStream = new FileInputStream(caminhoArquivo);

        Workbook planilha;
        if (caminhoArquivo.endsWith(".xls")) {
            planilha = new HSSFWorkbook(fileInputStream);
        } else {
            planilha = new XSSFWorkbook(fileInputStream);
        }

        int numeroDeAbas = planilha.getNumberOfSheets();
        if (numeroDeAbas == 1) {
            tabela = planilha.getSheetAt(0);
            console.append("\nNúmero de abas: 1");
        } else {
            throw new Exception("ERRO: planilha possui mais de uma aba.");
        }
    }

    public void fecharPlanilha() {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException ex) {
                console.append("\nERRO: " + getStackTraceAsString(ex));
            }
        }
    }

    public static String getStackTraceAsString(Throwable exception) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        return sw.toString();
    }

    public FileInputStream getFileInputStream() {
        return fileInputStream;
    }

    public void setFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    public abstract void importar();

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public JTextArea getConsole() {
        return console;
    }

    public void setConsole(JTextArea console) {
        this.console = console;
    }

    public Sheet getTabela() {
        return tabela;
    }

    public void setTabela(Sheet tabela) {
        this.tabela = tabela;
    }

}
