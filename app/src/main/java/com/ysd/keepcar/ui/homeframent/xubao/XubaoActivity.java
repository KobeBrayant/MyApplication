package com.ysd.keepcar.ui.homeframent.xubao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ysd.keepcar.R;

public class XubaoActivity extends AppCompatActivity {

    private TextView title_biao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xubao);
        initview();
    }

    private void initview() {
     title_biao =   (TextView) findViewById(R.id.title_biao);
   title_biao.setText("4S店续保");

    }
}
