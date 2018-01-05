package com.ysd.keepcar.ui.homeframent.baner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.ysd.keepcar.R;

/**
 * Created by 刘贵河 on 2018/1/3.
 */

public class MyGridAdapter extends BaseAdapter {
      private int[] images;
    private ViewHolder holder;
    private Context context;
    public MyGridAdapter(int[] images,Context context) {
        super();
        this.images = images;
        this.context=context;
    }

    @Override
    public int getCount() {
        return images.length;
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
        if (view==null) {
            holder = new ViewHolder();

            view = View.inflate(context, R.layout.grid_item, null);

            holder.image = (ImageView) view.findViewById(R.id.item_tou);

            view.setTag(holder);
        }else{

            holder = (ViewHolder) view.getTag();

        }
        holder.image.setImageResource(images[i]);


        return view;
    }
    static class ViewHolder{
        public View ImageView;
        ImageView image;
    }
}
