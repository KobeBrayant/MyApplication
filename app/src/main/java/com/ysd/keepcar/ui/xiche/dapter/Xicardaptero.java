package com.ysd.keepcar.ui.xiche.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysd.keepcar.R;
import com.ysd.keepcar.ui.xiche.XiCarBean;

import java.util.List;

/**
 * Created by dell on 2018/1/11.
 */

public class Xicardaptero extends BaseAdapter {
    Context context;
    List<XiCarBean.DataBean.ListBean> Flist;

    public Xicardaptero(Context context, List<XiCarBean.DataBean.ListBean> flist) {
        this.context = context;
        Flist = flist;
    }


    @Override
    public int getCount() {
        return Flist.size();
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
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_xicar, null);
        ImageView icon_img = inflate.findViewById(R.id.imageView1);
        TextView carName = inflate.findViewById(R.id.textView8);
//        Glide.with(context).load(Flist.get(i).getImg()).into(icon_img);
//        carName.setText(Flist.get(i).getName());
        carName.setText(Flist.get(i).getShopName());

        return inflate;
    }
}

