package com.ysd.keepcar.ui.homeframent.baner;

/**
 * Created by dell on 2017/12/28.
 */

public class Horbean {
    private  String name;
    private  int Image;

    public Horbean(String name, int image) {
        this.name = name;
        Image = image;
    }

    public Horbean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
