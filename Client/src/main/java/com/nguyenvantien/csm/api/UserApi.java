package com.nguyenvantien.csm.api;

import com.google.gson.Gson;
import com.nguyenvantien.csm.model.User;
import com.nguyenvantien.csm.utils.ConfigHttpUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

public class UserApi {
    public static List<User> getUsers(String name) throws IOException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(ConfigHttpUtils.URL + "/users?name=" + name);
        HttpResponse httpResponse = client.execute(httpGet);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
        JSONArray array = new JSONArray(json_string);
        Gson gson = new Gson();
        List<User> lists = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            lists.add(gson.fromJson(array.get(i).toString(), User.class));
        }
        return lists;
    }
    
    public static boolean addUser(String userName, String password, String fullName, String phoneNumber, String address, String role) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        String bodyStr = "userName=" + userName +
                        "&password=" + password + 
                        "&fullName=" + fullName + 
                        "&phoneNumber=" + phoneNumber + 
                        "&address=" + address + 
                        "&role=" + role + "";
        RequestBody body = RequestBody.create(mediaType, bodyStr);
        Request request = new Request.Builder()
            .url(ConfigHttpUtils.URL + "/add-user")
            .method("POST", body)
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .build();
        Response response = client.newCall(request).execute();
        String json_string = response.body().string();
        System.out.println(json_string);
        if(json_string.equals("true")){
            return true;
        }
        return false;
    }
    
    public static boolean updateUser(Integer id, String userName, String password, String fullName, String phoneNumber, String address, String role) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        String bodyStr ="id=" + id + 
                        "&userName=" + userName +
                        "&password=" + password + 
                        "&fullName=" + fullName + 
                        "&phoneNumber=" + phoneNumber + 
                        "&address=" + address + 
                        "&role=" + role + "";
        RequestBody body = RequestBody.create(mediaType, bodyStr);
        Request request = new Request.Builder()
            .url(ConfigHttpUtils.URL + "/update-user")
            .method("POST", body)
            .addHeader("Content-Type", "application/x-www-form-urlencoded")
            .build();
        Response response = client.newCall(request).execute();
        String json_string = response.body().string();
        System.out.println(json_string);
        if(json_string.equals("true")){
            return true;
        }
        return false;
    }
    
    public static boolean deleteUser(Integer id) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
          .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "id="+id);
        Request request = new Request.Builder()
          .url(ConfigHttpUtils.URL + "/delete-user")
          .method("DELETE", body)
          .addHeader("Content-Type", "application/x-www-form-urlencoded")
          .build();
        Response response = client.newCall(request).execute();
        String json_string = response.body().string();
        System.out.println(json_string);
        if(json_string.equals("true")){
            return true;
        }
        return false;
    }
}
