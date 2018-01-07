package com.ysd.keepcar.ui.forsframents;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

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

        List<FourBean> carlist = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            carlist.add(new FourBean(R.mipmap.ic_launcher,"宝马"));
        }
        carList.setAdapter(new MyFourListAdapter(getActivity(),carlist));


        carList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getActivity(),Four_s_ShopActivity.class));
            }
        });

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
