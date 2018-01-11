package com.ysd.keepcar.ui.prisonframents.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.ysd.keepcar.R;
import com.ysd.keepcar.ui.prisonframents.adapter.OrderAdapter;
import com.ysd.keepcar.ui.prisonframents.orderfragment.DeliveryFragment;
import com.ysd.keepcar.ui.prisonframents.orderfragment.EvaluatedFragment;
import com.ysd.keepcar.ui.prisonframents.orderfragment.PendingFragment;
import com.ysd.keepcar.ui.prisonframents.orderfragment.ReceivedFragment;
import com.ysd.keepcar.ui.prisonframents.orderfragment.StayFragment;
import com.ysd.keepcar.ui.prisonframents.orderfragment.WholeFragment;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    private ImageView order_back;
    private TabLayout order_tab;
    private ViewPager order_viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
        initData();

    }

    private void initData() {
        ArrayList<String> tabList=new ArrayList<>();
        tabList.add("全部");
        tabList.add("待付款");
        tabList.add("带施工");
        tabList.add("代发货");
        tabList.add("代收货");
        tabList.add("待评价");
        ArrayList<Fragment> fragments=new ArrayList<>();
        DeliveryFragment deliveryFragment=new DeliveryFragment();
        EvaluatedFragment evaluatedFragment=new EvaluatedFragment();
        PendingFragment pendingFragment=new PendingFragment();
        ReceivedFragment receivedFragment=new ReceivedFragment();
        StayFragment stayFragment=new StayFragment();
        WholeFragment wholeFragment=new WholeFragment();
        fragments.add(wholeFragment);
        fragments.add(pendingFragment);
        fragments.add(stayFragment);
        fragments.add(deliveryFragment);
        fragments.add(evaluatedFragment);
        fragments.add(receivedFragment);
        OrderAdapter adapter=new OrderAdapter(getSupportFragmentManager(),fragments,tabList);
        order_viewpager.setAdapter(adapter);
        order_tab.setupWithViewPager(order_viewpager);

    }

    private void initView() {
        order_back = (ImageView) findViewById(R.id.order_back);
        order_tab = (TabLayout) findViewById(R.id.order_tab);
        order_viewpager = (ViewPager) findViewById(R.id.order_viewpager);
    }
}
