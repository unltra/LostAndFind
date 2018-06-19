package top.unltra.lost.controller.ad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import top.unltra.lost.domain.Admin;
import top.unltra.lost.domain.Kind;
import top.unltra.lost.domain.Notice;
import top.unltra.lost.domain.User;
import top.unltra.lost.service.LostService;
import top.unltra.lost.util.tag.PageModel;


/**   
 * @Description: 处理失物公告请求控制器
 
 */
@Controller
public class NoticeController {
	/**
	 * 自动注入lostService
	 * */
	@Autowired
	@Qualifier("lostService")
	private LostService lostService;
			
	/**
	 * 处理查询请求
	 * @param pageIndex 请求的是第几页
	 * @param String aid admin编号
	 * @param String kid kind编号
	 * @param notice 模糊查询参数
	 * @param Model model
	 * */
	@RequestMapping(value="/notice/selectNotice")
	 public String selectNotice(Integer pageIndex,
			 Integer kid,Integer aid,Integer uid,
			 @ModelAttribute Notice notice,
			 Model model){
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(aid, uid, kid, notice);
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
		return "notice/notice";
		
	}
	
	
	
	
	
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param String aid admin编号
	 * @param String kid kind编号
	 * @param Notice notice 接收添加参数
	 * @param ModelAndView mv 
	 * */
	@RequestMapping(value="/notice/addNotice")
	 public ModelAndView addNotice(
			 String flag,
			 Integer aid,Integer kid,Integer uid,
			 @ModelAttribute Notice notice,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 查询admin信息
			List<Admin> admins = lostService.findAllAdmin();
			// 查询kind信息 
			List<Kind> kinds = lostService.findAllKind();
			// 查询user信息，用于模糊查询
			List<User> users = lostService.findAllUser();
			// 设置Model数据
			mv.addObject("admins", admins);
			mv.addObject("kinds", kinds);
			mv.addObject("users",users);
			// 返回添加页面
			mv.setViewName("notice/showAddNotice");
		}else{
			// 判断是否有关联对象传递，如果有，创建关联对象
			this.genericAssociation(aid,uid, kid, notice);
			// 添加操作
			lostService.addNotice(notice);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/notice/selectNotice");
		}
		// 返回
		return mv;
		
	}
	
	/**
	 * 处理删除请求
	 * @param String lids 需要删除的lid字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/notice/removeNotice")
	 public ModelAndView removeNotice(String lids,ModelAndView mv){
		// 分解lid字符串
		String[] lidArray = lids.split(",");
		for(String lid : lidArray){
			// 根据lid删除员工
			lostService.removeNoticeByLid(Integer.parseInt(lid));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/notice/selectNotice");
		// 返回ModelAndView
		return mv;
	}
	
	/**
	 * 处理修改请求
	 * @param String flag 标记，1表示跳转到修改页面，2表示执行修改操作
	 * @param String aid 
	 * @param String kid 
	 * @param Notice notice 要修改的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/notice/updateNotice")
	 public ModelAndView updateNotice(
			 String flag,
			 Integer aid,Integer kid,Integer uid,
			 @ModelAttribute Notice notice,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据lid查询notice
			Notice target = lostService.findNoticeByLid(notice.getLid());
			// 需要查询admin信息 
			List<Admin> admins = lostService.findAllAdmin();
			// 查询user信息，用于模糊查询
			List<User> users = lostService.findAllUser();
			// 需要查询kind信息 
			List<Kind> kinds = lostService.findAllKind();
			// 设置Model数据
			mv.addObject("admins", admins);
			mv.addObject("kinds", kinds);
			mv.addObject("users", users);
			mv.addObject("notice", target);
			// 返回修改页面
			mv.setViewName("notice/showUpdateNotice");
		}else{
			// 创建并封装关联对象
			this.genericAssociation(aid,uid, kid, notice);
			System.out.println("updateNotice -->> " + notice);
			// 执行修改操作
			lostService.modifyNotice(notice);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/notice/selectNotice");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 由于管理员和类别在notice中是对象关联映射，
	 * 所以不能直接接收参数，需要创建Admin对象和Kind对象
	 * */
	private void genericAssociation(Integer aid,Integer uid,
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
