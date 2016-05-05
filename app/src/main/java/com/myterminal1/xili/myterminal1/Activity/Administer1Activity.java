package com.myterminal1.xili.myterminal1.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myterminal1.xili.myterminal1.Fragment.DetectFragment;
import com.myterminal1.xili.myterminal1.R;

/**
 * Created by Administrator on 2016/4/8.
 */
public class Administer1Activity extends MyBaseActivity{

    private Button exitButton = null;
    private Button maintainButton = null;
    private Button detectButton = null;

    private TextView timedispText = null;

    @Override
    void displayCurrentTime() {
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));
    }

    @Override
    void keyPressed(String keyNum) {
        switch (keyNum){
            case "0":
                maintainButtonPressed();
                break;
            case "1":
                detectButtonPressed();
                break;
            case "2":
                exitButtonPressed();
                break;
            default:
                break;
        }
    }


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administer1);

        timedispText = (TextView)findViewById(R.id.admi_currenttime);
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));

        exitButton = (Button)findViewById(R.id.exitbutton);
        maintainButton = (Button)findViewById(R.id.maintainbutton);
        detectButton = (Button)findViewById(R.id.detectbutton);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitButtonPressed();
            }
        });

        maintainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maintainButtonPressed();
            }
        });

        detectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detectButtonPressed();
            }
        });
    }

    /**
     * 退出管理员
     */
    void exitButtonPressed(){
        exitButton.setTextColor(getResources().getColor(R.color.blue));
        maintainButton.setTextColor(getResources().getColor(R.color.black));
        detectButton.setTextColor(getResources().getColor(R.color.black));

        finish();
    }
    /**
     *管理维护操作
     */
    void maintainButtonPressed(){
        exitButton.setTextColor(getResources().getColor(R.color.black));
        maintainButton.setTextColor(getResources().getColor(R.color.blue));
        detectButton.setTextColor(getResources().getColor(R.color.black));

        startActivity(new Intent(Administer1Activity.this, Administer2MaintainActivity.class));
    }
    /**
     *用电检测界面
     */
    void detectButtonPressed(){
        exitButton.setTextColor(getResources().getColor(R.color.black));
        maintainButton.setTextColor(getResources().getColor(R.color.black));
        detectButton.setTextColor(getResources().getColor(R.color.blue));

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DetectFragment detectFragment = new DetectFragment();
        fragmentTransaction.replace(R.id.administer1_masterdisp, detectFragment);
        fragmentTransaction.commit();
    }

    public void onResume(){
        super.onResume();
        exitButton.setTextColor(getResources().getColor(R.color.black));
        maintainButton.setTextColor(getResources().getColor(R.color.black));
        detectButton.setTextColor(getResources().getColor(R.color.black));

    }
}
