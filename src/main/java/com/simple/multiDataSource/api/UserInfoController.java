package com.simple.multiDataSource.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.simple.multiDataSource.model.UserInfo;
import com.simple.multiDataSource.service.UserInfoService;
import com.simple.multiDataSource.utils.PageResponse;
import com.simple.multiDataSource.utils.SimpleStringUtils;

@RestController
@RequestMapping("/api/userInfo")
public class UserInfoController {
	
	//查询所有
	@SuppressWarnings({ "rawtypes", "unchecked"})
	@GetMapping("/list")
	public PageResponse queryUserInfos(){
		List<UserInfo> list = new ArrayList<UserInfo>();
		try {
			list = userInfoService.queryAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new PageResponse(list, list.size());
	}
	
	//分页查询
	@SuppressWarnings({ "rawtypes", "unchecked"})
	@GetMapping
	public Map queryUserInfos(
			@RequestParam(value = "queryStr", required = false, defaultValue = "") String queryStr,
			@RequestParam(value = "offset", required = false, defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit){
		
		Map<String,Object> results = userInfoService.queryUserInfos(queryStr, offset, limit);
        
		return results;
	}
           
	//增加用户信息
	@PostMapping
   	public Object addUserInfo(@RequestBody HashMap<String, String> map) throws Exception {
		String name = SimpleStringUtils.getValueByKey("name", map);
		String job = SimpleStringUtils.getValueByKey("job", map, "");
		String workDetail = SimpleStringUtils.getValueByKey("workDetail", map , "");
		String icon = SimpleStringUtils.getValueByKey("icon", map , "");
		
		return userInfoService.insertUserInfo(name, job, workDetail, icon);
	}
            
	// 修改用户信息
	@PostMapping("/{id}")
	public Object updateUserInfoById(@PathVariable("id") Long id, @RequestBody HashMap<String, String> map)
			throws Exception {
		String name = SimpleStringUtils.getValueByKey("name", map);
		String job = SimpleStringUtils.getValueByKey("job", map, "");
		String workDetail = SimpleStringUtils.getValueByKey("workDetail", map , "");
		String icon = SimpleStringUtils.getValueByKey("icon", map , "");
		
		return userInfoService.updateUserInfo(id, name, job, workDetail, icon);
	}

		
	//删除用户信息(删除子节点、父节点)
	@DeleteMapping("/{id}")
    public Object deleteUserInfoById(@PathVariable("id") Long id) throws Exception{
		
		return userInfoService.deleteUserInfoById(id);
    }
	
	            
	@Autowired
	UserInfoService userInfoService;
	
}
