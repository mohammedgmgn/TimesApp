package com.mahmoud.mohammed.timesapp.presentation.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class UiUtil {

    public static boolean hasNetwork(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
