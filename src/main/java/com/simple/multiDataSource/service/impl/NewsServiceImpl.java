package com.simple.multiDataSource.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.simple.multiDataSource.mapper.NewsMapper;
import com.simple.multiDataSource.model.News;
import com.simple.multiDataSource.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Override
	public News getNews(String newsId) {
		return newsMapper.getNewsByNewsId(newsId);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map getNewsByClassName(String className, Integer offset, Integer limit) {
		Map<String, Object> results = new HashMap<>();
		
		String classId = newsMapper.getClassId(className);
		
		Page<Object> page = PageHelper.offsetPage(offset, limit, true);
		List<News> newsList = newsMapper.getNewsList(classId);
		
        return results;
	}

	
	@Autowired
	NewsMapper newsMapper;

}
