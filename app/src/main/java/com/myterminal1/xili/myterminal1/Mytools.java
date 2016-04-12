package com.myterminal1.xili.myterminal1;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/4/11.
 */
public class Mytools {
    /**
     * 自定义toast
     * @param message
     * @param duration
     */
    public static void showMyToast(String message,int duration){
        Toast toast = new Toast(MyApplication.getAppContext());
        LayoutInflater inflater = LayoutInflater.from(MyApplication.getAppContext());
        View view = inflater.inflate(R.layout.customtoast,null);
        TextView textView = (TextView)view.findViewById(R.id.mytoast);
        textView.setText(message);
        textView.setTextSize(35);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(view);
        toast.setDuration(duration);
        toast.show();
    }
}
