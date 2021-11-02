package com.nguyenvantien.csm.api;

import com.google.gson.Gson;
import com.nguyenvantien.csm.model.UserDto;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

public class LoginApi {
    private LoginApi(){
        
    }
    
    public static UserDto isLogin(String userName, String password) throws UnsupportedEncodingException, IOException{
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        String pBody = "userName=" + userName + "&password=" +password;
        RequestBody body = RequestBody.create(mediaType, pBody);
        Request request = new Request.Builder()
          .url("http://localhost:8080/Server/login")
          .method("POST", body)
          .addHeader("Content-Type", "application/x-www-form-urlencoded")
          .addHeader("Cookie", "JSESSIONID=4757831A611DE778CD24B4DD5BBE553D")
          .build();
        Response response = client.newCall(request).execute();
        String json_string = response.body().string();
        System.out.println(json_string);
        JSONObject temp1 = new JSONObject(json_string);
        Gson gson = new Gson();
        System.out.println(gson.fromJson(temp1.toString(), UserDto.class));;
        return gson.fromJson(temp1.toString(), UserDto.class);
    } 
    
}
