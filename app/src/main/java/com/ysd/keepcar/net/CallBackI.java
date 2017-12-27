package com.ysd.keepcar.net;

/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/26.
 */

public interface CallBackI<T> {
    void onSuccess(T t);
    void onError(int errorCode, String errorMsg);
}
