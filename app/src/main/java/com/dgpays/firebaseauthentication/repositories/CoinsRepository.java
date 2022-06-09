package com.dgpays.firebaseauthentication.repositories;


import androidx.lifecycle.LiveData;

import com.dgpays.firebaseauthentication.client.CoinsClient;
import com.dgpays.firebaseauthentication.model.Coin;

import java.util.List;

public class CoinsRepository {
    private static CoinsRepository instance;

    private CoinsRepository() {

    }

    public static CoinsRepository getInstance() {
        if (instance == null) {
            synchronized (CoinsRepository.class) {
                if (instance == null) {
                    instance = new CoinsRepository();
                }
            }
        }

        return instance;
    }

    public LiveData<List<Coin>> getCoins() {
        return CoinsClient.getInstance().getCoins();
    }

    public void call(String searchKey)
    {
        CoinsClient.getInstance().call(searchKey);
    }
}
