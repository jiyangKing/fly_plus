/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fy.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import com.thinkgem.jeesite.modules.sys.entity.Office;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 电子称Entity
 * @author HJL
 * @version 2016-03-07
 */
public class FyCheng extends DataEntity<FyCheng> {
	
	private static final long serialVersionUID = 1L;
	private String ip;		// ip
	private Integer port;		// 端口
	private Office depart;		// 部门id
	private Integer locationx;		// X坐标
	private Integer locationy;		// Y坐标
	private Integer locationz;		// 楼层
	private String status;		// 运行状态
	private String enable;		// 是否开
	private String type;		// 类型
	
	public FyCheng() {
		super();
	}

	public FyCheng(String id){
		super(id);
	}

	@Length(min=1, max=64, message="ip长度必须介于 1 和 64 之间")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@NotNull(message="端口不能为空")
	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
	
	@NotNull(message="部门id不能为空")
	public Office getDepart() {
		return depart;
	}

	public void setDepart(Office depart) {
		this.depart = depart;
	}
	
	public Integer getLocationx() {
		return locationx;
	}

	public void setLocationx(Integer locationx) {
		this.locationx = locationx;
	}
	
	public Integer getLocationy() {
		return locationy;
	}

	public void setLocationy(Integer locationy) {
		this.locationy = locationy;
	}
	
	public Integer getLocationz() {
		return locationz;
	}

	public void setLocationz(Integer locationz) {
		this.locationz = locationz;
	}
	
	@Length(min=1, max=8, message="运行状态长度必须介于 1 和 8 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Length(min=1, max=8, message="是否开长度必须介于 1 和 8 之间")
	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}
	
	@Length(min=0, max=8, message="类型长度必须介于 0 和 8 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}