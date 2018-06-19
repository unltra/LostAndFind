package top.unltra.lost.controller.ad;

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

import top.unltra.lost.domain.User;
import top.unltra.lost.service.LostService;
import top.unltra.lost.util.common.LostConstants;
import top.unltra.lost.util.tag.PageModel;

/**
 * 处理用户请求控制器
 * */

@Controller
public class UserController {
	
	/**
	 * 自动注入lostService
	 * */
	@Autowired
	@Qualifier("lostService")
	private LostService lostService;
	
	
	/**
	 * 处理登录请求
	 * @param String uname  登录名
	 * @param String upw 密码
	 * @return 跳转的视图
	 * */
	@RequestMapping(value="/ulogin.do")
	
	 public ModelAndView ulogin(@RequestParam("uname") String uname,
			 @RequestParam("upw") String upw,
			 HttpSession session,
			 ModelAndView mv){
		// 调用业务逻辑组件判断用户是否可以登录
		User user = lostService.ulogin(uname, upw);
		if(user != null){
			// 将用户保存到HttpSession当中
			session.setAttribute(LostConstants.USER_SESSION, user);
			// 客户端跳转到umain页面
			mv.setViewName("redirect:/umain");
		}else{
			// 设置登录失败提示信息
			mv.addObject("message", "登录名或密码错误!请重新输入");
			// 服务器内部跳转到登录页面
			mv.setViewName("forward:/uloginForm");
		}
		return mv;
		
	}
	
	//user
		/*@RequestMapping(value="/uloginForm")
		 public ModelAndView ulog(
				 ModelAndView mv){
			// 调用业务逻辑组件判断用户是否可以登录
		
			mv.setViewName("forward:/uloginForm");
			
			
			return mv;
			
		}*/
	
	//user退出登录
	@RequestMapping(value="/ulogout")
	 public ModelAndView ulogout(
			 HttpSession session,
			 ModelAndView mv){
		// 调用业务逻辑组件判断用户是否可以登录
		if(true){
			// 将用户从HttpSession当中移除
			session.removeAttribute(LostConstants.USER_SESSION);
			session.invalidate();
			// 客户端跳转到login页面
			mv.setViewName("redirect:/uloginForm");
		}
		return mv;
		
	}
	
	/**
	 * 处理查询请求
	 * @param pageIndex 请求的是第几页
	 * @param user 模糊查询user参数
	 * @param Model model
	 * */
	@RequestMapping(value="/user/selectUser")
	 public String selectUser(Integer pageIndex,
			 @ModelAttribute User user,
			 Model model){
		System.out.println("user = " + user);
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<User> users = lostService.findUser(user, pageModel);
		model.addAttribute("users", users);
		model.addAttribute("pageModel", pageModel);
		return "user/user";
		
	}
	
	/**
	 * 处理删除用户请求
	 * @param String uids 需要删除的uid字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/user/removeUser")
	 public ModelAndView removeUser(String uids,ModelAndView mv){
		// 分解uid字符串
		String[] uidArray = uids.split(",");
		for(String uid : uidArray){
			// 根据uid删除
			lostService.removeUserByUid(Integer.parseInt(uid));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/user/selectUser");
		// 返回ModelAndView
		return mv;
	}
	
	
	/**
	 * 处理修改用户请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param User user  要修改用户的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/user/updateUser")
	 public ModelAndView updateUser(
			 String flag,
			 @ModelAttribute User user,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据uid查询用户
			User target = lostService.findUserByUid(user.getUid());
			// 设置Model数据
			mv.addObject("user", target);
			// 返回修改员工页面
			mv.setViewName("user/showUpdateUser");
		}else{
			// 执行修改操作
			lostService.modifyUser(user);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/user/selectUser");
		}
		// 返回
		return mv;
	}
	
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param User user  要添加用户的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/user/addUser")
	 public ModelAndView addUser(
			 String flag,
			 @ModelAttribute User user,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 设置跳转到添加页面
			mv.setViewName("user/showAddUser");
		}else{
			// 执行添加操作
			lostService.addUser(user);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/user/selectUser");
		}
		// 返回
		return mv;
	}
	
}
