package com.dgpays.firebaseauthentication.api;

import com.dgpays.firebaseauthentication.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retro {

    private static Retro INSTANCE;

    private Retro() {

    }

    public static Retro getInstance() {

        if (INSTANCE == null) {
            synchronized (Retro.class)
            {
                if (INSTANCE == null) {
                    INSTANCE = new Retro();
                }
            }
        }

        return INSTANCE;
    }


    public API getAPI()
    {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        return retrofit.create(API.class);
    }

}
