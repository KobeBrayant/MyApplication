package com.ysd.keepcar.ui.homeframent.baner;

import java.util.List;

/**
 * Created by dell on 2017/12/28.
 */

public class BannerBean {
       private String code;
    private String msg;
    private List<String> data;

    public String getCode() {
        return code;
          }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

}
