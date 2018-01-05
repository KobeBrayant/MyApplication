package com.ysd.keepcar.ui.homeframent.baner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ysd.keepcar.R;

import java.util.List;

/**
 * Created by dell on 2018/1/2.
 */

public class Gridgedapter extends BaseAdapter {
       private Context context;
    private List<HomeBean> mlist;
    private TextView jifen_gongsi;

    public Gridgedapter(Context context, List<HomeBean> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @Override
    public int getCount() {
        return mlist.size();
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
      view=  LayoutInflater.from(context).inflate(R.layout.layout_jifen,null);
      jifen_gongsi =  (TextView) view.findViewById(R.id.jifen_gongsi);
       jifen_gongsi.setText(mlist.get(i).getMname());
       return view;
    }
}
