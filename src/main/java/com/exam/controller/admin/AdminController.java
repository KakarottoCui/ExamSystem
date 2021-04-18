package com.exam.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.exam.dao.AdminMapper;
import com.exam.entity.Users;

/**
 * 登陆功能
 */
@Controller
public class AdminController {

	@Autowired
	private AdminMapper adminMapper;

	/**
	 * 映射主页模板
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("login");
		return modelAndView;
	}

	/**
	 * 登陆接受JSON数据
	 * 
	 * @param session
	 * @param users
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginJson(HttpSession session, Users users) {
		String sessionCode = (String) session.getAttribute("code");// session中验证码
		String code = users.getCode();// 用户code
		if (!sessionCode.equals(code)) {// 验证码错误返回提示信息
			return "0";
		}

		Users user = adminMapper.findByUser(users);
		if (user != null) {
			session.setAttribute("myUser", user);// 存SESSION
			Integer permission = user.getPermission();// 权限 0 普通用户 1管理员
			if (permission == 1) {
				// 跳转管理员
				return "2";
			} else {
				// 跳转用户考试选题界面
				return "3";
			}
		}

		return "1";// 账号密码错误
	}

	@RequestMapping(value = "/admin/index.html", method = RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("_admin/index");
		return modelAndView;
	}

}
