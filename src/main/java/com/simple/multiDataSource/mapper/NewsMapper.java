package com.simple.multiDataSource.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.simple.multiDataSource.config.DS;
import com.simple.multiDataSource.config.DatabaseType;
import com.simple.multiDataSource.model.News;
import tk.mybatis.mapper.common.Mapper;

/**
 * 用户信息
 * @description 
 * @author jiangwj
 * @date 2018年7月20日
 *
 */
public interface NewsMapper extends Mapper<News> {
	/**
	 * 根据新闻分类名，获取分类id
	 * @param className
	 * @return
	 */
	@DS(DatabaseType.sqlserverDb)
	String getClassId(@Param("className") String className);
	
	/**
	 * 根据分类id，获取新闻列表
	 * @param classid
	 * @return
	 */
	@DS(DatabaseType.sqlserverDb)
	List<News> getNewsList(@Param("classid") String classid);
	
	/**
	 * 获取前几条新闻
	 * @param classid
	 * @param top
	 * @return
	 */
	@DS(DatabaseType.sqlserverDb)
	List<News> getTopNewsList(@Param("classid") String classid, @Param("top") Integer top);
	
	/**
	 * 根据新闻id获取新闻
	 * @param newsid
	 * @return
	 */
	@DS(DatabaseType.sqlserverDb)
	News getNewsByNewsId(@Param("newsid") String newsid);
	
	
}