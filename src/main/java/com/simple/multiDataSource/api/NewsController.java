package com.simple.multiDataSource.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.simple.multiDataSource.model.News;
import com.simple.multiDataSource.service.NewsService;

@RestController
@RequestMapping("/api/news")
public class NewsController {
	
	//获取新闻详情
	@GetMapping("/{newsId}")
	public News getNewsDetail(@PathVariable("newsId") String newsId){
		News news = newsService.getNews(newsId);
		if(news == null){
			news = new News();
		}
		return news;
	}
	
	
	
	@Autowired
	NewsService newsService;
}
