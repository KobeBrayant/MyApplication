package com.ysd.keepcar.ui.homeframent.zhanshiting.frament.beandapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ysd.keepcar.R;

import java.util.ArrayList;
import java.util.List;


public class MyBrandAdapter extends RecyclerView.Adapter<MyBrandAdapter.ViewHolder> {
    private List<BranBeen.DataBean> data;
    private Context context;

    public MyBrandAdapter(List<BranBeen.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_brand, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        List<BranBeen.DataBean.BrandListBean> brandList = data.get(position).getBrandList();
        List<BranBeen.DataBean.BrandListBean> list = new ArrayList<>();
        list.addAll(brandList);
        Log.e("TAG2222222",brandList.size()+"");
        Log.e("TAG3333333",list.size()+"");
        MyBrandLvAdapter adapter = new MyBrandLvAdapter(list, context);
        holder.ListView.setAdapter(adapter);
        setListViewHeight(holder.ListView);
        adapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final ListView ListView;

        public ViewHolder(View itemView) {
            super(itemView);
            ListView = (ListView) itemView.findViewById(R.id.listview);
        }

    }


    public class MyBrandLvAdapter extends BaseAdapter {
        private List<BranBeen.DataBean.BrandListBean> brandList;
        private Context context;

        public MyBrandLvAdapter(List<BranBeen.DataBean.BrandListBean> brandList, Context context) {
            this.brandList = brandList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return brandList.size();
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
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ListViewHolder listViewHolder;
            if (null == view) {
                listViewHolder = new ListViewHolder();
                view = LayoutInflater.from(context).inflate(R.layout.car_listview_itme, null);
                listViewHolder.mTvindex = view.findViewById(R.id.tv_index);
                listViewHolder.mTvname = view.findViewById(R.id.tv_name);
                listViewHolder.mImgLogo = view.findViewById(R.id.tv_img);
                view.setTag(listViewHolder);
            } else {
                listViewHolder = (ListViewHolder) view.getTag();
            }
            if (i == 0 || !brandList.get(i - 1).getK().equals(brandList.get(i).getK())) {
                listViewHolder.mTvindex.setVisibility(View.VISIBLE);
                listViewHolder.mTvindex.setText(brandList.get(i).getK());
            } else {
                listViewHolder.mTvindex.setVisibility(View.GONE);
            }

            Glide.with(context).load("http://39.106.173.47:8080/app" + brandList.get(i).getLogo()).into(listViewHolder.mImgLogo);
            listViewHolder.mTvname.setText(brandList.get(i).getValue());

            listViewHolder.mTvname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    ToastUtils.showLong(context,brandList.get(i).getValue());
                }
            });

            return view;
        }

    }

    class ListViewHolder {
        private TextView mTvindex;
        private TextView mTvname;
        private ImageView mImgLogo;
    }

    //重置ListView高度
    public static void setListViewHeight(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(1, 1);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight
                + (listView.getDividerHeight() * (listAdapter.getCount() - 1))
                + listView.getPaddingTop() + listView.getPaddingBottom();
        listView.setLayoutParams(par);
    }
}