package com.myterminal1.xili.myterminal1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/7.
 */
public class User1Activity extends Activity {

    private TextView currenttimedisp = null;

    private Button chargeButton = null;
    private Button fudianButton = null;
    private Button queryButton = null;
    private Button noticeButton = null;


    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            currenttimedisp.setText("  " + MainActivity.getCurrentTime());
            currenttimedisp.setTextColor(getResources().getColor(R.color.dodgerblue));
        }
    };
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user1);

        currenttimedisp = (TextView)findViewById(R.id.currenttime);
        currenttimedisp.setText("  " + MainActivity.getCurrentTime());
        currenttimedisp.setTextColor(getResources().getColor(R.color.dodgerblue));

        chargeButton = (Button)findViewById(R.id.chargebutton);
        fudianButton = (Button)findViewById(R.id.fudianbutton);
        queryButton = (Button)findViewById(R.id.querybutton);
        noticeButton = (Button)findViewById(R.id.noticebutton);

        chargeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chargeButton.setTextColor(getResources().getColor(R.color.blue));
                fudianButton.setTextColor(getResources().getColor(R.color.black));
                queryButton.setTextColor(getResources().getColor(R.color.black));
                noticeButton.setTextColor(getResources().getColor(R.color.black));

            }
        });

        fudianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chargeButton.setTextColor(getResources().getColor(R.color.black));
                fudianButton.setTextColor(getResources().getColor(R.color.blue));
                queryButton.setTextColor(getResources().getColor(R.color.black));
                noticeButton.setTextColor(getResources().getColor(R.color.black));

            }
        });

        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chargeButton.setTextColor(getResources().getColor(R.color.black));
                fudianButton.setTextColor(getResources().getColor(R.color.black));
                queryButton.setTextColor(getResources().getColor(R.color.blue));
                noticeButton.setTextColor(getResources().getColor(R.color.black));

               startActivity(new Intent(User1Activity.this,UserQueryActivity.class));
            }
        });

        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chargeButton.setTextColor(getResources().getColor(R.color.black));
                fudianButton.setTextColor(getResources().getColor(R.color.black));
                queryButton.setTextColor(getResources().getColor(R.color.black));
                noticeButton.setTextColor(getResources().getColor(R.color.blue));

                startActivity(new Intent(User1Activity.this,NoticeActivity.class));

            }
        });

        new Thread(new Runnable(){
            public void run(){
              while(true){
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

    public void onResume(){
        super.onResume();
        chargeButton.setTextColor(getResources().getColor(R.color.black));
        fudianButton.setTextColor(getResources().getColor(R.color.black));
        queryButton.setTextColor(getResources().getColor(R.color.black));
        noticeButton.setTextColor(getResources().getColor(R.color.black));
    }
}
