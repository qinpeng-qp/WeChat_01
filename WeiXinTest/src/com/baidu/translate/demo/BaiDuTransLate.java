package com.baidu.translate.demo;
import java.io.UnsupportedEncodingException;

import com.baidu.translate.demo.TransApi;

public class BaiDuTransLate {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20180530000169172";
    private static final String SECURITY_KEY = "Jrw9gxx5wocIZnN7n5rp";

    public static String transLate(String query) throws UnsupportedEncodingException {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        //String query = "翻译 ";
        return (api.getTransResult(query, "auto", "auto"));
    }

}
