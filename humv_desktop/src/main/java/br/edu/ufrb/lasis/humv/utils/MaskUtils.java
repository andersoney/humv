package br.edu.ufrb.lasis.humv.utils;

import java.math.BigInteger;
import java.text.NumberFormat;
import javax.swing.JFormattedTextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.edu.ufrb.lasis.humv.HUMVApp;

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

    private final static Logger log = LoggerFactory.getLogger(MaskUtils.class);

    public static JFormattedTextField mascaraTelefone() {
        try {
            javax.swing.text.MaskFormatter telefone = new javax.swing.text.MaskFormatter("(##)#####-####");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(telefone);
            return jFormattedTextField;
        } catch (Exception ex) {

            String mensagem = "Falha na conversão da mascara de telefone";
            log.debug("[" + HUMVApp.getNomeUsuario() + "] " + "mensagem: " + mensagem);
        }
        return null;
    }

    public static JFormattedTextField mascaraCep() {
        try {
            javax.swing.text.MaskFormatter cep = new javax.swing.text.MaskFormatter("#####-###");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(cep);
            return jFormattedTextField;
        } catch (Exception ex) {
            String mensagem = "Falha na conversão da mescara de cep";
            log.debug("[" + HUMVApp.getNomeUsuario() + "] " + "mensagem: " + mensagem);
        }
        return null;
    }

    public static JFormattedTextField mascaraCnpj() {
        try {
            javax.swing.text.MaskFormatter cnpj = new javax.swing.text.MaskFormatter("##.###.###/####-##");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(cnpj);
            return jFormattedTextField;
        } catch (Exception e) {
            String mensagem = "Falha na conversão da mascara de Cnpj";
            log.debug("[" + HUMVApp.getNomeUsuario() + "] " + "mensagem: " + mensagem);
        }
        return null;
    }

    public static JFormattedTextField mascaraCpf() {
        try {
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(cpf);
            return jFormattedTextField;
        } catch (Exception e) {
            String mensagem = "Falha na conversão da mascara de CPF";
            log.debug("[" + HUMVApp.getNomeUsuario() + "] " + "mensagem: " + mensagem);
        }
        return null;
    }

    public static JFormattedTextField mascaraIdade() {
        try {
            javax.swing.text.MaskFormatter idade = new javax.swing.text.MaskFormatter("##");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(idade);
            return jFormattedTextField;
        } catch (Exception e) {
            String mensagem = "Falha na conversão da mascara de Idade.";
            log.debug("[" + HUMVApp.getNomeUsuario() + "] " + "mensagem: " + mensagem);
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
