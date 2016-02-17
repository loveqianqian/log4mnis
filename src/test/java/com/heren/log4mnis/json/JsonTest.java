package com.heren.log4mnis.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * <p>Description:</p>
 * <p>ProjectName:log4mnis</p>
 * Created by diaozhiwei on 2016/2/17.
 */
public class JsonTest {
    @Test
    public void testJsonTrans() {
        try {
            String json = "{\"result\": false,\"msg\": null}";
            String xml = "<test><id>myId</id></test>";
            JSONObject jsonObject = JSON.parseObject(xml);
            System.out.println(jsonObject.toString());
        } catch (JSONException e) {
            System.out.println("false");
        }
    }
}
