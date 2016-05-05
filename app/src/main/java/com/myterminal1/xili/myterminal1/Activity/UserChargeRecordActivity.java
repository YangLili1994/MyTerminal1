package com.myterminal1.xili.myterminal1.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myterminal1.xili.myterminal1.R;
import com.myterminal1.xili.myterminal1.Fragment.RecordListFragment;

/**
 * Created by Administrator on 2016/4/7.
 */
public class UserChargeRecordActivity extends MyBaseActivity {
    private Button chargerecordButton = null;
    private Button fudianrecordButton = null;
    private Button owingrecordButton = null;
    private Button returnButton = null;

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
                chargerecordButtonPressed();
                break;
            case "1":
                fudianrecordButtonPressed();
                break;
            case "2":
                owingrecordButtonPressed();
                break;
            case "3":
                returnButtonPressed();
                break;
            default:
                break;
        }
    }


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
                returnButtonPressed();
            }
        });
        //充值记录查询
        chargerecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chargerecordButtonPressed();
            }
        });
        //复电记录查询
        fudianrecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fudianrecordButtonPressed();
            }
        });
        //欠费停电记录查询
        owingrecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                owingrecordButtonPressed();
            }
        });

    }

    /**
     *返回上级菜单
     */
    void returnButtonPressed(){
        chargerecordButton.setTextColor(getResources().getColor(R.color.black));
        fudianrecordButton.setTextColor(getResources().getColor(R.color.black));
        owingrecordButton.setTextColor(getResources().getColor(R.color.black));
        returnButton.setTextColor(getResources().getColor(R.color.blue));

        finish();
    }
    /**
     *充值记录查询
     */
    void chargerecordButtonPressed(){
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
    /**
     *复电记录查询
     */
    void fudianrecordButtonPressed(){
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
    /**
     *欠费停电记录查询
     */
    void owingrecordButtonPressed(){
        chargerecordButton.setTextColor(getResources().getColor(R.color.black));
        fudianrecordButton.setTextColor(getResources().getColor(R.color.black));
        owingrecordButton.setTextColor(getResources().getColor(R.color.blue));
        returnButton.setTextColor(getResources().getColor(R.color.black));

        //fragment替代操作
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RecordListFragment recordListFragment = new RecordListFragment();
        fragmentTransaction.replace(R.id.chargerecord_masterdisp, recordListFragment.newInstance(3));
        fragmentTransaction.commit();
    }

}
