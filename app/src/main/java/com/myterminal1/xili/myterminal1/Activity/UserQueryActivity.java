package com.myterminal1.xili.myterminal1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myterminal1.xili.myterminal1.R;

/**
 * Created by Administrator on 2016/4/7.
 */
public class UserQueryActivity  extends MyBaseActivity {
    private Button returnreturnButton = null;
    private Button currentrecordButton = null;
    private Button historyrecordButton = null;
    private Button chargerecordButton = null;

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
                Log.d("Key", "UserQueryActivity: 0 PressedOnce");
                currentrecordButtonPressed();
                break;
            case "1":
                Log.d("Key", "UserQueryActivity: 1 PressedOnce");
                historyrecordButtonPressed();
                break;
            case "2":
                Log.d("Key", "UserQueryActivity: 2 PressedOnce");
                chargerecordButtonPressed();
                break;
            case "3":
                Log.d("Key", "UserQueryActivity: 3 PressedOnce");
                returnreturnButtonPressed();
                break;
            default:
                break;
        }
    }


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_query);

        timedispText = (TextView)findViewById(R.id.user_query_currenttime);
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));

        returnreturnButton = (Button)findViewById(R.id.return1);
        currentrecordButton = (Button)findViewById(R.id.currentrecord);
        historyrecordButton = (Button)findViewById(R.id.historyrecord);
        chargerecordButton = (Button)findViewById(R.id.chargerecord);

        currentrecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentrecordButtonPressed();
            }
        });

        historyrecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyrecordButtonPressed();
            }
        });

        chargerecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chargerecordButtonPressed();
            }
        });

        returnreturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnreturnButtonPressed();
            }
        });

    }
    void currentrecordButtonPressed(){
        returnreturnButton.setTextColor(getResources().getColor(R.color.black));
        currentrecordButton.setTextColor(getResources().getColor(R.color.blue));
        historyrecordButton.setTextColor(getResources().getColor(R.color.black));
        chargerecordButton.setTextColor(getResources().getColor(R.color.black));

        startActivity(new Intent(UserQueryActivity.this,UserCurrentInfoActivity.class));
    }
    void historyrecordButtonPressed(){
        returnreturnButton.setTextColor(getResources().getColor(R.color.black));
        currentrecordButton.setTextColor(getResources().getColor(R.color.black));
        historyrecordButton.setTextColor(getResources().getColor(R.color.blue));
        chargerecordButton.setTextColor(getResources().getColor(R.color.black));

        startActivity(new Intent(UserQueryActivity.this, UserHistoryRecordActivity.class));
    }
    void chargerecordButtonPressed(){
        returnreturnButton.setTextColor(getResources().getColor(R.color.black));
        currentrecordButton.setTextColor(getResources().getColor(R.color.black));
        historyrecordButton.setTextColor(getResources().getColor(R.color.black));
        chargerecordButton.setTextColor(getResources().getColor(R.color.blue));

        startActivity(new Intent(UserQueryActivity.this, UserChargeRecordActivity.class));
    }
    void returnreturnButtonPressed(){
        returnreturnButton.setTextColor(getResources().getColor(R.color.blue));
        currentrecordButton.setTextColor(getResources().getColor(R.color.black));
        historyrecordButton.setTextColor(getResources().getColor(R.color.black));
        chargerecordButton.setTextColor(getResources().getColor(R.color.black));

        finish();
    }


    public void onResume(){
        super.onResume();
        returnreturnButton.setTextColor(getResources().getColor(R.color.black));
        currentrecordButton.setTextColor(getResources().getColor(R.color.black));
        historyrecordButton.setTextColor(getResources().getColor(R.color.black));
        chargerecordButton.setTextColor(getResources().getColor(R.color.black));
    }
}
