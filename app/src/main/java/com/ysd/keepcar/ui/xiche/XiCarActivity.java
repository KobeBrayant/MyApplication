package com.ysd.keepcar.ui.xiche;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.utils.DropBean;
import com.ysd.keepcar.utils.DropdownButton;

import java.util.ArrayList;

public class XiCarActivity extends AppCompatActivity {

    private TextView titlebiao;
    private ImageView title_fanhui;
    private ImageView title_fan;
    private DropdownButton dropdownButton1;
    private DropdownButton dropdownButton2;
    private ArrayList<DropBean> times;
    private ArrayList<DropBean> types;
    private GridView gridview_xiche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xi_car);
        initview();
        initdata();
        initload();
    }

    private void initload() {
        gridview_xiche = (GridView) findViewById(R.id.gridview);


    }

    private void initdata() {
        title_fan = (ImageView) findViewById(R.id.title_fanhui);
        dropdownButton1 = (DropdownButton) findViewById(R.id.time1);
        dropdownButton1.setText("店面");
        dropdownButton2 = (DropdownButton) findViewById(R.id.time2);
        dropdownButton2.setText("排序");
        initSomeData();
        dropdownButton1.setData(times);
        dropdownButton2.setData(types);
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


        times.add(new DropBean("店面不限"));
        times.add(new DropBean("全部洗车店"));
        times.add(new DropBean("全部会员店"));
        times.add(new DropBean("品牌4S店"));
        times.add(new DropBean("历史下单店"));


        types.add(new DropBean("默认排序"));
        types.add(new DropBean("距离最短"));
        types.add(new DropBean("评价最高"));
        types.add(new DropBean("价格最低"));

    }


    private void initview() {
        titlebiao = (TextView) findViewById(R.id.title_biao);
        title_fanhui = (ImageView) findViewById(R.id.title_fanhui);
        titlebiao.setText("洗车");
        title_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
