package com.ysd.keepcar.ui.homeframent.zhanshiting;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseActivity;
import com.ysd.keepcar.ui.homeframent.zhanshiting.frament.AllFragment;
import com.ysd.keepcar.ui.homeframent.zhanshiting.frament.ThellFragment;

import java.util.ArrayList;

public class TheHallActivity extends BaseActivity implements View.OnClickListener {

    private TextView title_biao;
    private TextView xincar_o;
    private TextView ershou_o;
    private FrameLayout frameLayout;
    private AllFragment allFragment;
    private ThellFragment thellFragment;
    private ArrayList<Fragment> list;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_the_hall;
    }

    @Override
    protected void initView() {
       title_biao = (TextView) findViewById(R.id.title_biao);
       xincar_o = (TextView) findViewById(R.id.xincar_o);
       ershou_o = (TextView) findViewById(R.id.ershoucar_o);
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        allFragment = new AllFragment();
        thellFragment = new ThellFragment();
        list = new ArrayList<>();
  list.add(allFragment);
        list.add(thellFragment);

        xincar_o.setOnClickListener(this);
        ershou_o.setOnClickListener(this);
  addFragment(allFragment);
    }
    @Override
    public void finish() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        viewGroup.removeAllViews();
        super.finish();
    }
    @Override
    protected void initData() {
  title_biao.setText("4S店展厅");
    }

    @Override
    public void onClick(View view) {
   switch (view.getId()){
       case R.id.xincar_o :
          addFragment(allFragment);
          xincar_o.setTextColor(Color.RED);
          ershou_o.setTextColor(Color.BLACK);
           break;
       case R.id.ershoucar_o:
          addFragment(thellFragment);
           xincar_o.setTextColor(Color.BLACK);
           ershou_o.setTextColor(Color.RED);
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
}
