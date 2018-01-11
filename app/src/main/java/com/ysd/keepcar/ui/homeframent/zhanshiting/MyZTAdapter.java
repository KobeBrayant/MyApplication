package com.ysd.keepcar.ui.homeframent.zhanshiting;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
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
 * Created by 刘贵河 on 2018/1/11.
 */

public class MyZTAdapter extends BaseAdapter {
    Context context;
    List<ZTBean.DataBean.ListBean> carList;
    private ViewHolder holder;



    public MyZTAdapter(Context context, List<ZTBean.DataBean.ListBean> carList) {
        this.context = context;
        this.carList = carList;
    }

    @Override
    public int getCount() {
        return carList.size();
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
        if (view==null){
            holder = new ViewHolder();
            view = View.inflate(context,R.layout.zhanting_item, null);
            holder.car_icon = (ImageView) view.findViewById(R.id.zhan_chezhao);
            holder.carName = (TextView) view.findViewById(R.id.zhan_cheming);
            holder.carShi = (TextView) view.findViewById(R.id.zhan_shijiaqian);
            holder.carMony = (TextView) view.findViewById(R.id.zhan_jiage);
            holder.carYuyue = (TextView) view.findViewById(R.id.zhan_shijia);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.carName.setText(carList.get(i).getBrandName()+"-"+carList.get(i).getSeriesName());
        holder.carShi.setText(carList.get(i).getModelName());


        return view;
    }
    static class ViewHolder {
        private ImageView car_icon;
        private TextView carName;
        private TextView carShi;
        private TextView carMony;
        private TextView carYuyue;
    }
}
