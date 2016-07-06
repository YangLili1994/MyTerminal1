package com.myterminal1.xili.myterminal1.Activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by Administrator on 2016/5/5.
 */
public abstract class MyBaseActivity extends Activity {
    KeyPressedReceiver keyPressedReceiver;

    /**
     * 根据广播接收到的值，进行相应处理
     * @param keyNum 被按下的按键
     */
    abstract void keyPressed(String keyNum);

    /**
     * 显示当前时间
     */
    abstract void displayCurrentTime();

    protected class KeyPressedReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String keyNum = intent.getStringExtra("keyNum");
            //Log.d("Driver_Key", "Receiver");
            keyPressed(keyNum);
        }
    }

    protected Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            displayCurrentTime();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        keyPressedReceiver = new KeyPressedReceiver();

        new Thread(new Runnable(){
            public void run(){
                while (true){
                    try {
                        Message message = new Message();
                        Thread.sleep(1000);//1S，用于每隔一秒刷新一下界面时间
                        handler.sendMessage(message);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

        }).start();
    }

    /**注册广播接收器
     * 注意：一定要在onResume中，保证activity处于运行状态时注册广播
     * 不可再onCreate中，因为onCreate只在第一次创建时调用
     */
    @Override
    protected void onResume() {
        super.onResume();
        registerKeyReceiver();
    }

    /**取消注册
     * 注意：一定要在onPause中，保证活动不可见时取消注册
     * 不可在onDestroy，否则广播会被多个activity响应
     */
    @Override
    protected void onPause() {
        super.onPause();
        unregisterKeyReceiver();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 注册
     */
    void registerKeyReceiver(){
        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction("com.myterminal1.broadcast.KeyPressed");
        registerReceiver(keyPressedReceiver, intentFilter);

    }
        /**
     * 取消注册
     */
    void unregisterKeyReceiver(){
        unregisterReceiver(keyPressedReceiver);
    }
}
