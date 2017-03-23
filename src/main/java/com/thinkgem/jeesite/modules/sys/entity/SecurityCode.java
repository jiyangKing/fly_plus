/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import com.thinkgem.jeesite.common.persistence.BaseEntity;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Date;
import java.util.Map;

/**
 * 日志Entity
 * @author ThinkGem
 * @version 2014-8-19
 */
public class SecurityCode extends BaseEntity<SecurityCode> {

	private Integer id;
	private String securityCode; 		// 日志类型（1：接入日志；2：错误日志）
	private Integer use;		// 日志标题
	public String getSecurityCode()
	{
		return this.securityCode;
	}
	public void setSecurityCode(String v)
	{
		this.securityCode=v;
	}
	public Integer getUse()
	{
		return this.use;
	}
	public void setUse(Integer v)
	{
		this.use=v;
	}
//	public Integer getId()
//	{
//		return this.id;
//	}

	@Override
	public void preInsert() {

	}

	@Override
	public void preUpdate() {

	}

	public void setId(Integer v)
	{
		this.id=v;
	}
}