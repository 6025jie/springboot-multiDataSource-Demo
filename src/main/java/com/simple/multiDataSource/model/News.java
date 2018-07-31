package com.simple.multiDataSource.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 新闻
 * @description
 * @author jiangwj
 * @date 2018年7月27日
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class News {
	
	private String newsId;
	
	private String newsTitle;
	
	@JsonFormat(pattern = "MM-dd")
	private Date createTime;
	
	private String className;
	
	private String content;

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
