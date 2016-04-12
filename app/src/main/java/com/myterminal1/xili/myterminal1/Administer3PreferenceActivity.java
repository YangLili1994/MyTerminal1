package com.myterminal1.xili.myterminal1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/4/11.
 */
public class Administer3PreferenceActivity  extends Activity {
    private Button returnButton = null;
    private Button systemsettingsButton = null;
    private Button testchannelButton = null;
    private Button systemmaintainButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administer3_preference);

        returnButton = (Button)findViewById(R.id.return6);
        systemsettingsButton = (Button)findViewById(R.id.systemsettingsbutton);
        systemmaintainButton = (Button)findViewById(R.id.systemmaintainbutton);
        testchannelButton = (Button)findViewById(R.id.testchannelbutton);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnButton.setTextColor(getResources().getColor(R.color.blue));
                systemsettingsButton.setTextColor(getResources().getColor(R.color.black));
                systemmaintainButton.setTextColor(getResources().getColor(R.color.black));
                testchannelButton.setTextColor(getResources().getColor(R.color.black));

                finish();
            }
        });

        systemsettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnButton.setTextColor(getResources().getColor(R.color.black));
                systemsettingsButton.setTextColor(getResources().getColor(R.color.blue));
                systemmaintainButton.setTextColor(getResources().getColor(R.color.black));
                testchannelButton.setTextColor(getResources().getColor(R.color.black));

            }
        });

        systemmaintainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnButton.setTextColor(getResources().getColor(R.color.black));
                systemsettingsButton.setTextColor(getResources().getColor(R.color.black));
                systemmaintainButton.setTextColor(getResources().getColor(R.color.blue));
                testchannelButton.setTextColor(getResources().getColor(R.color.black));

            }
        });

        testchannelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returnButton.setTextColor(getResources().getColor(R.color.black));
                systemsettingsButton.setTextColor(getResources().getColor(R.color.black));
                systemmaintainButton.setTextColor(getResources().getColor(R.color.black));
                testchannelButton.setTextColor(getResources().getColor(R.color.blue));

            }
        });

    }
}
