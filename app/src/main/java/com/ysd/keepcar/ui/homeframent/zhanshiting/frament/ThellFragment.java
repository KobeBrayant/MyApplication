package com.ysd.keepcar.ui.homeframent.zhanshiting.frament;


import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.gjiazhe.wavesidebar.WaveSideBar;
import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseFragMent;
import com.ysd.keepcar.ui.homeframent.zhanshiting.frament.beandapter.BranBeen;
import com.ysd.keepcar.ui.homeframent.zhanshiting.frament.beandapter.MyBrandAdapter;
import com.ysd.keepcar.utils.DropBean;
import com.ysd.keepcar.utils.DropdownButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThellFragment extends BaseFragMent implements WaveSideBar.OnSelectIndexItemListener {


    private TextView dropdownButton1;
    private DropdownButton dropdownButton2;
    private DropdownButton dropdownButton3;
    private TextView shaixuan_btn;
    private ArrayList<DropBean> types;
    private ArrayList<DropBean> orings;
    private DrawerLayout dbl;
    private LinearLayout right;
    private List<BranBeen.DataBean> data;
    private RecyclerView mBrandList;

    @Override
        protected int getLayoutId() {
        return R.layout.fragment_thell;
    }

    @Override
    protected void init(View view) {
        dropdownButton1 = (TextView) view.findViewById(R.id.time1);
        dropdownButton2 = (DropdownButton) view.findViewById(R.id.time2);
        dropdownButton3 = (DropdownButton) view.findViewById(R.id.time3);
        shaixuan_btn =  (TextView) view.findViewById(R.id.shaixuan_btn);
        //侧滑的id
       dbl = (DrawerLayout) view.findViewById(R.id.drawerlayout);
       right = (LinearLayout) view.findViewById(R.id.right);
        // 关闭手势滑动
        dbl.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        dbl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // 打开手势滑动
                dbl.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                // 关闭手势滑动
                dbl.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        initSomeData();
        dropdownButton2.setData(types);
        dropdownButton3.setData(orings);

    }

    private void initSomeData() {
        types = new ArrayList<>();
        orings = new ArrayList<>();


        types.add(new DropBean("4S店不限"));
        types.add(new DropBean("全部会员店"));
        types.add(new DropBean("某某某会员店"));

        orings.add(new DropBean("排序"));
        orings.add(new DropBean("综合排序"));
        orings.add(new DropBean("价格最低"));
        orings.add(new DropBean("车龄最小"));
        orings.add(new DropBean("里程最少"));

    }

    @Override
    protected void loadData() {
        shaixuan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!dbl.isDrawerOpen(right)) {
                    dbl.openDrawer(right);
                }
            }
        });
        dropdownButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View vicinityView = LayoutInflater.from(getActivity()).inflate(R.layout.shop_popup_window1, null);
                initPettypeView1(vicinityView);
                popupWindow1(vicinityView);
            }
        });


    }

    private void popupWindow1(View vicinityView) {
        PopupWindow popupWindow = new PopupWindow(vicinityView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        popupWindow.setFocusable(true);

// 设置点击其他地方 就消失 (只设置这个，没有效果) 必须设置背景
        popupWindow.setOutsideTouchable(true);

        popupWindow.setTouchable(true);

        popupWindow.setAnimationStyle(R.style.AnimationTopFade); // 设置动画

        popupWindow.showAsDropDown(dropdownButton1, 0, 0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
//                dropdownButton1.setChecked(false);
            }
        });
    }

    private void initPettypeView1(View vicinityView) {
        mBrandList = (RecyclerView) vicinityView.findViewById(R.id.recyclerView);
        WaveSideBar waveSideBar = (WaveSideBar) vicinityView.findViewById(R.id.waveSideBar);
        waveSideBar.setTextColor(Color.BLACK);
        waveSideBar.setMaxOffset(10);//字母偏移量
        waveSideBar.setPosition(WaveSideBar.POSITION_RIGHT);//侧边栏在左边还是右边
        waveSideBar.setLazyRespond(true);//false:列表随侧边栏的滚动滚动
        waveSideBar.setOnSelectIndexItemListener(this);
        OkHttpClient okHttpClient = new OkHttpClient();
        String string = "{\"ak\":\"f4474404846d470a8e1f6c081a28acc5\",\"channel\":\"android\"}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),string);
        Request request = new Request.Builder()
                .url("http://39.106.173.47:8080/app/carBrand/querySubBrand.do")
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string1 = response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson=new Gson();
                        BranBeen branBeen = gson.fromJson(string1, BranBeen.class);
                        data = branBeen.getData();
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                        mBrandList.setLayoutManager(linearLayoutManager);


                        MyBrandAdapter myAdapter = new MyBrandAdapter(data,getActivity());
                        mBrandList.setAdapter(myAdapter);
                    }
                });
            }
        });
    }

    @Override
    public void onSelectIndexItem(String index) {

    }
}
