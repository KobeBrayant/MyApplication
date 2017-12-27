package com.ysd.keepcar.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.ysd.keepcar.app.AppUtils;


/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/26.
 */

public abstract class BaseActivity extends FragmentActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        AppUtils.context=this;
        initView();
    }
    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initData();
}
