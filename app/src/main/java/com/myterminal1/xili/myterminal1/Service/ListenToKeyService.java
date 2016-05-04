package com.myterminal1.xili.myterminal1.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.myterminal1.xili.myterminal1.Driver.Key;

public class ListenToKeyService extends Service {
    static{
        System.loadLibrary("Hardware");
    }

    public ListenToKeyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        int status = 0;
        int i;
//      使用Key0isPressed()的示例，
        for (i=0; i<100;  i++){
            status = Key.Key0isPressed();
            if (status == 1)
                Log.d("Driver_Key", "PressedOnce");
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
