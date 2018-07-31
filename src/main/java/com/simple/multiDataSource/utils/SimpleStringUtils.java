package com.simple.multiDataSource.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @description 
 * @author jiangwj
 * @date 2018年7月31日
 *
 */
public class SimpleStringUtils {

    /**
     * 获取map中指定key的值且不为空
     * @param key
     * @param targetMap
     * @return
     */
    public static String getValueByKey(String key, Map targetMap) {
		return getValueByKey(key, targetMap, "");
    }
    
    /**
     * 
     * @param key
     * @param targetMap
     * @param defaultValue 默认值
     * @return
     */
    public static String getValueByKey(String key, Map targetMap ,String defaultValue) {
        return targetMap.get(key) == null ? defaultValue : targetMap.get(key) + "";
    }
    
    /**
     * 主动分页方法只适用于结果较少的场景
     *
     * @param result   查询结果
     * @param pageNum  开始页数
     * @param pageSize 每页数量
     * @return
     */
    public static <T> List<T> parseResultByPage(List<T> result, int pageNum, int pageSize) {

        List<T> subObjects = new ArrayList<>();
        if (result != null) {
            int startIndex = Math.min(result.size(), pageNum * pageSize);
            if (startIndex == result.size()) {
                return subObjects;
            }
            int endIndex = Math.min(result.size(), startIndex + pageSize);
            subObjects = result.subList(startIndex, endIndex);
        }
        return subObjects;
    }

}
