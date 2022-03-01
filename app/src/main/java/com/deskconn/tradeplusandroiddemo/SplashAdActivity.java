package com.deskconn.tradeplusandroiddemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.tradplus.ads.base.bean.TPAdError;
import com.tradplus.ads.base.bean.TPAdInfo;
import com.tradplus.ads.base.bean.TPBaseAd;
import com.tradplus.ads.open.splash.SplashAdListener;
import com.tradplus.ads.open.splash.TPSplash;

public class SplashAdActivity extends AppCompatActivity {

    private static final String TAG = "SplashAdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_ad);

        loadSplashAd();
    }

    private void loadSplashAd() {
        TPSplash tpSplash = new TPSplash(SplashAdActivity.this, AppGlobals.SPLASH_ADUNITID);
        tpSplash.setAdListener(new SplashAdListener() {
            @Override
            public void onAdClicked(TPAdInfo tpAdInfo) {
                Log.i(TAG, "onAdClicked: ");
                SplashAdActivity.this.finish();
            }

            @Override
            public void onAdImpression(TPAdInfo tpAdInfo) {
                Log.d(TAG, "onAdImpression: ");
            }

            @Override
            public void onAdClosed(TPAdInfo tpAdInfo) {
                Log.i(TAG, "onAdClosed: ");
                SplashAdActivity.this.finish();
            }

            @Override
            public void onAdLoaded(TPAdInfo tpAdInfo, TPBaseAd tpBaseAd) {
                Log.i(TAG, "onAdLoaded: ");
                tpSplash.showAd();
            }

            @Override
            public void onAdLoadFailed(TPAdError tpAdError) {
                super.onAdLoadFailed(tpAdError);
                Log.i(TAG, "onAdLoadFailed: ");
                finish();
            }

            @Override
            public void onAdShowFailed(TPAdInfo tpAdInfo, TPAdError tpAdError) {
                super.onAdShowFailed(tpAdInfo, tpAdError);
                Log.i(TAG, "onAdShowFailed: ");
                finish();
            }
        });
        tpSplash.loadAd(null);
    }

}