package com.example.daraz.api;

import com.example.daraz.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ItemApi {
    @GET("item/list")
    Call<List<Item>> getProduct();
}
