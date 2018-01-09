package com.ysd.keepcar.ui.prisonframents;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseFragMent;
import com.ysd.keepcar.ui.loginmodoule.LoginActivity;
import com.ysd.keepcar.ui.myview.CircleImageView;
import com.ysd.keepcar.ui.prisonframents.adapter.ProsionFragmentAdapter;
import com.ysd.keepcar.ui.prisonframents.smallfragment.JiFenFragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProsionFraments extends BaseFragMent {


    private CircleImageView icon_login;
    private TextView name_login;
    private TextView my_dingdan;
    private RadioButton daifukuan_rabtn;
    private RadioButton daishigong_rabtn;
    private RadioButton daifahuo_rabtn;
    private RadioButton daishouhuo_rabtn;
    private RadioButton daipingjia_rabtn;
    private RadioGroup group_dingdan;
    private ImageView mycars_img;
    private RelativeLayout my_car;
    private TextView current_car;
    private ImageView img_go;
    private TextView current_cars;
    private RelativeLayout dangqian_car;
    private TextView current_dianmian;
    private ImageView img_gos;
    private TextView dianmian_current;
    private RadioButton jifen_btn;
    private RadioButton xiangmu_btn;
    private RadioButton chuzhi_btn;
    private RadioButton xiche_btn;
    private RadioButton yuequan_btn;
    private RadioButton jibiezhekou_btn;
    private RadioButton dingequan_btn;
    private RadioGroup rid_group;
    private FrameLayout frag_zhanghu;
    private ViewPager prosion_viewpager;
    private ArrayList<Fragment> fragmentArrayList;

    @Override
    protected int getLayoutId() {
        return R.layout.prosion_fragmentl;
    }
    @Override
    protected void init(View view) {
        icon_login=view.findViewById(R.id.icon_login);
        prosion_viewpager = view.findViewById(R.id.prosion_viewpager);
    }
    @Override
    protected void loadData() {
        icon_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        fragmentArrayList = new ArrayList<>();
        JiFenFragment jiFenFragment=new JiFenFragment();
        fragmentArrayList.add(jiFenFragment);
        ProsionFragmentAdapter adapter=new ProsionFragmentAdapter(getActivity().getSupportFragmentManager(),fragmentArrayList);
        prosion_viewpager.setAdapter(adapter);



    }
}