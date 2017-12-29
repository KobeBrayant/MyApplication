package com.ysd.keepcar.ui.loginmodoule.presenterlogin;

import com.ysd.keepcar.base.BasePresenterI;

import okhttp3.RequestBody;

/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/29.
 */

public interface LoginPresentI extends BasePresenterI {
    @Override
    void onStart();
    void event(String url, RequestBody requestBody);
}
