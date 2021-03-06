package com.ysd.keepcar.chengshi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.ysd.keepcar.R;
import com.ysd.keepcar.chengshi.adapter.CityListAdapter;
import com.ysd.keepcar.chengshi.adapter.ResultListAdapter;
import com.ysd.keepcar.chengshi.db.DBManager;
import com.ysd.keepcar.chengshi.model.City;
import com.ysd.keepcar.chengshi.model.LocateState;
import com.ysd.keepcar.chengshi.utils.StringUtils;
import com.ysd.keepcar.chengshi.view.SideLetterBar;

import java.util.List;


/**
 * Author Bro0cL on 2016/12/16.
 */
public class CityPickerActivity extends CheckPermissionsActivity implements View.OnClickListener, CheckPermissionsListener {
    public static final String KEY_PICKED_CITY = "picked_city";

    private ListView mListView;
    private ListView mResultListView;
    private SideLetterBar mLetterBar;
    private EditText searchBox;
    private ImageView clearBtn;
    private TextView cancelBtn;
    private ViewGroup emptyView;

    private CityListAdapter mCityAdapter;
    private ResultListAdapter mResultAdapter;
    private List<City> mAllCities;
    private List<City> mResultCities;
    private DBManager dbManager;

    private AMapLocationClient mLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cp_activity_city_list);

        initData();
        initView();
        initLocation();
        //请求权限
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            mLocationClient.startLocation();
        }else {
            requestPermissions(this, neededPermissions, this);
        }
    }

    private void initLocation() {
        mLocationClient = new AMapLocationClient(this);
        AMapLocationClientOption option = new AMapLocationClientOption();
        option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        option.setOnceLocation(true);
        mLocationClient.setLocationOption(option);
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        String city = aMapLocation.getCity();

                        String district = aMapLocation.getDistrict();
                        String location = StringUtils.extractLocation(city, district);

                        mCityAdapter.updateLocateState(LocateState.SUCCESS, location);
                     /*   String address = aMapLocation.getAddress();
                        String poiName = aMapLocation.getPoiName();
                        Log.e("ass",poiName);
                        Log.e("ass",address);
                        Log.e("as",city);*/
                    } else {
                        //定位失败
                       Log.e("----", aMapLocation.getErrorCode()+"bbb");
                        Log.e("----1111----",mLocationClient.getLastKnownLocation().getAddress()+"0000");
                        String address = aMapLocation.getAddress();
                        String city = aMapLocation.getCity();
                        Log.e("----", address+"bbaaab");
                        Log.e("----", city+"bbaaab");
                        mCityAdapter.updateLocateState(LocateState.FAILED, null);
                    }
                }
            }
        });
    }

    private void initData() {
        dbManager = new DBManager(this);
        dbManager.copyDBFile();
       // mAllCities = dbManager.getAllCities();
        mAllCities=dbManager.getAllCities();
        mCityAdapter = new CityListAdapter(this, mAllCities);
        mCityAdapter.setOnCityClickListener(new CityListAdapter.OnCityClickListener() {
            @Override
            public void onCityClick(String name) {
                backWithData(name);
            }

            @Override
            public void onLocateClick() {
                mCityAdapter.updateLocateState(LocateState.LOCATING, null);
                requestPermissions(CityPickerActivity.this, neededPermissions, CityPickerActivity.this);
            }
        });

        mResultAdapter = new ResultListAdapter(this, null);
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.listview_all_city);
        mListView.setAdapter(mCityAdapter);

        TextView overlay = (TextView) findViewById(R.id.tv_letter_overlay);
        mLetterBar = (SideLetterBar) findViewById(R.id.side_letter_bar);
        mLetterBar.setOverlay(overlay);
        mLetterBar.setOnLetterChangedListener(new SideLetterBar.OnLetterChangedListener() {
            @Override
            public void onLetterChanged(String letter) {
                int position = mCityAdapter.getLetterPosition(letter);
                mListView.setSelection(position);
            }
        });

//        searchBox = (EditText) findViewById(R.id.et_search);
//        searchBox.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {}
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                String keyword = s.toString();
//                if (TextUtils.isEmpty(keyword)) {
//                    clearBtn.setVisibility(View.GONE);
//                    emptyView.setVisibility(View.GONE);
//                    mResultListView.setVisibility(View.GONE);
//                } else {
//                    clearBtn.setVisibility(View.VISIBLE);
//                    mResultListView.setVisibility(View.VISIBLE);
//                    mResultCities = dbManager.searchCity(keyword);
//                    if (mResultCities == null || mResultCities.size() == 0) {
//                        emptyView.setVisibility(View.VISIBLE);
//                    } else {
//                        emptyView.setVisibility(View.GONE);
//                        mResultAdapter.changeData(mResultCities);
//                    }
//                }
//            }
//        });

        emptyView = (ViewGroup) findViewById(R.id.empty_view);
        mResultListView = (ListView) findViewById(R.id.listview_search_result);
        mResultListView.setAdapter(mResultAdapter);
        mResultListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                backWithData(mResultAdapter.getItem(position).getName());
            }
        });

//        clearBtn = (ImageView) findViewById(R.id.iv_search_clear);
//        cancelBtn = (TextView) findViewById(R.id.tv_search_cancel);

//        clearBtn.setOnClickListener(this);
//        cancelBtn.setOnClickListener(this);
    }

    private void backWithData(String city){
        Intent data = new Intent();
        data.putExtra(KEY_PICKED_CITY, city);
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
//        if (i == R.id.iv_search_clear) {
//            searchBox.setText("");
//            clearBtn.setVisibility(View.GONE);
//            emptyView.setVisibility(View.GONE);
//            mResultListView.setVisibility(View.GONE);
//            mResultCities = null;
//        }
    }

    @Override
    public void onGranted() {
        mLocationClient.startLocation();
    }

    @Override
    public void onDenied(List<String> permissions) {
        Toast.makeText(this, "权限被禁用，请到设置里打开", Toast.LENGTH_SHORT).show();
        mCityAdapter.updateLocateState(LocateState.FAILED, null);
    }
}
