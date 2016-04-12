package com.myterminal1.xili.myterminal1;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/4/9.
 */
public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getAppContext() {
        return context;
    }
}
