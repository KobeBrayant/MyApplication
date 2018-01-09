package com.ysd.keepcar.ui.homeframent.jingpin;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.ysd.keepcar.R;
import com.ysd.keepcar.utils.DropBean;
import com.ysd.keepcar.utils.DropdownButton;

import java.util.ArrayList;
import java.util.List;

public class JingpinActivity extends AppCompatActivity {

    private ImageView title_fan;
    private DropdownButton dropdownButton1;
    private DropdownButton dropdownButton2;
    private DropdownButton dropdownButton3;
    private List<DropBean> times;
    private List<DropBean> types;
    private List<DropBean> names;

    private PopupWindow mPopupWindow;
    private String[] roots = new String[]{"装饰", "装饰", "装饰", "汽车用品", "汽车用品"};
    private String[][] sub_items = new String[][]{
            new String[]{"挂件", "挂件", "挂件", "挂件", "挂件"},
            new String[]{"挂件", "挂件", "挂件", "挂件", "挂件"},
            new String[]{"挂件", "挂件", "挂件", "挂件", "挂件"},
            new String[]{"汽车用品", "汽车用品", "汽车用品", "汽车用品", "汽车用品"},
            new String[]{"汽车用品", "汽车用品", "汽车用品", "汽车用品", "汽车用品"}};
    /**
     * 弹出的popupWindow布局
     */
    private LinearLayout popupLayout;

    /**
     * 子目录的布局
     */
    private FrameLayout subLayout;
    /**
     * 根目录被选中的节点
     */
    private ListView rootListView;
    private int selectedPosition;
    private ListView subListView;
    private TextView title_biao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jingpin);
        initview();
    }

    private void initview() {
        title_fan = (ImageView) findViewById(R.id.title_fanhui);
        title_biao = (TextView) findViewById(R.id.title_biao);
        title_biao.setText("4S店精品");
        dropdownButton1 = (DropdownButton) findViewById(R.id.time1);
        dropdownButton1.setText("分类");
        dropdownButton2 = (DropdownButton) findViewById(R.id.time2);
        dropdownButton2.setText("店面不限");
        dropdownButton3 = (DropdownButton) findViewById(R.id.time3);
        dropdownButton3.setText("默认排序");

        initSomeData();
        dropdownButton1.setData(times);
        dropdownButton2.setData(types);
        dropdownButton3.setData(names);
        title_fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        dropdownButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopBtn(ScreenUtils.getScreenWidth(JingpinActivity.this),
                        ScreenUtils.getScreenHeight(JingpinActivity.this));
            }
        });

    }

    private void showPopBtn(int screenWidth, int screenHeight) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = LayoutInflater.from(JingpinActivity.this);
        popupLayout = (LinearLayout) inflater.inflate(
                R.layout.popupwindow_layout, null, false);
        rootListView = (ListView) popupLayout.findViewById(R.id.root_listview);
        final RootListViewAdapter adapter = new RootListViewAdapter(
                JingpinActivity.this);
        adapter.setItems(roots);
        rootListView.setAdapter(adapter);

        /**
         * 子popupWindow
         */
        subLayout = (FrameLayout) popupLayout.findViewById(R.id.sub_popupwindow);

        /**
         * 初始化subListview
         */
        subListView = (ListView) popupLayout.findViewById(R.id.sub_listview);

        /**
         * 弹出popupwindow时，二级菜单默认隐藏，当点击某项时，二级菜单再弹出
         */
        subLayout.setVisibility(View.INVISIBLE);

        /**
         * 初始化mPopupWindow
         */
        mPopupWindow = new PopupWindow(popupLayout, screenWidth,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);

        /**
         * 有了mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
         * 这句可以使点击popupwindow以外的区域时popupwindow自动消失 但这句必须放在showAsDropDown之前
         */
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());

        /**
         * popupwindow的位置，第一个参数表示位于哪个控件之下 第二个参数表示向左右方向的偏移量，正数表示向左偏移，负数表示向右偏移
         * 第三个参数表示向上下方向的偏移量，正数表示向下偏移，负数表示向上偏移
         *
         */
        mPopupWindow.showAsDropDown(dropdownButton1, -5, 5);// 在控件下方显示popwindow

        mPopupWindow.update();

        rootListView
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        // TODO Auto-generated method stub

                        /**
                         * 选中root某项时改变该ListView item的背景色
                         */
                        adapter.setSelectedPosition(position);
                        adapter.notifyDataSetInvalidated();

                        selectedPosition = position;

                        SubListViewAdapter subAdapter = new SubListViewAdapter(
                                JingpinActivity.this, sub_items, position);
                        subListView.setAdapter(subAdapter);

                        /**
                         * 选中某个根节点时，使显示相应的子目录可见
                         */
                        subLayout.setVisibility(View.VISIBLE);
                        subListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                            @Override
                            public void onItemClick(
                                    AdapterView<?> parent, View view,
                                    int position, long id) {
                                // TODO Auto-generated method stub
                                popupLayout.setVisibility(View.GONE);
                                Toast.makeText(
                                        JingpinActivity.this,
                                        sub_items[selectedPosition][position],
                                        Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
    }


    private void initSomeData() {
        times = new ArrayList<>();
        types = new ArrayList<>();
        names = new ArrayList<>();
        times.add(new DropBean("分类"));

        types.add(new DropBean("店面不限"));
        types.add(new DropBean("全部会员店"));
        types.add(new DropBean("历史下单店"));

        names.add(new DropBean("默认排序"));
        names.add(new DropBean("销量最高"));
        names.add(new DropBean("价格最低"));
    }

}

