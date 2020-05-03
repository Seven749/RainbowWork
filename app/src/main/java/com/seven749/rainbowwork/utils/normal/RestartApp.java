package com.seven749.rainbowwork.utils.normal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * @author 行云流水
 * @date 2020/4/27
 * @description 这是重启App的工具类
 */
public class RestartApp {
    private RestartApp() {};
    /**
     * @param context
     */
    public static void run(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (null == packageManager) {
            Log.e(TAG,"null == packageManager");
            return;
        }
        final Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }
    }
}
