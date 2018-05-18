package top.unltra.lost.service;

import java.util.List;


import top.unltra.lost.domain.Admin;
import top.unltra.lost.domain.Kind;
import top.unltra.lost.domain.Notice;
import top.unltra.lost.domain.Pick;
import top.unltra.lost.domain.User;
import top.unltra.lost.util.tag.PageModel;

/**
 * @Description: 服务层接口
 */

public interface LostService {

	// Admin

	/**
	 * 用户登录
	 * 
	 * @param aname
	 * @param apw
	 * @return Admin对象
	 */
	Admin login(String aname, String apw);

	/**
	 * 根据aid查询用户
	 * 
	 * @param aid
	 * @return 用户对象
	 */
	Admin findAdminByAid(Integer aid);

	/**
	 * 获得所有用户
	 * 
	 * @return Admin对象的List集合
	 */
	List<Admin> findAllAdmin();
	
	List<Admin> findAdmin(Admin admin, PageModel pageModel);

	/**
	 * 根据aid删除admin
	 * 
	 * @param aid
	 */
	void removeAdminByAid(Integer aid);

	/**
	 * 修改用户
	 * 
	 * @param Admin
	 *            用户对象
	 */
	void modifyAdmin(Admin admin);

	/**
	 * 添加用户
	 * 
	 * @param Admin
	 *            用户对象
	 */
	void addAdmin(Admin admin);

	// User

	User findUserByUid(Integer uid);
	
	User ulogin(String uname, String upw);

	List<User> findAllUser();
	
	List<User> findUser(User user, PageModel pageModel);

	void removeUserByUid(Integer uid);

	void modifyUser(User user);

	void addUser(User user);

	// Kind
	

	Kind findKindByKid(Integer kid);
	
	List<Kind> findAllKind();

	List<Kind> findKind(Kind kind, PageModel pageModel);

	void removeKindByKid(Integer kid);

	void modifyKind(Kind kind);

	void addKind(Kind kind);

	// Pick

	Pick findPickByPid(Integer pid);
	
	List<Pick> findAllPick(Pick pick);

	List<Pick> findPick(Pick pick, PageModel pageModel);
	
	List<Pick> findPickByTime(Pick pick, PageModel pageModel);

	void removePickByPid(Integer pid);

	void modifyPick(Pick pick);

	void addPick(Pick pick);
	
	// Notice

	Notice findNoticeByLid(Integer lid);
	
	List<Notice> findAllNotice(Notice notice);

	List<Notice> findNotice(Notice notice, PageModel pageModel);

	void removeNoticeByLid(Integer lid);

	void modifyNotice(Notice notice);

	void addNotice(Notice notice);

	List<Notice> findNoticeByUser(Integer uid);

	

	

}
