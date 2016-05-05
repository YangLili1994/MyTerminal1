package com.myterminal1.xili.myterminal1.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myterminal1.xili.myterminal1.Fragment.BasicInfoFragment;
import com.myterminal1.xili.myterminal1.Fragment.CommunicationPreferenceFragment;
import com.myterminal1.xili.myterminal1.R;
import com.myterminal1.xili.myterminal1.Fragment.UserfileFragment;

/**
 * Created by Administrator on 2016/4/8.
 */
public class Administer3TerminalInfoActivity extends MyBaseActivity{

    private Button basicinfoButton = null;
    private Button fileButton = null;
    private Button communicationparameterButton = null;
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
                basicinfoButtonPressed();
                break;
            case "1":
                fileButtonPressed();
                break;
            case "2":
                communicationparameterButtonPressed();
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
        setContentView(R.layout.administer3_terminalinfo);

        timedispText = (TextView)findViewById(R.id.administer3_terminalinfo_currenttime);
        timedispText.setText("  " + MainActivity.getCurrentTime());
        timedispText.setTextColor(getResources().getColor(R.color.dodgerblue));

        basicinfoButton = (Button)findViewById(R.id.basicinfobutton);
        fileButton = (Button)findViewById(R.id.filebutton);
        communicationparameterButton = (Button)findViewById(R.id.communicationparametersbutton);
        returnButton = (Button)findViewById(R.id.return5);

        basicinfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basicinfoButtonPressed();
            }
        });
        //用户档案查询与操作
        fileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileButtonPressed();
            }
        });

        communicationparameterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                communicationparameterButtonPressed();
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnButtonPressed();
            }
        });
    }

    /**
     * 基本信息
     */
    void basicinfoButtonPressed(){
        basicinfoButton.setTextColor(getResources().getColor(R.color.blue));
        fileButton.setTextColor(getResources().getColor(R.color.black));
        communicationparameterButton.setTextColor(getResources().getColor(R.color.black));
        returnButton.setTextColor(getResources().getColor(R.color.black));

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BasicInfoFragment basicInfoFragment = new BasicInfoFragment();
        fragmentTransaction.replace(R.id.administer3_info_maindisp, basicInfoFragment);
        fragmentTransaction.commit();
    }
    /**
     *用户档案信息
     */
    void fileButtonPressed(){
        basicinfoButton.setTextColor(getResources().getColor(R.color.black));
        fileButton.setTextColor(getResources().getColor(R.color.blue));
        communicationparameterButton.setTextColor(getResources().getColor(R.color.black));
        returnButton.setTextColor(getResources().getColor(R.color.black));

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        UserfileFragment userfileFragment = new UserfileFragment();
        userfileFragment.setContext(getApplicationContext());
        fragmentTransaction.replace(R.id.administer3_info_maindisp,userfileFragment);
        fragmentTransaction.commit();
    }
    /**
     *通讯参数
     */
    void communicationparameterButtonPressed(){
        basicinfoButton.setTextColor(getResources().getColor(R.color.black));
        fileButton.setTextColor(getResources().getColor(R.color.black));
        communicationparameterButton.setTextColor(getResources().getColor(R.color.blue));
        returnButton.setTextColor(getResources().getColor(R.color.black));

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CommunicationPreferenceFragment fragment = new CommunicationPreferenceFragment();
        fragmentTransaction.replace(R.id.administer3_info_maindisp, fragment);
        fragmentTransaction.commit();
    }
    /**
     *返回上级菜单
     */
    void returnButtonPressed(){
        basicinfoButton.setTextColor(getResources().getColor(R.color.black));
        fileButton.setTextColor(getResources().getColor(R.color.black));
        communicationparameterButton.setTextColor(getResources().getColor(R.color.black));
        returnButton.setTextColor(getResources().getColor(R.color.blue));

        finish();
    }

}
