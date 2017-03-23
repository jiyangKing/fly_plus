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
import com.thinkgem.jeesite.modules.fy.entity.FyCheng;
import com.thinkgem.jeesite.modules.fy.dao.FyChengDao;

/**
 * 电子称Service
 * @author HJL
 * @version 2016-03-07
 */
@Service
@Transactional(readOnly = true)
public class FyChengService extends CrudService<FyChengDao, FyCheng> {

	
	public FyCheng get(String id) {
		FyCheng fyCheng = super.get(id);
		return fyCheng;
	}
	
	public List<FyCheng> findList(FyCheng fyCheng) {
		return super.findList(fyCheng);
	}
	
	public Page<FyCheng> findPage(Page<FyCheng> page, FyCheng fyCheng) {
		User user = UserUtils.getUser();
		String filter=dataScopeFilter(user, "o4", "");
		fyCheng.getSqlMap().put("dsf", filter);
		return super.findPage(page, fyCheng);
	}
	
	@Transactional(readOnly = false)
	public void save(FyCheng fyCheng) {
		super.save(fyCheng);
	}
	
	@Transactional(readOnly = false)
	public void delete(FyCheng fyCheng) {
		super.delete(fyCheng);
	}
	
}