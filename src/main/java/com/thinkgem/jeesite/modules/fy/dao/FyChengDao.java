/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fy.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.fy.entity.FyCheng;

/**
 * 电子称DAO接口
 * @author HJL
 * @version 2016-03-07
 */
@MyBatisDao
public interface FyChengDao extends CrudDao<FyCheng> {
	
}