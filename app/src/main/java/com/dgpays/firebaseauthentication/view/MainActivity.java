package com.dgpays.firebaseauthentication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.dgpays.firebaseauthentication.api.Retro;
import com.dgpays.firebaseauthentication.databinding.ActivityMainBinding;
import com.dgpays.firebaseauthentication.model.Coin;
import com.dgpays.firebaseauthentication.viewmodel.CoinsViewModel;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CoinsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(CoinsViewModel.class);
        setObserver();
        call();
    }

    void call() {
        viewModel.call("BTC,BSV,BCH,ETH");
    }

    void setObserver() {
        viewModel.getCoins().observe(this, coins -> {
            if (coins != null && coins.size() > 0) {
                setDatas(coins);
            }
        });
    }

    void setDatas(List<Coin> coins) {
        String price = "$" + String.format(Locale.ENGLISH, "%.2f", coins.get(0).getPrice());
        //TODO: buraya ekstra olarak kontrol eklenmeli
        binding.btccoin.setText(coins.get(0).getCoin());
        binding.btccoinName.setText("- "+coins.get(0).getName());
        binding.btcprice.setText(price);
        binding.btcpriceBottom.setText(price);

        binding.engcoin.setText(coins.get(1).getCoin());
        binding.engcoinName.setText("- "+coins.get(1).getName());
        price = "$" + String.format(Locale.ENGLISH, "%.2f", coins.get(1).getPrice());
        binding.engprice.setText(price);
        binding.engpriceBottom.setText(price);

        binding.tnbcoin.setText(coins.get(2).getCoin());
        binding.tnbcoinName.setText("- "+coins.get(2).getName());
        price = "$" + String.format(Locale.ENGLISH, "%.2f", coins.get(2).getPrice());
        binding.tnbprice.setText(price);
        binding.tnbpriceBottom.setText(price);

        binding.ethcoin.setText(coins.get(3).getCoin());
        binding.ethcoinName.setText("- "+coins.get(2).getName());
        price = "$" + String.format(Locale.ENGLISH, "%.2f", coins.get(2).getPrice());
        binding.ethprice.setText(price);
        binding.ethpriceBottom.setText(price);
    }
}