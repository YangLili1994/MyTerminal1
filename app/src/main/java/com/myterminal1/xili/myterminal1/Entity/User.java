package com.myterminal1.xili.myterminal1.Entity;

/**
 * Created by Administrator on 2016/4/8.
 */
public class User {
    private String meter_addr;//表地址,用于用户档案的匹配
    private String meter_id;//表编号
    private String user_id;//用户编号
    private String user_addr;//地址
    private String door_num;//门牌号

    public User(String meter_addr,String meter_id,String user_id,String user_addr,String door_num){
        super();
        this.meter_addr = meter_addr;
        this.meter_id = meter_id;
        this.user_id = user_id;
        this.user_addr = user_addr;
        this.door_num = door_num;
    }

    public String getMeter_addr() {
        return meter_addr;
    }

    public void setMeter_addr(String meter_addr) {
        this.meter_addr = meter_addr;
    }

    public String getMeter_id() {
        return meter_id;
    }

    public void setMeter_id(String meter_id) {
        this.meter_id = meter_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_addr() {
        return user_addr;
    }

    public void setUser_addr(String user_addr) {
        this.user_addr = user_addr;
    }

    public String getDoor_num() {
        return door_num;
    }

    public void setDoor_num(String door_num) {
        this.door_num = door_num;
    }
}
