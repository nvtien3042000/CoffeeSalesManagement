package com.nguyenvantien.csm.utils;

import java.util.HashMap;
import java.util.Map;

public class UsersListUtils {
    public static Map<String, Integer> usersList;
    static {
        usersList = new HashMap<>();
    }
    private UsersListUtils(){
        
    }
    
    public static Map<String, Integer> getIds(){
        return usersList;
    }
}
