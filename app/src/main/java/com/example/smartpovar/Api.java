package com.example.smartpovar;

import com.example.smartpovar.entity.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String baseUrl = "http://10.0.2.2:8080/";

    @GET("categories")
    Call<List<Category>> categories();

    @GET("category")
    Call<Category> category();
}