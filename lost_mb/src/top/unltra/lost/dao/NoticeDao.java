package top.unltra.lost.dao;

import static top.unltra.lost.util.common.LostConstants.LOSTNOTICETABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

import top.unltra.lost.dao.provider.NoticeDynaSqlProvider;

import top.unltra.lost.domain.Notice;

public interface NoticeDao {
	// 根据lid查询
	@Select("select * from " + LOSTNOTICETABLE + " where lid = #{lid}")
	@Results({ @Result(id = true, column = "lid", property = "lid"),
			@Result(column = "lname", property = "lname"),
			@Result(column = "lpic", property = "lpic"),
			@Result(column = "ldescri", property = "ldescri"),
			@Result(column = "lplace", property = "lplace"),
			@Result(column = "loutstatus", property = "loutstatus"),
			@Result(column = "ltime", property = "ltime", javaType = java.util.Date.class),
			@Result(column = "lcreatetime", property = "lcreatetime", javaType = java.util.Date.class),
			@Result(column = "aid", property = "admin", one = @One(select = "top.unltra.lost.dao.AdminDao.selectByAid", fetchType = FetchType.EAGER)),
			@Result(column = "uid", property = "user", one = @One(select = "top.unltra.lost.dao.UserDao.selectByUid", fetchType = FetchType.EAGER)),
			@Result(column = "kid", property = "kind", one = @One(select = "top.unltra.lost.dao.KindDao.selectByKid", fetchType = FetchType.EAGER)) })
	Notice selectByLid(Integer lid);

	// 查找所有notice
	@SelectProvider(type = NoticeDynaSqlProvider.class, method = "selectAllNotice")
	@Results({ @Result(id = true, column = "lid", property = "lid"), 
			@Result(column = "lname", property = "lname"),
			@Result(column = "lpic", property = "lpic"), 
			@Result(column = "ldescri", property = "ldescri"),
			@Result(column = "lplace", property = "lplace"),
			@Result(column = "loutstatus", property = "loutstatus"),
			@Result(column = "ltime", property = "ltime", javaType = java.util.Date.class),
			@Result(column = "lcreatetime", property = "lcreatetime", javaType = java.util.Date.class),
			@Result(column = "aid", property = "admin", one = @One(select = "top.unltra.lost.dao.AdminDao.selectByAid", fetchType = FetchType.EAGER)),
			@Result(column = "uid", property = "user", one = @One(select = "top.unltra.lost.dao.UserDao.selectByUid", fetchType = FetchType.EAGER)),
			@Result(column = "kid", property = "kind", one = @One(select = "top.unltra.lost.dao.KindDao.selectByKid", fetchType = FetchType.EAGER)) })
	List<Notice> selectAllNotice(Map<String, Object> params);

	// 根据lid删除
	@Delete(" delete from " + LOSTNOTICETABLE + " where lid = #{lid} ")
	void deleteByLid(Integer lid);

	// 动态修改
	@SelectProvider(type = NoticeDynaSqlProvider.class, method = "updateNotice")
	void update(Notice notice);

	// 根据参数动态查询
	@SelectProvider(type = NoticeDynaSqlProvider.class, method = "selectWhitParam")
	@Results({ @Result(id = true, column = "lid", property = "lid"), 
			@Result(column = "lname", property = "lname"),
			@Result(column = "lpic", property = "lpic"),
			@Result(column = "ldescri", property = "ldescri"),
			@Result(column = "lplace", property = "lplace"),
			@Result(column = "loutstatus", property = "loutstatus"),
			@Result(column = "ltime", property = "ltime", javaType = java.util.Date.class),
			@Result(column = "lcreatetime", property = "lcreatetime", javaType = java.util.Date.class),
			@Result(column = "aid", property = "admin", one = @One(select = "top.unltra.lost.dao.AdminDao.selectByAid", fetchType = FetchType.EAGER)),
			@Result(column = "uid", property = "user", one = @One(select = "top.unltra.lost.dao.UserDao.selectByUid", fetchType = FetchType.EAGER)),
			@Result(column = "kid", property = "kind", one = @One(select = "top.unltra.lost.dao.KindDao.selectByKid", fetchType = FetchType.EAGER)) })
	List<Notice> selectByPage(Map<String, Object> params);

	// 根据参数查询总数
	@SelectProvider(type = NoticeDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);

	// 动态插入
	@SelectProvider(type = NoticeDynaSqlProvider.class, method = "insertNotice")
	void save(Notice notice);
	
	@Select("select * from " + LOSTNOTICETABLE + " where uid = #{uid}")
	List<Notice> findNoticeByUid(Integer uid);

}
