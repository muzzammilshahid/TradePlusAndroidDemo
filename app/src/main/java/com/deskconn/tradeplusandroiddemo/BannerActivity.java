package com.deskconn.tradeplusandroiddemo;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.tradplus.ads.base.bean.TPAdError;
import com.tradplus.ads.base.bean.TPAdInfo;
import com.tradplus.ads.open.banner.BannerAdListener;
import com.tradplus.ads.open.banner.TPBanner;

public class BannerActivity extends AppCompatActivity {

    private TPBanner tpBanner;
    private ViewGroup adContainer;
    private static final String TAG = "tradpluslog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        adContainer = findViewById(R.id.ad_container);

        loadBanner();
    }

    private void loadBanner() {
        tpBanner = new TPBanner(this);
        tpBanner.setAdListener(new BannerAdListener() {
            @Override
            public void onAdClicked(TPAdInfo tpAdInfo) {
                Log.i(TAG, "onAdClicked: " + tpAdInfo.adSourceName);
            }

            @Override
            public void onAdImpression(TPAdInfo tpAdInfo) {
                Log.i(TAG, "onAdImpression: " + tpAdInfo.adSourceName);
            }

            @Override
            public void onAdLoaded(TPAdInfo tpAdInfo) {
                Log.i(TAG, "onAdLoaded: " + tpAdInfo.adSourceName);
            }

            @Override
            public void onAdLoadFailed(TPAdError error) {
                Log.i(TAG, "onAdLoadFailed:，code :" + error.getErrorCode() + ", msg : " + error.getErrorMsg());
            }

            @Override
            public void onAdClosed(TPAdInfo tpAdInfo) {
                Log.i(TAG, "onAdClosed: " + tpAdInfo.adSourceName);
            }
        });
        adContainer.addView(tpBanner);
        tpBanner.loadAd(AppGlobals.BANNER_ADUNITID);
    }

}