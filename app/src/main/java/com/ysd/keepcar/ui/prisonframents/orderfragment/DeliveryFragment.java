package com.ysd.keepcar.ui.prisonframents.orderfragment;


import android.os.Bundle;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ysd.keepcar.R;

import butterknife.internal.Finder;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeliveryFragment extends Fragment {


    public DeliveryFragment() {
        // Required empty public constructor
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delivery, container, false);
    }

}
