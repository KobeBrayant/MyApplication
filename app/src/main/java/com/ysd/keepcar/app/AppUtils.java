package com.ysd.keepcar.app;

import android.app.Application;

import com.ysd.keepcar.base.BaseActivity;
import com.zhy.autolayout.config.AutoLayoutConifg;


/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/26.
 */

public class AppUtils extends Application {
public static BaseActivity context=null;
    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();

    }
}
