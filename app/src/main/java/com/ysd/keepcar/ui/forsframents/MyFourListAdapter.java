package com.ysd.keepcar.ui.forsframents;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseActivity;

import java.util.List;

/**
 * Created by 刘贵河 on 2018/1/5.
 */

class MyFourListAdapter extends BaseAdapter {

    Context context;
    List<ForFragmentBeen.DataBean.ListBean> list;

    public MyFourListAdapter(Context context, List<ForFragmentBeen.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.four_s_item, null);
        ImageView icon_img = inflate.findViewById(R.id.imageView4);
        TextView carName = inflate.findViewById(R.id.textView8);
        TextView forcity = inflate.findViewById(R.id.for_city);
        Glide.with(context).load(list.get(i).getLogo()).into(icon_img);
        carName.setText(list.get(i).getShopName());
        forcity.setText(list.get(i).getCityName());
        return inflate;
    }
}
