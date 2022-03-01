package com.deskconn.tradeplusandroiddemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.interstitial_button).setOnClickListener(view -> startActivity(new Intent(this, InterstitialActivity.class)));

        findViewById(R.id.banner_button).setOnClickListener(view -> startActivity(new Intent(this, BannerActivity.class)));

        findViewById(R.id.native_button).setOnClickListener(view -> startActivity(new Intent(this, NativeBannerActivity.class)));

        findViewById(R.id.splash_button).setOnClickListener(view -> startActivity(new Intent(this, SplashAdActivity.class)));

    }
}