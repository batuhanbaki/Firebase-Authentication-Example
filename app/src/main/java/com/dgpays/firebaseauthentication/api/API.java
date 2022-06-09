package com.dgpays.firebaseauthentication.api;

import com.dgpays.firebaseauthentication.model.Coin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("v2/coins")
    Call<List<Coin>> getCoins(@Query("list") String list);
}
