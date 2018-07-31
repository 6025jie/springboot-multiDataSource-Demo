package com.simple.multiDataSource.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.simple.multiDataSource.SimpleMapper;
import com.simple.multiDataSource.model.UserInfo;
/**
 * 用户信息
 * @description 
 * @author jiangwj
 * @date 2018年7月20日
 *
 */
public interface UserInfoMapper extends SimpleMapper<UserInfo> {
	
	List<UserInfo> queryList(@Param("queryStr") String queryStr);
	
}