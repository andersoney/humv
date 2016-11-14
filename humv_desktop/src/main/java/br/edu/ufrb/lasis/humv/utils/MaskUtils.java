package br.edu.ufrb.lasis.humv.utils;

import java.math.BigInteger;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;

/**
 * Utilitário: Máscaras de campo.
 *
 * @author Luiz Antônio Pereira
 *
 * @version 1
 *
 * @since 26 de junho de 2016
 *
 */
public class MaskUtils {

    public static JFormattedTextField mascaraTelefone() {
        try {
            javax.swing.text.MaskFormatter telefone = new javax.swing.text.MaskFormatter("(##)#####-####");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(telefone);
            return jFormattedTextField;
        } catch (Exception e) {
        }
        return null;
    }

    public static JFormattedTextField mascaraCep() {
        try {
            javax.swing.text.MaskFormatter cep = new javax.swing.text.MaskFormatter("#####-###");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(cep);
            return jFormattedTextField;
        } catch (Exception e) {
        }
        return null;
    }

    public static JFormattedTextField mascaraCnpj() {
        try {
            javax.swing.text.MaskFormatter cnpj = new javax.swing.text.MaskFormatter("##.###.###/####-##");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(cnpj);
            return jFormattedTextField;
        } catch (Exception e) {
        }
        return null;
    }

    public static JFormattedTextField mascaraCpf() {
        try {
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(cpf);
            return jFormattedTextField;
        } catch (Exception e) {
        }
        return null;
    }

    public static JFormattedTextField mascaraIdade() {
        try {
            javax.swing.text.MaskFormatter idade = new javax.swing.text.MaskFormatter("##");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(idade);
            return jFormattedTextField;
        } catch (Exception e) {
        }
        return null;
    }

    public static String removeMascara(String string) {
        return string.replaceAll("\\D", "");
    }

    public static String formatarCPF_CNPJ(String id, String tipoId) {
        if (tipoId.equalsIgnoreCase("CPF")) {
            return formatarStringCPF(id);
        } else {
            return formatarStringCPF(id);
        }
    }

    public static String formatarStringCPF(String cpf) {
        BigInteger idInt = new BigInteger(cpf);
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMinimumIntegerDigits(11);
        numberFormat.setMaximumIntegerDigits(11);
        numberFormat.setGroupingUsed(false);
        return numberFormat.format(idInt);
    }

    public static String formatarStringCNPJ(String cnpj) {
        BigInteger idInt = new BigInteger(cnpj);
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMinimumIntegerDigits(14);
        numberFormat.setMaximumIntegerDigits(14);
        numberFormat.setGroupingUsed(false);
        return numberFormat.format(idInt);
    }

}
