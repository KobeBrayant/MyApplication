package com.ysd.keepcar.ui.shopingframents.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ysd.keepcar.R;

public class ShouhuoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button shouhuo_car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouhuo);
        initView();
    }

    private void initView() {
        shouhuo_car = (Button) findViewById(R.id.shouhuo_car);

        shouhuo_car.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shouhuo_car:

                break;
        }
    }
}
