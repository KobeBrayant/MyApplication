package com.ysd.keepcar.ui.forsframents;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.GridView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseFragMent;
import com.ysd.keepcar.utils.DropBean;
import com.ysd.keepcar.utils.DropdownButton;

import java.util.ArrayList;
import java.util.List;


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

    }
}
