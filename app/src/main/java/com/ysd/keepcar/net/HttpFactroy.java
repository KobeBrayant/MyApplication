package com.ysd.keepcar.net;


import com.ysd.keepcar.utils.OkhttpUtils;

import okhttp3.OkHttpClient;

/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/26.
 */

public class HttpFactroy {
    public static OkhttpUtils create(){
        return OkhttpUtils.newInstance();
    }
}
