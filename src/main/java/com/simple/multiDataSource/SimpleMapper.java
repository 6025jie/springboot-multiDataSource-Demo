package com.simple.multiDataSource;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 
 * @description 
 * @author jiangwj
 * @date 2018年7月31日
 *
 */
public interface SimpleMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
