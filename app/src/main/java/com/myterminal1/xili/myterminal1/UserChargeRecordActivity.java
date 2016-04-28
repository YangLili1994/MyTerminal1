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
public class UserChargeRecordActivity extends Activity {
    private Button chargerecordButton = null;
    private Button fudianrecordButton = null;
    private Button owingrecordButton = null;
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
        setContentView(R.layout.userchargerecord);

        timedispText = (TextView)findViewById(R.id.userchargerecord_currenttime);
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));

        chargerecordButton = (Button)findViewById(R.id.chargerecordbutton);
        fudianrecordButton = (Button)findViewById(R.id.fudianrecordbutton);
        owingrecordButton = (Button)findViewById(R.id.owingrecordbutton);
        returnButton = (Button)findViewById(R.id.return2);
        //返回上一级
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chargerecordButton.setTextColor(getResources().getColor(R.color.black));
                fudianrecordButton.setTextColor(getResources().getColor(R.color.black));
                owingrecordButton.setTextColor(getResources().getColor(R.color.black));
                returnButton.setTextColor(getResources().getColor(R.color.blue));

                finish();
            }
        });
        //充值记录查询
        chargerecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chargerecordButton.setTextColor(getResources().getColor(R.color.blue));
                fudianrecordButton.setTextColor(getResources().getColor(R.color.black));
                owingrecordButton.setTextColor(getResources().getColor(R.color.black));
                returnButton.setTextColor(getResources().getColor(R.color.black));

                //fragment替代操作
                FragmentManager fragmentManager =  getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                RecordListFragment recordListFragment = new RecordListFragment();
                fragmentTransaction.replace(R.id.chargerecord_masterdisp,recordListFragment.newInstance(1));
                fragmentTransaction.commit();

            }
        });
        //复电记录查询
        fudianrecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chargerecordButton.setTextColor(getResources().getColor(R.color.black));
                fudianrecordButton.setTextColor(getResources().getColor(R.color.blue));
                owingrecordButton.setTextColor(getResources().getColor(R.color.black));
                returnButton.setTextColor(getResources().getColor(R.color.black));

                //fragment替代操作
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                RecordListFragment recordListFragment = new RecordListFragment();
                fragmentTransaction.replace(R.id.chargerecord_masterdisp,recordListFragment.newInstance(2));
                fragmentTransaction.commit();

            }
        });
        //欠费停电记录查询
        owingrecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chargerecordButton.setTextColor(getResources().getColor(R.color.black));
                fudianrecordButton.setTextColor(getResources().getColor(R.color.black));
                owingrecordButton.setTextColor(getResources().getColor(R.color.blue));
                returnButton.setTextColor(getResources().getColor(R.color.black));

                //fragment替代操作
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                RecordListFragment recordListFragment = new RecordListFragment();
                fragmentTransaction.replace(R.id.chargerecord_masterdisp,recordListFragment.newInstance(3));
                fragmentTransaction.commit();

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try{
                        Message message = new Message();
                        Thread.sleep(1000);
                        handler.sendMessage(message);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
