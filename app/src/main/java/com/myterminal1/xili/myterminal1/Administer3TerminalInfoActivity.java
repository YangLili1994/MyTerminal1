package com.myterminal1.xili.myterminal1;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/8.
 */
public class Administer3TerminalInfoActivity extends Activity{

    private Button basicinfoButton = null;
    private Button fileButton = null;
    private Button communicationparameterButton = null;
    private Button returnButton = null;

    private TextView timedispText = null;
    //用于每隔一秒刷新一下界面时间
    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            timedispText.setText("  " + MainActivity.getCurrentTime());
            timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));
        }
    };

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administer3_terminalinfo);

        timedispText = (TextView)findViewById(R.id.administer3_terminalinfo_currenttime);
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));

        basicinfoButton = (Button)findViewById(R.id.basicinfobutton);
        fileButton = (Button)findViewById(R.id.filebutton);
        communicationparameterButton = (Button)findViewById(R.id.communicationparametersbutton);
        returnButton = (Button)findViewById(R.id.return5);

        basicinfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                basicinfoButton.setTextColor(getResources().getColor(R.color.blue));
                fileButton.setTextColor(getResources().getColor(R.color.black));
                communicationparameterButton.setTextColor(getResources().getColor(R.color.black));
                returnButton.setTextColor(getResources().getColor(R.color.black));

            }
        });
        //用户档案查询与操作
        fileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                basicinfoButton.setTextColor(getResources().getColor(R.color.black));
                fileButton.setTextColor(getResources().getColor(R.color.blue));
                communicationparameterButton.setTextColor(getResources().getColor(R.color.black));
                returnButton.setTextColor(getResources().getColor(R.color.black));

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                UserfileFragment userfileFragment = new UserfileFragment();
                userfileFragment.setContext(getApplicationContext());
                fragmentTransaction.replace(R.id.administer3_info_maindisp,userfileFragment);
                fragmentTransaction.commit();

            }
        });

        communicationparameterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                basicinfoButton.setTextColor(getResources().getColor(R.color.black));
                fileButton.setTextColor(getResources().getColor(R.color.black));
                communicationparameterButton.setTextColor(getResources().getColor(R.color.blue));
                returnButton.setTextColor(getResources().getColor(R.color.black));

            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                basicinfoButton.setTextColor(getResources().getColor(R.color.black));
                fileButton.setTextColor(getResources().getColor(R.color.black));
                communicationparameterButton.setTextColor(getResources().getColor(R.color.black));
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
}
