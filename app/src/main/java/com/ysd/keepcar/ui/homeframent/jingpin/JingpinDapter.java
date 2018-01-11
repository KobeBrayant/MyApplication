package com.ysd.keepcar.ui.homeframent.jingpin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ysd.keepcar.R;

import java.util.List;

/**
 * Created by dell on 2018/1/10.
 */

public class JingpinDapter extends BaseAdapter {
    private Context context;
    private ImageView jingpin_biao;
    private TextView jingpin_fukuan;
    private ImageView jingpin_image;
    private TextView jingpin_dianpu;
    private TextView jingpin_qian;
    private TextView jingpin_gongsi;
    List<Beena.DataBean.ListBean> list;

    public JingpinDapter(Context context, List<Beena.DataBean.ListBean> list) {
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
       view= LayoutInflater.from(context).inflate(R.layout.jingpin_item,null);
      jingpin_biao =  (ImageView)  view.findViewById(R.id.jingpin_biao);
      jingpin_fukuan =  (TextView)  view.findViewById(R.id.jingpin_fukuan);
      jingpin_image =  (ImageView) view.findViewById(R.id.jingping_image);
       jingpin_dianpu = (TextView) view.findViewById(R.id.jingpin_name);
       jingpin_qian = (TextView) view.findViewById(R.id.jingpin_qian);
       jingpin_gongsi = (TextView) view.findViewById(R.id.jingpin_gongsi);

        Glide.with(context).load(list.get(i).getLogo()).into(jingpin_biao);
        jingpin_dianpu.setText(list.get(i).getProductName());
jingpin_gongsi.setText(list.get(i).getShopName());
        return view;
    }
}
