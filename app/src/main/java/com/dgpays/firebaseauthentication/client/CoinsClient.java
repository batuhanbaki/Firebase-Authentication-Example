package com.dgpays.firebaseauthentication.client;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dgpays.firebaseauthentication.api.API;
import com.dgpays.firebaseauthentication.api.Retro;
import com.dgpays.firebaseauthentication.model.Coin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import retrofit2.Response;

public class CoinsClient implements Runnable {

    private static CoinsClient instance;
    private final MutableLiveData<List<Coin>> coins;
    private final ScheduledExecutorService networkIO;
    private String searchKey;

    private CoinsClient() {
        coins = new MutableLiveData<>();
        networkIO = Executors.newScheduledThreadPool(3);
    }


    public static CoinsClient getInstance() {
        if (instance == null) {
            synchronized (CoinsClient.class) {
                if (instance == null) {
                    instance = new CoinsClient();
                }
            }
        }

        return instance;
    }

    public LiveData<List<Coin>> getCoins() {
        return coins;
    }

    public void call(String searchKey) {
        this.searchKey = searchKey;
        networkIO.submit(this);
    }

    @Override
    public void run() {
        API api = Retro.getInstance().getAPI();
        try {
            Response<List<Coin>> response = api.getCoins(searchKey.trim()).execute();
            if (response.code() == 200) {
                List<Coin> list = response.body();
                if (coins.getValue() != null && coins.getValue().size() > 0) {
                    coins.postValue(null);
                }
                coins.postValue(list);
            } else {
                assert response.errorBody() != null;
                String err = response.errorBody().string();
                Log.d("datay", "Error! ~ " + err);
                coins.postValue(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
            coins.postValue(null);
        }

    }
}
