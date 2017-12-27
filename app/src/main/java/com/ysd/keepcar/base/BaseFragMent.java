package com.ysd.keepcar.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/26.
 */

public abstract class BaseFragMent extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        loadData();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);

        //当前Fragment处于隐藏状态
        if (hidden){
            onHidden();
        }else {//当前Fragment处于显示状态
            onShow();
        }
    }

    //加载布局
    protected abstract int getLayoutId();
    //初始化数据
    protected abstract void init(View view);
    //加载数据
    protected abstract void loadData();
    //该方法在Fragment可见时调用，可以在该方法中刷新数据
    protected void onShow(){}
    //该方法在Fragment隐藏时调用，可以做数据保存
    protected void onHidden(){}

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}
