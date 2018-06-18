package top.unltra.lost.controller;

import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import top.unltra.lost.domain.Admin;
import top.unltra.lost.service.LostService;
import top.unltra.lost.util.common.LostConstants;
import top.unltra.lost.util.tag.PageModel;

/**
 * 处理用户请求控制器
 * */

@Controller
public class AdminController {
	
	/**
	 * 自动注入lostService
	 * */
	@Autowired
	@Qualifier("lostService")
	private LostService lostService;
		
	/**
	 * 处理登录请求
	 * @param String aname  登录名
	 * @param String apw 密码
	 * @return 跳转的视图
	 * */
	@RequestMapping(value="/login.do")
	
	 public ModelAndView login(@RequestParam("aname") String aname,
			 @RequestParam("apw") String apw,
			 HttpSession session,
			 ModelAndView mv){
		// 调用业务逻辑组件判断用户是否可以登录
		Admin admin = lostService.login(aname, apw);
		if(admin != null){
			// 将用户保存到HttpSession当中
			session.setAttribute(LostConstants.ADMIN_SESSION, admin);
			// 客户端跳转到main页面
			mv.setViewName("redirect:/main");
		}else{
			// 设置登录失败提示信息
			mv.addObject("message", "登录名或密码错误!请重新输入");
			// 服务器内部跳转到登录页面
			mv.setViewName("forward:/loginForm");
		}
		return mv;
		
	}
	
	//admin退出登录
	@RequestMapping(value="/logout")
	 public ModelAndView logout(
			 HttpSession session,
			 ModelAndView mv){
		// 调用业务逻辑组件判断用户是否可以登录
		if(true){
			// 将用户从HttpSession当中移除
			session.removeAttribute(LostConstants.ADMIN_SESSION);
			session.invalidate();
			// 客户端跳转到login页面
			mv.setViewName("redirect:/loginForm");
		}
		return mv;
		
	}
	
	/**
	 * 处理查询请求
	 * @param pageIndex 请求的是第几页
	 * @param employee 模糊查询参数
	 * @param Model model
	 * */
	@RequestMapping(value="/admin/selectAdmin")
	 public String selectAdmin(Integer pageIndex,
			 @ModelAttribute Admin admin,
			 Model model){
		System.out.println("admin = " + admin);
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<Admin> admins = lostService.findAdmin(admin, pageModel);
		model.addAttribute("admins", admins);
		model.addAttribute("pageModel", pageModel);
		return "admin/admin";
		
	}
	
	/**
	 * 处理删除用户请求
	 * @param String aids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/admin/removeAdmin")
	 public ModelAndView removeAdmin(String aids,ModelAndView mv){
		// 分解id字符串
		String[] aidArray = aids.split(",");
		for(String aid : aidArray){
			// 根据id删除员工
			lostService.removeAdminByAid(Integer.parseInt(aid));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/admin/selectAdmin");
		// 返回ModelAndView
		return mv;
	}
	
	
	/**
	 * 处理修改用户请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Admin admin  要修改用户的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/admin/updateAdmin")
	 public ModelAndView updateAdmin(
			 String flag,
			 @ModelAttribute Admin admin,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据aid查询用户
			Admin target = lostService.findAdminByAid(admin.getAid());
			// 设置Model数据
			mv.addObject("admin", target);
			// 返回修改员工页面
			mv.setViewName("admin/showUpdateAdmin");
		}else{
			// 执行修改操作
			lostService.modifyAdmin(admin);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/admin/selectAdmin");
		}
		// 返回
		return mv;
	}
	
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param Admin admin  要添加用户的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/admin/addAdmin")
	 public ModelAndView addAdmin(
			 String flag,
			 @ModelAttribute Admin admin,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 设置跳转到添加页面
			mv.setViewName("admin/showAddAdmin");
		}else{
			// 执行添加操作
			lostService.addAdmin(admin);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/admin/selectAdmin");
		}
		// 返回
		return mv;
	}
	
}
