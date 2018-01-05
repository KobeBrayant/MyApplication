package com.ysd.keepcar.ui.homeframent.baner;

/**
 * Created by dell on 2018/1/2.
 */

public class HomeBean {
       private int Imageone;
    private  int Imagetwo;
    private String mname;
    private  String mcontent;
    private  String gender;
    private  String money;

    public HomeBean(int imageone, int imagetwo, String mname, String mcontent, String gender, String money) {
        Imageone = imageone;
        Imagetwo = imagetwo;
        this.mname = mname;
        this.mcontent = mcontent;
        this.gender = gender;
        this.money = money;
    }

    public HomeBean() {
    }

    public int getImageone() {
        return Imageone;
    }

    public void setImageone(int imageone) {
        Imageone = imageone;
    }

    public int getImagetwo() {
        return Imagetwo;
    }

    public void setImagetwo(int imagetwo) {
        Imagetwo = imagetwo;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
