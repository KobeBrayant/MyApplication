package com.ysd.keepcar.ui.prisonframents;


import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseFragMent;
import com.ysd.keepcar.ui.loginmodoule.LoginActivity;
import com.ysd.keepcar.ui.myview.CircleImageView;
import com.ysd.keepcar.ui.prisonframents.activity.LoveCarActivity;
import com.ysd.keepcar.ui.prisonframents.activity.OrderActivity;
import com.ysd.keepcar.ui.prisonframents.adapter.ProsionFragmentAdapter;
import com.ysd.keepcar.ui.prisonframents.smallfragment.ChuZHiFragment;
import com.ysd.keepcar.ui.prisonframents.smallfragment.DingEQuanFragment;
import com.ysd.keepcar.ui.prisonframents.smallfragment.JiFenFragment;
import com.ysd.keepcar.ui.prisonframents.smallfragment.Yu_e_QuanFragment;

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
    private ImageView top;
    private RelativeLayout mycar;

    @Override
    protected int getLayoutId() {
        return R.layout.prosion_fragmentl;
    }
    @Override
    protected void init(View view) {
        icon_login=view.findViewById(R.id.icon_login);
        prosion_viewpager = view.findViewById(R.id.prosion_viewpager);
        jifen_btn = view.findViewById(R.id.jifen_btn);
         xiangmu_btn = view.findViewById(R.id.xiangmu_btn);
        top = view.findViewById(R.id.top);
        chuzhi_btn = view.findViewById(R.id.chuzhi_btn);
        yuequan_btn = view.findViewById(R.id.yuequan_btn);
        dingequan_btn = view.findViewById(R.id.dingequan_btn);
        daifukuan_rabtn = view.findViewById(R.id.daifukuan_rabtn);
        daishigong_rabtn = view.findViewById(R.id.daishigong_rabtn);
        daifahuo_rabtn = view.findViewById(R.id.daifahuo_rabtn);
        daishouhuo_rabtn = view.findViewById(R.id.daishouhuo_rabtn);
        daipingjia_rabtn = view.findViewById(R.id.daipingjia_rabtn);
        rid_group = view.findViewById(R.id.rid_group);
        group_dingdan = view.findViewById(R.id.group_dingdan);
        mycar = view.findViewById(R.id.my_car);

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
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTipPopupWindow(top, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "as", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        mycar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoveCarActivity.class);
                startActivity(intent);
            }
        });
        group_dingdan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.daifukuan_rabtn:
                        Intent intent=new Intent(getActivity(), OrderActivity.class);
                        startActivity(intent);
                        break;


                }
            }
        });
        fragmentArrayList = new ArrayList<>();
        JiFenFragment jiFenFragment=new JiFenFragment();
        ChuZHiFragment chuZHiFragment=new ChuZHiFragment();
        Yu_e_QuanFragment yu_e_quanFragment=new Yu_e_QuanFragment();
        DingEQuanFragment dingEQuanFragment=new DingEQuanFragment();
        fragmentArrayList.add(jiFenFragment);
        fragmentArrayList.add(chuZHiFragment);
        fragmentArrayList.add(yu_e_quanFragment);
        fragmentArrayList.add(dingEQuanFragment);
        ProsionFragmentAdapter adapter=new ProsionFragmentAdapter(getActivity().getSupportFragmentManager(),fragmentArrayList);
        prosion_viewpager.setAdapter(adapter);

        rid_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId){
                        case R.id.jifen_btn:
                            prosion_viewpager.setCurrentItem(0);
                            break;
                        case R.id.chuzhi_btn:
                            prosion_viewpager.setCurrentItem(1);
                            break;
                        case R.id.yuequan_btn:
                            prosion_viewpager.setCurrentItem(2);
                            break;
                        case R.id.dingequan_btn:
                            prosion_viewpager.setCurrentItem(3);
                            break;


                    }
            }
        });
        prosion_viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rid_group.check(R.id.jifen_btn);
                        break;
                    case 1:
                       rid_group.check(R.id.chuzhi_btn);
                        break;
                        case 2:
                            rid_group.check(R.id.yuequan_btn);
                    break;
                    case 3:
                        rid_group.check(R.id.dingequan_btn);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    public PopupWindow showTipPopupWindow(final View anchorView, final View.OnClickListener onClickListener) {
        final View contentView = LayoutInflater.from(anchorView.getContext()).inflate(R.layout.toppopup, null);
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        // 创建PopupWindow时候指定高宽时showAsDropDown能够自适应
        // 如果设置为wrap_content,showAsDropDown会认为下面空间一直很充足（我以认为这个Google的bug）
        // 备注如果PopupWindow里面有ListView,ScrollView时，一定要动态设置PopupWindow的大小
        final PopupWindow popupWindow = new PopupWindow(contentView,
                contentView.getMeasuredWidth(), contentView.getMeasuredHeight(), false);

        contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                onClickListener.onClick(v);
            }
        });

        contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                // 自动调整箭头的位置
                autoAdjustArrowPos(popupWindow, contentView, anchorView);
                contentView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        // 如果不设置PopupWindow的背景，有些版本就会出现一个问题：无论是点击外部区域还是Back键都无法dismiss弹框
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        // setOutsideTouchable设置生效的前提是setTouchable(true)和setFocusable(false)
        popupWindow.setOutsideTouchable(true);

        // 设置为true之后，PopupWindow内容区域 才可以响应点击事件
        popupWindow.setTouchable(true);

        // true时，点击返回键先消失 PopupWindow
        // 但是设置为true时setOutsideTouchable，setTouchable方法就失效了（点击外部不消失，内容区域也不响应事件）
        // false时PopupWindow不处理返回键
        popupWindow.setFocusable(false);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;   // 这里面拦截不到返回键
            }
        });
        // 如果希望showAsDropDown方法能够在下面空间不足时自动在anchorView的上面弹出
        // 必须在创建PopupWindow的时候指定高度，不能用wrap_content
        popupWindow.showAsDropDown(anchorView);
        return popupWindow;
    }

    private void autoAdjustArrowPos(PopupWindow popupWindow, View contentView, View anchorView) {
        View upArrow = contentView.findViewById(R.id.up_arrow);
        View downArrow = contentView.findViewById(R.id.down_arrow);

        int pos[] = new int[2];
        contentView.getLocationOnScreen(pos);
        int popLeftPos = pos[0];
        anchorView.getLocationOnScreen(pos);
        int anchorLeftPos = pos[0];
        int arrowLeftMargin = anchorLeftPos - popLeftPos + anchorView.getWidth() / 2 - upArrow.getWidth() / 2;
        upArrow.setVisibility(popupWindow.isAboveAnchor() ? View.INVISIBLE : View.VISIBLE);
        downArrow.setVisibility(popupWindow.isAboveAnchor() ? View.VISIBLE : View.INVISIBLE);

        RelativeLayout.LayoutParams upArrowParams = (RelativeLayout.LayoutParams) upArrow.getLayoutParams();
        upArrowParams.leftMargin = arrowLeftMargin;
        RelativeLayout.LayoutParams downArrowParams = (RelativeLayout.LayoutParams) downArrow.getLayoutParams();
        downArrowParams.leftMargin = arrowLeftMargin;
    }
}