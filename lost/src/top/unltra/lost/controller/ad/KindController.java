package top.unltra.lost.controller.ad;

import java.util.List;

import top.unltra.lost.domain.Kind;
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
 * @Description: 处理kind请求控制器
 
 */

@Controller
public class KindController {

	/**
	 * 自动注入LostService
	 * */
	@Autowired
	@Qualifier("lostService")
	private LostService lostService;
	
	
	@RequestMapping(value="/kind/selectKind")
	 public String selectKind(Model model,Integer pageIndex,
			 @ModelAttribute Kind kind){
		System.out.println("selectKind -->>");
		System.out.println("pageIndex = " + pageIndex);
		System.out.println("Kind = " + kind);
		PageModel pageModel = new PageModel();
		System.out.println("getPageIndex = " + pageModel.getPageIndex());
		System.out.println("getPageSize = " + pageModel.getPageSize());
		System.out.println("getRecordCount = " + pageModel.getRecordCount());
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询kind信息     */
		List<Kind> kinds = lostService.findKind(kind, pageModel);
		model.addAttribute("kinds", kinds);
		model.addAttribute("pageModel", pageModel);
		return "kind/kind";
		
	}
	
	/**
	 * 处理删除kind请求
	 * @param String kids 需要删除的kid字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/kind/removeKind")
	 public ModelAndView removeKind(String kids,ModelAndView mv){
		// 分解kid字符串
		String[] kidArray = kids.split(",");
		for(String kid : kidArray){
			// 根据kid删除kind
			lostService.removeKindByKid(Integer.parseInt(kid));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/kind/selectKind");
		// 返回ModelAndView
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param Kind kind  要添加的部门对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/kind/addKind")
	 public ModelAndView addKind(
			 String flag,
			 @ModelAttribute Kind kind,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 设置跳转到添加页面
			mv.setViewName("kind/showAddKind");
		}else{
			// 执行添加操作
			lostService.addKind(kind);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/kind/selectkind");
		}
		// 返回
		return mv;
	}
	
	
	/**
	 * 处理修改请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Kind kind 要修改的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/kind/updateKind")
	 public ModelAndView updateKind(
			 String flag,
			 @ModelAttribute Kind kind,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据kid查询kind
			Kind target = lostService.findKindByKid(kind.getKid());
			// 设置Model数据
			mv.addObject("kind", target);
			// 设置跳转到修改页面
			mv.setViewName("kind/showUpdateKind");
		}else{
			// 执行修改操作
			lostService.modifyKind(kind);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/kind/selectKind");
		}
		// 返回
		return mv;
	}
	
}
