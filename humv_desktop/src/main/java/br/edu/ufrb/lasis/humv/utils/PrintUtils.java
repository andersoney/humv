/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.utils;

import br.edu.ufrb.lasis.humv.HUMVApp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author tassiovale
 */
public class PrintUtils {

    public static final String TABELA_ANIMAIS = "relatorios/tabela_animais.jasper";
    public static final String TABELA_DONOS = "relatorios/tabela_donos.jasper";
    public static final String TABELA_PROCEDIMENTOS = "relatorios/tabela_procedimentos.jasper";
    public static final String TABELA_PROJETOS = "relatorios/tabela_projetos.jasper";
    public static final String TABELA_SETORES = "relatorios/tabela_setores.jasper";
    public static final String TABELA_USUARIOS = "relatorios/tabela_usuarios.jasper";

    public static void print(String reportFileName, List lista) {
        if (lista != null && !lista.isEmpty()) {

            try {
                InputStream reportStream = new FileInputStream(reportFileName);
                Map parameters = new HashMap();
                parameters.put("INFO", "Relatório");
                parameters.put("TABELA", lista);
                JRDataSource dataSource = new JRBeanCollectionDataSource(lista, true);
                JasperPrint jasperPrint = JasperFillManager.fillReport(reportStream, parameters, dataSource);

                final JFileChooser fileChooser = new JFileChooser();
                Date horarioAtual = Calendar.getInstance().getTime();
                String strData = new SimpleDateFormat("dd-MM-yyyy").format(horarioAtual);
                String strHora = new SimpleDateFormat("HH").format(horarioAtual);
                String strMinuto = new SimpleDateFormat("mm").format(horarioAtual);
                fileChooser.setSelectedFile(new File("relatorio_" + strData + "_" + strHora + "h" + strMinuto + "m.pdf"));
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Documentos PDF", "pdf"));
                fileChooser.setAcceptAllFileFilterUsed(false);

                int returnVal = fileChooser.showSaveDialog(HUMVApp.getMainWindow());
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    String caminho = fileChooser.getSelectedFile().getAbsolutePath();
                    exportReportToPDF(jasperPrint, caminho);
                }
            } catch (JRException | FileNotFoundException exception) {
                MessageUtils.erroGeracaoRelatorio();
            }

        } else {
            MessageUtils.semResultadosGeracaoRelatorio();
        }
    }

    private static void exportReportToPDF(JasperPrint print, String pathToPDF) {
        try {
            JasperExportManager.exportReportToPdfFile(print, pathToPDF);
            MessageUtils.sucessoGeracaoRelatorio();
        } catch (JRException exception) {
            MessageUtils.erroGeracaoRelatorio();
        }
    }

}
