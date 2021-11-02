package com.nguyenvantien.csm.api;

import com.google.gson.Gson;
import com.nguyenvantien.csm.model.Item;
import com.nguyenvantien.csm.model.ItemCategoryDto;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

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
            lists.add(gson.fromJson(array.get(i).toString(), Item.class));
        }
        return lists;
    }
    
    public static List<ItemCategoryDto> getAllItemAndCategory(String name) throws IOException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://localhost:8080/Server/item-category?name=" + name);
        HttpResponse httpResponse = client.execute(httpGet);
        String json_string = EntityUtils.toString(httpResponse.getEntity());
        System.out.println(json_string);
        JSONArray array = new JSONArray(json_string);
        Gson gson = new Gson();
        List<ItemCategoryDto> lists = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            lists.add(gson.fromJson(array.get(i).toString(), ItemCategoryDto.class));
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
    
    public static boolean addItem(String name, Double price, String unit, String category) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        String bodyStr = "name=" + name 
                + "&price=" + String.valueOf(price) 
                + "&unit=" + unit 
                + "&category=" + category;
        RequestBody body = RequestBody.create(mediaType, bodyStr);
        Request request = new Request.Builder()
        .url("http://localhost:8080/Server/add-item")
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
    
    public static boolean updateItem(Integer id, String name, Double price, String unit, String category) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        String bodyStr = "id=" + id + "&name=" + name 
                + "&price=" + String.valueOf(price) 
                + "&unit=" + unit 
                + "&category=" + category;
        RequestBody body = RequestBody.create(mediaType, bodyStr);
        Request request = new Request.Builder()
            .url("http://localhost:8080/Server/update-item")
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
    
    public static boolean deleteItem(Integer id) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
        .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "id="+id);
        Request request = new Request.Builder()
        .url("http://localhost:8080/Server/delete-item")
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
