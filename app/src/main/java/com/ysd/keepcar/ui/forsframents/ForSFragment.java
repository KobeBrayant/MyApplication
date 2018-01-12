package com.ysd.keepcar.ui.forsframents;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseFragMent;
import com.ysd.keepcar.config.HttpUrl;
import com.ysd.keepcar.utils.Cjson;
import com.ysd.keepcar.utils.DropBean;
import com.ysd.keepcar.utils.DropdownButton;
import com.ysd.keepcar.utils.OkhttpUtils;
import com.ysd.keepcar.utils.SharedPreferencesUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ForSFragment extends BaseFragMent {
    private DropdownButton dropdownButton1;
    private DropdownButton dropdownButton2;
    private DropdownButton dropdownButton3;
    private List<DropBean> times;
    private List<DropBean> types;
    private List<DropBean> names;
    private GridView gridView;
    private ListView carList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_for;
    }


    @Override
    protected void init(View view) {
        dropdownButton1 = (DropdownButton) view.findViewById(R.id.time1);
        dropdownButton1.setText("品牌");
        dropdownButton2 = (DropdownButton) view.findViewById(R.id.time2);
        dropdownButton2.setText("店面");
        dropdownButton3 = (DropdownButton) view.findViewById(R.id.time3);
        dropdownButton3.setText("排序");
        carList = (ListView) view.findViewById(R.id.four_list4s);
/*

        List<FourBean> carlist = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            carlist.add(new FourBean(R.mipmap.ic_launcher,"宝马"));
        }
*/




    }


    @Override
    protected void loadData() {


        times = new ArrayList<>();
        types = new ArrayList<>();
        names = new ArrayList<>();


        times.add(new DropBean("活动不限"));


        types.add(new DropBean("店面不限"));
        types.add(new DropBean("全部会员店"));
        types.add(new DropBean("历史下单店"));
        names.add(new DropBean("默认排序"));
        names.add(new DropBean("距离最近"));
        names.add(new DropBean("评价最高"));
        dropdownButton1.setData(times);
        dropdownButton2.setData(types);
        dropdownButton3.setData(names);

        httpmethod("");
    }

    private void httpmethod(String sho) {
        OkhttpUtils okhttpUtils = OkhttpUtils.newInstance();

        Map<String,Object> map=new HashMap<>();
        map.put("ak","f4474404846d470a8e1f6c081a28acc5");
        map.put("channel","android");
        map.put("brandId","");
        map.put("shopCode","");
        map.put("sortType","");
        map.put("pageNum","0");
        map.put("pageSize","10");
        final String s = Cjson.toJSONMap(map);
        final RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),s);
        Call call = okhttpUtils.doPost(HttpUrl.BASEURL + "4sShop/shopList.do", requestBody);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("aaa",string+"0000000");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson=new Gson();
                        ForFragmentBeen forFragmentBeen = gson.fromJson(string, ForFragmentBeen.class);
                        String code = forFragmentBeen.getCode();
                        if(code.equals("200")){
                            final List<ForFragmentBeen.DataBean.ListBean> list = forFragmentBeen.getData().getList();
                            MyFourListAdapter m=new MyFourListAdapter(getActivity(),list);
                            carList.setAdapter(m);
                            carList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                    Log.e("aaa",list.get(i).getShopCode()+"---");
                                    //SharedPreferencesUtils.setParam(getActivity(),"shopcode",list.get(i).getShopCode());
                                    Intent intent = new Intent(getActivity(), Four_s_ShopActivity.class);
                                    intent.putExtra("shop",list.get(i).getShopCode());
                                    startActivity(intent);
                                }
                            });
                        }
                    }
                });
            }
        });
    }

}
