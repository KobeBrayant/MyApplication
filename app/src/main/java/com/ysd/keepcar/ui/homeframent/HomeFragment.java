package com.ysd.keepcar.ui.homeframent;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseFragMent;
import com.ysd.keepcar.ui.homeframent.baner.BannerBean;
import com.ysd.keepcar.ui.homeframent.baner.Horbean;
import com.zaaach.citypicker.CityPickerActivity;

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

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragMent {
    private static final int REQUEST_CODE_PICK_CITY = 233;
    private ImageView top_xiajian;
    private TextView top_bei;
    private PullToRefreshListView pullListView;
    private View top;
    private List<Horbean> mhorbean;
    List<String> shopList = new ArrayList<>();
    //图片
    String TU_PIAN = "http://39.106.173.47:8080/saas-img";
    private Banner banner;
    private ArrayList<String > bannerlist =null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(View view) {
        top_xiajian = (ImageView) view.findViewById(R.id.top_xiajian);
        top_bei = (TextView) view.findViewById(R.id.top_bei);
       pullListView =  (PullToRefreshListView) view.findViewById(R.id.mVideoListView);
       inittop();
    }
    private void inittop() {
        top = View.inflate(getActivity(), R.layout.top_home, null);
       banner = (Banner) top.findViewById(R.id.home_banner);
        initbanner();
    }
    private void initbanner() {
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), "");
        Request request = new Request.Builder()
                .url("http://39.106.173.47:8080/app/main/queryBrandImg.do")
                                .post(requestBody)
                                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            private BannerBean bean;
            private String string1;

            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "错误：" + e.toString());
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                string1 = response.body().string();
           bean = new Gson().fromJson(string1, BannerBean.class);
                Log.e("TAG", "成功：" + string1);
               getActivity().runOnUiThread(new Runnable() {
                    private String s;
                    @Override
                    public void run() {
                        shopList.addAll(bean.getData());
//                                设置图片加载器
                        banner.setImageLoader(new GlideImage());
                        bannerlist = new ArrayList<>();
                        bannerlist.clear();

                        for (int i = 0; i < shopList.size(); i++) {
                            s = shopList.get(i);
                            bannerlist.add(TU_PIAN + s);
                        }

                        banner.setImages(bannerlist);
                        //设置自动轮播，默认为true
                        banner.isAutoPlay(true);
                        //设置轮播时间
                        banner.setDelayTime(1500);
                        //设置指示器位置（当banner模式中有指示器时）
                        banner.setIndicatorGravity(BannerConfig.CENTER);
                        //banner设置方法全部调用完毕时最后调用
                        banner.start();

                    }
                });

            }
        });

    }

    @Override
    protected void loadData() {
        ListView refreshableView = pullListView.getRefreshableView();
        refreshableView.addHeaderView(top);
        top_bei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(getActivity(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                top_bei.setText(city);
            }
        }
    }
    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }

    }
}