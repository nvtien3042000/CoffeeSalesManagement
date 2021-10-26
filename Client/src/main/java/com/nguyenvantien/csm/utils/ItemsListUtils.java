/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyenvantien.csm.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
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
