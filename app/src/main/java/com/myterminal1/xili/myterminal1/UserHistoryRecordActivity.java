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
 * Created by Administrator on 2016/4/7.
 */
public class UserHistoryRecordActivity extends Activity {
    private Button lastsevendaysButton = null;
    private Button lastthreemonthsButton = null;
    private Button lastsixmonthsButton = null;
    private Button returnButton = null;
    //最近6个月用电记录数据，第一位为标志位
    private float[] lastsixmonthsRecords = {0,30,41,50.3f,48,66,88.8f};
    //最近3个月用电记录数据，第一位为标志位
    private float[] lastthreemonthsRecords = {2,48,66,88.8f};
    //最近7天用电记录数据，第一位为标志位
    private float[] lastsevendaysRecords = {1,5,8,6,9,3,7,6};

    private TextView timedispText = null;

    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            timedispText.setText("  " + MainActivity.getCurrentTime());
            timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));
        }
    };

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userhistoryrecord);

        timedispText = (TextView)findViewById(R.id.userhistoryrecord_currenttime);
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));

        lastsixmonthsButton = (Button)findViewById(R.id.lastsixmonths_button);
        lastthreemonthsButton = (Button)findViewById(R.id.lastthreemonths_button);
        lastsevendaysButton = (Button)findViewById(R.id.lastsevendays_button);
        returnButton = (Button)findViewById(R.id.return3);

        //返回上一级菜单
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lastsevendaysButton.setTextColor(getResources().getColor(R.color.black));
                lastthreemonthsButton.setTextColor(getResources().getColor(R.color.black));
                lastsixmonthsButton.setTextColor(getResources().getColor(R.color.black));
                returnButton.setTextColor(getResources().getColor(R.color.blue));

                finish();
            }
        });
        //最近7天用电信息查询
        lastsevendaysButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lastsevendaysButton.setTextColor(getResources().getColor(R.color.blue));
                lastthreemonthsButton.setTextColor(getResources().getColor(R.color.black));
                lastsixmonthsButton.setTextColor(getResources().getColor(R.color.black));
                returnButton.setTextColor(getResources().getColor(R.color.black));

                FragmentManager fm = getFragmentManager();
                //开启Fragment事务
                FragmentTransaction transaction = fm.beginTransaction();
                BarcharFragment barcharFragment = new BarcharFragment();
                transaction.replace(R.id.historyrecord_masterdisp, barcharFragment.newInstance(lastsevendaysRecords));
                transaction.commit();
            }
        });
        //最近3个月用电信息查询
        lastthreemonthsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lastsevendaysButton.setTextColor(getResources().getColor(R.color.black));
                lastthreemonthsButton.setTextColor(getResources().getColor(R.color.blue));
                lastsixmonthsButton.setTextColor(getResources().getColor(R.color.black));
                returnButton.setTextColor(getResources().getColor(R.color.black));

                FragmentManager fm = getFragmentManager();
                //开启Fragment事务
                FragmentTransaction transaction = fm.beginTransaction();
                BarcharFragment barcharFragment = new BarcharFragment();
                transaction.replace(R.id.historyrecord_masterdisp, barcharFragment.newInstance(lastthreemonthsRecords));
                transaction.commit();
            }
        });
        //最近6个月用电信息查询
        lastsixmonthsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lastsevendaysButton.setTextColor(getResources().getColor(R.color.black));
                lastthreemonthsButton.setTextColor(getResources().getColor(R.color.black));
                lastsixmonthsButton.setTextColor(getResources().getColor(R.color.blue));
                returnButton.setTextColor(getResources().getColor(R.color.black));

                FragmentManager fm = getFragmentManager();
                //开启Fragment事务
                FragmentTransaction transaction = fm.beginTransaction();
                BarcharFragment barcharFragment = new BarcharFragment();
                transaction.replace(R.id.historyrecord_masterdisp, barcharFragment.newInstance(lastsixmonthsRecords));
                transaction.commit();
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
