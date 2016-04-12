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
 * Created by Administrator on 2016/4/8.
 */
public class Administer2MaintainActivity extends Activity {

    private Button infoButton = null;
    private Button preferenceButton = null;
    private Button returnButton = null;

    private TextView timedispText = null;

    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            timedispText.setText("  " + MainActivity.getCurrentTime());
            timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));
        }
    };

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administer2_maintain);

        timedispText = (TextView)findViewById(R.id.administer2_maintain_currenttime);
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));

        infoButton = (Button)findViewById(R.id.infobutton);
        preferenceButton = (Button)findViewById(R.id.preferencebutton);
        returnButton = (Button)findViewById(R.id.return4button);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                infoButton.setTextColor(getResources().getColor(R.color.blue));
                preferenceButton.setTextColor(getResources().getColor(R.color.black));
                returnButton.setTextColor(getResources().getColor(R.color.black));

                startActivity(new Intent(Administer2MaintainActivity.this,Administer3TerminalInfoActivity.class));

            }
        });

        preferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                infoButton.setTextColor(getResources().getColor(R.color.black));
                preferenceButton.setTextColor(getResources().getColor(R.color.blue));
                returnButton.setTextColor(getResources().getColor(R.color.black));

                startActivity(new Intent(Administer2MaintainActivity.this,Administer3PreferenceActivity.class));

            }
        });
        //返回上一级菜单
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                infoButton.setTextColor(getResources().getColor(R.color.black));
                preferenceButton.setTextColor(getResources().getColor(R.color.black));
                returnButton.setTextColor(getResources().getColor(R.color.blue));

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

        infoButton.setTextColor(getResources().getColor(R.color.black));
        preferenceButton.setTextColor(getResources().getColor(R.color.black));
        returnButton.setTextColor(getResources().getColor(R.color.black));


    }
}
