package com.myterminal1.xili.myterminal1.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myterminal1.xili.myterminal1.R;
import com.myterminal1.xili.myterminal1.Receive.NetworkChangeReceiver;
import com.myterminal1.xili.myterminal1.Service.ListenToKeyService;
import com.myterminal1.xili.myterminal1.Utils.Mytools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends Activity {

    private TextView timedisplayText = null;
    private Button userloginButton = null;
    private Button administerloginButton = null;
    private Button toUARTButton = null;

    //获取当前时间,24小时制
    public static String getCurrentTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");//其中HH24小时制，hh12小时制
        String currenttime = simpleDateFormat.format(new Date());
        return currenttime;
    }
    //用于每隔一秒刷新一下界面时间
    private Handler handler = new Handler(){
        public void handleMessage(Message message){
            timedisplayText.setText("        "+getCurrentTime());
        }
    };

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //广播接收器动态注册
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTVITY_CHANGE");
        NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver, intentFilter);


        startListenToKeyService();

        timedisplayText = (TextView)findViewById(R.id.timedisplay);
        //最好有，否则页面加载1s后才有时间显示
        timedisplayText.setText("        "+getCurrentTime());

        userloginButton = (Button)findViewById(R.id.userlogin);
        administerloginButton = (Button)findViewById(R.id.administerlogin);
        toUARTButton = (Button)findViewById(R.id.ButtonToUART);


        //Mytools.showMyToast("" + Mytools.isTablet(this), 1000);


        userloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Mytools.showMyToast("用户登录成功！", 1000);

                Intent intent = new Intent(MainActivity.this, User1Activity.class);
                startActivity(intent);

            }
        });

        administerloginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mytools.showMyToast("管理员登录成功！",1000);
                startActivity(new Intent(MainActivity.this,Administer1Activity.class));
            }
        });

        toUARTButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UARTActivity.class));
            }
        });



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

    private void startListenToKeyService(){
        Intent startListenToKeySerivece = new Intent(this, ListenToKeyService.class);
        startService(startListenToKeySerivece);
    }


}
