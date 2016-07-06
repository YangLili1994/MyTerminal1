package com.myterminal1.xili.myterminal1.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.myterminal1.xili.myterminal1.R;

/**
 * Created by Administrator on 2016/5/17.
 */
public class JianhangPayActivity extends Activity {

    private WebView payInterface = null;
    private static final String jianhangUrl = "http://www.ccbjf.com/Frontpage/index_service_list.jsp?a_id=Ng~~";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.jianhang_interface);

        payInterface = (WebView)findViewById(R.id.jianhang_web);

        payInterface.getSettings().setJavaScriptEnabled(true);
        payInterface.setWebViewClient(new WebViewClient());
        payInterface.loadUrl(jianhangUrl);


    }
}
