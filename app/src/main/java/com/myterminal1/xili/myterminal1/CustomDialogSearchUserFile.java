package com.myterminal1.xili.myterminal1;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/4/11.
 */
public class CustomDialogSearchUserFile extends Dialog {

    UserfilesDao dao = null;

    //自定义dialog监听器
    public interface SearchDialogListener{
        //回调函数，用于监听dialog操作的返回结果
        public void getSearchDialogResult(int resultCode,User user);
    }

    private SearchDialogListener dialogListener;

    public CustomDialogSearchUserFile(Context context, int themeResId) {
        super(context, themeResId);
    }
    //带监听器参数的构造函数
    public CustomDialogSearchUserFile(Context context, int themeResId,SearchDialogListener dialogListener) {
        super(context, themeResId);
        this.dialogListener = dialogListener;
    }

    public static  class Builder{

        private Context context;
        private SearchDialogListener dialogListener;
        private View contentView;
        //搜索到的用户信息
        private User user;

        public Builder(Context context,User user,SearchDialogListener dialogListener) {
            this.context = context;
            this.user = user;
            this.dialogListener = dialogListener;
        }

        /**
         * Set the Dialog view from resource
         *
         * @param contentView
         * @return
         */
        public Builder setContentview(View contentView) {
            this.contentView = contentView;
            return this;
        }

        public CustomDialogSearchUserFile create(){


            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final CustomDialogSearchUserFile customDialogSearchUserFile = new CustomDialogSearchUserFile(context,R.style.Dialog,dialogListener);
            View layout = inflater.inflate(R.layout.customdialog_searchuserfile,null);


            final TextView meteraddrTextView = ((TextView) layout.findViewById(R.id.search_meteraddr));
            final TextView meteridTextView  = ((TextView) layout.findViewById(R.id.search_meterid));
            final TextView useridTextView  = ((TextView) layout.findViewById(R.id.search_userid));
            final TextView useraddrTextView  = ((TextView) layout.findViewById(R.id.search_useraddr));
            final TextView doornumTextView  = ((TextView) layout.findViewById(R.id.search_doornum));


            customDialogSearchUserFile.setContentView(layout);
            //禁止软键盘自动弹出！！
            customDialogSearchUserFile.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

            meteraddrTextView.setText(user.getMeter_addr());
            meteridTextView.setText(user.getMeter_id());
            useridTextView.setText(user.getUser_id());
            useraddrTextView.setText(user.getUser_addr());
            doornumTextView.setText(user.getDoor_num());

            //电表地址作为唯一标识，默认不能更改
            meteraddrTextView.setEnabled(false);

            Button deleteButton = (Button)layout.findViewById(R.id.customdialog_searchuserfile_delete);
            Button updateButton = (Button)layout.findViewById(R.id.customdialog_searchuserfile_update);
            Button returnButton = (Button)layout.findViewById(R.id.customdialog_searchuserfile_return);
            //删除用户档案
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogListener.getSearchDialogResult(1,null);
                    customDialogSearchUserFile.dismiss();
                }
            });
            //更新用户档案
            updateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //获取待更新用户档案信息
                    String meter_addr = meteraddrTextView.getText().toString();
                    String meter_id = meteridTextView.getText().toString();
                    String user_id = useridTextView.getText().toString();
                    String user_addr = useraddrTextView.getText().toString();
                    String door_num = doornumTextView.getText().toString();
                    //检查输入信息是否完整
                    if(meter_addr.isEmpty()){
                        Toast.makeText(context,"请输入电表地址",Toast.LENGTH_SHORT).show();
                    }else if (meter_id.isEmpty()){
                        Toast.makeText(context,"请输入电表编号",Toast.LENGTH_SHORT).show();
                    }else if (user_id.isEmpty()){
                        Toast.makeText(context,"请输入用户编号",Toast.LENGTH_SHORT).show();
                    }else if (user_addr.isEmpty()){
                        Toast.makeText(context,"请输入用户地址",Toast.LENGTH_SHORT).show();
                    }else if (door_num.isEmpty()){
                        Toast.makeText(context,"请输入门牌号",Toast.LENGTH_SHORT).show();
                    }else {
                        //传递给fragment更新用户信息用户档案
                        dialogListener.getSearchDialogResult(2,new User(meter_addr,meter_id,user_id,user_addr,door_num));
                        customDialogSearchUserFile.dismiss();
                    }

                }
            });
            //返回
            returnButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialogListener.getSearchDialogResult(0,null);
                    customDialogSearchUserFile.dismiss();
                }
            });

           // customDialogSearchUserFile.dialogListener.getDialogResult();

            return customDialogSearchUserFile;

        }


    }

    public boolean onTouchEvent(MotionEvent event) {
        if(null != this.getCurrentFocus()){
            /**
             * 点击空白位置 隐藏软键盘
             */
            InputMethodManager mInputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            return mInputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super .onTouchEvent(event);
    }


}
