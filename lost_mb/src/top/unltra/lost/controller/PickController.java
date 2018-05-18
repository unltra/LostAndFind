package top.unltra.lost.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import top.unltra.lost.domain.Admin;
import top.unltra.lost.domain.Kind;
import top.unltra.lost.domain.Pick;
import top.unltra.lost.service.LostService;
import top.unltra.lost.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**   
 * @Description: 处理pick请求控制器
 
 */
@Controller
public class PickController {
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
	 * @param pick 模糊查询参数
	 * @param Model model
	 * */
	@RequestMapping(value="/pick/selectPick")
	 public String selectPick(Integer pageIndex,
			 Integer kid,Integer aid,
			 @ModelAttribute Pick pick,
			 Model model){
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(aid, kid, pick);
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
		List<Pick> picks = lostService.findPick(pick,pageModel);
		// 设置Model数据
		model.addAttribute("picks", picks);
		model.addAttribute("kinds", kinds);
		model.addAttribute("admins", admins);
		model.addAttribute("pageModel", pageModel);
		// 返回pick页面
		return "pick/pick";
		
	}
	
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param String aid admin编号
	 * @param String kid kind编号
	 * @param Pick pick 接收添加参数
	 * @param ModelAndView mv 
	 * @throws Exception 
	 * */
	@RequestMapping(value="/pick/addPick")
	 public ModelAndView addPick(
			 String flag,
			 Integer aid,Integer kid,
			 @ModelAttribute Pick pick,
			 ModelAndView mv,HttpSession session) throws Exception{
		if(flag.equals("1")){
			// 查询admin信息
			List<Admin> admins = lostService.findAllAdmin();
			// 查询kind信息 
			List<Kind> kinds = lostService.findAllKind();
			// 设置Model数据
			mv.addObject("admins", admins);
			mv.addObject("kinds", kinds);
			// 返回添加页面
			mv.setViewName("pick/showAddPick");
		}else{
			if(!pick.getFile().isEmpty()) {
				// 上传文件路径
				String path = session.getServletContext().getRealPath(
					                "/upload/");
				System.out.println(path);
				// 上传文件名
				String originalFilename = pick.getFile().getOriginalFilename();
				
				//使用UUID重新命名上传的文件名称（看公司需求，也可以用日期时间）
	            String picName= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
				// 将上传文件保存到一个目标文件当中
				pick.getFile().transferTo(new File(path+File.separator+ picName));
				
				// 设置fileName
				pick.setPpic(picName);
				
			}
			// 判断是否有关联对象传递，如果有，创建关联对象
			this.genericAssociation(aid, kid, pick);
			// 添加操作
			lostService.addPick(pick);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/pick/selectPick");
		}
		// 返回
		return mv;
		
	}
	
	/**
	 * 处理删除请求
	 * @param String pids 需要删除的pid字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/pick/removePick")
	 public ModelAndView removePick(String pids,ModelAndView mv){
		// 分解pid字符串
		String[] pidArray = pids.split(",");
		for(String pid : pidArray){
			// 根据pid删除员工
			lostService.removePickByPid(Integer.parseInt(pid));
		}
		// 设置客户端跳转到查询请求
//		mv.setView(new RedirectView("/hrmapp/employee/selectEmployee"));
//		mv.setViewName("forward:/employee/selectEmployee");
		mv.setViewName("redirect:/pick/selectPick");
		// 返回ModelAndView
		return mv;
	}
	
	/**
	 * 处理修改请求
	 * @param String flag 标记，1表示跳转到修改页面，2表示执行修改操作
	 * @param String aid 
	 * @param String kid 
	 * @param Pick pick 要修改的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/pick/updatePick")
	 public ModelAndView updatePick(
			 String flag,
			 Integer aid,Integer kid,
			 @ModelAttribute Pick pick,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据pid查询pick
			Pick target = lostService.findPickByPid(pick.getPid());
			// 需要查询admin信息 
			List<Admin> admins = lostService.findAllAdmin();
			// 需要查询kind信息 
			List<Kind> kinds = lostService.findAllKind();
			// 设置Model数据
			mv.addObject("admins", admins);
			mv.addObject("kinds", kinds);
			mv.addObject("pick", target);
			// 返回修改页面
			mv.setViewName("pick/showUpdatePick");
		}else{
			// 创建并封装关联对象
			this.genericAssociation(aid, kid, pick);
			System.out.println("updatePick -->> " + pick);
			// 执行修改操作
			lostService.modifyPick(pick);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/pick/selectPick");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 由于管理员和类别在pick中是对象关联映射，
	 * 所以不能直接接收参数，需要创建Admin对象和Kind对象
	 * */
	private void genericAssociation(Integer aid,
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
}
