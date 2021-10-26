/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyenvantien.csm.api;

import com.nguyenvantien.csm.view.Login;
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
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class LoginApi {
    private LoginApi(){
        
    }
    
    public static String isLogin(String userName, String password) throws UnsupportedEncodingException, IOException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8080/Server/login");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("userName", userName));
        params.add(new BasicNameValuePair("password", password));
        
        httpPost.setEntity(new UrlEncodedFormEntity(params));
        System.out.println(httpPost.getURI());
        HttpResponse httpResponse = client.execute(httpPost);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
        JSONObject temp1 = new JSONObject(json_string);
        System.out.println(temp1);
            
        return temp1.getString("role");
    } 
    
//    public static void main(String[] args) throws IOException {
//        new Login().setVisible(true);
//    }
}
