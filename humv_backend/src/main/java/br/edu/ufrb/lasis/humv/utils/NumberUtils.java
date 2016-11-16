package br.edu.ufrb.lasis.humv.utils;

import java.math.BigInteger;

public class NumberUtils {

    public static BigInteger convertStringToBigInteger(String str) {
        try {
            if (!str.matches("\\D+")) {
                
                return new BigInteger(str);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
