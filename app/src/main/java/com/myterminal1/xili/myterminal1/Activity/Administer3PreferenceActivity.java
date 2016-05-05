package com.myterminal1.xili.myterminal1.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myterminal1.xili.myterminal1.R;

/**
 * Created by Administrator on 2016/4/11.
 */
public class Administer3PreferenceActivity  extends MyBaseActivity {
    private Button returnButton = null;
    private Button systemsettingsButton = null;
    private Button testchannelButton = null;
    private Button systemmaintainButton = null;

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
                systemsettingsButtonPressed();
                break;
            case "1":
                testchannelButtonPressed();
                break;
            case "2":
               systemmaintainButtonPressed();
                break;
            case "3":
                returnButtonPressed();
                break;
            default:
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administer3_preference);

        timedispText = (TextView)findViewById(R.id.administer3_preference_currenttime);
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));

        returnButton = (Button)findViewById(R.id.return6);
        systemsettingsButton = (Button)findViewById(R.id.systemsettingsbutton);
        systemmaintainButton = (Button)findViewById(R.id.systemmaintainbutton);
        testchannelButton = (Button)findViewById(R.id.testchannelbutton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnButtonPressed();
            }
        });

        systemsettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                systemsettingsButtonPressed();
            }
        });

        systemmaintainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                systemmaintainButtonPressed();
            }
        });

        testchannelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testchannelButtonPressed();
            }
        });
    }

    /**
     *返回上级菜单
     */
    void returnButtonPressed(){
        returnButton.setTextColor(getResources().getColor(R.color.blue));
        systemsettingsButton.setTextColor(getResources().getColor(R.color.black));
        systemmaintainButton.setTextColor(getResources().getColor(R.color.black));
        testchannelButton.setTextColor(getResources().getColor(R.color.black));

        finish();
    }
    /**
     *系统参数
     */
    void systemsettingsButtonPressed(){
        returnButton.setTextColor(getResources().getColor(R.color.black));
        systemsettingsButton.setTextColor(getResources().getColor(R.color.blue));
        systemmaintainButton.setTextColor(getResources().getColor(R.color.black));
        testchannelButton.setTextColor(getResources().getColor(R.color.black));
    }
    /**
     *系统维护
     */
    void systemmaintainButtonPressed(){
        returnButton.setTextColor(getResources().getColor(R.color.black));
        systemsettingsButton.setTextColor(getResources().getColor(R.color.black));
        systemmaintainButton.setTextColor(getResources().getColor(R.color.blue));
        testchannelButton.setTextColor(getResources().getColor(R.color.black));
    }
    /**
     *测试通道
     */
    void testchannelButtonPressed(){
        returnButton.setTextColor(getResources().getColor(R.color.black));
        systemsettingsButton.setTextColor(getResources().getColor(R.color.black));
        systemmaintainButton.setTextColor(getResources().getColor(R.color.black));
        testchannelButton.setTextColor(getResources().getColor(R.color.blue));
    }
}
