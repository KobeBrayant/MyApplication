package com.ysd.keepcar.ui.homeframent.baner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ysd.keepcar.R;

import java.util.List;

/**
 * Created by dell on 2018/1/2.
 */

public class HomeDapter extends BaseAdapter {
   private Context context;
   private List<HomeBean> mbean;
    private ImageView item_tou;
    private ImageView item_xiche;
    private TextView item_name;
    private TextView item_gongsi;
    private TextView item_fukuan;
    private TextView item_qian;

    public HomeDapter(Context context, List<HomeBean> mbean) {
        this.context = context;
        this.mbean = mbean;
    }

    @Override
    public int getCount() {
        return mbean.size();
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
      view=  LayoutInflater.from(context).inflate(R.layout.item_home,null);
//      item_tou =  (ImageView) view.findViewById(R.id.item_tou);
//       item_xiche = (ImageView) view.findViewById(R.id.item_xiche);
       item_name = (TextView) view.findViewById(R.id.item_name);
//      item_gongsi =  (TextView)  view.findViewById(R.id.item_gongsi);
//       item_fukuan = (TextView) view.findViewById(R.id.item_fukuan);
//       item_qian = (TextView) view.findViewById(R.id.item_qian);
//        Glide.with(context).load(mbean.get(i).getImageone()).into(item_tou);
//        Glide.with(context).load(mbean.get(i).getImagetwo()).into(item_xiche);
        item_name.setText(mbean.get(i).getMname());
//        item_gongsi.setText(mbean.get(i).getMcontent());
//        item_fukuan.setText(mbean.get(i).getGender());
//        item_qian.setText(mbean.get(i).getMoney());
        return view;
    }
}
