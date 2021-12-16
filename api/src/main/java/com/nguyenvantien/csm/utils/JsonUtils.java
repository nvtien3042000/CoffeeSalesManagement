package com.nguyenvantien.csm.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class JsonUtils {
	private JsonUtils() {
		
	}
	
	public static void tranObjectToJson(HttpServletResponse resp, boolean result) throws IOException {
		Gson gson = new Gson();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(result));
		out.flush();
	}
	
	public static void tranObjectToJson(HttpServletResponse resp, List<?> result) throws IOException {
		Gson gson = new Gson();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(result));
		out.flush();
	}
	
	public static void tranObjectToJson(HttpServletResponse resp, Map<?, ?> result) throws IOException {
		Gson gson = new Gson();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print(gson.toJson(result));
		out.flush();
	}

}
