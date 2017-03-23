/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fy.entity;

import javax.validation.constraints.NotNull;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 垃圾称重Entity
 * @author HJL
 * @version 2016-03-07
 */
public class FyGarbageList extends DataEntity<FyGarbageList> {
	
	private static final long serialVersionUID = 1L;
	private Integer weight;		// 重量
	private Integer weightChoujian;		// 抽检重量
	private Integer choujianFlag;		// 是否抽检
	private User shouer;		// 垃圾收集人员
	private User departer;		// 科室负责人
	private Office office;		// 科室
	private String type;		// 垃圾类型
	private String status;		// 状态
	private Date inDate;		// 加入日期
	private Integer wuCha;		// 误差的范围
	private Integer cheng1Id;		// 称重称
	private Integer cheng2Id;		// 抽检称
	private String tiaoMaUuid;		// 条码编号
	private String tiaoMaInfo;		// 条码信息
	
	public FyGarbageList() {
		super();
	}

	public FyGarbageList(String id){
		super(id);
	}

	@NotNull(message="重量不能为空")
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
//	@NotNull(message="重量不能为空")
	public Integer getWeightChoujian() {
		return weightChoujian;
	}

	public void setWeightChoujian(Integer weightChoujian) {
		this.weightChoujian = weightChoujian;
	}

	@NotNull(message="是否抽检不能为空")
	public Integer getChoujianFlag() {
		return choujianFlag;
	}

	public void setChoujianFlag(Integer choujianFlag) {
		this.choujianFlag = choujianFlag;
	}
	
	@NotNull(message="垃圾收集人员不能为空")
	public User getShouer() {
		return shouer;
	}

	public void setShouer(User shouer) {
		this.shouer = shouer;
	}
	
	@NotNull(message="科室负责人不能为空")
	public User getDeparter() {
		return departer;
	}

	public void setDeparter(User departer) {
		this.departer = departer;
	}
	
	@NotNull(message="科室不能为空")
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@Length(min=1, max=100, message="垃圾类型长度必须介于 1 和 100 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=255, message="状态长度必须介于 0 和 255 之间")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="加入日期不能为空")
	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	
	@NotNull(message="误差的范围不能为空")
	public Integer getWuCha() {
		return wuCha;
	}

	public void setWuCha(Integer wuCha) {
		this.wuCha = wuCha;
	}
	
	public Integer getCheng1Id() {
		return cheng1Id;
	}

	public void setCheng1Id(Integer cheng1Id) {
		this.cheng1Id = cheng1Id;
	}
	
	public Integer getCheng2Id() {
		return cheng2Id;
	}

	public void setCheng2Id(Integer cheng2Id) {
		this.cheng2Id = cheng2Id;
	}
	
	public String getTiaoMaUuid() {
		return tiaoMaUuid;
	}

	public void setTiaoMaUuid(String tiaoMaUuid) {
		this.tiaoMaUuid = tiaoMaUuid;
	}
	
	@Length(min=0, max=255, message="条码信息长度必须介于 0 和 255 之间")
	public String getTiaoMaInfo() {
		return tiaoMaInfo;
	}

	public void setTiaoMaInfo(String tiaoMaInfo) {
		this.tiaoMaInfo = tiaoMaInfo;
	}
	
}