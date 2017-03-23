/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.fy.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.fy.entity.FyCheng;
import com.thinkgem.jeesite.modules.fy.service.FyChengService;

/**
 * 电子称Controller
 * @author HJL
 * @version 2016-03-07
 */
@Controller
@RequestMapping(value = "${adminPath}/fy/fyCheng")
public class FyChengController extends BaseController {

	@Autowired
	private FyChengService fyChengService;
	
	@ModelAttribute
	public FyCheng get(@RequestParam(required=false) String id) {
		FyCheng entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = fyChengService.get(id);
		}
		if (entity == null){
			entity = new FyCheng();
		}
		return entity;
	}
	
	@RequiresPermissions("fy:fyCheng:view")
	@RequestMapping(value = {"list", ""})
	public String list(FyCheng fyCheng, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<FyCheng> page = fyChengService.findPage(new Page<FyCheng>(request, response), fyCheng); 
		model.addAttribute("page", page);
		return "modules/fy/fyChengList";
	}

	@RequiresPermissions("fy:fyCheng:view")
	@RequestMapping(value = "form")
	public String form(FyCheng fyCheng, Model model) {
		model.addAttribute("fyCheng", fyCheng);
		return "modules/fy/fyChengForm";
	}

	@RequiresPermissions("fy:fyCheng:edit")
	@RequestMapping(value = "save")
	public String save(FyCheng fyCheng, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, fyCheng)){
			return form(fyCheng, model);
		}
		fyChengService.save(fyCheng);
		addMessage(redirectAttributes, "保存电子称成功");
		return "redirect:"+Global.getAdminPath()+"/fy/fyCheng/?repage";
	}
	
	@RequiresPermissions("fy:fyCheng:edit")
	@RequestMapping(value = "delete")
	public String delete(FyCheng fyCheng, RedirectAttributes redirectAttributes) {
		fyChengService.delete(fyCheng);
		addMessage(redirectAttributes, "删除电子称成功");
		return "redirect:"+Global.getAdminPath()+"/fy/fyCheng/?repage";
	}

}