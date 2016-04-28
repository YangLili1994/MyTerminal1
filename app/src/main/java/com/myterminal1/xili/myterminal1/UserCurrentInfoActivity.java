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

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/4/15.
 */
public class UserCurrentInfoActivity extends Activity{

    private Button billinfoButton = null;
    private Button returnButton = null;

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
        setContentView(R.layout.usercurrentinfo);

        timedisp = (TextView)findViewById(R.id.usercurrentinfo_currenttime);
        timedisp.setText("  " + MainActivity.getCurrentTime());
        timedisp.setTextColor(getResources().getColor(R.color.dodgerblue));

        billinfoButton = (Button)findViewById(R.id.billinfo_button);
        returnButton = (Button)findViewById(R.id.return7);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnButton.setTextColor(getResources().getColor(R.color.blue));
                billinfoButton.setTextColor(getResources().getColor(R.color.black));

                finish();
            }
        });

        billinfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnButton.setTextColor(getResources().getColor(R.color.black));
                billinfoButton.setTextColor(getResources().getColor(R.color.blue));

                //应换成从云服务器获得的数据
                String username = "张三";
                String userid = "001";
                String doornum = "101";
                String totalelectric = "100KWh";
                String useraccount = "￥1000";
                String accounttime = null;

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
                accounttime = simpleDateFormat.format(new Date());

                String[] info = {username,userid,doornum,totalelectric,useraccount,accounttime};

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                UserCurrentInfoFragment fragment = new UserCurrentInfoFragment();

                Bundle bundle = new Bundle();
                bundle.putStringArray("info",info);

                fragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.currentinfo_masterdisp,fragment);
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
                   }catch (Exception e){
                       e.printStackTrace();
                   }
               }
            }
        }).start();
    }
}
