package com.ysd.keepcar.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseActivity;
import com.ysd.keepcar.ui.forsframents.ForSFragment;
import com.ysd.keepcar.ui.homeframent.HomeFragment;
import com.ysd.keepcar.ui.prisonframents.ProsionFraments;
import com.ysd.keepcar.ui.shopingframents.ShopFraments;

import java.util.ArrayList;


public class WelcomeActivity extends BaseActivity implements View.OnClickListener {

    private RadioGroup radioGroup;
    private ArrayList<Fragment> list;
    private RadioButton button_1;
    private RadioButton button_2;
    private RadioButton button_3;
    private RadioButton button_4;
    private FrameLayout frameLayout;
    private HomeFragment fragment_1;
    private ForSFragment fragment_2;
    private ShopFraments fragment_3;
    private ProsionFraments fragment_4;

    @Override
    protected int getLayoutId() {
        return R.layout.home_one;
    }

    @Override
    protected void initView() {
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        radioGroup = (RadioGroup) findViewById(R.id.mBottomGroup);
        //找到四个按钮
        button_1 = (RadioButton) findViewById(R.id.my_home);
        button_2 = (RadioButton) findViewById(R.id.my_fors);
        button_3 = (RadioButton) findViewById(R.id.my_shoping);
        button_4 = (RadioButton) findViewById(R.id.my_myprison);
        //创建Fragment对象及集合
        fragment_1 = new HomeFragment();
        fragment_2 = new ForSFragment();
        fragment_3 = new ShopFraments();
        fragment_4 = new ProsionFraments();
        //将Fragment对象添加到list中
        list = new ArrayList<>();
        list.add(fragment_1);
        list.add(fragment_2);
        list.add(fragment_3);
        list.add(fragment_4);
        //设置RadioGroup开始时设置的按钮，设置第一个按钮为默认值
        radioGroup.check(R.id.my_home);
        //设置按钮点击监听
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        //初始时向容器中添加第一个Fragment对象
        addFragment(fragment_1);
    }

    @Override
    public void finish() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        viewGroup.removeAllViews();
        super.finish();
    }

    //点击事件处理
    @Override
    public void onClick(View v) {
        //我们根据参数的id区别不同按钮
        //不同按钮对应着不同的Fragment对象页面
        switch (v.getId()) {
            case R.id.my_home:
                addFragment(fragment_1);
                break;
            case R.id.my_fors:
                addFragment(fragment_2);
                break;
            case R.id.my_shoping:
                addFragment(fragment_3);
                break;
            case R.id.my_myprison:
                addFragment(fragment_4);
                break;
            default:
                break;
        }

    }

    //向Activity中添加Fragment的方法
    public void addFragment(Fragment fragment) {

        //获得Fragment管理器
        FragmentManager fragmentManager = getSupportFragmentManager();
        //使用管理器开启事务
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //使用事务替换Fragment容器中Fragment对象
        fragmentTransaction.replace(R.id.framelayout,fragment);
        //提交事务，否则事务不生效
        fragmentTransaction.commit();
    }


    @Override
    protected void initData() {

    }

    }


