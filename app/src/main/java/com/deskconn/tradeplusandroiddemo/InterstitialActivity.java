package com.deskconn.tradeplusandroiddemo;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tradplus.ads.base.bean.TPAdError;
import com.tradplus.ads.base.bean.TPAdInfo;
import com.tradplus.ads.open.LoadAdEveryLayerListener;
import com.tradplus.ads.open.TradPlusSdk;
import com.tradplus.ads.open.interstitial.InterstitialAdListener;
import com.tradplus.ads.open.interstitial.TPInterstitial;

public class InterstitialActivity extends AppCompatActivity {

    Button interstitial_show, interstitial_load;
    TextView tv;
    TPInterstitial mTPInterstitial;
    private static final String TAG = "tradpluslog";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TradPlusSdk.initSdk(this, "44273068BFF4D8A8AFF3D5B11CBA3ADE");

        tv = findViewById(R.id.tv);
        interstitial_load = findViewById(R.id.load);
        interstitial_show = findViewById(R.id.show);

        interstitial_load.setOnClickListener(v -> mTPInterstitial.loadAd());

        interstitial_show.setOnClickListener(v -> {
            if (!mTPInterstitial.isReady()) {
                Log.i(TAG, "isReady: not ready");
                tv.setText("isReady: not ready");
            } else {
                mTPInterstitial.showAd(InterstitialActivity.this, "01EAD2CCED1870");
                Log.i(TAG, "showAd: add shown");
            }
        });

        initInterstitialAd();
    }

    private void initInterstitialAd() {
        mTPInterstitial = new TPInterstitial(this, "E609A0A67AF53299F2176C3A7783C46D", false);
        mTPInterstitial.entryAdScenario("01EAD2CCED1870");

        mTPInterstitial.setAdListener(new InterstitialAdListener() {
            @Override
            public void onAdLoaded(TPAdInfo tpAdInfo) {
                Log.i(TAG, "onAdLoaded: ");
            }

            @Override
            public void onAdClicked(TPAdInfo tpAdInfo) {
                Log.i(TAG, "onAdClicked: add clicked " + tpAdInfo.adSourceName);
            }

            @Override
            public void onAdImpression(TPAdInfo tpAdInfo) {
                Log.i(TAG, "onAdImpression: " + tpAdInfo.adSourceName);

            }

            @Override
            public void onAdFailed(TPAdError tpAdError) {
                Log.i(TAG, "onAdFailed: ");
            }

            @Override
            public void onAdClosed(TPAdInfo tpAdInfo) {
                Log.i(TAG, "onAdClosed: " + tpAdInfo.adSourceName);

            }

            @Override
            public void onAdVideoError(TPAdInfo tpAdInfo, TPAdError tpAdError) {
                Log.i(TAG, "onAdClosed: " + tpAdInfo.adSourceName);
            }
        });

        mTPInterstitial.setAllAdLoadListener(new LoadAdEveryLayerListener() {
            @Override
            public void onAdAllLoaded(boolean b) {
                Log.i(TAG, "onAdAllLoaded：" + b);
                tv.setText("onAdAllLoaded: addloaded");
            }

            @Override
            public void oneLayerLoadFailed(TPAdError tpAdError, TPAdInfo tpAdInfo) {
                Log.i(TAG, "oneLayerLoadFailed:  failed" + tpAdInfo.adSourceName + "code :: " +
                        tpAdError.getErrorCode() + " , Msg :: " + tpAdError.getErrorMsg());
            }

            @Override
            public void oneLayerLoaded(TPAdInfo tpAdInfo) {
                Log.i(TAG, "oneLayerLoaded: " + tpAdInfo.adSourceName + " 加载成功");
                tv.setText("oneLayerLoaded: " + tpAdInfo.adSourceName + " 加载成功");
            }

            @Override
            public void onLoadAdStart(TPAdInfo tpAdInfo) {

            }

            @Override
            public void onBiddingStart(TPAdInfo tpAdInfo) {

            }

            @Override
            public void onBiddingEnd(TPAdInfo tpAdInfo, TPAdError tpAdError) {

            }

        });
    }

}