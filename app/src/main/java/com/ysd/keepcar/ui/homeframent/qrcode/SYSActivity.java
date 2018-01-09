package com.ysd.keepcar.ui.homeframent.qrcode;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.ysd.keepcar.R;

public class SYSActivity extends Activity implements View.OnClickListener,DecoratedBarcodeView.TorchListener{
    private Button btn_switch;

    private DecoratedBarcodeView mDBV;
    private CaptureManager captureManager;
    private boolean isLightOn = false;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys);
        tvResult = (TextView) findViewById(R.id.textView);


        initView();
        mDBV.setTorchListener(this);

        if (!hasFlash()) {
            btn_switch.setVisibility(View.GONE);
        }
        //重要代码，初始化捕获
        captureManager = new CaptureManager(this, mDBV);
        captureManager.initializeFromIntent(getIntent(), savedInstanceState);
        captureManager.decode();
    }

    @Override
    protected void onPause() {
        super.onPause();
        captureManager.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        captureManager.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        captureManager.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        captureManager.onSaveInstanceState(outState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return mDBV.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }


    private void initView() {
        btn_switch = (Button) findViewById(R.id.btn_switch);
        mDBV = (DecoratedBarcodeView) findViewById(R.id.dbv_custom);

        btn_switch.setOnClickListener(this);
    }


////TODO 返回值
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if(resultCode==RESULT_OK){
//            Bundle bundle = data.getExtras();
//            String result = bundle.getString("result");
//
//            tvResult.setText(result);
//        }
//    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_switch:
                if (isLightOn) {
                    mDBV.setTorchOff();
                } else {
                    mDBV.setTorchOn();
                }

//                    //TODO 跳转识别扫一扫

                break;

        }
    }

    @Override
    public void onTorchOn() {
        Toast.makeText(this, "torch on", Toast.LENGTH_LONG).show();
        isLightOn = true;
    }

    @Override
    public void onTorchOff() {
        Toast.makeText(this, "torch off", Toast.LENGTH_LONG).show();
        isLightOn = false;
    }

    // 判断是否有闪光灯功能
    private boolean hasFlash() {
        return getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }
}
