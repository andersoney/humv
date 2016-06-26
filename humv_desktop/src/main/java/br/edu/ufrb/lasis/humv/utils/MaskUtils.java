/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ufrb.lasis.humv.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author Luiz
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
}

