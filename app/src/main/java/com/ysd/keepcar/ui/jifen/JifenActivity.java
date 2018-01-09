package com.ysd.keepcar.ui.jifen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.ui.homeframent.baner.Gridgedapter;
import com.ysd.keepcar.ui.homeframent.baner.HomeBean;
import com.ysd.keepcar.utils.DropBean;
import com.ysd.keepcar.utils.DropdownButton;

import java.util.ArrayList;
import java.util.List;

public class JifenActivity extends AppCompatActivity {

    private DropdownButton dropdownButton1;
    private DropdownButton dropdownButton2;
    private DropdownButton dropdownButton3;
    private List<DropBean> times;
    private List<DropBean> types;
    private List<DropBean> names;
    private ImageView title_fan;
    private GridView gridview;
    private List<HomeBean> mlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jifen);
        initview();
        initdata();
    }

    private void initdata() {
        gridview = (GridView) findViewById(R.id.gridView);
        for (int i = 0; i < 10; i++) {
            mlist.add(new HomeBean(R.mipmap.ic_launcher, R.mipmap.ic_dropdown_actived, "定制卷" + i, "回力普斯店公司", "200", "已兑2000"));
        }
        Gridgedapter gridgedapter = new Gridgedapter(this, mlist);
        gridview.setAdapter(gridgedapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(JifenActivity.this, XiangqingActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initview() {

        title_fan = (ImageView) findViewById(R.id.title_fanhui);
        dropdownButton1 = (DropdownButton) findViewById(R.id.time1);
        dropdownButton1.setText("分类不限");
        dropdownButton2 = (DropdownButton) findViewById(R.id.time2);
        dropdownButton2.setText("店面不限");
        dropdownButton3 = (DropdownButton) findViewById(R.id.time3);
        dropdownButton3.setText("默认排序");
        initSomeData();
        dropdownButton1.setData(times);
        dropdownButton2.setData(types);
        dropdownButton3.setData(names);
        title_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void initSomeData() {
        times = new ArrayList<>();
        types = new ArrayList<>();
        names = new ArrayList<>();

        times.add(new DropBean("分类不限"));
        times.add(new DropBean("精品"));
        times.add(new DropBean("定值卷"));
        times.add(new DropBean("余额卷"));
        times.add(new DropBean("项目"));
        times.add(new DropBean("洗车"));


        types.add(new DropBean("店面不限"));
        types.add(new DropBean("全部会员店"));

        names.add(new DropBean("默认排序"));
        names.add(new DropBean("销量最高"));
        names.add(new DropBean("积分值最低"));
    }

}

