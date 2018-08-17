package com.sipox11.retrofitgsonmoviesapiclientdemo.data.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This should be done with proper DI using Dagger 2, but this is just a quick demo on how Retrofit
 * itself works, not how DI is done.
 */
public class ApiClient {
    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    // Set the base url
                    .baseUrl(BASE_URL)
                    // Define which converter factory will be used for translation (volley, gson...)
                    .addConverterFactory(GsonConverterFactory.create())
                    // Build the retrofit instance
                    .build();
        }
        return retrofit;
    }
}
