package com.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.pojo.AdminInfo;
import com.pojo.Functions;
import com.pojo.utils.JsonFactory;
import com.pojo.utils.TreeNode;
import com.service.AdminInfoService;

@SessionAttributes(value={"admin"})   //为了设置这个会话的，安全登入的方式
@Controller
@RequestMapping("/admininfo")
public class AdminInfoController {
	
	
	@Autowired
	private AdminInfoService adminInfoService;
	/**
	 * 登入验证
	 * @param ai
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String login(AdminInfo ai,ModelMap model){
		// 后台登入验证
		System.out.println("\nlogin......");
		AdminInfo adminInfo =adminInfoService.login(ai);
		if(adminInfo!=null && adminInfo.getName()!=null){
			//通过过验证
			if(adminInfoService.getAdminInfoAndFunctions(adminInfo.getId()).getFs().size() > 0){
				model.put("admin", adminInfo);
				return "{\"success\":\"true\",\"message\":\"登入成功\"}";
			}else {
				return "{\"success\":\"false\",\"message\":\"您没有权限，请联系超级管理员设置权限！\"}";
			}
		}
		return "{\"success\":\"false\",\"message\":\"登入登入失败\"}";
	}
	/**
	 * 功能结构
	 * @param adminid
	 * @return
	 */
	@RequestMapping("/getTree")
	@ResponseBody
	public List<TreeNode> getTree(@RequestParam(value="adminid") String adminid){
		
		System.out.println("getTree....");
		
		AdminInfo admininfo =adminInfoService.getAdminInfoAndFunctions(Integer.parseInt(adminid));
		
		System.out.println(admininfo.getName());// ok 
		List<TreeNode> nodes =new ArrayList<TreeNode>();
		
		List<Functions> functionsList =admininfo.getFs();
		System.out.println("functionsList  : "+functionsList.size());// 1
		
		//排序
		Collections.sort(functionsList);
		
		//遍历这个function中方法名称
		for (Functions functions : functionsList) {
			TreeNode treeNode =new TreeNode();
			treeNode.setId(functions.getId());
			treeNode.setFid(functions.getParentid());
			treeNode.setText(functions.getName());
			nodes.add(treeNode);
		}
		System.out.println("nodes size:"+nodes.size());
		List<TreeNode> treeNodes =JsonFactory.buildtree(nodes,0);
		//szie   = 0;
		System.out.println(treeNodes.size());
		return treeNodes;
	}
	
	/**
	 * 退出系统
	 * @param status
	 * @return
	 */
	@RequestMapping(value="/logout" ,method = RequestMethod.GET)
	@ResponseBody
	public String logout(SessionStatus status){
		// 清除这个sessionAttribute 的属性值
		status.setComplete();
		return "{\"success\":\"true\",\"message\":\"注销成功\"}";
	}
	

}
