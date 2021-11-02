package com.nguyenvantien.csm.api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class BillApi {
    
    private BillApi(){
        
    }
    
    public static boolean insertBill(String discount, String total, String date, String itemsList) throws UnsupportedEncodingException, IOException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/Server/add-bill");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("discount", discount));
        params.add(new BasicNameValuePair("total", total));
        params.add(new BasicNameValuePair("date", date));
        params.add(new BasicNameValuePair("itemsList", itemsList));
        
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        
        HttpResponse httpResponse = client.execute(httpPost);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
            
        return true;
    }
}
