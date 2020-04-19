package com.piyu.uidashboard.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class AppUtils {
    public static  boolean checkInternetConnection(Context context)
    {
        ConnectivityManager cm=(ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork=cm.getActiveNetworkInfo();
        boolean isConnected=activenetwork!=null && activenetwork.isConnectedOrConnecting();
        return isConnected;
    }
}
