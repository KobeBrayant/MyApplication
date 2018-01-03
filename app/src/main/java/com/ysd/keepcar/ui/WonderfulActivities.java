package com.ysd.keepcar.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.ui.homeframent.baner.MyGridAdapter;
import com.ysd.keepcar.utils.DropBean;
import com.ysd.keepcar.utils.DropdownButton;
import java.util.ArrayList;
import java.util.List;

public class WonderfulActivities extends Activity {
    private DropdownButton dropdownButton1;
    private DropdownButton dropdownButton2;
    private DropdownButton dropdownButton3;
    private List<DropBean> times;
    private List<DropBean> types;
    private List<DropBean> names;
    private GridView gridView;
    private int[] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonderful_activities);
        dropdownButton1 = (DropdownButton) findViewById(R.id.time1);
        dropdownButton1.setText("活动");
        dropdownButton2 = (DropdownButton) findViewById(R.id.time2);
        dropdownButton2.setText("店面不限");
        dropdownButton3 = (DropdownButton) findViewById(R.id.time3);
        dropdownButton3.setText("排序");
        gridView = (GridView)findViewById(R.id.gridview);
        initSomeData();
        dropdownButton1.setData(times);
        dropdownButton2.setData(types);
        dropdownButton3.setData(names);

        initAdapter();


    }
    private void initSomeData() {
        times = new ArrayList<>();
        types = new ArrayList<>();
        names = new ArrayList<>();


        times.add(new DropBean("活动不限"));
        times.add(new DropBean("市场活动"));
        times.add(new DropBean("保险活动"));
        times.add(new DropBean("团购"));
        times.add(new DropBean("限时抢购"));
        times.add(new DropBean("定时秒杀"));
        times.add(new DropBean("买赠"));
        times.add(new DropBean("套餐"));

        types.add(new DropBean("店面不限"));
        types.add(new DropBean("全部会员店"));
        types.add(new DropBean("历史下单店"));


        names.add(new DropBean("默认排序"));
        names.add(new DropBean("距离最近"));
        names.add(new DropBean("评价最高"));

        images = new int[]{R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher};

    }

    private void initAdapter() {

        gridView.setAdapter(new MyGridAdapter(images,WonderfulActivities.this));

    }
}
