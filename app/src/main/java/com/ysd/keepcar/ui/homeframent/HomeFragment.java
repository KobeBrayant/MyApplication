package com.ysd.keepcar.ui.homeframent;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseFragMent;
import com.ysd.keepcar.ui.WonderfulActivities;
import com.ysd.keepcar.ui.homeframent.baner.BannerBean;
import com.ysd.keepcar.ui.homeframent.baner.HomeBean;
import com.ysd.keepcar.ui.homeframent.baner.HomeDapter;
import com.ysd.keepcar.ui.homeframent.baner.Horbean;
import com.ysd.keepcar.ui.homeframent.jingpin.JingpinActivity;
import com.ysd.keepcar.ui.homeframent.qrcode.EWMActivity;
import com.ysd.keepcar.ui.homeframent.qrcode.SYSActivity;
import com.ysd.keepcar.ui.jifen.JifenActivity;
import com.ysd.keepcar.ui.shopingframents.ShopFraments;
import com.ysd.keepcar.ui.xiche.XiCarActivity;
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
public class HomeFragment extends BaseFragMent implements View.OnClickListener {
    private static final int REQUEST_CODE_PICK_CITY = 233;
    private ImageView top_xiajian;
    private TextView top_bei;
    private ListView pullListView;
    private View top;
    private List<Horbean> mhorbean;
    List<String> shopList = new ArrayList<>();
    //图片
    String TU_PIAN = "http://39.106.173.47:8080/saas-img";
    private Banner banner;
    private ArrayList<String > bannerlist =null;

    private RadioButton top_baoyang;
    private RadioButton top_weixiu;
    private RadioButton top_zhanshi;
    private RadioButton top_xubao;
    private RadioButton top_jingpin;
    private RadioButton top_xiche;
    private RadioButton top_huodong;
    private RadioButton top_jifen;
    private RadioButton top_weizhang;
    private RadioButton top_jiuyuan;
    private ImageView top_jia;
    private RelativeLayout viewById;
    private PopupWindow window;
    private ViewFlipper flipper;
    private List<String> testList;
    private int count;
    private int mItemCount = 9;
    private View bomm;
    private SwipeRefreshLayout swip;
    private ListView home_list;
  private  List<HomeBean> mlist = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void init(View view) {
        viewById = view.findViewById(R.id.My_Title);
        top_xiajian = (ImageView) view.findViewById(R.id.top_xiajian);
        top_bei = (TextView) view.findViewById(R.id.top_bei);
        top_jia = (ImageView) view.findViewById(R.id.top_jia);
        pullListView =  (ListView) view.findViewById(R.id.mVideoListView);
       inittop();
//        pullListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
//            @Override
//            public void onRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
//                String label = DateUtils.formatDateTime(
//                       getContext(),
//                        System.currentTimeMillis(),
//                        DateUtils.FORMAT_SHOW_TIME
//                                | DateUtils.FORMAT_SHOW_DATE
//                                | DateUtils.FORMAT_ABBREV_ALL);
//                // 显示最后更新的时间
//                pullListView.getLoadingLayoutProxy()
//                        .setLastUpdatedLabel(label);
//
//                // 模拟加载任务
//                new GetDataTask().execute();
//            }
//        });
//
//    }
//    private class GetDataTask extends AsyncTask<Void, Void, String> {
//
//        @Override
//        protected String doInBackground(Void... params) {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//            }
//            return "" + (mItemCount++);
//        }
//        @Override
//        protected void onPostExecute(String result)
//        {
//           // mAdapter.notifyDataSetChanged();
//            // Call onRefreshComplete when the list has been refreshed.
//            pullListView.onRefreshComplete();
//        }
    }
        private void inittop() {
        top = View.inflate(getActivity(), R.layout.top_home, null);
        bomm = View.inflate(getActivity(), R.layout.top_bomm, null);
            initboom();
       banner = (Banner) top.findViewById(R.id.home_banner);
         //   swip =  (SwipeRefreshLayout)top.findViewById(R.id.swip);
        top_baoyang =  (RadioButton)   top.findViewById(R.id.top_baoyang);
        top_weixiu =  (RadioButton)   top.findViewById(R.id.top_weixiu);
        top_zhanshi =  (RadioButton)  top.findViewById(R.id.top_zhanshi);
        top_xubao =  (RadioButton)  top.findViewById(R.id.top_xubao);
        top_jingpin =  (RadioButton)   top.findViewById(R.id.top_jingpin);
        top_xiche =  (RadioButton)  top.findViewById(R.id.top_xiche);
        top_huodong =  (RadioButton)  top.findViewById(R.id.top_huodong);
        top_jifen =  (RadioButton)  top.findViewById(R.id.top_jifen);
        top_weizhang =  (RadioButton)  top.findViewById(R.id.top_weizhang);
        top_jiuyuan =  (RadioButton)  top.findViewById(R.id.top_jiuyuan);
//            swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//                @Override
//                public void onRefresh() {
//                    new Handler().postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            // TODO Auto-generated method stub
//                            swip.setRefreshing(false);
//                        }
//                    }, 3000);
//                }
//            });
        flipper = (ViewFlipper) top.findViewById(R.id.flipper);
        testList = new ArrayList();
        testList.add(0, "坐在里面是件美事，被人们看见坐在其中更是快事。");
        testList.add(1, "该车外型一直维持不变，所以外型上很丑陋，但其性能一直在改进。");
        testList.add(2, "车到山前必有路，有路必有丰田车 更远更自由");
        testList.add(3, "激活新力量新雅阁新力量新登场");
        testList.add(4, "和谐灵动，君子风范和谐生活新成员");
        count = testList.size();
        for (int i = 0; i < count; i++) {
            final View ll_content = View.inflate(getActivity(), R.layout.item_flipper, null);
            TextView tv_content = (TextView) ll_content.findViewById(R.id.tv_content);
            ImageView iv_closebreak = (ImageView) ll_content.findViewById(R.id.iv_closebreak);
            tv_content.setText(testList.get(i).toString());
            iv_closebreak.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //对当前显示的视图进行移除
                    flipper.removeView(ll_content);
                    count--;
                    //当删除后仅剩 一条 新闻时，则取消滚动
                    if (count == 1) {
                        flipper.stopFlipping();
                    }
                }
            });
            flipper.addView(ll_content);
        }
        top_baoyang.setOnClickListener(this);
        top_weixiu.setOnClickListener(this);
                top_zhanshi.setOnClickListener(this);
        top_xubao.setOnClickListener(this);
        top_jingpin.setOnClickListener(this);
        top_xiche.setOnClickListener(this);
        top_huodong.setOnClickListener(this);
        top_jifen.setOnClickListener(this);
        top_weizhang.setOnClickListener(this);
        top_jiuyuan.setOnClickListener(this);
        initbanner();


    }

    private void initboom() {
      home_list =  (ListView)   bomm.findViewById(R.id.home_listbom);
        for (int i = 0; i <5 ; i++) {
         mlist.add(new HomeBean(R.mipmap.ic_launcher,R.mipmap.xiche1,"精品"+i,"惠尔普斯店铺"+i,"329人付款","$999"+i));
        }
        getActivity().runOnUiThread(new Runnable() {
          @Override
          public void run() {
              HomeDapter  homeDapter = new HomeDapter(getActivity(),mlist);
              home_list.setAdapter(homeDapter);
          }
      });
    }

    private void initbanner() {
        shopList.clear();
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
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                string1 = response.body().string();
           bean = new Gson().fromJson(string1, BannerBean.class);
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
        //  头布局
//        ListView refreshableView = pullListView.getRefreshableView();
        pullListView.addHeaderView(top);
        //尾布局

        pullListView.addHeaderView(bomm);
        pullListView.setAdapter(null);
        top_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                but(view);

            }
        });
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //保养
            case R.id.top_baoyang :
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framelayout, new ShopFraments(), null)
                        .addToBackStack(null)
                        .commit();

                break;
                //维修
            case  R.id.top_weixiu:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framelayout, new ShopFraments(), null)
                        .addToBackStack(null)
                        .commit();
                break;
                //展示
            case  R.id.top_zhanshi:
                break;
            //续保
            case  R.id.top_xubao:
                break;
            //精品
            case  R.id.top_jingpin:
  startActivity(new Intent(getActivity(), JingpinActivity.class));
                break;
            //洗车
            case  R.id.top_xiche:
startActivity(new Intent(getActivity(), XiCarActivity.class));
                break;
            //活动
            case  R.id.top_huodong:
                startActivity(new Intent(getActivity(),WonderfulActivities.class));
                break;
            //积分
            case  R.id.top_jifen:
             startActivity(new Intent(getActivity(), JifenActivity.class));
                break;
            //违章
            case  R.id.top_weizhang:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framelayout, new ShopFraments(), null)
                        .addToBackStack(null)
                        .commit();
                break;
            //救援
            case  R.id.top_jiuyuan:
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.framelayout, new ShopFraments(), null)
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }

    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }

    }
    @SuppressLint("NewApi")
    public void but(View v) {

        View view = View.inflate(getActivity(), R.layout.menu_item, null);
        TextView myRWM = view.findViewById(R.id.My_EWM);
        TextView mySYS = view.findViewById(R.id.My_SYS);
        window = new PopupWindow(view, ActionBar.LayoutParams.WRAP_CONTENT,
                android.support.v4.view.ViewPager.LayoutParams.WRAP_CONTENT,
                true);
//        ColorDrawable cd = new ColorDrawable(0x000000);
        // 弹出框 默认弹出之后不能关闭 这里设置一个背景就可以关了
        window.setBackgroundDrawable(getResources().getDrawable(R.mipmap.erweima));
        window.setFocusable(true);
        //设置popupwindow外的的区域可点击
        window.setOutsideTouchable(true);
//设置popupwindow获得焦点
        WindowManager.LayoutParams lp=getActivity().getWindow().getAttributes();
        lp.alpha = 0.4f;
        getActivity().getWindow().setAttributes(lp);
		/*
		 * 第一个参数： 要加载的布局 第二个参数： 这个弹出框的宽 第三个参数： 这个弹出框的高 第四个参数： boolean类型 默认是false
		 * 如果传入true 代表当前弹出框获取了焦点 也就是可以点击
		 */

        // showAsDropDown(View anchor)：相对某个控件的位置，无偏移
       // 这个v其实代表的就是这个按钮
        window.showAsDropDown(v);

       // showAtLocation(View parent, int gravity, int x, int y)：相对于父控件的位置
//        window.showAtLocation(v, Gravity.RIGHT, 0, -730);
        myRWM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(),EWMActivity.class));
                window.dismiss();
            }
        });
        mySYS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().startActivity(new Intent(getActivity(),SYSActivity.class));
                window.dismiss();
            }
        });
        window.setOnDismissListener(new PopupWindow.OnDismissListener(){

            //在dismiss中恢复透明度
            public void onDismiss(){
                WindowManager.LayoutParams lp=getActivity().getWindow().getAttributes();
                lp.alpha = 1f;
                getActivity().getWindow().setAttributes(lp);

            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();
//        bannerlist.clear();
    }
}