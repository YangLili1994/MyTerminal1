package com.myterminal1.xili.myterminal1.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myterminal1.xili.myterminal1.R;
import com.myterminal1.xili.myterminal1.Fragment.UserCurrentInfoFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/4/15.
 */
public class UserCurrentInfoActivity extends MyBaseActivity{

    private Button billinfoButton = null;
    private Button returnButton = null;

    private TextView timedisp = null;

    @Override
    void displayCurrentTime() {
        timedisp.setText("  "+ MainActivity.getCurrentTime());
        timedisp.setTextColor(getResources().getColor(R.color.dodgerblue));
    }

    @Override
    void keyPressed(String keyNum) {
        switch (keyNum){
            case "0":
                Log.d("Key", "UserCurrentInfoActivity: 0 PressedOnce");
                billinfoButtonPressed();
                break;
            case "1":
                Log.d("Key", "UserCurrentInfoActivity: 1 PressedOnce");
                returnButtonPressed();
                break;
            default:
                break;
        }
    }

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
                returnButtonPressed();
            }
        });

        billinfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billinfoButtonPressed();
            }
        });

    }
    void returnButtonPressed(){
        returnButton.setTextColor(getResources().getColor(R.color.blue));
        billinfoButton.setTextColor(getResources().getColor(R.color.black));

        finish();
    }
    void billinfoButtonPressed(){
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

        String[] info = {username, userid, doornum, totalelectric, useraccount, accounttime};

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        UserCurrentInfoFragment fragment = new UserCurrentInfoFragment();

        Bundle bundle = new Bundle();
        bundle.putStringArray("info", info);

        fragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.currentinfo_masterdisp, fragment);
        fragmentTransaction.commit();
    }


}
