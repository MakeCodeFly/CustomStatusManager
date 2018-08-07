package com.lishijie.zoujuequn;

import android.content.Context;
import android.widget.Toast;


public class ToastUtils {
    private static Toast mToast;

    public static void show(Context context, String message) {
        if (mToast == null) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
