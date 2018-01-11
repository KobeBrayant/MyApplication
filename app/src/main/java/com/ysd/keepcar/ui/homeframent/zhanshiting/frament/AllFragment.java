package com.ysd.keepcar.ui.homeframent.zhanshiting.frament;


import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.gjiazhe.wavesidebar.WaveSideBar;
import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseFragMent;
import com.ysd.keepcar.ui.homeframent.zhanshiting.dapter.ZhanDapter;
import com.ysd.keepcar.ui.homeframent.zhanshiting.frament.beandapter.BranBeen;
import com.ysd.keepcar.ui.homeframent.zhanshiting.frament.beandapter.MyBrandAdapter;
import com.ysd.keepcar.ui.homeframent.zhanshiting.frament.beandapter.XinBean;
import com.ysd.keepcar.utils.Cjson;
import com.ysd.keepcar.utils.DropBean;
import com.ysd.keepcar.utils.DropdownButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class AllFragment extends BaseFragMent implements WaveSideBar.OnSelectIndexItemListener {


    private TextView dropdownButton1;
    private DropdownButton dropdownButton2;
    private List<BranBeen.DataBean> data;
    private ArrayList<DropBean> types;
    private RecyclerView rec;
    private RecyclerView mBrandList;
    private ListView listview_xin;
    private List<XinBean.DataBean.ListBean> list;
    private XinBean xinbean;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_all;
    }

    @Override
    protected void init(View view) {
       listview_xin = (ListView)  view.findViewById(R.id.listView_xin);
       inithttp();
        dropdownButton1 = (TextView) view.findViewById(R.id.time1);
        dropdownButton1.setText("品牌");
        dropdownButton2 = (DropdownButton) view.findViewById(R.id.time2);
        dropdownButton2.setText("排序");
        initSomeData();
        dropdownButton2.setData(types);
    }

    private void inithttp() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, Object> map = new HashMap<>();
        map.put("pageSize", "10");
        map.put("brandId", "品牌不限");
        map.put("pageNum", "0");
        map.put("sortType", "默认排序");
//        map.put("productType", "全部分类");
        String mapstr = Cjson.toJSONMap(map);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), mapstr);
        Request request = new Request.Builder()
                .url("http://39.106.173.47:8080/app/carExhibition/newCarList.do")
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "失败啦");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string1 = response.body().string();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        xinbean = gson.fromJson(string1, XinBean.class);
                        list = xinbean.getData().getList();
//                        list1 = huodongBean.getData().getList();
// ZhanBean beena=gson.fromJson(string1,ZhanBean.class);
//                        list = beena.getData().getList();
                        ZhanDapter  zhanDapter =  new ZhanDapter(getActivity(),list);
                        listview_xin.setAdapter(zhanDapter);

                    }
                });
                Log.e("TAG", "hahahah" + string1);
            }
        });
    }

    private void initSomeData() {
       // data = new ArrayList<>();
        types = new ArrayList<>();
//        times.add(new DropBean("品牌"));
//        times.add(new DropBean("品牌不限"));


        types.add(new DropBean("默认排序"));
        types.add(new DropBean("试驾最多"));
    }

    @Override
    protected void loadData() {
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

//        myBrandBeen.addAll(MyBrandBean.getEnglishContacts());
    }


    @Override
    public void onSelectIndexItem(String index) {

    }
}
