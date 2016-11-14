package br.edu.ufrb.lasis.humv.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.JTextField;

/**
 * Utilitário: KeyListner para preço.
 *
 * @author Luiz Antônio Pereira
 *
 * @version 1
 *
 * @since 26 de junho de 2016
 *
 */
public class PrecoMask implements KeyListener {

    JTextField jTextField;
    DecimalFormat decimalFormat;
    int inteiro, decimal;

    public PrecoMask(JTextField jTextField, int tam, int dec) {
        this.jTextField = jTextField;
        inteiro = tam - dec;
        decimal = dec;
        String mascara = "";
        if ((tam - dec) > 0) {
            for (int a = 0; a < dec; a++) {
                mascara += "0";
            }
            if (mascara.length() > 0) {
                mascara = "." + mascara;
            }
            for (int a = 0; a < tam - dec; a++) {
                mascara = "#" + mascara;
                if (((a + 1) % 3) == 0 && (a + 1) < (tam - dec)) {
                    mascara = "," + mascara;
                }
            }
        }
        decimalFormat = new DecimalFormat(mascara);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        String textNum = jTextField.getText().replace(".", "").replace(",", "");
        if (!Character.isDigit(c) || textNum.length() >= (inteiro + decimal)) {
            e.consume();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        String textoAntes = jTextField.getText();
        if (textoAntes.replace(".", "").replace(",", "").length() <= decimal) {
            if (inteiro >= decimal) {
                jTextField.setText(textoAntes.replace(".", "").replace(",", ""));
            } else {
            }
        } else if (textoAntes.replace(".", "").replace(",", "").length() > decimal) {
            Double num = 0.0;
            String textNum = textoAntes.replace(".", "").replace(",", "");
            if (decimal > 0) {
                textNum = textNum.substring(0, textNum.length() - decimal) + "." + textNum.substring(textNum.length() - decimal, textNum.length());
            } else {
                textNum = textNum + ".0";
            }
            try {
                num = Double.parseDouble(textNum);
            } catch (Exception exp) {
            }
            String fim = decimalFormat.format(num);
            if (fim.substring(0, 1).equals(",")) {
                fim = "0" + fim;
            }
            jTextField.setText(fim);
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
    }
}
