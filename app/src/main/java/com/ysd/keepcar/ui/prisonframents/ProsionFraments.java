package com.ysd.keepcar.ui.prisonframents;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseFragMent;
import com.ysd.keepcar.ui.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProsionFraments extends BaseFragMent {
    @Override
    protected int getLayoutId() {
        return R.layout.prosion_fragmentl;
    }

    @Override
    protected void init(View view) {

    }

    @Override
    protected void loadData() {

    }

/*
   // private ImageView loginpop;
    private PopupWindow mPopWindow;

    @Override
    protected int getLayoutId() {
        return R.layout.prosion_fragmentl;
    }

    @Override
    protected void init(View view) {
        //loginpop = view.findViewById(R.id.loginpop);
    }

    @Override
    protected void loadData() {
       *//* loginpop.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.loginpopupwindow, null);
                showPopWindow(inflate);
            }
        });*//*
    }

 *//*   @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void showPopWindow() {
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.loginpopupwindow, null);
        mPopWindow = new PopupWindow(contentView);
        mPopWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_prosion_framents, null);
        View viewById = inflate.findViewById(R.id.loginpop);
        //mPopWindow.showAtLocation(inflate,Gravity.AXIS_PULL_BEFORE,0,0);
        mPopWindow.showAsDropDown(inflate);
    }*//*
 private void showPopWindow(View view) {
     try {

         mPopWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,
                 ViewGroup.LayoutParams.WRAP_CONTENT);
         mPopWindow.setFocusable(true);
         mPopWindow.setOutsideTouchable(true);
         ColorDrawable cd = new ColorDrawable(0x00ffffff);// 背景颜色全透明
         mPopWindow.setBackgroundDrawable(cd);
         mPopWindow.setAnimationStyle(R.style.style_pop_animation);// 动画效果必须放在showAsDropDown()方法上边，否则无效
        //mPopWindow.showAsDropDown(loginpop,0,10);

         mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

             @Override
             public void onDismiss() {
                 mPopWindow = null;// 当点击屏幕时，使popupWindow消失
                 backgroundAlpha(1.0f);// 当点击屏幕时，使半透明效果取消
             }
         });


     } catch (Exception e) {
         e.printStackTrace();
     }

 }
    // 设置popupWindow背景半透明
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
        lp.alpha = bgAlpha;// 0.0-1.0
        getActivity().getWindow().setAttributes(lp);
    }*/
}
