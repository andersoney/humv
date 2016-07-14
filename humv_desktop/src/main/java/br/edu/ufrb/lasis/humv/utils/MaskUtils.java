package br.edu.ufrb.lasis.humv.utils;

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
    public static JFormattedTextField mascaraTelefone(){
        try{
            javax.swing.text.MaskFormatter telefone = new javax.swing.text.MaskFormatter("(##)#####-####");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(telefone);
            return jFormattedTextField;
        }catch(Exception e){}
        return null;
    }
    public static JFormattedTextField mascaraCep(){
        try{
            javax.swing.text.MaskFormatter cep = new javax.swing.text.MaskFormatter("#####-###");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(cep);
            return jFormattedTextField;
        }catch(Exception e){}
        return null;
    }
    public static JFormattedTextField mascaraCnpj(){
        try{                                                                            
            javax.swing.text.MaskFormatter cnpj = new javax.swing.text.MaskFormatter("##.###.###/####-##");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(cnpj);
            return jFormattedTextField;
        }catch(Exception e){}
        return null;
    }
    public static JFormattedTextField mascaraCpf(){
        try{                                                                            
            javax.swing.text.MaskFormatter cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(cpf);
            return jFormattedTextField;
        }catch(Exception e){}
        return null;
    }
    public static JFormattedTextField mascaraIdade(){
        try{                                                                            
            javax.swing.text.MaskFormatter idade = new javax.swing.text.MaskFormatter("##");
            JFormattedTextField jFormattedTextField = new JFormattedTextField(idade);
            return jFormattedTextField;
        }catch(Exception e){}
        return null;
    }
    public static String removeMascara(String string){
       return string.replaceAll("\\D", "");
    }
    
    public static NumberFormat formatarCPF(){
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumIntegerDigits(11);
        numberFormat.setGroupingUsed(false);
        return numberFormat;
    }
    
    public static NumberFormat formatarCNPJ(){
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumIntegerDigits(14);
        numberFormat.setGroupingUsed(false);
        return numberFormat;
    }
}
