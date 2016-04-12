package com.myterminal1.xili.myterminal1;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/8.
 */
public class Administer1Activity extends Activity{

    private Button exitButton = null;
    private Button maintainButton = null;
    private Button detectButton = null;

    private TextView timedispText = null;

    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            timedispText.setText("  " + MainActivity.getCurrentTime());
            timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));
        }
    };

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administer1);

        timedispText = (TextView)findViewById(R.id.admi_currenttime);
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));

        exitButton = (Button)findViewById(R.id.exitbutton);
        maintainButton = (Button)findViewById(R.id.maintainbutton);
        detectButton = (Button)findViewById(R.id.detectbutton);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exitButton.setTextColor(getResources().getColor(R.color.blue));
                maintainButton.setTextColor(getResources().getColor(R.color.black));
                detectButton.setTextColor(getResources().getColor(R.color.black));

                finish();
            }
        });

        maintainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exitButton.setTextColor(getResources().getColor(R.color.black));
                maintainButton.setTextColor(getResources().getColor(R.color.blue));
                detectButton.setTextColor(getResources().getColor(R.color.black));

                startActivity(new Intent(Administer1Activity.this, Administer2MaintainActivity.class));

            }
        });

        detectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                exitButton.setTextColor(getResources().getColor(R.color.black));
                maintainButton.setTextColor(getResources().getColor(R.color.black));
                detectButton.setTextColor(getResources().getColor(R.color.blue));

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                DetectFragment detectFragment = new DetectFragment();
                fragmentTransaction.replace(R.id.administer1_masterdisp,detectFragment);
                fragmentTransaction.commit();

            }
        });

        new Thread(new Runnable(){
            public void run(){
                while(true){
                    try {
                        Message message = new Message();
                        Thread.sleep(1000);//每隔1s发送一次消息
                        handler.sendMessage(message);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

        }).start();
    }

    public void onResume(){
        super.onResume();
        exitButton.setTextColor(getResources().getColor(R.color.black));
        maintainButton.setTextColor(getResources().getColor(R.color.black));
        detectButton.setTextColor(getResources().getColor(R.color.black));


    }
}
