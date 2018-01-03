package com.ysd.keepcar.ui.loginmodoule;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseActivity;
import com.ysd.keepcar.ui.loginmodoule.entity.ReCode;
import com.ysd.keepcar.ui.loginmodoule.presenterlogin.LoginPresentI;
import com.ysd.keepcar.ui.loginmodoule.presenterlogin.LoginPresenter;
import com.ysd.keepcar.ui.loginmodoule.view.LoginViewI;
import com.ysd.keepcar.utils.SharedPreferencesUtils;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class LoginActivity extends BaseActivity implements LoginViewI{


    private EditText edt_user_phone;
    private EditText edt_user_code;
    private Button login_button;
    private TextView getyan;
    private String str;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        edt_user_phone = (EditText) findViewById(R.id.edt_user_phone);
        edt_user_code = (EditText) findViewById(R.id.edt_user_code);
        login_button = (Button) findViewById(R.id.login_button);
        getyan = (TextView) findViewById(R.id.getyan);
    }

    @Override
    protected void initData() {
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = edt_user_phone.getText().toString();
                String code = edt_user_code.getText().toString();
                if (!phone.equals("")&&!code.equals("")&&code.length()==6){
                    SharedPreferencesUtils.setParam(LoginActivity.this,"userphone",phone);
                    login(phone,code);
                }else {
                    Toast.makeText(LoginActivity.this,"手机号不能为空",Toast.LENGTH_SHORT).show();
                }
            }

            private void login(String phone, String code) {
                LoginPresentI loginPresentI=new LoginPresenter(LoginActivity.this);
                String string = "{\"accountUname\":\""+phone+"\",\"ak\":\"f4474404846d470a8e1f6c081a28acc5\",\"channel\":\"android\"}";
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),string);
                loginPresentI.event("http://39.106.173.47:8080/app//account/m_login/v1_0.do",requestBody);
            }
        });


        getyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = edt_user_phone.getText().toString();
                String code = edt_user_code.getText().toString();
//                getyan.setText("已发送");
                if (!phone.equals("")&&phone.length()==11){
                    login(phone,code);
                }else {
                    Toast.makeText(LoginActivity.this,"手机号不能为空",Toast.LENGTH_SHORT).show();
                }

            }
            private void login(String phone,String code) {
                LoginPresentI loginPresentI=new LoginPresenter(LoginActivity.this);
                String string = "{\"accountUname\":\""+phone+"\",\"ak\":\"f4474404846d470a8e1f6c081a28acc5\",\"channel\":\"android\"}";
                RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),string);
                loginPresentI.event("http://39.106.173.47:8080/app/vcode/m_sendSms_v1_0.do",requestBody);
            }


        });


    }



    @Override
    public void setPresenter(Object o) {

        str = (String) o;
        Log.e("asda",str);

        ReCode reCode = new Gson().fromJson(str, ReCode.class);
        String code = reCode.getCode();
        if (Integer.parseInt(code)==200){
            String data = reCode.getData();
            if (!TextUtils.isEmpty(data)){
                SharedPreferencesUtils.setParam(this,"ticket",data);
                //自己保存一个值用来判断登陆状态
                SharedPreferencesUtils.setParam(this,"tag",1);
      finish();

                // TK:   D66705E90A30D7D6E4E657E6E7517D60
            }
        }


    }
}
