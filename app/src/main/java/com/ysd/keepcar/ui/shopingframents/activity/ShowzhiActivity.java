package com.ysd.keepcar.ui.shopingframents.activity;

import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseActivity;

public class ShowzhiActivity extends BaseActivity {


    private TextView title_biao;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_showzhi;
    }

    @Override
    protected void initView() {
       title_biao = (TextView) findViewById(R.id.title_biao);
      title_biao.setText("确认订单");

    }

    @Override
    protected void initData() {

    }
}
