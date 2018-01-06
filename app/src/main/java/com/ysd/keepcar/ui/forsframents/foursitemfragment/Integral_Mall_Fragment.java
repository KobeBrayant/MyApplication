package com.ysd.keepcar.ui.forsframents.foursitemfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ysd.keepcar.R;
import com.ysd.keepcar.utils.Cjson;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class Integral_Mall_Fragment extends Fragment {


    public Integral_Mall_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            HashMap<String, Object> map = new HashMap<>();
            map.put("productType","");
            map.put("shopCode","");
            map.put("searchType","");
            map.put("cityId","");
            map.put("pageSize","10");
            map.put("pageNum","0");
            map.put("tk","");
            map.put("q","");

            String str = Cjson.toJSONMap(map);



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_integral__mall_, container, false);
    }

}
