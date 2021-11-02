package com.nguyenvantien.csm.api;

import com.google.gson.Gson;
import com.nguyenvantien.csm.model.Revenue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

public class RevenueApi {
    private RevenueApi(){
        
    }
    
    public static List<Revenue> getRevenues(String time) throws IOException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/Server/revenue?time=" + time);
        HttpResponse httpResponse = client.execute(httpGet);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
        JSONArray array = new JSONArray(json_string);
        Gson gson = new Gson();
        List<Revenue> lists = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            lists.add(gson.fromJson(array.get(i).toString(), Revenue.class));
        }
        return lists;
    }
}
