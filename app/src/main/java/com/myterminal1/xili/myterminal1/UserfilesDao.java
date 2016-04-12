package com.myterminal1.xili.myterminal1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户档案基本操作（增、删、改、查）类
 * Created by Administrator on 2016/4/8.
 */
public class UserfilesDao {
    private SQLiteDatabase db;
    public DBHelper dbHelper;

    //构造方法，带有context参数，以便下一对象操作
    public UserfilesDao(Context context) {
        dbHelper = new DBHelper(context);

    }
    /**
     * 添加用户
     * @param user
     */
    public void add(User user){
        String sql = "insert into userfiles(meter_addr,meter_id,user_id,user_addr,door_num) " +
                "values(?,?,?,?,?)";
        //得到SQLite数据库
        db = dbHelper.getWritableDatabase();
        //执行sql语句
        db.execSQL(sql,new String[]{user.getMeter_addr(),user.getMeter_id(),user.getUser_id(),user.getUser_addr(),user.getDoor_num()});
    }
    /**
     * 根据表地址删除用户
     * @param meter_addr
     */
    public void delete(String meter_addr){
        String sql = "delete from userfiles where meter_addr = ?";
        //得到SQLite数据库
        db = dbHelper.getWritableDatabase();
        //执行sql语句
        db.execSQL(sql,new String[]{meter_addr});
    }
    /**
     * 根据表地址更新用户信息（这里假定表地址作为身份标识，不可变。其他属性可变）
     * @param user
     */
    public void update(User user){
        String sql = "update userfiles set meter_id=?,user_id=?,user_addr=?,door_num=?" +
                "where meter_addr = ?";
        //得到SQLite数据库
        db = dbHelper.getWritableDatabase();
        //执行sql语句
        db.execSQL(sql,new String[]{user.getMeter_id(),user.getUser_id(),user.getUser_addr(),user.getDoor_num(),user.getMeter_addr()});
    }
    /**
     * 根据表地址查询用户信息
     * @param meter_addr
     * @return User
     */
    public User select(String meter_addr){
        User user =null;
        String sql = "select * from userfiles where meter_addr = ?";
        //得到SQLite数据库
        db = dbHelper.getWritableDatabase();
        //执行行查询语句,返回符合条件的行集合
        Cursor cursor = db.rawQuery(sql, new String[]{meter_addr});
        //表地址作为唯一标识，最多只能返回一行数据
        if(cursor.moveToFirst()){//查询到有数据
            String meter_id = cursor.getString(cursor.getColumnIndex("meter_id"));
            String user_id = cursor.getString(cursor.getColumnIndex("user_id"));
            String user_addr = cursor.getString(cursor.getColumnIndex("user_addr"));
            String door_num = cursor.getString(cursor.getColumnIndex("door_num"));

            user = new User(meter_addr,meter_id,user_id,user_addr,door_num);
        }
        return user;
    }
    /**
     * 获取所有的用户信息
     * @return List<User>
     */
    public List<User> getAllUsers(){
        List<User> list = new ArrayList<>();
        Log.d("test","getdb?");
        db = dbHelper.getReadableDatabase();
        Log.d("test","getdb");
        //返回所有用户信息的行集合
        Cursor cursor = db.rawQuery("select * from userfiles", null);
        //遍历每一行
        while (cursor.moveToNext()){
            String meter_addr = cursor.getString(cursor.getColumnIndex("meter_addr"));
            String meter_id = cursor.getString(cursor.getColumnIndex("meter_id"));
            String user_id = cursor.getString(cursor.getColumnIndex("user_id"));
            String user_addr = cursor.getString(cursor.getColumnIndex("user_addr"));
            String door_num = cursor.getString(cursor.getColumnIndex("door_num"));

            list.add(new User(meter_addr,meter_id,user_id,user_addr,door_num));
        }

        return list;
    }

}
