package com.myterminal1.xili.myterminal1.Driver;

import android.util.Log;

/**
 * Created by WangTao on 2016/5/4.
 */
public class Key {
    public static final int PRESSED = 0;
    public static final int UNPRESSED = 1;

    /* 判断按键0是否被按下一次，是的话返回1， 否的话返回0 */
    public static int Key0isPressed(){
        int status;
        status = Key.readKey0Status();
        /* 如果按键被按下，进入此if语句，并在按键被松开时返回1； 如果按键没有被按下，返回0 */
        if (status == Key.PRESSED){
            while (Key.readKey0Status() == Key.PRESSED)
                continue;
            if(Key.readKey0Status() == Key.UNPRESSED)
            return 1;
        }
        return 0;
    }

    /* 判断按键1是否被按下一次 */
    public static int Key1isPressed(){
        int status;
        status = Key.readKey1Status();
        /* 如果按键被按下，进入此if语句，并在按键被松开时返回1； 如果按键没有被按下，返回0 */
        if (status == Key.PRESSED){
            while (Key.readKey0Status() == Key.PRESSED)
                continue;
            if(Key.readKey0Status() == Key.UNPRESSED)
                return 1;
        }
        return 0;
    }

    /* 判断按键是否被按下一次 */
    public static int Key2isPressed(){
        int status;
        status = Key.readKey2Status();
        /* 如果按键被按下，进入此if语句，并在按键被松开时返回1； 如果按键没有被按下，返回0 */
        if (status == Key.PRESSED){
            while (Key.readKey0Status() == Key.PRESSED)
                continue;
            if(Key.readKey0Status() == Key.UNPRESSED)
                return 1;
        }
        return 0;
    }

    //读取按键的当前值，按下为0 ，松开为1
    public static native int readKey0Status();
    public static native int readKey1Status();
    public static native int readKey2Status();
    public static native int readKey3Status();

    public static native void setKey0Status(int status);
    public static native void setKey1Status(int status);
    public static native void setKey2Status(int status);
    public static native void setKey3Status(int status);

    static{
        System.loadLibrary("Hardware");
    }
}
