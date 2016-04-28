package com.myterminal1.xili.myterminal1;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/9.
 */
public class UserfileFragment extends Fragment {
    private Button addUserButton = null;
    private SearchView searchView = null;
    private ListView listView = null;

    private Context context;

    List<User> users;
    List<Map<String,Object>> data;

    public UserfileFragment() {
       super();
    }

    public void setContext(Context context) {
        this.context = context;
    }


//    UserfilesDao dao = new UserfilesDao(MyApplication.getAppContext());
    UserfilesDao dao = null;

    public View onCreateView(LayoutInflater layoutInflater,ViewGroup container,Bundle savedInstanceState){

        View rootView = layoutInflater.inflate(R.layout.userfile_frament,container,false);


        //获得listview
        listView = (ListView)rootView.findViewById(R.id.listView_userfiles);



        addUserButton = (Button)rootView.findViewById(R.id.user_add);
        searchView = (SearchView)rootView.findViewById(R.id.searchview);


        //searchView.clearFocus();//清除焦点
        //设置searchview默认是否缩小为图标
        searchView.setIconifiedByDefault(false);
        //设置是否显示搜索按钮
        searchView.setSubmitButtonEnabled(true);
        //设置搜索框默认提示文字
        searchView.setQueryHint("请输入电表地址");
        //为searchview设置事件监听器
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //清除焦点
                searchView.clearFocus();
                final User selectedUser = dao.select(query);

                if (selectedUser == null){
                    Toast.makeText(getActivity(), "找不到该用户信息", Toast.LENGTH_SHORT).show();
                }else {

                    CustomDialogSearchUserFile.Builder builder = new CustomDialogSearchUserFile.Builder(getActivity(), selectedUser, new CustomDialogSearchUserFile.SearchDialogListener() {
                        @Override
                        public void getSearchDialogResult(int resultCode,User user) {
                            if(resultCode == 1){//删除用户
                                dao.delete(selectedUser.getMeter_addr());
                                //Toast.makeText(getActivity(), "删除用户成功！", Toast.LENGTH_SHORT).show();
                                Mytools.showMyToast("删除用户成功！",500);
                                showAllUsers();
                            }else if (resultCode == 2){//修改用户档案信息
                                dao.update(user);
                                //Toast.makeText(getActivity(), "更新用户成功！", Toast.LENGTH_SHORT).show();
                                Mytools.showMyToast("更新用户成功！", 500);
                                showAllUsers();
                            }
                        }
                    });
                    builder.create().show();

                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomDialogAddUserFile.Builder builder = new CustomDialogAddUserFile.Builder(getActivity(), new CustomDialogAddUserFile.DialogListener() {
                    @Override
                    public void getDialogResult(int result) {
                        if (result == 1){//添加用户成功
                            showAllUsers();
                        }

                    }
                });
                builder.create().show();

            }
        });



        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getActivity()要在onActivityCreated之后
        dao = new UserfilesDao(getActivity());

        showAllUsers();
    }

    public  void showAllUsers(){
        //获得listview
        //listView = (ListView)findViewById(R.id.listView_userfiles);
        //List<User> users = new ArrayList<>();
        users = new ArrayList<>();
        data = new ArrayList<>();

        Log.d("test","1");
        users = dao.getAllUsers();
        Log.d("test","2");
        for(User u : users){
            Map<String,Object> map = new HashMap<>();

            map.put("meter_addr",u.getMeter_addr());
            map.put("meter_id",u.getMeter_id());
            map.put("user_id",u.getUser_id());
            map.put("user_addr",u.getUser_addr());
            map.put("door_num",u.getDoor_num());

            data.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this.getActivity(),data,R.layout.userfile_item,
                new String[]{"meter_addr","meter_id","user_id","user_addr","door_num"},
                new int[]{R.id.meteraddr,R.id.meterid,R.id.userid,R.id.useraddr,R.id.doornum});
        listView.setAdapter(simpleAdapter);
    }

//    public boolean onTouchEvent(MotionEvent event) {
//        if(null != getActivity().getCurrentFocus()){
//            /**
//             * 点击空白位置 隐藏软键盘
//             */
//            InputMethodManager mInputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//            return mInputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
//        }
//        return super .onTouchEvent(event);
//    }
}
