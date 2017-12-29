package com.ysd.keepcar.ui.loginmodoule.presenterlogin;

import com.ysd.keepcar.net.CallBackI;
import com.ysd.keepcar.ui.loginmodoule.model.LoginModel;
import com.ysd.keepcar.ui.loginmodoule.model.LoginModelI;
import com.ysd.keepcar.ui.loginmodoule.view.LoginViewI;

import okhttp3.RequestBody;

/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/29.
 */

public class LoginPresenter implements LoginPresentI,CallBackI {
    LoginViewI loginViewI;
    LoginModelI loginModelI;

    public LoginPresenter(LoginViewI loginViewI) {
        this.loginViewI = loginViewI;
        loginModelI=new LoginModel();
    }

    @Override
    public void onStart() {


    }

    @Override
    public void event(String url, RequestBody requestBody) {
        loginModelI.data(url,requestBody,this);
    }

    @Override
    public void onSuccess(Object o) {
        String str = (String) o;
        loginViewI.setPresenter(str);
    }

    @Override
    public void onError(int errorCode, String errorMsg) {

    }
}
