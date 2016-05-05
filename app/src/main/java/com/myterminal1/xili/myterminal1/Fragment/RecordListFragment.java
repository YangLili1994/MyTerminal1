package com.myterminal1.xili.myterminal1.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.myterminal1.xili.myterminal1.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/31.
 */
public class RecordListFragment extends Fragment {
    List<Map<String,Object>> record;

    public static Fragment newInstance(int type){
        RecordListFragment recordListFragment = new RecordListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type",type);
        recordListFragment.setArguments(bundle);
        return recordListFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater,ViewGroup container,Bundle savedInstanceState){
        int type = this.getArguments().getInt("type");
        View rootView = null;

        switch (type){
            case 1://充值记录
            {
                rootView = layoutInflater.inflate(R.layout.chongzhirecordfragment,container,false);
                TextView record_usernameText = (TextView)rootView.findViewById(R.id.record_username);
                TextView record_usernumText = (TextView)rootView.findViewById(R.id.record_usernum);
                TextView record_dooridText = (TextView)rootView.findViewById(R.id.record_doorid);
                record_usernameText.setText("客户名称："+"张三");
                record_usernumText.setText("户号："+"001");
                record_dooridText.setText("门牌号："+"101");

                ListView listView = (ListView)rootView.findViewById(R.id.recordlist);

                record = new ArrayList<>();
                Map<String, Object> map = new HashMap<>();
                map.put("num", "充值记录");
                map.put("chargetime", "充值时间");
                map.put("chargemoney", "充值金额");
                map.put("beforeaccount", "充值前金额");
                map.put("afteraccount", "充值后金额");
                record.add(map);

                String[] time = {"2015-01-01", "2015-02-10", "2015-03-15", "2015-05-01", "2015-06-21", "2015-08-10", "2015-10-01",
                        "2015-12-11", "2016-01-25", "2016-03-01"};
                String[] chargemoney = {"200", "300", "500", "300", "200", "500", "600", "200", "300", "500"};
                String[] beforeaccount = {"110", "30", "80", "60", "76", "92", "12", "20", "15", "63"};
                for (int i = 1; i < 11; i++) {
                    Map<String, Object> map1 = new HashMap<>();
                    map1.put("num", String.valueOf(i));
                    map1.put("chargetime", time[i - 1]);
                    map1.put("chargemoney", chargemoney[i - 1]);
                    map1.put("beforeaccount", beforeaccount[i - 1]);
                    map1.put("afteraccount", String.valueOf(Integer.valueOf(chargemoney[i - 1]) + Integer.valueOf(beforeaccount[i - 1])));
                    record.add(map1);
                }

                Map<String, Object> map2 = new HashMap<>();
                map2.put("num", "  ");
                map2.put("chargetime", " ");
                map2.put("chargemoney", " ");
                map2.put("beforeaccount", " ");
                map2.put("afteraccount", " ");
                record.add(map2);

                SimpleAdapter adapter;
                adapter = new SimpleAdapter(getActivity(), record, R.layout.chargerecord_item,
                        new String[]{"num", "chargetime", "chargemoney", "beforeaccount", "afteraccount"},
                        new int[]{R.id.num, R.id.record_chargetime, R.id.record_chargemoney, R.id.record_beforechargemoney, R.id.record_afterchargemoney});
                listView.setAdapter(adapter);

                break;
            }

            case 2://复电记录
            {
                rootView = layoutInflater.inflate(R.layout.fudianrecordfragment,container,false);
                TextView record1_usernameText = (TextView)rootView.findViewById(R.id.record1_username);
                TextView record1_usernumText = (TextView)rootView.findViewById(R.id.record1_usernum);
                TextView record1_dooridText = (TextView)rootView.findViewById(R.id.record1_doorid);
                record1_usernameText.setText("客户名称："+"张三");
                record1_usernumText.setText("户号："+"001");
                record1_dooridText.setText("门牌号："+"101");

                ListView listView = (ListView)rootView.findViewById(R.id.recordlist1);

                record = new ArrayList<>();
                Map<String, Object> map = new HashMap<>();
                map.put("fudiannum", "复电记录");
                map.put("fudiantime", "复电时间");
                record.add(map);

                String[] fudiantime = {"2015-01-01", "2015-02-10", "2015-03-15", "2015-05-01", "2015-06-21", "2015-08-10", "2015-10-01",
                        "2015-12-11", "2016-01-25", "2016-03-01"};
                for (int i = 1; i < 11; i++) {
                    Map<String, Object> map1 = new HashMap<>();
                    map1.put("fudiannum", String.valueOf(i));
                    map1.put("fudiantime", fudiantime[i - 1]);
                    record.add(map1);
                }

                Map<String, Object> map2 = new HashMap<>();
                map2.put("fudiannum", "  ");
                map2.put("fudiantime", " ");
                record.add(map2);

                SimpleAdapter adapter;
                adapter = new SimpleAdapter(getActivity(), record, R.layout.fudianrecord_item,
                        new String[]{"fudiannum", "fudiantime"},
                        new int[]{R.id.fudiannum, R.id.record_fudiantime});
                listView.setAdapter(adapter);

                break;
            }
            case 3:
            {
                rootView = layoutInflater.inflate(R.layout.qianfeirecordfragment,container,false);

                TextView record2_usernameText = (TextView)rootView.findViewById(R.id.record2_username);
                TextView record2_usernumText = (TextView)rootView.findViewById(R.id.record2_usernum);
                TextView record2_dooridText = (TextView)rootView.findViewById(R.id.record2_doorid);
                record2_usernameText.setText("客户名称："+"张三");
                record2_usernumText.setText("户号："+"001");
                record2_dooridText.setText("门牌号："+"101");

                ListView listView = (ListView)rootView.findViewById(R.id.recordlist2);
                //以下需要修改
                record = new ArrayList<>();
                Map<String, Object> map = new HashMap<>();
                map.put("qianfeinum", "欠费停电记录");
                map.put("qianfeitime", "欠费停电时间");
                map.put("qianfeimoney", "欠费金额");
                record.add(map);

                String[] qianfeitime = {"2015-01-01", "2015-02-10", "2015-03-15", "2015-05-01", "2015-06-21", "2015-08-10", "2015-10-01",
                        "2015-12-11", "2016-01-25", "2016-03-01"};
                String[] qianfeimoney = {"-20", "-30", "-50", "-30", "-20", "-15", "-60", "-20", "-100", "-50"};
                for (int i = 1; i < 11; i++) {
                    Map<String, Object> map1 = new HashMap<>();
                    map1.put("qianfeinum", String.valueOf(i));
                    map1.put("qianfeitime", qianfeitime[i - 1]);
                    map1.put("qianfeimoney", qianfeimoney[i - 1]);
                    record.add(map1);
                }

                Map<String, Object> map2 = new HashMap<>();
                map2.put("qianfeinum", "  ");
                map2.put("qianfeitime", " ");
                map2.put("qianfeimoney", " ");
                record.add(map2);

                SimpleAdapter adapter;
                adapter = new SimpleAdapter(getActivity(), record, R.layout.qianfeirecord_item,
                        new String[]{"qianfeinum", "qianfeitime","qianfeimoney"},
                        new int[]{R.id.qianfeinum, R.id.record_qianfeitime,R.id.record_qianfeimoney});
                listView.setAdapter(adapter);

                break;

            }
            default: break;


        }
        return rootView;
    }
}
