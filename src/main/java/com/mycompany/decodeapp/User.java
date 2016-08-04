package com.mycompany.decodeapp;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userlogin")
@SessionScoped

public class User implements Serializable {

    private String name;
    private int key;
    private String msg;

//Settersssssssss
    public void setName(String name) {
        this.name = name;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//Getterssssssss
    public String getName() {
        return this.name;
    }

    public int getKey() {
        return key;
    }

    public String getMsg() {
        return msg;
    }

    public void reset() {
        msg = null;
    }

}
