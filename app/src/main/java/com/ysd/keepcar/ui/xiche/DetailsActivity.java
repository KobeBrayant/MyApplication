package com.ysd.keepcar.ui.xiche;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseActivity;
import com.ysd.keepcar.ui.forsframents.FourBean;
import com.ysd.keepcar.ui.xiche.dapter.XiCarDapter;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends BaseActivity implements View.OnClickListener {


          private ListView listview_xi;
         private RelativeLayout image_background;
        private ImageView image_return;
    private ImageView image_icon;
    private TextView text_name;
    private TextView text_dizhi;
    private TextView text_km;
    private TextView text_pingfen;
    private LinearLayout btn_bendianzhanghu;
    private LinearLayout btn_find;
    private LinearLayout btn_daohang;
    private PopupWindow popupWindow1;
    private PopupWindow popupWindow;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details;
    }

    @Override
    protected void initView() {
        //浸入式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
       listview_xi = (ListView) findViewById(R.id.listView_xi);
        List<FourBean> carlist = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            carlist.add(new FourBean(R.mipmap.ic_launcher,"公司名称"));
        }
        listview_xi.setAdapter(new XiCarDapter(this,carlist));
        listview_xi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(DetailsActivity.this,RegCarActivity.class));
            }
        });


        image_background = (RelativeLayout)findViewById(R.id.image_background);
        image_return = (ImageView)findViewById(R.id.image_return);
        image_icon = (ImageView)findViewById(R.id.image_icon);
        text_name = (TextView)findViewById(R.id.text_name);
        text_dizhi = (TextView)findViewById(R.id.text_dizhi);
        text_km = (TextView)findViewById(R.id.text_km);
        text_pingfen = (TextView)findViewById(R.id.text_pingfen);
        btn_bendianzhanghu = (LinearLayout) findViewById(R.id.btn_bendianzhanghu);
        btn_find = (LinearLayout)findViewById(R.id.btn_find);
        btn_daohang = (LinearLayout)findViewById(R.id.btn_daohang);

        btn_bendianzhanghu.setOnClickListener(this);
        btn_find.setOnClickListener(this);
        btn_daohang.setOnClickListener(this);
        image_return.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //按键返回
            case R.id.image_return:
                finish();
                break;
            //本店账户
            case R.id.btn_bendianzhanghu:

//                startActivity(new Intent(Four_s_ShopActivity.this, Shop_DetailsActivity.class));
                View shop_account_popupwindow = LayoutInflater.from(DetailsActivity.this).inflate(R.layout.shop_account_popupwindow,null);
                Find_Popuwindow(shop_account_popupwindow);
                break;
            //发现
            case R.id.btn_find:
                View shop_find_popuwindow = LayoutInflater.from(DetailsActivity.this).inflate(R.layout.shop_find_popuwindow, null);
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
