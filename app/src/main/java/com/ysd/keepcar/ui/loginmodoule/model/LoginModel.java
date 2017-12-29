package com.ysd.keepcar.ui.loginmodoule.model;

import com.ysd.keepcar.net.CallBackI;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/29.
 */

public class LoginModel implements LoginModelI {

    @Override
    public void data(String url, final RequestBody requestBody, final CallBackI callBackI) {
        Call call = iHttp.doPost(url, requestBody);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                callBackI.onSuccess(data);
            }
        });

    }
}
