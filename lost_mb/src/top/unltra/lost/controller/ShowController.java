package top.unltra.lost.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import top.unltra.lost.domain.Admin;
import top.unltra.lost.domain.Kind;
import top.unltra.lost.domain.Notice;
import top.unltra.lost.domain.Pick;
import top.unltra.lost.domain.User;
import top.unltra.lost.service.LostService;
import top.unltra.lost.util.common.LostConstants;
import top.unltra.lost.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowController {
	/**
	 * 自动注入lostService
	 * */
	@Autowired
	@Qualifier("lostService")
	private LostService lostService;
			
	
	
	@RequestMapping(value="/showPick")
	 public String selectPick(Integer pageIndex,
			 Integer kid,Integer aid,
			 @ModelAttribute Pick pick,
			 Model model){
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.pickBind(aid, kid, pick);
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
		if(pageIndex != null){
				pageModel.setPageIndex(pageIndex);
		}
		// 查询admin信息，用于模糊查询
		List<Admin> admins = lostService.findAllAdmin();
		// 查询kind信息 ，用于模糊查询
		List<Kind> kinds = lostService.findAllKind();
		// 查询员工信息      
		List<Pick> picks = lostService.findPickByTime(pick,pageModel);
		// 设置Model数据
		model.addAttribute("picks", picks);
		model.addAttribute("kinds", kinds);
		model.addAttribute("admins", admins);
		model.addAttribute("pageModel", pageModel);
		
		// 返回pick页面
		return "show/pi";
		
	}
	
	@RequestMapping(value="/showNotice")
	 public String selNotice(Integer pageIndex,
			 Integer kid,Integer aid,Integer uid,
			 @ModelAttribute Notice notice,
			 Model model){
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.noticeBind(aid, uid, kid, notice);
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		// 查询admin信息，用于模糊查询
		List<Admin> admins = lostService.findAllAdmin();
		// 查询user信息，用于模糊查询
		List<User> users = lostService.findAllUser();
		// 查询kind信息 ，用于模糊查询
		List<Kind> kinds = lostService.findAllKind();
		// 查询员工信息    
		List<Notice> notices = lostService.findNotice(notice,pageModel);
		// 设置Model数据
		model.addAttribute("notices", notices);
		model.addAttribute("kinds", kinds);
		model.addAttribute("admins", admins);
		model.addAttribute("users", users);
		model.addAttribute("pageModel", pageModel);
		// 返回notice页面
		return "show/notice";
		
	}
	
	@RequestMapping(value="/picks")
	 public String showP(
			 Integer kid,Integer aid,
			 @ModelAttribute Pick pick,
			 Model model){
		
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.pickBind(aid, kid, pick);
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 查询admin信息，用于模糊查询
		List<Admin> admins = lostService.findAllAdmin();
		// 查询kind信息 ，用于模糊查询
		List<Kind> kinds = lostService.findAllKind();
		// 查询员工信息      
		List<Pick> picks = lostService.findAllPick(pick);
		// 设置Model数据
		model.addAttribute("picks", picks);
		model.addAttribute("kinds", kinds);
		model.addAttribute("admins", admins);
		
		// 返回pick页面
		return "cool/pick";
		
	}
	
	@RequestMapping(value="/notices")
	 public String showN(
			 Integer kid,Integer aid,Integer uid,
			 @ModelAttribute Notice notice,
			 Model model){
		
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.noticeBind(aid, uid, kid, notice);
		// 查询admin信息，用于模糊查询
		List<Admin> admins = lostService.findAllAdmin();
		// 查询kind信息 ，用于模糊查询
		List<Kind> kinds = lostService.findAllKind();
		//查询user
		List<User> users = lostService.findAllUser();
		// 查询员工信息      
		List<Notice> notices = lostService.findAllNotice(notice);
		// 设置Model数据
		model.addAttribute("notices", notices);
		model.addAttribute("kinds", kinds);
		model.addAttribute("admins", admins);
		model.addAttribute("users", users);
		// 返回pick页面
		return "cool/allnotice";
		
	}
	
	@RequestMapping(value="/cool")
	 public String coolIn(
			 Model model) {
		return "cool/index";
		
	}
	
	@RequestMapping(value="/register")
	 public String reg(
			 Model model) {
		return "man/reg/register";
		
	}
	
	@RequestMapping(value="/addU")
	 public ModelAndView addUser(
			 @ModelAttribute User user,
			 ModelAndView mv){
		if(true) {
			// 执行添加操作
			user.setStuid("3150407145");
			lostService.addUser(user);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/uloginForm");
		}
		// 返回
		return mv;
	}
	
	@RequestMapping(value="UserInfo")
	 public String UserInfo(
			 HttpSession session,
			 Model model){
		User u =(User) session.getAttribute(LostConstants.USER_SESSION);
		if(u!=null) {
			Integer uid=u.getUid();
			User user = lostService.findUserByUid(uid);
			model.addAttribute("user", user);
			// 返回
			return "man/UserInfo";
		}
		else {
			return "uright";
		}
	}
	
	/*@RequestMapping(value="/MyNotice")
	 public String selectNotice(
			 Integer kid,Integer aid,Integer uid,
			 @ModelAttribute Notice notice,
			 Model model){
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.noticeBind(aid, uid, kid, notice);
		// 查询admin信息，用于模糊查询
		List<Admin> admins = lostService.findAllAdmin();
		// 查询user信息，用于模糊查询
		List<User> users = lostService.findAllUser();
		// 查询kind信息 ，用于模糊查询
		List<Kind> kinds = lostService.findAllKind();
		// 查询员工信息    
		List<Notice> notices = lostService.findAllNotice(notice);
		// 设置Model数据
		model.addAttribute("notices", notices);
		model.addAttribute("kinds", kinds);
		model.addAttribute("admins", admins);
		model.addAttribute("users", users);
		
		// 返回notice页面
		return "man/myNotice";
		
	}*/
	
	/*@RequestMapping(value="MyNotice")
	 public String myNotice(
			 HttpSession session,
			 @ModelAttribute Notice notice,
			 Model model){
		User u =(User) session.getAttribute(LostConstants.USER_SESSION);
		if(u!=null) {
			Integer uid=u.getUid();
			
			User user = lostService.findUserByUid(uid);
			List<Kind> kinds = lostService.findAllKind();
			List<Notice> notices =lostService.findNoticeByUser(uid);
			model.addAttribute("notices", notices);
			model.addAttribute("kinds", kinds);
			model.addAttribute("user", user);
			// 返回
			return "man/myNotice";
		}
		else {
			return "uright";
		}
	}*/
	
	@RequestMapping(value="MyNotice")
	 public String myN(
			 HttpSession session,Integer kid,
			 @ModelAttribute Notice notice,
			 Model model){
		User u =(User) session.getAttribute(LostConstants.USER_SESSION);
		if(u!=null) {
			Integer uid=u.getUid();
			
			User user = lostService.findUserByUid(uid);
			List<Kind> kinds = lostService.findAllKind();
			this.NoticeBindKind(uid, kid, notice);
			List<Notice> notices = lostService.findAllNotice(notice);
			model.addAttribute("notices", notices);
			model.addAttribute("kinds", kinds);
			model.addAttribute("user", user);
			// 返回
			return "man/myNotice";
		}
		else {
			return "uright";
		}
	}
	
	@RequestMapping(value="/delNotice")
	 public ModelAndView delNotice(Integer lid,ModelAndView mv){
		// 根据lid删除员工
		lostService.removeNoticeByLid(lid);
		
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/MyNotice");
		// 返回ModelAndView
		return mv;
	}
	
	@RequestMapping(value="/addNotice")
	 public ModelAndView addNotice(
		String flag,
		HttpSession session,	 
		Integer kid,
		@ModelAttribute Notice notice,
		ModelAndView mv) throws Exception{
		User user =(User) session.getAttribute(LostConstants.USER_SESSION);
		if(user!=null) {
			
		// 查询kind信息 
		List<Kind> kinds = lostService.findAllKind();
		// 设置Model数据
		mv.addObject("kinds", kinds);
		// 返回添加页面
		mv.setViewName("man/addMyNotice");
		}else {
			mv.setViewName("/uright");
		}	
			
		return mv;
	}
	
@RequestMapping(value="/addMyN")
public ModelAndView addMyN(
	HttpSession session,	 
	Integer kid,
	@ModelAttribute Notice notice,
	ModelAndView mv) throws Exception{
	User user =(User) session.getAttribute(LostConstants.USER_SESSION);
	if(!notice.getFile().isEmpty()) {
			// 上传文件路径
			String path = session.getServletContext().getRealPath(
					                "/upload/");
			System.out.println(path);
			// 上传文件名
			String originalFilename = notice.getFile().getOriginalFilename();
				
			//使用UUID重新命名上传的文件名称（看公司需求，也可以用日期时间）
	         String picName= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
			// 将上传文件保存到一个目标文件当中
			notice.getFile().transferTo(new File(path+File.separator+ picName));
				
			// 设置fileName
			notice.setLpic(picName);
				
		}
			// 判断是否有关联对象传递，如果有，创建关联对象
			Integer aid = 4;
			Integer uid =user.getUid();
			
			this.noticeBind(aid, uid, kid, notice);
			// 添加操作
			lostService.addNotice(notice);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/MyNotice");
			return mv;
		}
	

	@RequestMapping(value="/editNotice")
	 public ModelAndView editNotice(
		HttpSession session,	 
		Integer aid,Integer kid,Integer uid,
		@ModelAttribute Notice notice,
		ModelAndView mv){
		
		// 根据lid查询notice
		Notice target = lostService.findNoticeByLid(notice.getLid());
		//user
		User user =(User) session.getAttribute(LostConstants.USER_SESSION);
		// 需要查询kind信息 
		List<Kind> kinds = lostService.findAllKind();
		// 设置Model数据
		
		mv.addObject("kinds", kinds);
		mv.addObject("user", user);
		mv.addObject("notice", target);
		// 返回修改页面
		mv.setViewName("man/editNotice");
	
		
		// 返回
		return mv;
	}
	
	@RequestMapping(value="/changeNotice")
	 public ModelAndView changeNotice(
	 
		Integer aid,Integer kid,Integer uid,
		@ModelAttribute Notice notice,
		ModelAndView mv){
		// 创建并封装关联对象
		this.noticeBind(aid,uid, kid, notice);
		System.out.println("updateNotice -->> " + notice);
			// 执行修改操作
		lostService.modifyNotice(notice);
			// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/MyNotice");
		
		return mv;
	}
	
	
	@RequestMapping(value="changeUser")
	 public ModelAndView changeUser(
			 @ModelAttribute User user,
			 ModelAndView mv){
		
		// 执行修改操作
		lostService.modifyUser(user);
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/uright");
		
		// 返回
		return mv;
	}
	

	
	/**
	 * 由于管理员和类别在pick中是对象关联映射，
	 * 所以不能直接接收参数，需要创建Admin对象和Kind对象
	 * */
	private void pickBind(Integer aid,
			Integer kid,Pick pick){
		if(aid != null){
			Admin  admin = new Admin();
			admin.setAid(aid);
			pick.setAdmin(admin);
		}
		if(kid!= null){
			Kind kind = new Kind();
			kind.setKid(kid);
			pick.setKind(kind);
		}
	}
	
	private void NoticeBindKind(Integer uid,
			Integer kid,Notice notice){
		if(uid != null){
			User user = new User();
			user.setUid(uid);
			notice.setUser(user);
		}
		if(kid!= null){
			Kind kind = new Kind();
			kind.setKid(kid);
			notice.setKind(kind);
		}
	}
	
	private void noticeBind(Integer aid,Integer uid,
			Integer kid,Notice notice){
		if(aid != null){
			Admin  admin = new Admin();
			admin.setAid(aid);
			notice.setAdmin(admin);
		}
		if(uid != null){
			User user = new User();
			user.setUid(uid);
			notice.setUser(user);
		}
		if(kid!= null){
			Kind kind = new Kind();
			kind.setKid(kid);
			notice.setKind(kind);
		}
	}

}
