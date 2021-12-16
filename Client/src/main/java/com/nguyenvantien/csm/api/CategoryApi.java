package com.nguyenvantien.csm.api;

import com.nguyenvantien.csm.utils.ConfigHttpUtils;
import java.io.IOException;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

public class CategoryApi {
    
    private CategoryApi(){
        
    }
    
    public static List<Object> getAllCategory() throws IOException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(ConfigHttpUtils.URL + "/category");
        HttpResponse httpResponse = client.execute(httpGet);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
        JSONArray array = new JSONArray(json_string);
        return array.toList();
    }
}
