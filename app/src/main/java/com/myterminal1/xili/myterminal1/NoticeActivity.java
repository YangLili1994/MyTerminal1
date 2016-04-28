package com.myterminal1.xili.myterminal1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/15.
 */
public class NoticeActivity extends Activity {
    private TextView timedisp = null;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            timedisp.setText("  "+MainActivity.getCurrentTime());
            timedisp.setTextColor(getResources().getColor(R.color.dodgerblue));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice);

        timedisp = (TextView)findViewById(R.id.notice_currenttime);
        timedisp.setText("  " + MainActivity.getCurrentTime());
        timedisp.setTextColor(getResources().getColor(R.color.dodgerblue));


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try{
                        Message message = new Message();
                        handler.sendMessage(message);
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
