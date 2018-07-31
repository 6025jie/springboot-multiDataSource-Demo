package com.simple.multiDataSource.service;

import java.util.List;
import java.util.Map;

import com.simple.multiDataSource.model.UserInfo;

public interface UserInfoService {
	
	Object insertUserInfo(String name, String job, String workDetail, String icon);
	
	Object updateUserInfo(Long id,String name, String job, String workDetail, String icon);
	
	Object deleteUserInfoById(Long id);
	
	Map<String, Object> queryUserInfos(String queryStr, Integer offset, Integer limit);
	
	List<UserInfo> queryAll();
	
}
