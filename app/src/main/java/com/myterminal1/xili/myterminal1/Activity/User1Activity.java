package com.myterminal1.xili.myterminal1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myterminal1.xili.myterminal1.R;

/**
 * Created by Administrator on 2016/4/7.
 */
public class User1Activity extends MyBaseActivity {

    private TextView currenttimedisp = null;

    private Button chargeButton = null;
    private Button fudianButton = null;
    private Button queryButton = null;
    private Button noticeButton = null;

    @Override
    void keyPressed(String keyNum) {
        switch (keyNum){
            case "0":
                chargeButtonPressed();
                break;
            case "1":
                fudianButtonPressed();
                break;
            case "2":
                queryButtonPressed();
                break;
            case "3":
                noticeButtonPressed();
                break;
            default:
                break;
        }
    }

    @Override
    void displayCurrentTime() {
        currenttimedisp.setText("  " + MainActivity.getCurrentTime());
        currenttimedisp.setTextColor(getResources().getColor(R.color.dodgerblue));
    }

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user1);

        currenttimedisp = (TextView)findViewById(R.id.currenttime);
        currenttimedisp.setText("  " + MainActivity.getCurrentTime());
        currenttimedisp.setTextColor(getResources().getColor(R.color.dodgerblue));

        chargeButton = (Button)findViewById(R.id.chargebutton);
        fudianButton = (Button)findViewById(R.id.fudianbutton);
        queryButton = (Button)findViewById(R.id.querybutton);
        noticeButton = (Button)findViewById(R.id.noticebutton);

        chargeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chargeButtonPressed();
            }
        });

        fudianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fudianButtonPressed();
            }
        });

        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryButtonPressed();
            }
        });

        noticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noticeButtonPressed();
            }
        });
    }
    void chargeButtonPressed(){
        chargeButton.setTextColor(getResources().getColor(R.color.blue));
        fudianButton.setTextColor(getResources().getColor(R.color.black));
        queryButton.setTextColor(getResources().getColor(R.color.black));
        noticeButton.setTextColor(getResources().getColor(R.color.black));

        startActivity(new Intent(User1Activity.this,JianhangPayActivity.class));
    }
    void fudianButtonPressed(){
        chargeButton.setTextColor(getResources().getColor(R.color.black));
        fudianButton.setTextColor(getResources().getColor(R.color.blue));
        queryButton.setTextColor(getResources().getColor(R.color.black));
        noticeButton.setTextColor(getResources().getColor(R.color.black));
    }
    void queryButtonPressed(){
        chargeButton.setTextColor(getResources().getColor(R.color.black));
        fudianButton.setTextColor(getResources().getColor(R.color.black));
        queryButton.setTextColor(getResources().getColor(R.color.blue));
        noticeButton.setTextColor(getResources().getColor(R.color.black));

        startActivity(new Intent(User1Activity.this,UserQueryActivity.class));
    }
    void noticeButtonPressed(){
        chargeButton.setTextColor(getResources().getColor(R.color.black));
        fudianButton.setTextColor(getResources().getColor(R.color.black));
        queryButton.setTextColor(getResources().getColor(R.color.black));
        noticeButton.setTextColor(getResources().getColor(R.color.blue));

        startActivity(new Intent(User1Activity.this, NoticeActivity.class));
    }


    public void onResume() {
        super.onResume();
        chargeButton.setTextColor(getResources().getColor(R.color.black));
        fudianButton.setTextColor(getResources().getColor(R.color.black));
        queryButton.setTextColor(getResources().getColor(R.color.black));
        noticeButton.setTextColor(getResources().getColor(R.color.black));
    }


}
