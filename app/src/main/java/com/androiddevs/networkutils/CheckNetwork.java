package com.androiddevs.networkutils;

import android.content.Context;
import android.net.ConnectivityManager;

public class CheckNetwork {

    public CheckNetwork() {
        // TODO Auto-generated constructor stub
        super();
    }

    public static boolean isNetworkAvailable(Context context) {
        // TODO Auto-generated method stub
        final ConnectivityManager connMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connMgr.getActiveNetworkInfo() != null
                && connMgr.getActiveNetworkInfo().isAvailable()
                && connMgr.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}
