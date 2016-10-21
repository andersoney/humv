package br.edu.ufrb.lasis.humv.utils;

import java.math.BigInteger;

public class NumberUtils {

	public static BigInteger convertStringToInteger(String str){
		if(str.matches("\\d+")){
			return BigInteger.valueOf(Integer.parseInt(str));
		}else{
			return null;
		}
	}

}
