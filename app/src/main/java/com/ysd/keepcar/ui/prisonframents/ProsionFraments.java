package com.ysd.keepcar.ui.prisonframents;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseFragMent;
import com.ysd.keepcar.ui.LoginActivity;
import com.ysd.keepcar.ui.MainActivity;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProsionFraments extends BaseFragMent {
    private PopupWindow mPopWindow;
    private ImageView menu_login;
    private View inflate;
    private ImageView icon_login;

    @Override
    protected int getLayoutId() {
        return R.layout.prosion_fragmentl;
    }

    @Override
    protected void init(View view) {
        menu_login = view.findViewById(R.id.menu_login);
        icon_login = view.findViewById(R.id.icon_login);
        inflate = LayoutInflater.from(getActivity()).inflate(R.layout.loginpopupwindow, null);

    }

    @Override
    protected void loadData() {
        menu_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopWindow(inflate);
            }
        });
        icon_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,"======");
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

 private void showPopWindow(View view) {
     try {

         mPopWindow = new PopupWindow(view,200,
                250);
         mPopWindow.setFocusable(true);
         mPopWindow.setOutsideTouchable(true);
         ColorDrawable cd = new ColorDrawable(0x00ffffff);// 背景颜色全透明
         mPopWindow.setBackgroundDrawable(cd);
         mPopWindow.setAnimationStyle(R.style.style_pop_animation);// 动画效果必须放在showAsDropDown()方法上边，否则无效
        mPopWindow.showAsDropDown(menu_login,0,10);

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
    }
}
