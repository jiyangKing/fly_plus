/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.Dict;
import com.thinkgem.jeesite.modules.sys.entity.SecurityCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 安全码DAO
 * @author HJL
 * @version 2015-12-16
 */
@MyBatisDao
public interface SecurityCodeDao extends CrudDao<SecurityCode> {

	List<String> findByPage(@Param("map")Map map,@Param("start")int start,@Param("size")int size);
	
}
