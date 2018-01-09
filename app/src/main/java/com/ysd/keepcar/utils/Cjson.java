package com.ysd.keepcar.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.Set;

/**
 * Created by 阿三 on 2018/1/3.
 */
public class Cjson {

    public static String toJSONMap(Map<String, Object> param) {
        Set<Map.Entry<String, Object>> entrySet = param.entrySet();
        JSONObject object=new JSONObject();
        try {
            object.put("ak","f4474404846d470a8e1f6c081a28acc5");
            object.put("channel","android");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (Map.Entry<String, Object> entry:entrySet) {
            String key = entry.getKey();
            Object value = param.get(key);
            try {
                object.put(key,value);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return object.toString();
    }
}
