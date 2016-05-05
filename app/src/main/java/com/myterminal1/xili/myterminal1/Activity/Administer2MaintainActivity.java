package com.myterminal1.xili.myterminal1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myterminal1.xili.myterminal1.R;

/**
 * Created by Administrator on 2016/4/8.
 */
public class Administer2MaintainActivity extends MyBaseActivity {

    private Button infoButton = null;
    private Button preferenceButton = null;
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
                infoButtonPressed();
                break;
            case "1":
                preferenceButtonPressed();
                break;
            case "2":
                returnButtonPressed();
                break;
            default:
                break;
        }
    }

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administer2_maintain);

        timedispText = (TextView)findViewById(R.id.administer2_maintain_currenttime);
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));

        infoButton = (Button)findViewById(R.id.infobutton);
        preferenceButton = (Button)findViewById(R.id.preferencebutton);
        returnButton = (Button)findViewById(R.id.return4button);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoButtonPressed();
            }
        });

        preferenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferenceButtonPressed();
            }
        });
        //返回上一级菜单
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnButtonPressed();
            }
        });

    }
    /**
     *终端信息页面
     */
    void infoButtonPressed(){
        infoButton.setTextColor(getResources().getColor(R.color.blue));
        preferenceButton.setTextColor(getResources().getColor(R.color.black));
        returnButton.setTextColor(getResources().getColor(R.color.black));

        startActivity(new Intent(Administer2MaintainActivity.this,Administer3TerminalInfoActivity.class));
    }
    /**
     *参数设置页面
     */
    void preferenceButtonPressed(){
        infoButton.setTextColor(getResources().getColor(R.color.black));
        preferenceButton.setTextColor(getResources().getColor(R.color.blue));
        returnButton.setTextColor(getResources().getColor(R.color.black));

        startActivity(new Intent(Administer2MaintainActivity.this, Administer3PreferenceActivity.class));
    }
    /**
     *返回上级菜单
     */
    void returnButtonPressed(){
        infoButton.setTextColor(getResources().getColor(R.color.black));
        preferenceButton.setTextColor(getResources().getColor(R.color.black));
        returnButton.setTextColor(getResources().getColor(R.color.blue));

        finish();
    }

    public void onResume(){
        super.onResume();

        infoButton.setTextColor(getResources().getColor(R.color.black));
        preferenceButton.setTextColor(getResources().getColor(R.color.black));
        returnButton.setTextColor(getResources().getColor(R.color.black));


    }
}
