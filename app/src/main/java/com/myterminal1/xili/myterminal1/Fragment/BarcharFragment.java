package com.myterminal1.xili.myterminal1.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.myterminal1.xili.myterminal1.R;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Administrator on 2016/3/22.
 */
public class BarcharFragment extends Fragment {

    public BarChart barChart;
    public ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
    public BarDataSet dataset;
    public ArrayList<String> labels = new ArrayList<String>();

    private int currentMonth;
    private int currentYear;
    private int currentDay;
    private int lastMonthLastDay;

    private TextView usernameText = null;
    private TextView usernumText = null;
    private TextView dooridText = null;

    private float[] records;
    private String[] months = {"12","01","02","03","04","05","06","07","08","09","10","11"};

    public BarcharFragment(){}

    public static Fragment newInstance(float[] records){
        BarcharFragment barcharFragment = new BarcharFragment();
        Bundle bundle = new Bundle();
        bundle.putFloatArray("records", records);
        barcharFragment.setArguments(bundle);
        return barcharFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bar_chart, container, false);
        barChart = (BarChart) view.findViewById(R.id.bar_chart);
        records = this.getArguments().getFloatArray("records");
        //显示用户信息
        usernameText = (TextView) view.findViewById(R.id.historyrecord_username);
        usernumText = (TextView) view.findViewById(R.id.historyrecord_usernum);
        dooridText = (TextView) view.findViewById(R.id.historyrecord_doorid);

        usernameText.setText("客户名称："+"张三");
        usernumText.setText("户号："+"001");
        dooridText.setText("门牌号："+"101");
        //获取当前年月日
        Calendar calendar = Calendar.getInstance();
        currentMonth = calendar.get(Calendar.MONTH)+1;
        currentYear = calendar.get(Calendar.YEAR);
        currentDay = calendar.get(Calendar.DATE);
        //获取上个月最后一天的日期
        calendar.add(Calendar.DATE,-calendar.get(Calendar.DAY_OF_MONTH));
        lastMonthLastDay = calendar.get(Calendar.DATE);
        Log.d("BarcharFragment", "currentday" + currentDay);
        Log.d("BarcharFragment", "lastMonthLastDay" + lastMonthLastDay);

        //因为records[]为float，不能用switch语句
        if (records[0] == 0){//查询最近六个月
            initEntriesData();
            initLableData();
        }else if (records[0] == 1){//查询最近7天
            initEntriesData1();
            initLableData1();
        }else if (records[0] == 2){//查询最近3个月
            initEntriesData2();
            initLableData2();
        }

        show();

        return view;
    }

    public void initEntriesData() {//查询最近六个月
        entries.add(new BarEntry(records[1], 0));
        entries.add(new BarEntry(records[2], 1));
        entries.add(new BarEntry(records[3], 2));
        entries.add(new BarEntry(records[4], 3));
        entries.add(new BarEntry(records[5], 4));
        entries.add(new BarEntry(records[6], 5));
    }
    public void initEntriesData1() {//查询最近7天
        entries.add(new BarEntry(records[1], 0));
        entries.add(new BarEntry(records[2], 1));
        entries.add(new BarEntry(records[3], 2));
        entries.add(new BarEntry(records[4], 3));
        entries.add(new BarEntry(records[5], 4));
        entries.add(new BarEntry(records[6], 5));
        entries.add(new BarEntry(records[7], 6));
    }
    public void initEntriesData2() {//查询最近3个月
        entries.add(new BarEntry(records[1], 0));
        entries.add(new BarEntry(records[2], 1));
        entries.add(new BarEntry(records[3], 2));
    }

    public void initLableData() {//查询最近六个月
        for(int i=6;i>0;i--){
            if((currentMonth - i) > 0){
                labels.add(""+currentYear+"."+months[currentMonth-i]);
            }else{
                labels.add(""+(currentYear -1)+"."+months[(currentMonth-i+12)%12]);
            }

        }
//        if(currentMonth - 6 > 0) labels.add(""+currentYear+"."+months[currentMonth-6]);
//        else labels.add(""+(currentYear -1)+"."+months[(currentMonth-6+12)%12]);
//
//        if(currentMonth - 5 > 0) labels.add(""+currentYear+"."+months[currentMonth-5]);
//        else labels.add(""+(currentYear -1)+"."+months[(currentMonth-5+12)%12]);
//
//        if(currentMonth - 4 > 0) labels.add(""+currentYear+"."+months[currentMonth-4]);
//        else labels.add(""+(currentYear -1)+"."+months[(currentMonth-4+12)%12]);
//
//        if(currentMonth - 3 > 0) labels.add(""+currentYear+"."+months[currentMonth-3]);
//        else labels.add(""+(currentYear -1)+"."+months[(currentMonth-3+12)%12]);
//
//        if(currentMonth - 2 > 0) labels.add(""+currentYear+"."+months[currentMonth-2]);
//        else labels.add(""+(currentYear -1)+"."+months[(currentMonth-2+12)%12]);
//
//        if(currentMonth - 1 > 0) labels.add(""+currentYear+"."+months[currentMonth-1]);
//        else labels.add(""+(currentYear -1)+"."+months[(currentMonth-1+12)%12]);
    }

    public void initLableData1() {//查询最近7天
        for(int i=7;i>0;i--){
        if(currentDay-i>0){
            labels.add(""+currentYear+"."+currentMonth+"."+(currentDay-i));
        }else{
            if (currentMonth == 1){//当前月份为1月，前推7天，则变为上一年12月
                    labels.add("" + (currentYear - 1) + "." + 12 + "." + (31 - (i - currentDay)));
            }else{
                    labels.add("" + currentYear + "." + (currentMonth-1) + "." + (lastMonthLastDay - (i - currentDay)));
            }
        }

        }
    }
    public void initLableData2() {//查询最近3个月
        for(int i=3;i>0;i--){
            if((currentMonth - i) > 0){
                labels.add(""+currentYear+"."+months[currentMonth-i]);
            }else{
                labels.add(""+(currentYear -1)+"."+months[(currentMonth-i+12)%12]);
            }
        }
    }

    public void show() {
        //计算最大显示值和显示列数
        dataset = new BarDataSet(entries, "");
        //dataset = new BarDataSet(entries, "# of Calls");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        BarData data = new BarData(labels, dataset);
        LimitLine line = new LimitLine(10f);

        //Legend legend = new Legend();
       // legend.setFormSize(20);
       // line.setTextSize(6f);

        //Paint paint = new Paint();
        //paint.setTextSize(40);
        //line.setTextStyle(paint.sty);
        barChart.setData(data);

        //barChart.setTextAlignment();

//      chart.animateXY(5000,5000);
//      chart.animateX(5000);
        //y轴上产生动态效果
        barChart.animateY(2000);
       // barChart.setDescription("历史用电信息");
       // Log.d("BarcharFragment","show");
    }
}
