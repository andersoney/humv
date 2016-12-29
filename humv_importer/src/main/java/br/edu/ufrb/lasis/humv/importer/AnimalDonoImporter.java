/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.importer;

import br.edu.ufrb.lasis.humv.dao.AnimalDAO;
import br.edu.ufrb.lasis.humv.dao.DonoDAO;
import br.edu.ufrb.lasis.humv.entity.Animal;
import br.edu.ufrb.lasis.humv.entity.Dono;
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
public class AnimalDonoImporter extends GenericImporter {

    private DonoDAO donoDAO;
    private AnimalDAO animalDAO;

    public AnimalDonoImporter(String caminhoArquivo, JTextArea console) throws Exception {
        super(caminhoArquivo, console);
    }

    @Override
    public void importar() {
        Sheet tabela = getTabela();
        Iterator rowIterator = tabela.iterator();
        int contadorLinhas = 0;

        donoDAO = new DonoDAO();
        animalDAO = new AnimalDAO();

        rowIterator.next();

        //iterating over each row
        while (rowIterator.hasNext()) {

            Dono dono = new Dono();
            Animal animal = new Animal();

            Row row = (Row) rowIterator.next();

            //RGHUMV do animal
            Cell celulaRGHUMV = row.getCell(1);
            if (celulaRGHUMV != null && celulaRGHUMV.getCellTypeEnum() == CellType.NUMERIC) {
                animal.setRghumv(new BigDecimal(celulaRGHUMV.getNumericCellValue()).toBigInteger());
            } else {
                break;
            }

            /*
                ------------ DONO ------------
             */

            HibernateUtils.beginTransaction();
            
            //Nome
            Cell celulaNomeDono = row.getCell(7);
            if (celulaNomeDono != null && celulaNomeDono.getCellTypeEnum() == CellType.STRING) {
                String nomeDono = celulaNomeDono.getStringCellValue();
                if (nomeDono.contains("Faz.") || nomeDono.contains("Canil")) {
                    dono.setEndereco(nomeDono);
                }
                dono.setNome(nomeDono);
            } else {
                dono.setNome("Não informado");
            }

            //Cidade
            Cell celulaCidade = row.getCell(8);
            if (celulaCidade != null && celulaCidade.getCellTypeEnum() == CellType.STRING) {
                dono.setCidade(celulaCidade.getStringCellValue());
            } else {
                dono.setCidade("Cruz das Almas");
            }
            dono.setEstado("Bahia");

            //CPF-CNPJ
            Cell celulaCPF = row.getCell(9);
            if (celulaCPF != null && celulaCPF.getCellTypeEnum() == CellType.STRING) {
                String cpfCnpj = celulaCPF.getStringCellValue();
                if (!cpfCnpj.contains("siape") && !cpfCnpj.contains("rg")) {
                    if (cpfCnpj.contains("/")) {
                        dono.setTipoDocumento("CNPJ");
                        cpfCnpj = cpfCnpj.replaceAll("/", "");
                    } else {
                        dono.setTipoDocumento("CPF");
                        cpfCnpj = cpfCnpj.replaceAll("\\.", "");
                    }
                    cpfCnpj = cpfCnpj.replaceAll("-", "");
                    dono.setCpfCnpj(cpfCnpj);
                } else {
                    dono.setTipoDocumento("Não informado");
                    dono.setCpfCnpj("Não informado");
                }
            } else {
                dono.setTipoDocumento("Não informado");
                dono.setCpfCnpj("Não informado");
            }

            //Telefone
            Cell celulaTelefone = row.getCell(10);
            if (celulaTelefone != null && celulaTelefone.getCellTypeEnum() == CellType.STRING) {
                dono.setTelefone(celulaTelefone.getStringCellValue());
            } else {
                dono.setTelefone("Não informado");
            }

            dono.setEmail("Não informado");
            dono.setCep("44380000");

            
            Dono resultDonoNome = donoDAO.searchNome(dono.getNome());
            Dono resultDonoCpfCnpj = donoDAO.searchCpfCnpj(dono.getCpfCnpj());
            if(resultDonoNome != null){
                dono = resultDonoNome;
            } else if(resultDonoCpfCnpj != null){
                dono = resultDonoCpfCnpj;
            } else {
                donoDAO.saveOwner(dono);
            }

            HibernateUtils.commitTransaction();

            /*
                ------------ ANIMAL ------------
             */
            
            HibernateUtils.beginTransaction();

            animal.setDono(dono);

            //Data de cadastro
            Cell celulaDataCadastro = row.getCell(0);
            try {
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
                if (celulaDataCadastro != null && celulaDataCadastro.getCellTypeEnum() == CellType.NUMERIC) {
                    //System.out.println(celulaDataCadastro.getDateCellValue());
                    animal.setDataCadastro(celulaDataCadastro.getDateCellValue());
                } else {
                    animal.setDataCadastro(df.parse("28/11/13"));
                }
            } catch (ParseException ex) {
                animal.setDataCadastro(new Date());
            }

            //Espécie
            Cell celulaEspecie = row.getCell(2);
            if (celulaEspecie != null && celulaEspecie.getCellTypeEnum() == CellType.STRING) {
                animal.setEspecie(celulaEspecie.getStringCellValue());
            } else {
                animal.setEspecie("Não informada");
            }

            //Raça
            Cell celulaRaca = row.getCell(3);
            if (celulaRaca != null && celulaRaca.getCellTypeEnum() == CellType.STRING) {
                animal.setRaca(celulaRaca.getStringCellValue());
            } else {
                animal.setRaca("Não informada");
            }

            //Nome
            Cell celulaNomeAnimal = row.getCell(4);
            if (celulaNomeAnimal != null && celulaNomeAnimal.getCellTypeEnum() == CellType.STRING) {
                String nomeAnimal = celulaNomeAnimal.getStringCellValue();
                if (nomeAnimal.equalsIgnoreCase("S/Nº")) {
                    animal.setNome("Não informado");
                } else {
                    animal.setNome(nomeAnimal);
                }
            } else {
                animal.setNome("Não informado");
            }

            //Porte
            Cell celulaPorte = row.getCell(5);
            if (celulaPorte != null && celulaPorte.getCellTypeEnum() == CellType.STRING) {
                String porte = celulaPorte.getStringCellValue();
                if (porte.equalsIgnoreCase("G")) {
                    porte = "Grande";
                } else {
                    porte = "Pequeno";
                }
                animal.setPorte(porte);
            } else {
                animal.setPorte("Não informado");
            }

            //Sexo
            Cell celulaSexo = row.getCell(6);
            if (celulaSexo != null && celulaSexo.getCellTypeEnum() == CellType.STRING) {
                String sexo = celulaSexo.getStringCellValue();
                animal.setSexo(sexo.toUpperCase().charAt(0));
            } else {
                animal.setSexo('I');
            }

            animal.setIdade(0);
            animal.setPeso(0);
            animal.setPelagem("Não informada");

            animalDAO.saveAnimal(animal);

            HibernateUtils.commitTransaction();

            getConsole().append("\nRGHUMV: " + animal.getRghumv() + " / Dono: " + dono.getNome() + ", nome do animal: " + animal.getNome());
            contadorLinhas++;
        }

        getConsole().append("\n" + contadorLinhas + " linhas adicionadas com sucesso!");

        fecharPlanilha();
    }

}
