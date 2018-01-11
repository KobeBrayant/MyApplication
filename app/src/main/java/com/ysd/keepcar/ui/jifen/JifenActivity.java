package com.ysd.keepcar.ui.jifen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.ui.homeframent.baner.HomeBean;
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

public class JifenActivity extends AppCompatActivity {

    private DropdownButton dropdownButton1;
    private DropdownButton dropdownButton2;
    private DropdownButton dropdownButton3;
    private List<DropBean> times;
    private List<DropBean> types;
    private List<DropBean> names;
    private ImageView title_fan;
    private GridView gridview;
    private List<HomeBean> mlist = new ArrayList<>();
    private List<JifenBean.DataBean.ListBean> list;
    private JifenDapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jifen);
        initview();
        initdata();
    }

    private void initdata() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Map<String, Object> map = new HashMap<>();
        map.put("shopCode", "店面不限");
        map.put("pageSize", "10");
        map.put("pageNum", "0");
        map.put("searchType", "默认排序");
        map.put("productType", "全部分类");
        String mapstr = Cjson.toJSONMap(map);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), mapstr);
        Request request = new Request.Builder()
                .url("http://39.106.173.47:8080/app/integralMall/showProduct_v1_0.do")
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
                        JifenBean beena=gson.fromJson(string1,JifenBean.class);
                        list = beena.getData().getList();
                        myAdapter = new JifenDapter(JifenActivity.this, list);
                        gridview.setAdapter(myAdapter);
                    }
                });
                Log.e("TAG", "hahahah" + string1);
            }
        });


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(JifenActivity.this, XiangqingActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initview() {
       gridview= (GridView)  findViewById(R.id.gridView);
        title_fan = (ImageView) findViewById(R.id.title_fanhui);
        dropdownButton1 = (DropdownButton) findViewById(R.id.time1);
        dropdownButton1.setText("分类不限");
        dropdownButton2 = (DropdownButton) findViewById(R.id.time2);
        dropdownButton2.setText("店面不限");
        dropdownButton3 = (DropdownButton) findViewById(R.id.time3);
        dropdownButton3.setText("默认排序");
        initSomeData();
        dropdownButton1.setData(times);
        dropdownButton2.setData(types);
        dropdownButton3.setData(names);
        title_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void initSomeData() {
        times = new ArrayList<>();
        types = new ArrayList<>();
        names = new ArrayList<>();

        times.add(new DropBean("分类不限"));
        times.add(new DropBean("精品"));
        times.add(new DropBean("定值卷"));
        times.add(new DropBean("余额卷"));
        times.add(new DropBean("项目"));
        times.add(new DropBean("洗车"));


        types.add(new DropBean("店面不限"));
        types.add(new DropBean("全部会员店"));

        names.add(new DropBean("默认排序"));
        names.add(new DropBean("销量最高"));
        names.add(new DropBean("积分值最低"));
    }

}

