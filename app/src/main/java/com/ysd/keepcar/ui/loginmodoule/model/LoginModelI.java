package com.ysd.keepcar.ui.loginmodoule.model;

import com.ysd.keepcar.base.BaseModelI;
import com.ysd.keepcar.net.CallBackI;

import okhttp3.RequestBody;

/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/29.
 */

public interface LoginModelI  extends BaseModelI{
    void data(String url, RequestBody requestBody, CallBackI callBackI);

}
