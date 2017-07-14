package com.softjourn.practise.library_aos.api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.softjourn.practise.library_aos.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiHelper {

    private static final String BASE_URL = "http://10.10.10.247:8080/";

    private static final Retrofit sRetrofit;

    static {
        final OkHttpClient.Builder okClient = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            okClient.addInterceptor(logging);
        }

        final Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        sRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okClient.build())
                .build();

    }
}
