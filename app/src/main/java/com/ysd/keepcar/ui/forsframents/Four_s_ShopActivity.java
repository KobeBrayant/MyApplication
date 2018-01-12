package com.ysd.keepcar.ui.forsframents;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseActivity;
import com.ysd.keepcar.ui.forsframents.foursitemfragment.Boutique_Fragment;
import com.ysd.keepcar.ui.forsframents.foursitemfragment.HuoDong_Fragment;
import com.ysd.keepcar.ui.forsframents.foursitemfragment.Integral_Mall_Fragment;
import com.ysd.keepcar.ui.forsframents.foursitemfragment.The_New_Car_Fragment;
import com.ysd.keepcar.ui.forsframents.foursitemfragment.UsedCar_Fragment;

import java.util.ArrayList;

public class Four_s_ShopActivity extends BaseActivity implements View.OnClickListener{
    private RelativeLayout image_background;
    private ImageView image_return;
    private ImageView image_icon;
    private TextView text_name;
    private TextView text_dizhi;
    private TextView text_km;
    private TextView text_pingfen;
    private TabLayout shop_tablayout;
    private ViewPager viewp_shop;

    private LinearLayout btn_bendianzhanghu;
    private LinearLayout btn_find;
    private LinearLayout btn_daohang;
    private PopupWindow popupWindow;
    private PopupWindow popupWindow1;
    public String shop;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_four_s__shop;
    }

    @Override
    protected void initView() {
        //浸入式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        image_background = (RelativeLayout)findViewById(R.id.image_background);
        image_return = (ImageView)findViewById(R.id.image_return);
        image_icon = (ImageView)findViewById(R.id.image_icon);
        text_name = (TextView)findViewById(R.id.text_name);
        text_dizhi = (TextView)findViewById(R.id.text_dizhi);
        text_km = (TextView)findViewById(R.id.text_km);
        text_pingfen = (TextView)findViewById(R.id.text_pingfen);
        shop_tablayout = (TabLayout)findViewById(R.id.shop_tablayout);
        viewp_shop = (ViewPager)findViewById(R.id.viewp_shop);

        btn_bendianzhanghu = (LinearLayout) findViewById(R.id.btn_bendianzhanghu);
        btn_find = (LinearLayout)findViewById(R.id.btn_find);
        btn_daohang = (LinearLayout)findViewById(R.id.btn_daohang);

        btn_bendianzhanghu.setOnClickListener(this);
        btn_find.setOnClickListener(this);
        btn_daohang.setOnClickListener(this);
        image_return.setOnClickListener(this);

        shop_tablayout.setupWithViewPager(viewp_shop);
        shop_tablayout.setTabMode(TabLayout.MODE_FIXED);

        ArrayList<String> list = new ArrayList<>();
        list.add("精品");
        list.add("活动");
        list.add("新车");
        list.add("二手车");
        list.add("积分商场");
        list.add("洗车");
        Intent intent = getIntent();
        shop = intent.getStringExtra("shop");

        ArrayList<Fragment> fragmentslist = new ArrayList<>();
        Boutique_Fragment boutique_fragment = new Boutique_Fragment();
        HuoDong_Fragment huoDong_fragment = new HuoDong_Fragment();
        The_New_Car_Fragment the_new_car_fragment = new The_New_Car_Fragment();
        UsedCar_Fragment usedCar_fragment = new UsedCar_Fragment();
        Integral_Mall_Fragment integral_mall_fragment = new Integral_Mall_Fragment();
        fragmentslist.add(boutique_fragment);
        fragmentslist.add(huoDong_fragment);
        fragmentslist.add(the_new_car_fragment);
        fragmentslist.add(usedCar_fragment);
        fragmentslist.add(integral_mall_fragment);


        FragmentManager fm = getSupportFragmentManager();

        Shop_Fragment_Adapter shop_fragment_adapter = new Shop_Fragment_Adapter(fm, list, fragmentslist);
        viewp_shop.setAdapter(shop_fragment_adapter);




    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //按键返回
            case R.id.image_return:
                finish();
                break;

            //本店账户
            case R.id.btn_bendianzhanghu:

//                startActivity(new Intent(Four_s_ShopActivity.this, Shop_DetailsActivity.class));
                View shop_account_popupwindow = LayoutInflater.from(Four_s_ShopActivity.this).inflate(R.layout.shop_account_popupwindow,null);
                Find_Popuwindow(shop_account_popupwindow);
                break;

            //发现
            case R.id.btn_find:
                View shop_find_popuwindow = LayoutInflater.from(Four_s_ShopActivity.this).inflate(R.layout.shop_find_popuwindow, null);
                Find_Popuwindow(shop_find_popuwindow);
                break;
            //导航
            case R.id.btn_daohang:

                break;
        }
    }
    private void Find_Popuwindow(View shop_find_popuwindow) {

        popupWindow = new PopupWindow(shop_find_popuwindow, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        shop_find_popuwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setFocusable(true);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAsDropDown(btn_find, 0, 20);

    }

    private void Account_Popupwindow(View shop_account_popupwindow){
        popupWindow1 = new PopupWindow(shop_account_popupwindow, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        shop_account_popupwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow1.dismiss();
            }
        });
        popupWindow1.setFocusable(true);
        popupWindow1.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow1.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow1.setBackgroundDrawable(new BitmapDrawable());
        popupWindow1.showAsDropDown(btn_bendianzhanghu,0,100);
    }
}
