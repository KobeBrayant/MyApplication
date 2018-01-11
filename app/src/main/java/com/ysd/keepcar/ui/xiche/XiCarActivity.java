package com.ysd.keepcar.ui.xiche;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.ui.xiche.dapter.Xicardaptero;
import com.ysd.keepcar.utils.Cjson;
import com.ysd.keepcar.utils.DropBean;
import com.ysd.keepcar.utils.DropdownButton;
import com.ysd.keepcar.utils.SharedPreferencesUtils;

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

public class XiCarActivity extends AppCompatActivity {

    private TextView titlebiao;
    private ImageView title_fanhui;
    private ImageView title_fan;
    private DropdownButton dropdownButton1;
    private DropdownButton dropdownButton2;
    private ArrayList<DropBean> times;
    private ArrayList<DropBean> types;
    private ListView gridview_xiche;
    private List<XiCarBean.DataBean.ListBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xi_car);
        initview();
        initdata();
        initload();
        inithttp();
    }

    private void inithttp() {
        OkHttpClient client = new OkHttpClient();
        Map<String,Object> kp = new HashMap<>();
        String ticket = (String) SharedPreferencesUtils.getParam(XiCarActivity.this, "ticket", "");
        kp.put("pageNum",0);
        kp.put("pageSize",10);
        String s = Cjson.toJSONMap(kp);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),s);
        Request request = new Request.Builder()
                .url("http://39.106.173.47:8080/app/washcar/queryWashShops.do")
                .post(requestBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {



            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TTT",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("TTT",string);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list = new Gson().fromJson(string, XiCarBean.class).getData().getList();
                        gridview_xiche.setAdapter(new Xicardaptero(XiCarActivity.this,list));

                    }
                });

            }
        });
    }

    private void initload() {
       gridview_xiche =   (ListView) findViewById(R.id.xiListView);
//        List<FourBean> carlist = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            carlist.add(new FourBean(R.mipmap.ic_launcher,"公司名称"));
//        }
//     gridview_xiche.setAdapter(new XiCarDapter(this,carlist));
        gridview_xiche.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(XiCarActivity.this,DetailsActivity.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void initdata() {
        title_fan = (ImageView) findViewById(R.id.title_fanhui);
        dropdownButton1 = (DropdownButton) findViewById(R.id.time1);
        dropdownButton1.setText("店面");
        dropdownButton2 = (DropdownButton) findViewById(R.id.time2);
        dropdownButton2.setText("排序");
        initSomeData();
        dropdownButton1.setData(times);
        dropdownButton2.setData(types);
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


        times.add(new DropBean("店面不限"));
        times.add(new DropBean("全部洗车店"));
        times.add(new DropBean("全部会员店"));
        times.add(new DropBean("品牌4S店"));
        times.add(new DropBean("历史下单店"));


        types.add(new DropBean("默认排序"));
        types.add(new DropBean("距离最短"));
        types.add(new DropBean("评价最高"));
        types.add(new DropBean("价格最低"));

    }


    private void initview() {
        titlebiao = (TextView) findViewById(R.id.title_biao);
        title_fanhui = (ImageView) findViewById(R.id.title_fanhui);
        titlebiao.setText("洗车");
        title_fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
