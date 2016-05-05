package com.myterminal1.xili.myterminal1.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 2016/4/8.
 */
public class DBHelper extends SQLiteOpenHelper {
    final String CREATE_TABLE_SQL = "CREATE TABLE userfiles"
            +"("
            +"id integer primary key,"
            +"meter_addr String,"
            +"meter_id String,"
            +"user_id String,"
            +"user_addr String,"
            +"door_num String"
            +")";
    public DBHelper(Context context) {
        super(context, "userfiles.db", null, 1);
    }
    public void onCreate(SQLiteDatabase db){
        //第一次使用数据库时自动建表
        db.execSQL(CREATE_TABLE_SQL);
        Log.d("DBHelper", "数据库创建正确");
        Log.d("test","0");
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        System.out.println("--------update called!----------");
    }

}
