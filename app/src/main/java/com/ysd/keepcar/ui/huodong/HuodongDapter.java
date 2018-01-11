package com.ysd.keepcar.ui.huodong;

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
 * Created by dell on 2018/1/11.
 */

public class HuodongDapter extends BaseAdapter {
    private Context context;
    private List<HuodongBean.DataBean.ListBean> mlist;
    private ImageView item_tou;
    private ImageView item_chebiao;
    private TextView item_dian;
    private TextView item_shihuo;
    private TextView item_shijian;
    private TextView item_jiaqian;
    private TextView jinxing;

    public HuodongDapter(Context context, List<HuodongBean.DataBean.ListBean> mlist) {
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
        view=   LayoutInflater.from(context).inflate(R.layout.huodong_item,null);
      item_tou =  (ImageView) view.findViewById(R.id.item_tou);
  item_chebiao =  (ImageView) view.findViewById(R.id.item_chebiao);
 item_dian = (TextView) view.findViewById(R.id.item_dian);
 item_shihuo = (TextView) view.findViewById(R.id.item_shihuo);
     item_shijian =   (TextView) view.findViewById(R.id.item_shijian);
      item_jiaqian =  (TextView)view.findViewById(R.id.item_jiaqian);
       jinxing = (TextView) view.findViewById(R.id.item_jinxing);
      item_dian.setText(mlist.get(i).getShopName());
        item_shihuo.setText(mlist.get(i).getProductName());
        item_shijian.setText(mlist.get(i).getUseYear()+"");
        item_jiaqian.setText(mlist.get(i).getDiscountPrice()+"");
        return view;
    }
}
