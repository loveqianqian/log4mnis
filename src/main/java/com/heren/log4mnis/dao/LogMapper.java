package com.heren.log4mnis.dao;

import com.heren.log4mnis.model.Log;

import java.util.List;
import java.util.Map;

/**
 * <p>ProjectName:log4mnis</p>
 * <p>Description:log日志map</p>
 *
 * @author:diaozhiwei
 * @data:2016/2/16
 */
public interface LogMapper {
    /**
     * 插入一条log信息
     * @param log
     */
    void addLog(Log log);

    /**
     * 根据id删除一条log
     * @param params
     */
    void delLogById(Map<String, Object> params);

    /**
     * 根据匹配时间戳，删除log信息
     * @param params
     */
    void delLogByTimeStamp(Map<String, Object> params);

    /**
     * 根据type类型，匹配log
     * @param params
     * @return
     */
    List<Log> queryLog(Map<String, Object> params);
}
