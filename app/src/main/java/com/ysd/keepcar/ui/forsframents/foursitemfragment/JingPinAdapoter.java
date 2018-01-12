package com.ysd.keepcar.ui.forsframents.foursitemfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ysd.keepcar.R;
import com.ysd.keepcar.config.HttpUrl;

import java.util.List;

/**
 * Created by 特雷西麦克格蕾蒂 on 2018/1/12.
 */

public class JingPinAdapoter extends BaseAdapter {
    Context c;
    List<JingPinBeen.DataBean.ListBean> list;

    public JingPinAdapoter(Context c, List<JingPinBeen.DataBean.ListBean> list) {
        this.c = c;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(c).inflate(R.layout.item_fours_layout,null);
        TextView viewitem_name = convertView.findViewById(R.id.viewitem_name);
        TextView viewitem_dianname = convertView.findViewById(R.id.viewitem_dianname);
        TextView viewitem_money = convertView.findViewById(R.id.viewitem_money);
        ImageView viewitem_image = convertView.findViewById(R.id.viewitem_image);
            viewitem_dianname.setText(list.get(position).getProductName());
            viewitem_name.setText(list.get(position).getShopName());
            viewitem_money.setText("￥"+list.get(position).getDiscountPrice()+"");
        Glide.with(c).load(HttpUrl.IMGBASE+list.get(position).getLogo()).into(viewitem_image);


        return convertView;
    }
}
