/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fy.service;

import java.util.List;

import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.fy.entity.FyGarbageList;
import com.thinkgem.jeesite.modules.fy.dao.FyGarbageListDao;

/**
 * 垃圾称重Service
 * @author HJL
 * @version 2016-03-07
 */
@Service
@Transactional(readOnly = true)
public class FyGarbageListService extends CrudService<FyGarbageListDao, FyGarbageList> {

	
	public FyGarbageList get(String id) {
		FyGarbageList fyGarbageList = super.get(id);
		return fyGarbageList;
	}
	
	public List<FyGarbageList> findList(FyGarbageList fyGarbageList) {
		return super.findList(fyGarbageList);
	}
	
	public Page<FyGarbageList> findPage(Page<FyGarbageList> page, FyGarbageList fyGarbageList) {
		User user =UserUtils.getUser();
		String filter=dataScopeFilter(user, "o6", "u4,u5");
		fyGarbageList.getSqlMap().put("dsf", filter);
		return super.findPage(page, fyGarbageList);
	}
	
	@Transactional(readOnly = false)
	public void save(FyGarbageList fyGarbageList) {
		super.save(fyGarbageList);
	}
	
	@Transactional(readOnly = false)
	public void delete(FyGarbageList fyGarbageList) {
		super.delete(fyGarbageList);
	}
	
}