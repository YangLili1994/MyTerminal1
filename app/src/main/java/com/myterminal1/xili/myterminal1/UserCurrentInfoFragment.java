package com.myterminal1.xili.myterminal1;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/15.
 */
public class UserCurrentInfoFragment extends Fragment {

    private TextView username = null;
    private TextView userid = null;
    private TextView doornum = null;
    private TextView totalelectric = null;
    private TextView useraccount = null;
    private TextView accounttime = null;

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.currentinfofragment,container,false);

        String[] info = getArguments().getStringArray("info");

        username = (TextView)rootView.findViewById(R.id.user1_name);
        userid = (TextView)rootView.findViewById(R.id.user1_id);
        doornum = (TextView)rootView.findViewById(R.id.user1_door);
        totalelectric = (TextView)rootView.findViewById(R.id.user1_totalelectric);
        useraccount = (TextView)rootView.findViewById(R.id.user1_account);
        accounttime = (TextView)rootView.findViewById(R.id.user1_accounttime);

        username.setText(info[0]);
        userid.setText(info[1]);
        doornum.setText(info[2]);
        totalelectric.setText(info[3]);
        useraccount.setText(info[4]);
        accounttime.setText(info[5]);

        return rootView;
    }
}
