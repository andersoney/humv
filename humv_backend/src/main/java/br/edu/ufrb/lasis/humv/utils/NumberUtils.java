package br.edu.ufrb.lasis.humv.utils;

public class NumberUtils {

	public static Integer convertStringToInteger(String str){
		if(str.matches("\\d+")){
			return Integer.parseInt(str);
		}else{
			return null;
		}
	}

}
