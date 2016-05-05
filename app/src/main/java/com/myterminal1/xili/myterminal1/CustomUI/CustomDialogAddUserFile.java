package com.myterminal1.xili.myterminal1.CustomUI;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.myterminal1.xili.myterminal1.R;
import com.myterminal1.xili.myterminal1.Entity.User;
import com.myterminal1.xili.myterminal1.db.UserfilesDao;

/**
 * Created by Administrator on 2016/4/9.
 */
public class CustomDialogAddUserFile extends Dialog{
    /**
     * 自定义dialog监听器接口
     */
    public interface DialogListener {
        /**
         * 回调函数，用于监听dialog操作的返回结果
         */
        public  void getDialogResult(int result);
    }

    public DialogListener dialoglistener;


    public CustomDialogAddUserFile(Context context) {
        super(context);
    }

    /**
     * 带监听器参数的构造函数
     */
    public CustomDialogAddUserFile(Context context, int themeResId,DialogListener dialogListener) {
        super(context, themeResId);
        this.dialoglistener = dialoglistener;
    }

    public static class Builder{
        private Context context;

        private DialogListener dialoglistener;

        private View contentview;

        public Builder(Context context,DialogListener dialogListener) {
            this.context = context;
            this.dialoglistener = dialogListener;
        }


        /**
         * Set the Dialog view from resource
         *
         * @param contentview
         * @return
         */
        public Builder setContentview(View contentview) {
            this.contentview = contentview;
            return this;
        }

        public CustomDialogAddUserFile create() {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final CustomDialogAddUserFile dialogAddUserFile = new CustomDialogAddUserFile(context, R.style.Dialog,dialoglistener);
            final View layout = layoutInflater.inflate(R.layout.customdialog_adduserfile, null);
            dialogAddUserFile.addContentView(layout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            //点击取消
            ((Button) layout.findViewById(R.id.customdialog_adduserfile_add_cancel)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialoglistener.getDialogResult(0);
                    dialogAddUserFile.dismiss();
                }
            });

            //点击确定
            ((Button) layout.findViewById(R.id.customdialog_adduserfile_add_yes)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    UserfilesDao dao = null;
                    dao = new UserfilesDao(context);

                    //获取待添加用户档案信息
                    String meter_addr = ((TextView)layout.findViewById(R.id.add_meteraddr)).getText().toString();
                    String meter_id = ((TextView)layout.findViewById(R.id.add_meterid)).getText().toString();
                    String user_id = ((TextView)layout.findViewById(R.id.add_userid)).getText().toString();
                    String user_addr = ((TextView)layout.findViewById(R.id.add_useraddr)).getText().toString();
                    String door_num = ((TextView)layout.findViewById(R.id.add_doornum)).getText().toString();
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
                        //添加用户档案
                        dao.add(new User(meter_addr,meter_id,user_id,user_addr,door_num));
                        Toast.makeText(context,"添加用户成功",Toast.LENGTH_SHORT).show();
                        //添加成功，传递数值1   刷新listview
                        dialoglistener.getDialogResult(1);
                        dialogAddUserFile.dismiss();
                    }
                }
            });

            dialogAddUserFile.setContentView(layout);
            //禁止软键盘自动弹出！！
            dialogAddUserFile.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

            return dialogAddUserFile;
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
