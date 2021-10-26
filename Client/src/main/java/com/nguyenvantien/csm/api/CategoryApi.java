/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyenvantien.csm.api;

import java.io.IOException;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

/**
 *
 * @author Admin
 */
public class CategoryApi {
    private CategoryApi(){
        
    }
    
    public static List<Object> getAllCategory() throws IOException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/Server/category");
        HttpResponse httpResponse = client.execute(httpGet);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
        JSONArray array = new JSONArray(json_string);
        return array.toList();
    }
}
