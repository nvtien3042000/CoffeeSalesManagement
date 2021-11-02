package com.nguyenvantien.csm.utils;

import java.util.HashMap;
import java.util.Map;

public class ItemsListUtils {
    public static Map<String, Integer> itemsList;
    static {
        itemsList = new HashMap<>();
    }
    private ItemsListUtils(){
        
    }
    
    public static Map<String, Integer> getIds(){
        return itemsList;
    }
}
