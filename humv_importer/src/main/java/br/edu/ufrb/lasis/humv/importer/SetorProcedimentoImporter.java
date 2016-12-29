/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.importer;

import br.edu.ufrb.lasis.humv.dao.ProcedimentoDAO;
import br.edu.ufrb.lasis.humv.dao.SetorDAO;
import br.edu.ufrb.lasis.humv.entity.Procedimento;
import br.edu.ufrb.lasis.humv.entity.Setor;
import br.edu.ufrb.lasis.humv.utils.HibernateUtils;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JTextArea;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author tassiovale
 */
public class SetorProcedimentoImporter extends GenericImporter {

    private SetorDAO setorDAO;
    private ProcedimentoDAO procedimentoDAO;

    public SetorProcedimentoImporter(String caminhoArquivo, JTextArea console) throws Exception {
        super(caminhoArquivo, console);
    }

    @Override
    public void importar() {
        Sheet tabela = getTabela();
        Iterator rowIterator = tabela.iterator();
        int contadorLinhas = 0;

        setorDAO = new SetorDAO();
        procedimentoDAO = new ProcedimentoDAO();

        rowIterator.next();

        //iterating over each row
        while (rowIterator.hasNext()) {

            Setor setor = new Setor();
            Procedimento procedimento = new Procedimento();

            Row row = (Row) rowIterator.next();

            /*
                ------------ SETOR ------------
             */
            HibernateUtils.beginTransaction();

            //Nome do setor
            Cell celulaNomeSetor = row.getCell(2);
            if (celulaNomeSetor != null && celulaNomeSetor.getCellTypeEnum() == CellType.STRING) {
                String nomeSetor = celulaNomeSetor.getStringCellValue();
                Setor resultSetor = setorDAO.searchByNome(nomeSetor);
                if (resultSetor != null) {
                    setor = resultSetor;
                } else {
                    setor.setNome(nomeSetor);
                    setorDAO.saveSetor(setor);
                }
            }

            HibernateUtils.commitTransaction();

            /*
                ------------ PROCEDIMENTO ------------
             */
            HibernateUtils.beginTransaction();

            procedimento.setSetor(setor);

            //Código
            Cell celulaCodigoProcedimento = row.getCell(0);
            if (celulaCodigoProcedimento != null && celulaCodigoProcedimento.getCellTypeEnum() == CellType.NUMERIC) {
                procedimento.setCodigo(new BigDecimal(celulaCodigoProcedimento.getNumericCellValue()).toBigInteger());
            } else {
                break;
            }

            //Nome do procedimento
            Cell celulaNomeProcedimento = row.getCell(1);
            if (celulaNomeProcedimento != null && celulaNomeProcedimento.getCellTypeEnum() == CellType.STRING) {
                String procedimentoNome = celulaNomeProcedimento.getStringCellValue();
                Procedimento resultProcedimento = procedimentoDAO.searchByNome(procedimentoNome);
                if (resultProcedimento != null) {
                    continue;
                } else {
                    procedimento.setNome(procedimentoNome);
                }
            } else {
                continue;
            }

            //Valor do procedimento
            Cell celulaValorProcedimento = row.getCell(3);
            if (celulaValorProcedimento != null && celulaValorProcedimento.getCellTypeEnum() == CellType.NUMERIC) {
                procedimento.setValor(celulaValorProcedimento.getNumericCellValue());
            } else {
                procedimento.setValor(0);
            }

            String setorNome = setor.getNome().toLowerCase();
            if (setorNome.contains("consulta")) {
                procedimento.setTipo(Procedimento.TIPO_CONSULTA);
            } else if (setorNome.contains("ambulat") || setorNome.contains("laborat") || setorNome.contains("diagn")) {
                procedimento.setTipo(Procedimento.TIPO_AMBULATORIO_EXAME);
            } else if (setorNome.contains("cirurgia") || setorNome.contains("reprodu") || setorNome.contains("anest")) {
                procedimento.setTipo(Procedimento.TIPO_CIRURGIA_REPRODUCAO);
            } else {
                procedimento.setTipo(Procedimento.TIPO_OUTROS);
            }

            procedimentoDAO.saveProcedimento(procedimento);

            HibernateUtils.commitTransaction();

            getConsole().append("\nSetor: " + setor.getNome() + " / Procedimento: " + procedimento.getNome() + ", valor: R$ " + procedimento.getValor());
            contadorLinhas++;

        }

        getConsole().append("\n" + contadorLinhas + " linhas adicionadas com sucesso!");

        fecharPlanilha();
    }

}
