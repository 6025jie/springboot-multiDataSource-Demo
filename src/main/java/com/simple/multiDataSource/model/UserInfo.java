package com.simple.multiDataSource.model;

import java.util.Date;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@Table(name = "p_userinfo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 职务
     */
    private String job;

    /**
     * 工作分工
     */
    @Column(name = "work_detail")
    private String workDetail;

    /**
     * 头像
     */
    private String icon;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "lastupdate_time")
    private Date lastupdateTime;
    
    
    public void toBean(){
    	this.createTime = null;
    	this.lastupdateTime = null;
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取职务
     *
     * @return job - 职务
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置职务
     *
     * @param job 职务
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 获取工作分工
     *
     * @return work_detail - 工作分工
     */
    public String getWorkDetail() {
        return workDetail;
    }

    /**
     * 设置工作分工
     *
     * @param workDetail 工作分工
     */
    public void setWorkDetail(String workDetail) {
        this.workDetail = workDetail;
    }

    /**
     * 获取头像
     *
     * @return icon - 头像
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置头像
     *
     * @param icon 头像
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Date getLastupdateTime() {
		return lastupdateTime;
	}

	public void setLastupdateTime(Date lastupdateTime) {
		this.lastupdateTime = lastupdateTime;
	}
    
    
    
}