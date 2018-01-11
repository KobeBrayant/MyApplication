package com.ysd.keepcar.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.ui.huodong.HuodongBean;
import com.ysd.keepcar.ui.huodong.HuodongDapter;
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

public class WonderfulActivities extends Activity {
    private DropdownButton dropdownButton1;
    private DropdownButton dropdownButton2;
    private DropdownButton dropdownButton3;
    private List<DropBean> times;
    private List<DropBean> types;
    private List<DropBean> names;
    private GridView gridView;
    private int[] images;
    private HuodongBean huodongBean;
    private List<HuodongBean.DataBean.ListBean> list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wonderful_activities);
        dropdownButton1 = (DropdownButton) findViewById(R.id.time1);
        dropdownButton1.setText("活动");
        dropdownButton2 = (DropdownButton) findViewById(R.id.time2);
        dropdownButton2.setText("店面不限");
        dropdownButton3 = (DropdownButton) findViewById(R.id.time3);
        dropdownButton3.setText("排序");
        gridView = (GridView)findViewById(R.id.gridview);
        initSomeData();
        dropdownButton1.setData(times);
        dropdownButton2.setData(types);
        dropdownButton3.setData(names);

        initAdapter();


    }
    private void initSomeData() {
        times = new ArrayList<>();
        types = new ArrayList<>();
        names = new ArrayList<>();


        times.add(new DropBean("活动不限"));
        times.add(new DropBean("市场活动"));
        times.add(new DropBean("保险活动"));
        times.add(new DropBean("团购"));
        times.add(new DropBean("限时抢购"));
        times.add(new DropBean("定时秒杀"));
        times.add(new DropBean("买赠"));
        times.add(new DropBean("套餐"));

        types.add(new DropBean("店面不限"));
        types.add(new DropBean("全部会员店"));
        types.add(new DropBean("历史下单店"));


        names.add(new DropBean("默认排序"));
        names.add(new DropBean("距离最近"));
        names.add(new DropBean("评价最高"));

        images = new int[]{R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher
                ,R.mipmap.ic_launcher};

    }

    private void initAdapter() {

        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, Object> map = new HashMap<>();
        map.put("shopCode", "店面不限");
        map.put("pageSize", "10");
        map.put("tk", "D66705E90A30D7D6E4E657E6E7517D60");
        map.put("pageNum", "0");
        map.put("sortType", "默认排序");
//        map.put("productType", "全部分类");
        String mapstr = Cjson.toJSONMap(map);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), mapstr);
        Request request = new Request.Builder()
                .url("http://39.106.173.47:8080/app/boutique/showProduct.do")
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
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson = new Gson();
                        huodongBean = gson.fromJson(string1, HuodongBean.class);
                        list1 = huodongBean.getData().getList();
                        HuodongDapter huodongDapter  = new HuodongDapter(WonderfulActivities.this, list1);
                        gridView.setAdapter(huodongDapter);
                    }
                });
                Log.e("TAG", "hahahah" + string1);
            }
        });

    }
}
