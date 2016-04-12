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
public class UserQueryActivity  extends Activity {
    private Button returnreturnButton = null;
    private Button currentrecordButton = null;
    private Button historyrecordButton = null;
    private Button chargerecordButton = null;

    private TextView timedispText = null;

    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            timedispText.setText("  " + MainActivity.getCurrentTime());
            timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));
        }
    };

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_query);

        timedispText = (TextView)findViewById(R.id.user_query_currenttime);
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));

        returnreturnButton = (Button)findViewById(R.id.return1);
        currentrecordButton = (Button)findViewById(R.id.currentrecord);
        historyrecordButton = (Button)findViewById(R.id.historyrecord);
        chargerecordButton = (Button)findViewById(R.id.chargerecord);

        currentrecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnreturnButton.setTextColor(getResources().getColor(R.color.black));
                currentrecordButton.setTextColor(getResources().getColor(R.color.blue));
                historyrecordButton.setTextColor(getResources().getColor(R.color.black));
                chargerecordButton.setTextColor(getResources().getColor(R.color.black));

            }
        });

        historyrecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnreturnButton.setTextColor(getResources().getColor(R.color.black));
                currentrecordButton.setTextColor(getResources().getColor(R.color.black));
                historyrecordButton.setTextColor(getResources().getColor(R.color.blue));
                chargerecordButton.setTextColor(getResources().getColor(R.color.black));

                startActivity(new Intent(UserQueryActivity.this, UserHistoryRecordActivity.class));
            }
        });

        chargerecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnreturnButton.setTextColor(getResources().getColor(R.color.black));
                currentrecordButton.setTextColor(getResources().getColor(R.color.black));
                historyrecordButton.setTextColor(getResources().getColor(R.color.black));
                chargerecordButton.setTextColor(getResources().getColor(R.color.blue));

                startActivity(new Intent(UserQueryActivity.this,UserChargeRecordActivity.class));
            }
        });

        returnreturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnreturnButton.setTextColor(getResources().getColor(R.color.blue));
                currentrecordButton.setTextColor(getResources().getColor(R.color.black));
                historyrecordButton.setTextColor(getResources().getColor(R.color.black));
                chargerecordButton.setTextColor(getResources().getColor(R.color.black));

                finish();
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
        returnreturnButton.setTextColor(getResources().getColor(R.color.black));
        currentrecordButton.setTextColor(getResources().getColor(R.color.black));
        historyrecordButton.setTextColor(getResources().getColor(R.color.black));
        chargerecordButton.setTextColor(getResources().getColor(R.color.black));
    }
}
