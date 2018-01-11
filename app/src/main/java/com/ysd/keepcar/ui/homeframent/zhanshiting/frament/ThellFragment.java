package com.ysd.keepcar.ui.homeframent.zhanshiting.frament;


import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.gjiazhe.wavesidebar.WaveSideBar;
import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseFragMent;
import com.ysd.keepcar.ui.homeframent.zhanshiting.MyZTAdapter;
import com.ysd.keepcar.ui.homeframent.zhanshiting.ZTBean;
import com.ysd.keepcar.ui.homeframent.zhanshiting.frament.beandapter.BranBeen;
import com.ysd.keepcar.ui.homeframent.zhanshiting.frament.beandapter.MyBrandAdapter;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class ThellFragment extends BaseFragMent implements WaveSideBar.OnSelectIndexItemListener, View.OnClickListener {


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
    private ImageView hua_liangxiang;
    private ImageView hua_sanxiang;
    private ImageView hua_suv;
    private ImageView hua_mvp;
    private ImageView hua_paocar;
    private ImageView hua_pika;
    private ImageView hua_mianbao;
    private ImageView hua_qitache;
    private RadioButton hua_guoer;
    private RadioButton hua_guosan;
    private RadioButton hua_guosi;
    private RadioButton hua_guowu;
    private RadioButton hua_qita;
    private RadioButton hua_shoudong;
    private RadioButton hua_zidong;
    private RadioButton hua_shouzi;
    private RadioButton hua_pai1;
    private RadioButton hua_pai2;
    private RadioButton hua_paisan;
    private RadioButton hua_paisi;
    private RadioButton hua_paiwu;
    private RadioButton hua_sanwan;
    private RadioButton hua_wuwan;
    private RadioButton hua_qiwan;
    private RadioButton hua_jiuwan;
    private RadioButton hua_shierwan;
    private RadioButton hua_shiliuwan;
    private RadioButton hua_ershiwan;
    private RadioButton hua_ershiyishang;
    private RadioButton hua_yinian;
    private RadioButton hua_liangnian;
    private RadioButton hua_sanian;
    private RadioButton hua_wunian;
    private RadioButton hua_qinian;
    private RadioButton hua_qinianshang;
    private RadioGroup Pailiang;
    private RadioGroup PailiangS;
    private RadioGroup AUTO_AGE;
    private RadioGroup AUTO_AGES;
    private RadioGroup PRICE;
    private RadioGroup PRICES;
    private RadioGroup PRICESS;
    private RadioGroup FRANCE_EPD_REGISTERED;
    private RadioGroup FRANCE_EPD_REGISTEREDS;
    private boolean isChangeGroup = false;
    private Button hua_queding;
    private Button hua_quxiao;
    private ListView car_item;
    private List<ZTBean.DataBean.ListBean> carListBean;
    @Override
        protected int getLayoutId() {
        return R.layout.fragment_thell;
    }

    @Override
    protected void init(View view) {
        car_item = (ListView) view.findViewById(R.id.ershoucar);
        dropdownButton1 = (TextView) view.findViewById(R.id.time1);
        dropdownButton2 = (DropdownButton) view.findViewById(R.id.time2);
        dropdownButton2.setText("4S店不限");
        dropdownButton3 = (DropdownButton) view.findViewById(R.id.time3);
        dropdownButton3.setText("排序");
        shaixuan_btn =  (TextView) view.findViewById(R.id.shaixuan_btn);
       dbl = (DrawerLayout) view.findViewById(R.id.drawerlayout);
        //侧滑的id
       right = (LinearLayout) view.findViewById(R.id.right);
       initright();
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
 //侧滑获取id
    private void initright() {
     //车辆类型
      hua_liangxiang =  (ImageView)  right.findViewById(R.id.hua_liangxiang);
      hua_sanxiang =  (ImageView) right.findViewById(R.id.hua_sanxiang);
        hua_suv =  (ImageView) right.findViewById(R.id.hua_suv);
        hua_mvp =  (ImageView) right.findViewById(R.id.hua_mvp);
        hua_paocar =  (ImageView) right.findViewById(R.id.hua_paocar);
        hua_pika =  (ImageView) right.findViewById(R.id.hua_pika);
        hua_mianbao =  (ImageView) right.findViewById(R.id.hua_mianbao);
        hua_qitache =  (ImageView) right.findViewById(R.id.hua_qitache);
      //环保标准
        hua_guoer =   (RadioButton) right.findViewById(R.id.hua_guoer);
        hua_guosan =(RadioButton) right.findViewById(R.id.hua_guosan);
       hua_guosi = (RadioButton) right.findViewById(R.id.hua_guosi);
        hua_guowu = (RadioButton) right.findViewById(R.id.hua_guowu);
       hua_qita = (RadioButton) right.findViewById(R.id.hua_qita);
    //变速
     hua_shoudong =   (RadioButton) right.findViewById(R.id.hua_shoudong);
     hua_zidong =   (RadioButton)  right.findViewById(R.id.hua_zidong);
     hua_shouzi =   (RadioButton) right.findViewById(R.id.hua_shouzi);
//排量

        Pailiang =(RadioGroup)right.findViewById(R.id.Pailiang);
        PailiangS =(RadioGroup)right.findViewById(R.id.PailiangS);
        //汽车排量
        hua_pai1 =   (RadioButton) right.findViewById(R.id.hua_pai1);
        hua_pai2 =   (RadioButton)  right.findViewById(R.id.hua_pai2);
        hua_paisan =   (RadioButton) right.findViewById(R.id.hua_paisan);
        hua_paisi =   (RadioButton)  right.findViewById(R.id.hua_paisi);
        hua_paiwu =   (RadioButton) right.findViewById(R.id.hua_paiwu);
        //价格
        PRICE =(RadioGroup)right.findViewById(R.id.PRICE);
        PRICES =(RadioGroup)right.findViewById(R.id.PRICES);
        PRICESS =(RadioGroup)right.findViewById(R.id.PRICESS);

        //环保标准
        FRANCE_EPD_REGISTERED =(RadioGroup)right.findViewById(R.id.FRANCE_EPD_REGISTERED);

        FRANCE_EPD_REGISTEREDS =(RadioGroup)right.findViewById(R.id.FRANCE_EPD_REGISTERED_S);
//价钱
        hua_sanwan =   (RadioButton) right.findViewById(R.id.hua_sanwan);
        hua_wuwan =   (RadioButton)  right.findViewById(R.id.hua_wuwan);
        hua_qiwan =   (RadioButton)  right.findViewById(R.id.hua_qiwan);
        hua_jiuwan =   (RadioButton)  right.findViewById(R.id.hua_jiuwan);
        hua_shierwan =   (RadioButton)  right.findViewById(R.id.hua_shierwan);
        hua_shiliuwan =   (RadioButton)  right.findViewById(R.id.hua_shiliuwan);
        hua_ershiwan =   (RadioButton)  right.findViewById(R.id.hua_ershiwan);
        hua_ershiyishang =   (RadioButton) right.findViewById(R.id.hua_ershiyishang);
        //车龄
        AUTO_AGE =(RadioGroup)right.findViewById(R.id.AUTO_AGE);
        AUTO_AGES =(RadioGroup)right.findViewById(R.id.AUTO_AGES);
       //车龄

        hua_yinian =   (RadioButton)   right.findViewById(R.id.hua_yinian);
        hua_liangnian =   (RadioButton)   right.findViewById(R.id.hua_liangnian);
        hua_sanian =   (RadioButton)    right.findViewById(R.id.hua_sanian);
        hua_wunian =   (RadioButton)    right.findViewById(R.id.hua_wunian);
        hua_qinian =   (RadioButton)    right.findViewById(R.id.hua_qinian);
        hua_qinianshang =   (RadioButton)   right.findViewById(R.id.hua_qinianshang);

//环保标准
        FRANCE_EPD_REGISTERED.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.hua_guoer:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(FRANCE_EPD_REGISTERED)){
                                isChangeGroup = true;
                                FRANCE_EPD_REGISTEREDS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(FRANCE_EPD_REGISTEREDS)){
                                isChangeGroup = true;
                                FRANCE_EPD_REGISTEREDS.setBackgroundResource(R.drawable.bg_commmm);
                                FRANCE_EPD_REGISTERED.clearCheck();
                                isChangeGroup = false;
                            }
                        }



                        break;
                    case R.id.hua_guosan:

                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(FRANCE_EPD_REGISTERED)){
                                isChangeGroup = true;
                                FRANCE_EPD_REGISTEREDS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(FRANCE_EPD_REGISTEREDS)){
                                isChangeGroup = true;
                                FRANCE_EPD_REGISTEREDS.setBackgroundResource(R.drawable.bg_commmm);
                                FRANCE_EPD_REGISTERED.clearCheck();
                                isChangeGroup = false;
                            }
                        }





                        break;
                    case R.id.hua_guosi:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(FRANCE_EPD_REGISTERED)){
                                isChangeGroup = true;
                                FRANCE_EPD_REGISTEREDS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(FRANCE_EPD_REGISTEREDS)){
                                isChangeGroup = true;
                                FRANCE_EPD_REGISTEREDS.setBackgroundResource(R.drawable.bg_commmm);
                                FRANCE_EPD_REGISTERED.clearCheck();
                                isChangeGroup = false;
                            }
                        }



                        break;


                }
            }
        });
        //环保标准
        FRANCE_EPD_REGISTEREDS.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.hua_guowu:

                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(FRANCE_EPD_REGISTEREDS)){
                                isChangeGroup = true;
                                FRANCE_EPD_REGISTERED.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(FRANCE_EPD_REGISTERED)){
                                isChangeGroup = true;
                                FRANCE_EPD_REGISTERED.setBackgroundResource(R.drawable.bg_commmm);
                                FRANCE_EPD_REGISTEREDS.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                    case R.id.hua_qita:

                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(FRANCE_EPD_REGISTEREDS)){
                                isChangeGroup = true;
                                FRANCE_EPD_REGISTERED.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(FRANCE_EPD_REGISTERED)){
                                isChangeGroup = true;
                                FRANCE_EPD_REGISTERED.setBackgroundResource(R.drawable.bg_commmm);
                                FRANCE_EPD_REGISTEREDS.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                }
            }
        });
//排量
        Pailiang.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.hua_pai1:

                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(Pailiang)){
                                isChangeGroup = true;
                                PailiangS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PailiangS)){
                                isChangeGroup = true;
                                Pailiang.clearCheck();
                                isChangeGroup = false;
                            }
                        }


                        break;
                    case R.id.hua_pai2:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(Pailiang)){
                                isChangeGroup = true;
                                PailiangS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PailiangS)){
                                isChangeGroup = true;
                                Pailiang.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                    case R.id.hua_paisan:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(Pailiang)){
                                isChangeGroup = true;
                                PailiangS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PailiangS)){
                                isChangeGroup = true;
                                Pailiang.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                }
            }
        });
        //排量
        PailiangS.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.hua_paisi:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(Pailiang)){
                                isChangeGroup = true;
                                PailiangS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PailiangS)){
                                isChangeGroup = true;
                                Pailiang.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                    case R.id.hua_paiwu:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(Pailiang)){
                                isChangeGroup = true;
                                PailiangS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PailiangS)){
                                isChangeGroup = true;
                                Pailiang.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                }
            }
        });
        //价格
        PRICE.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.hua_sanwan:


                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(PRICE)){
                                isChangeGroup = true;
                                PRICES.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICES)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICESS)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICES.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                    case R.id.hua_wuwan:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(PRICE)){
                                isChangeGroup = true;
                                PRICES.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICES)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICESS)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICES.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                    case R.id.hua_qiwan:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(PRICE)){
                                isChangeGroup = true;
                                PRICES.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICES)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICESS)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICES.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                }
            }
        });
        //价格
        PRICES.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.  hua_jiuwan:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(PRICES)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICE)){
                                isChangeGroup = true;
                                PRICES.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICESS)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICES.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                    case R.id.hua_shierwan:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(PRICES)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICE)){
                                isChangeGroup = true;
                                PRICES.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICESS)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICES.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                    case R.id.hua_shiliuwan:

                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(PRICES)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICE)){
                                isChangeGroup = true;
                                PRICES.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICESS)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICES.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;


                }
            }
        });
//价格
        PRICESS.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.hua_ershiwan:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(PRICESS)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICES.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICES)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICE)){
                                isChangeGroup = true;
                                PRICESS.clearCheck();
                                PRICES.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                    case R.id.hua_ershiyishang:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(PRICESS)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICES.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICES)){
                                isChangeGroup = true;
                                PRICE.clearCheck();
                                PRICESS.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(PRICE)){
                                isChangeGroup = true;
                                PRICESS.clearCheck();
                                PRICES.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;

                }
            }
        });
        //车龄
        AUTO_AGE.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.hua_yinian:


                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(AUTO_AGE)){
                                isChangeGroup = true;
                                AUTO_AGES.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(AUTO_AGES)){
                                isChangeGroup = true;
                                AUTO_AGE.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;

                    case R.id.hua_liangnian:

                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(AUTO_AGE)){
                                isChangeGroup = true;
                                AUTO_AGES.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(AUTO_AGES)){
                                isChangeGroup = true;
                                AUTO_AGE.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;

                    case R.id.hua_sanian:

                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(AUTO_AGE)){
                                isChangeGroup = true;
                                AUTO_AGES.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(AUTO_AGES)){
                                isChangeGroup = true;
                                AUTO_AGE.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;

                }
            }
        });
        //车龄
        AUTO_AGES.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.hua_wunian:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(AUTO_AGES)){
                                isChangeGroup = true;
                                AUTO_AGE.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(AUTO_AGE)){
                                isChangeGroup = true;
                                AUTO_AGES.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                    case R.id.hua_qinian:
                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(AUTO_AGES)){
                                isChangeGroup = true;
                                AUTO_AGE.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(AUTO_AGE)){
                                isChangeGroup = true;
                                AUTO_AGES.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                    case R.id.hua_qinianshang:

                        if ((radioGroup!=null)&&(i>-1)&&(!isChangeGroup)){
                            if (radioGroup.equals(AUTO_AGES)){
                                isChangeGroup = true;
                                AUTO_AGE.clearCheck();
                                isChangeGroup = false;
                            }else if (radioGroup.equals(AUTO_AGE)){
                                isChangeGroup = true;
                                AUTO_AGES.clearCheck();
                                isChangeGroup = false;
                            }
                        }
                        break;
                }
            }
        });

     hua_liangxiang.setOnClickListener(this);
        hua_sanxiang.setOnClickListener(this);
        hua_suv.setOnClickListener(this);
        hua_mvp.setOnClickListener(this);
        hua_paocar.setOnClickListener(this);
        hua_pika.setOnClickListener(this);
        hua_mianbao.setOnClickListener(this);
        hua_qitache.setOnClickListener(this);
    hua_queding =    (Button)   right.findViewById(R.id.hua_queding);
        hua_quxiao=  (Button) right.findViewById(R.id.hua_quxiao);
     hua_queding.setOnClickListener(this);
         hua_quxiao.setOnClickListener(this);


    }




    private void initSomeData() {
        types = new ArrayList<>();
        orings = new ArrayList<>();



        types.add(new DropBean("全部会员店"));
        types.add(new DropBean("某某某会员店"));


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

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case  R.id.hua_queding:
               getActivity().finish();
                break;
            case  R.id.hua_quxiao:
                getActivity().finish();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        OkHttpClient client = new OkHttpClient();

        Map<String,Object> kp = new HashMap<>();
        String ticket = (String) SharedPreferencesUtils.getParam(getContext(), "ticket", "");
        kp.put("ticket",ticket);
        kp.put("shopCode","店面不限");
        kp.put("sortType","默认排序");
        kp.put("pageNum",0);
        kp.put("pageSize",10);
        String s = Cjson.toJSONMap(kp);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),s);
        Request request = new Request.Builder()
                .url("http://39.106.173.47:8080/app/carExhibition/oldCarList.do")
                .post(requestBody)
                .build();

        Call call = client.newCall(request);
        call.enqueue(new Callback() {



            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG",e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();

                ZTBean ztBean = new Gson().fromJson(string, ZTBean.class);
                List<ZTBean.DataBean.ListBean> list = ztBean.getData().getList();
                carListBean = new ArrayList<>();
                carListBean.addAll(list);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        MyZTAdapter adapter = new MyZTAdapter(getActivity(),carListBean);
                        car_item.setAdapter(adapter);

                    }
                });
            }
        });
    }
}
