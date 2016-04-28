package com.myterminal1.xili.myterminal1;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/11.
 */
public class Administer3PreferenceActivity  extends Activity {
    private Button returnButton = null;
    private Button systemsettingsButton = null;
    private Button testchannelButton = null;
    private Button systemmaintainButton = null;

    private TextView timedispText = null;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            timedispText.setText("  " + MainActivity.getCurrentTime());
            timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administer3_preference);

        timedispText = (TextView)findViewById(R.id.administer3_preference_currenttime);
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));

        returnButton = (Button)findViewById(R.id.return6);
        systemsettingsButton = (Button)findViewById(R.id.systemsettingsbutton);
        systemmaintainButton = (Button)findViewById(R.id.systemmaintainbutton);
        testchannelButton = (Button)findViewById(R.id.testchannelbutton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnButton.setTextColor(getResources().getColor(R.color.blue));
                systemsettingsButton.setTextColor(getResources().getColor(R.color.black));
                systemmaintainButton.setTextColor(getResources().getColor(R.color.black));
                testchannelButton.setTextColor(getResources().getColor(R.color.black));

                finish();
            }
        });

        systemsettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnButton.setTextColor(getResources().getColor(R.color.black));
                systemsettingsButton.setTextColor(getResources().getColor(R.color.blue));
                systemmaintainButton.setTextColor(getResources().getColor(R.color.black));
                testchannelButton.setTextColor(getResources().getColor(R.color.black));

            }
        });

        systemmaintainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnButton.setTextColor(getResources().getColor(R.color.black));
                systemsettingsButton.setTextColor(getResources().getColor(R.color.black));
                systemmaintainButton.setTextColor(getResources().getColor(R.color.blue));
                testchannelButton.setTextColor(getResources().getColor(R.color.black));

            }
        });

        testchannelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnButton.setTextColor(getResources().getColor(R.color.black));
                systemsettingsButton.setTextColor(getResources().getColor(R.color.black));
                systemmaintainButton.setTextColor(getResources().getColor(R.color.black));
                testchannelButton.setTextColor(getResources().getColor(R.color.blue));

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
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
