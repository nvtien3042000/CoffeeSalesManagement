package com.nguyenvantien.csm.utils;

import java.text.DecimalFormat;

public class StringUtils {
    private StringUtils(){
        
    }
    
    public static String formatMoney(String value){
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(Double.parseDouble(value))+" VNĐ";
    }
    
    public static String formatMoney(Double value){
        String valueStr = String.valueOf(value);
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(Double.parseDouble(valueStr))+" VNĐ";
    }
    
    public static double toValue(String value){
        String number = value.split(" ")[0];
        return Double.parseDouble(number.replaceAll(",", ""));
    }
}
