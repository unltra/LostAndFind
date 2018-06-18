package top.unltra.lost.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import top.unltra.lost.dao.AdminDao;
import top.unltra.lost.dao.KindDao;
import top.unltra.lost.dao.NoticeDao;
import top.unltra.lost.dao.PickDao;
import top.unltra.lost.dao.UserDao;
import top.unltra.lost.domain.Admin;
import top.unltra.lost.domain.Kind;
import top.unltra.lost.domain.Notice;
import top.unltra.lost.domain.Pick;
import top.unltra.lost.domain.User;
import top.unltra.lost.service.LostService;
import top.unltra.lost.util.tag.PageModel;

/**   
 * @Description: 服务层接口实现类
 */
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("lostService")
public class LostServiceImpl implements LostService{

	/**
	 * 自动注入持久层Dao对象
	 * */
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private KindDao kindDao;
	
	@Autowired
	private PickDao pickDao;
	
	@Autowired
	private NoticeDao noticeDao;
	
	/*****************服务接口实现*************************************/
	/**
	 * LostServiceImpl接口login方法实现
	 *  @see { LostService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public Admin login(String aname, String apw) {
//		System.out.println("LostServiceImpl logout -- >>");
		return adminDao.selectByAnameAndApw(aname, apw);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Admin findAdminByAid(Integer aid) {
		return adminDao.selectByAid(aid);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Admin> findAllAdmin() {
		
		return adminDao.selectAllAdmin();
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Admin> findAdmin(Admin admin, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("admin", admin);
		int recordCount = adminDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<Admin> admins = adminDao.selectByPage(params);
		 
		return admins;
	}

	@Override
	public void removeAdminByAid(Integer aid) {
		adminDao.deleteByAid(aid);
		
	}

	@Override
	public void modifyAdmin(Admin admin) {
		adminDao.update(admin);
		
	}

	@Override
	public void addAdmin(Admin admin) {
		adminDao.save(admin);
		
	}

	//user

	@Transactional(readOnly=true)
	@Override
	public User findUserByUid(Integer uid) {
		
		return userDao.selectByUid(uid);
	}
	
	@Override
	public User ulogin(String uname, String upw) {
		
		return userDao.selectByUnameAndUpw(uname, upw);
	}

	@Transactional(readOnly=true)
	@Override
	public List<User> findAllUser() {
		
		return userDao.selectAllUser();
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<User> findUser(User user, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("user", user);
		int recordCount = userDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<User> users = userDao.selectByPage(params);
		 
		return users;
	}




	@Override
	public void removeUserByUid(Integer uid) {
		userDao.deleteByUid(uid);
		
	}




	@Override
	public void modifyUser(User user) {
		userDao.update(user);
		
	}




	@Override
	public void addUser(User user) {
		userDao.save(user);
		
	}

	
	//kind
	
	@Transactional(readOnly=true)
	@Override
	public Kind findKindByKid(Integer kid) {
		
		return kindDao.selectByKid(kid);
	}

	
	
	@Transactional(readOnly=true)
	@Override
	public List<Kind> findAllKind() {
		
		return kindDao.selectAllKind();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Kind> findKind(Kind kind, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("kind", kind);
		int recordCount = kindDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<Kind> kinds = kindDao.selectByPage(params);
		 
		return kinds;
	}




	@Override
	public void removeKindByKid(Integer kid) {
		kindDao.deleteByKid(kid);
	}




	@Override
	public void modifyKind(Kind kind) {
		kindDao.update(kind);
	}




	@Override
	public void addKind(Kind kind) {
		kindDao.save(kind);
	}


	//pick
	
	@Transactional(readOnly=true)
	@Override
	public Pick findPickByPid(Integer pid) {
		
		return pickDao.selectByPid(pid);
	}



	@Transactional(readOnly=true)
	@Override
	public List<Pick> findPick(Pick pick, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("pick", pick);
		int recordCount = pickDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<Pick> picks = pickDao.selectByPage(params);
		 
		return picks;
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Pick> findPickByTime(Pick pick, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("pick", pick);
		int recordCount = pickDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<Pick> picks = pickDao.selectByTimeAndPage(params);
		 
		return picks;
	}




	@Override
	public void removePickByPid(Integer pid) {
		pickDao.deleteByPid(pid);
		
	}




	@Override
	public void modifyPick(Pick pick) {
		pickDao.update(pick);
		
	}




	@Override
	public void addPick(Pick pick) {
		pickDao.save(pick);
		
	}
	
	//Notice
	
	@Transactional(readOnly=true)
	@Override
	public Notice findNoticeByLid(Integer lid) {
		return noticeDao.selectByLid(lid);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Notice> findNotice(Notice notice, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("notice", notice);
		int recordCount = noticeDao.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<Notice> notices = noticeDao.selectByPage(params);
		 
		return notices;
	}

	@Override
	public void removeNoticeByLid(Integer lid) {
		noticeDao.deleteByLid(lid);
		
	}

	@Override
	public void modifyNotice(Notice notice) {
		noticeDao.update(notice);
		
	}

	@Override
	public void addNotice(Notice notice) {
		noticeDao.save(notice);
		
	}

	@Override
	public List<Pick> findAllPick(Pick pick) {
		
		Map<String,Object> params = new HashMap<>();
		params.put("pick", pick);
		List<Pick> picks = pickDao.selectAllPick(params); 
		return picks;
	}

	@Override
	public List<Notice> findAllNotice(Notice notice) {
		
		Map<String,Object> params = new HashMap<>();
		params.put("notice", notice);
		List<Notice> notices = noticeDao.selectAllNotice(params); 
		return notices;
	}

	@Override
	public List<Notice> findNoticeByUser(Integer uid) {
		
		return noticeDao.findNoticeByUid(uid);
	}

	

	

	
}
