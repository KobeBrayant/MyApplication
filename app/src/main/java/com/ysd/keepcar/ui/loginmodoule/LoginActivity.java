package com.ysd.keepcar.ui.loginmodoule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ysd.keepcar.R;
import com.ysd.keepcar.base.BaseActivity;
import com.ysd.keepcar.ui.loginmodoule.presenterlogin.LoginPresentI;
import com.ysd.keepcar.ui.loginmodoule.presenterlogin.LoginPresenter;
import com.ysd.keepcar.ui.loginmodoule.view.LoginViewI;

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
            public void onClick(View v) {
                String phone = edt_user_phone.getText().toString();
                String code = edt_user_code.getText().toString();
                Log.e("aaaaaaa","aaaaaaaa");
                login(phone,code);
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
    }
}
