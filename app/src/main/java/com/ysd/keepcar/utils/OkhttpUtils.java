package com.ysd.keepcar.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/26.
 */

public class OkhttpUtils {

    //1.声明OkHttpUtil类对象
    private static OkhttpUtils okHttpUtil;
    private static OkHttpClient okHttpClient;
    //2.构造方法私有化
    private OkhttpUtils() {
        okHttpClient = new OkHttpClient();
    }

    //3.提供公有方法供其他类访问获取本类对象
    public static OkhttpUtils newInstance() {
        if (null == okHttpUtil) {
            synchronized (OkhttpUtils.class) {
                if (null == okHttpUtil) {
                    okHttpUtil = new OkhttpUtils();
                }
            }
        }
        return okHttpUtil;
    }
    public Call doPost(String url, RequestBody requestBody){
        Request.Builder request = new Request.Builder();
        Request build = request.url(url).post(requestBody).build();
        Call call = okHttpClient.newCall(build);
        return call;
    }

}
