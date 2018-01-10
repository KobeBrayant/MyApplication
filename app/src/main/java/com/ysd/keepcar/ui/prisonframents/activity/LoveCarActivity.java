package com.ysd.keepcar.ui.prisonframents.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseActivity;

public class LoveCarActivity extends BaseActivity {


    private ListView listview;
    private ImageView back;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_love_car;
    }

    @Override
    protected void initView() {


        back = findViewById(R.id.back);
        listview = findViewById(R.id.love_listview);
    }

    @Override
    protected void initData() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
