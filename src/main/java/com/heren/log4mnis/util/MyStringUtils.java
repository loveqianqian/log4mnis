package com.heren.log4mnis.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import org.apache.commons.lang.StringUtils;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:对字符串做出处理</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/17
 */
public class MyStringUtils extends StringUtils {
    /**
     * 判断是否是xml格式
     *
     * @return
     */
    public static boolean isXml(String value) {
        try {
            DocumentHelper.parseText(value);
        } catch (DocumentException e) {
            return false;
        }
        return true;
    }

    public static boolean isJson(String value) {
        try {
            JSON.parse(value);
        } catch (JSONException e) {
            return false;
        }
        return true;
    }
}
