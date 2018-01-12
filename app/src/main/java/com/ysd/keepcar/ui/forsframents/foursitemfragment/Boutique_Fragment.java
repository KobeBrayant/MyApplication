package com.ysd.keepcar.ui.forsframents.foursitemfragment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseFragMent;
import com.ysd.keepcar.config.HttpUrl;
import com.ysd.keepcar.ui.forsframents.Four_s_ShopActivity;
import com.ysd.keepcar.utils.Cjson;
import com.ysd.keepcar.utils.OkhttpUtils;
import com.ysd.keepcar.utils.SharedPreferencesUtils;

import java.io.IOException;
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
public class Boutique_Fragment extends BaseFragMent {


    private GridView bouti_grid;

    public Boutique_Fragment() {
        // Required empty public constructor
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_boutique_;
    }

    @Override
    protected void init(View view) {
        bouti_grid = (GridView)view.findViewById(R.id.bouti_grid);
    }

    @Override
    protected void loadData() {

        OkhttpUtils okhttpUtils = OkhttpUtils.newInstance();
        Map<String,Object> map=new HashMap<>();
        //aaaaaaaaaaaa
        //String shopcode = (String) SharedPreferencesUtils.getParam(getActivity(), "shopcode", null);
        Four_s_ShopActivity activity = (Four_s_ShopActivity) getActivity();
        String shop = activity.shop;
        //String string = "{\"ak\":\"f4474404846d470a8e1f6c081a28acc5\",\"channel\":\"android\"}";
        map.put("ak","f4474404846d470a8e1f6c081a28acc5");
        map.put("channel","android");
        map.put("shopCode",shop);
        map.put("pageNum","0");
        map.put("pageSize","15");
        final String s = Cjson.toJSONMap(map);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),s);
        Call call = okhttpUtils.doPost(HttpUrl.BASEURL + "boutique/queryBoutiqueByShop.do", requestBody);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
               // Log.e("aa",e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("da",string+"---------");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson=new Gson();
                        JingPinBeen jingPinBeen = gson.fromJson(string, JingPinBeen.class);
                        String code = jingPinBeen.getCode();
                        if(code.equals("200")){
                            List<JingPinBeen.DataBean.ListBean> list = jingPinBeen.getData().getList();
                            JingPinAdapoter jingPinAdapoter=new JingPinAdapoter(getActivity(),list);
                            bouti_grid.setAdapter(jingPinAdapoter);
                        }
                    }
                });
            }
        });
    }


}
