package com.ysd.keepcar.ui.homeframent.zhanshiting.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.ui.homeframent.zhanshiting.frament.beandapter.XinBean;

import java.util.List;


/**
 * Created by dell on 2018/1/11.
 */

public class ZhanDapter extends BaseAdapter {
   private Context context;
    private List<XinBean.DataBean.ListBean> list;
    private TextView cheming;
    private ImageView chezhao;
    private TextView jiage;
    private TextView shijiaqian;
    private TextView shijia;
    private TextView zhanchexi;
    private TextView zhan_jiaqian;

    public ZhanDapter(Context context, List<XinBean.DataBean.ListBean> list) {
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
      view=  LayoutInflater.from(context).inflate(R.layout.item_zhantt,null);
      cheming =  (TextView) view.findViewById(R.id.zhan_cheming);
      chezhao =  (ImageView) view.findViewById(R.id.zhan_chezhao);
       jiage = (TextView)  view.findViewById(R.id.zhan_jiage);
    shijiaqian =    (TextView) view.findViewById(R.id.zhan_shijiaqian);
     shijia =   (TextView) view.findViewById(R.id.zhan_shijia);
        zhanchexi =    (TextView)  view.findViewById(R.id.zhan_chexi);
      zhan_jiaqian =  (TextView)   view.findViewById(R.id.zhan_jiaqian);
        cheming.setText(list.get(i).getBrandName());
        zhanchexi.setText(list.get(i).getSeriesName());
      jiage.setText(list.get(i).getMinPrice()+"");
      zhan_jiaqian.setText(list.get(i).getMaxPrice()+"");

        return view;
    }
}
