package com.myterminal1.xili.myterminal1.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.myterminal1.xili.myterminal1.Driver.Key;

public class ListenToKeyService extends Service {
    static{
        System.loadLibrary("Hardware");
    }

    private LocalBroadcastManager localBroadcastManager;

    public ListenToKeyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){

//      使用Key0isPressed()的示例，
        new Thread(new Runnable() {

            int status0 = 0;
            int status1 = 0;
            int status2 = 0;

            @Override
            public void run() {
                while(true){
                    try {
                        status0 = Key.Key0isPressed();
                        status1 = Key.Key1isPressed();
                        status2 = Key.Key2isPressed();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    if (status0 == 1) {
                        Log.d("Driver_Key", "0PressedOnce");
                        Intent intent = new Intent("com.myterminal1.broadcast.KeyPressed");
                        intent.putExtra("keyNum","0");
                        sendBroadcast(intent);
                    }
                    if (status1 == 1) {
                        Log.d("Driver_Key", "1PressedOnce");
                        Intent intent = new Intent("com.myterminal1.broadcast.KeyPressed");
                        intent.putExtra("keyNum","1");
                        sendBroadcast(intent);
                    }
                    if (status2 == 1) {
                        Log.d("Driver_Key", "2PressedOnce");
                        Intent intent = new Intent("com.myterminal1.broadcast.KeyPressed");
                        intent.putExtra("keyNum","2");
                        sendBroadcast(intent);
                    }
                }
            }
        }).start();

       return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Intent startListenToKeySerivece = new Intent(this, ListenToKeyService.class);
        startService(startListenToKeySerivece);
    }
}
