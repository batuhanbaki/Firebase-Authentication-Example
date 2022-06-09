package com.dgpays.firebaseauthentication.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dgpays.firebaseauthentication.client.CoinsClient;
import com.dgpays.firebaseauthentication.model.Coin;
import com.dgpays.firebaseauthentication.repositories.CoinsRepository;

import java.util.List;

public class CoinsViewModel extends ViewModel
{

    public CoinsViewModel()
    {

    }

    public LiveData<List<Coin>> getCoins()
    {
        return CoinsRepository.getInstance().getCoins();
    }


    public void call(String searchKey)
    {
        CoinsRepository.getInstance().call(searchKey);
    }
}
