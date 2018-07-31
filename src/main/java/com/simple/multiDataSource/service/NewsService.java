package com.simple.multiDataSource.service;

import java.util.Map;

import com.simple.multiDataSource.model.News;

public interface NewsService {
	
	/**
	 * 获取新闻详情
	 * @param newsId
	 * @return
	 */
	News getNews(String newsId);
	
	/**
	 * 根据类型获取新闻列表
	 * @param className
	 * @return
	 */
	Map getNewsByClassName(String className, Integer offset, Integer limit);
	
}
