package org.o7planning.giuaky_221121514234.ui.Day3_Network.network;

import org.o7planning.giuaky_221121514234.ui.Day3_Network.model.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIManager {
    String SERVER_URL = "https://imdb236.p.rapidapi.com";

    APIManager apiService = new Retrofit.Builder()
            .baseUrl(SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIManager.class);
    @Headers({
            "x-rapidapi-host:imdb236.p.rapidapi.com",
            "x-rapidapi-key:6144d0aee6mshb8a54aad071de82p1d52dbjsn1e1a8c0dda84"
    })
    @GET("/imdb/top250-movies")
    Call<List<Item>> getListData();
}
