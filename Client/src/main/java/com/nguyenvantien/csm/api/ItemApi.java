/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyenvantien.csm.api;

import com.google.gson.Gson;
import com.nguyenvantien.csm.model.Item;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

/**
 *
 * @author Admin
 */
public class ItemApi {
    private ItemApi(){
        
    }
    
    public static List<Item> getAllItem() throws IOException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/Server/item");
        HttpResponse httpResponse = client.execute(httpGet);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
        JSONArray array = new JSONArray(json_string);
        Gson gson = new Gson();
        List<Item> lists = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
//gson.fromJson(array.get(i).toString(), Item.class); JSONObject to Object
            lists.add(gson.fromJson(array.get(i).toString(), Item.class));
        }
        return lists;
    }
    public static List<Item> getItemsByCategory(String category) throws IOException, URISyntaxException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/Server/item");
        URI uri = new URIBuilder(httpGet.getURI())
        .addParameter("category", category)
        .build();
        ((HttpRequestBase) httpGet).setURI(uri);
        System.out.println("item by category: " + httpGet.getURI());
        HttpResponse httpResponse = client.execute(httpGet);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
        JSONArray array = new JSONArray(json_string);
        Gson gson = new Gson();
        List<Item> lists = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            lists.add(gson.fromJson(array.get(i).toString(), Item.class));
        }
        return lists;
    }
    
    public static List<Item> getItemsByName(String name) throws IOException, URISyntaxException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/Server/item");
        URI uri = new URIBuilder(httpGet.getURI())
        .addParameter("name", name)
        .build();
        ((HttpRequestBase) httpGet).setURI(uri);
        System.out.println("item by name: " + httpGet.getURI());
        HttpResponse httpResponse = client.execute(httpGet);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
        JSONArray array = new JSONArray(json_string);
        Gson gson = new Gson();
        List<Item> lists = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            lists.add(gson.fromJson(array.get(i).toString(), Item.class));
        }
        return lists;
    }
}
