package com.simple.multiDataSource.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.simple.multiDataSource.mapper.UserInfoMapper;
import com.simple.multiDataSource.model.UserInfo;
import com.simple.multiDataSource.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Override
	public Object insertUserInfo(String name, String job, String workDetail, String icon) {
		UserInfo ui = new UserInfo();
		
		ui.setName(name);
		ui.setJob(job);
		ui.setWorkDetail(workDetail);
		ui.setIcon(icon);
		ui.setCreateTime(new Date());
		ui.setLastupdateTime(new Date());
		
		int result = userInfoMapper.insertUseGeneratedKeys(ui);
		
		return null;
	}
	

	@Override
	public Object updateUserInfo(Long id, String name, String job, String workDetail, String icon) {
		
		UserInfo ui = userInfoMapper.selectByPrimaryKey(id);
		
		if (ui != null && ui.getId() > 0) {
			ui.setName(name);
			ui.setJob(job);
			ui.setWorkDetail(workDetail);
			ui.setIcon(icon);
			ui.setLastupdateTime(new Date());
		}else{
//			return new SuccessResponseWithMsg(false, Constant.UPDATE_FAILED +"，用户信息不存在");
		}
		
		int result = userInfoMapper.updateByPrimaryKey(ui);
//		if (result <= 0) {
//			throw new SimpleException(500, Constant.UPDATE_FAILED);
//		}
//		return new SuccessResponse(true);
		return null;
	}
	
	@Override
	public Object deleteUserInfoById(Long id) {
		int result = userInfoMapper.deleteByPrimaryKey(id);
//		if (result <= 0) {
//			throw new SimpleException(500, Constant.DELETE_FAILED);
//		}
//		return new SuccessResponse(true);
		return null;
	}

	@Override
	public Map<String, Object> queryUserInfos(String queryStr, Integer offset, Integer limit) {
		Map<String, Object> results = new HashMap<>();
		
		Page<Object> page = PageHelper.offsetPage(offset, limit, true);
		
		List<UserInfo> list = userInfoMapper.queryList(queryStr);
		
		for(UserInfo r : list){
			r.toBean();
		}
		
        return results;
	}
	
	@Override
	public List<UserInfo> queryAll() {
		List<UserInfo> list = userInfoMapper.queryList("");
		
		for(UserInfo r : list){
			r.toBean();
			r.setId(null);
		}
		return list;
	}
	
	
	@Autowired
	UserInfoMapper userInfoMapper;
	
}
