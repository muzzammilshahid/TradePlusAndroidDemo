package com.deskconn.tradeplusandroiddemo;

import android.app.Application;

import com.tradplus.ads.open.TradPlusSdk;

public class AppGlobals extends Application {

    public static final String APPID = "44273068BFF4D8A8AFF3D5B11CBA3ADE";

    public static final String NATIVE_ADUNITID = "DDBF26FBDA47FBE2765F1A089F1356BF";
    public static final String INTERSTITIAL_ADUNITID = "E609A0A67AF53299F2176C3A7783C46D";
    public static final String BANNER_ADUNITID = "A24091715B4FCD50C0F2039A5AF7C4BB";

    public static final String ENTRY_AD_INTERSTITIAL = "01EAD2CCED1870";
    public static final String SPLASH_ADUNITID = "D9118E91DD06DF6D322369455CAED618";

    @Override
    public void onCreate() {
        super.onCreate();
        TradPlusSdk.initSdk(this, APPID);
    }
}
