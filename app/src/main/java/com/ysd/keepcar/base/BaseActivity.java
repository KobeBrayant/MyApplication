package com.ysd.keepcar.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.Toast;

import com.ysd.keepcar.app.AppUtils;
import com.zhy.autolayout.AutoLayoutActivity;


/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/26.
 */

public abstract class BaseActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //取消标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        AppUtils.context=this;
        initView();
        initData();
    }
    protected abstract int getLayoutId();
    protected abstract void initView();
    protected abstract void initData();
    //吐司调用
    public void ShowToast(String info) {
        Toast.makeText(AppUtils.context, info, Toast.LENGTH_SHORT).show();
    }
}
