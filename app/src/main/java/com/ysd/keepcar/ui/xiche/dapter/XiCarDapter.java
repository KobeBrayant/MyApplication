package com.ysd.keepcar.ui.xiche.dapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ysd.keepcar.R;
import com.ysd.keepcar.ui.forsframents.FourBean;

import java.util.List;

/**
 * Created by dell on 2018/1/9.
 */

public class XiCarDapter extends BaseAdapter {
    Context context;
    List<FourBean> Flist;

    public XiCarDapter(Context context, List<FourBean> flist) {
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
        Glide.with(context).load(Flist.get(i).getImg()).into(icon_img);
        carName.setText(Flist.get(i).getName());
        return inflate;
    }
}
