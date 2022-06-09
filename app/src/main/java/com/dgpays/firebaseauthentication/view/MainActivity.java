package com.dgpays.firebaseauthentication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dgpays.firebaseauthentication.R;
import com.dgpays.firebaseauthentication.databinding.ActivityMainBinding;
import com.dgpays.firebaseauthentication.databinding.ActivitySplashBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}