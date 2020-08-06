package com.reptiles.demo;


import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘晓亮
 * @date 2020/8/6 17:41
 */
public class
Test {
    public static void main(String[] args) {
        String host = "http://apigateway.jianjiaoshuju.com";
        String path = "/api/v_1/air.html";
        String method = "POST";
        String appcode = "EC89F57304B53A9E9D2D6EF205A91CFD";
        String appKey = "AKIDdd58a5658f37c3262e4e54ce70e901ac";
        String appSecret = "bd49fe369bd1669ab74823f32e0e3d61";
        Map headers = new HashMap();
        headers.put("appcode",appcode);
        headers.put("appKey",appKey);
        headers.put("appSecret",appSecret);
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map querys = new HashMap();
        Map bodys = new HashMap();
        bodys.put("arrive_code", "BJS");
        bodys.put("leave_code", "TAO");
        bodys.put("query_date", "2020-09-31");
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
             * 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            // 获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
