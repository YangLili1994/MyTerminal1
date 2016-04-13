package com.myterminal1.xili.myterminal1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/4/13.
 */
public class BootCompleteReceiver extends BroadcastReceiver {
    static final String ACTION = "android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(ACTION)){
            Intent mainActivityIntent = new Intent(context,MainActivity.class); //开机自启动
            mainActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//设定activity创建方式
            context.startActivity(mainActivityIntent);
        }
    }
}
