package top.unltra.lost.dao;

import static top.unltra.lost.util.common.LostConstants.PICKTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;


/*		  `pname` varchar(30) DEFAULT NULL,
		  `ppic` varchar(50) DEFAULT NULL,
		  `pdescri` varchar(50) DEFAULT NULL,
		  `pplace` varchar(20) DEFAULT NULL,
		  `ptime` date DEFAULT NULL,
		  `ppersoninf` varchar(50) DEFAULT NULL,
		  `pnowplace` varchar(20) DEFAULT NULL,
		  `poutstatus` int(1) DEFAULT NULL,
		  `pownstatus` int(1) DEFAULT NULL,
		  `pcreatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
		  PRIMARY KEY (`pid`),
		  KEY `FK_pick_ad` (`aid`),
		  KEY `FK_pick_classd` (`kid`),
*/

import top.unltra.lost.dao.provider.PickDynaSqlProvider;
import top.unltra.lost.domain.Notice;
import top.unltra.lost.domain.Pick;

public interface PickDao {
	// 根据pid查询pick
	@Select("select * from " + PICKTABLE + " where pid = #{pid}")
	@Results({ @Result(id = true, column = "pid", property = "pid"), 
			@Result(column = "pname", property = "pname"),
			@Result(column = "ppic", property = "ppic"),
			@Result(column = "pdescri", property = "pdescri"),
			@Result(column = "pplace", property = "pplace"),
			@Result(column = "ppersoninf", property = "ppersoninf"),
			@Result(column = "pnowplace", property = "pnowplace"),
			@Result(column = "poutstatus", property = "poutstatus"),
			@Result(column = "pownstatus", property = "pownstatus"),
			@Result(column = "ptime", property = "ptime", javaType = java.util.Date.class),
			@Result(column = "pcreatetime", property = "pcreatetime", javaType = java.util.Date.class),
			@Result(column = "aid", property = "admin",
				one = @One(select = "top.unltra.lost.dao.AdminDao.selectByAid", fetchType = FetchType.EAGER)),
			@Result(column = "kid", property = "kind",
				one = @One(select = "top.unltra.lost.dao.KindDao.selectByKid", fetchType = FetchType.EAGER)) })
	Pick selectByPid(Integer pid);

	// 根据pid删除pick
	@Delete(" delete from " + PICKTABLE + " where pid = #{pid} ")
	void deleteByPid(Integer pid);
	
	// 查找所有pick
	@SelectProvider(type = PickDynaSqlProvider.class, method = "selectAllPick")
	@Results({ 
			@Result(id = true, column = "pid", property = "pid"),
			@Result(column = "pname", property = "pname"),
			@Result(column = "ppic", property = "ppic"),
			@Result(column = "pdescri", property = "pdescri"),
			@Result(column = "pplace", property = "pplace"),
			@Result(column = "ppersoninf", property = "ppersoninf"),
			@Result(column = "pnowplace", property = "pnowplace"),
			@Result(column = "poutstatus", property = "poutstatus"),
			@Result(column = "pownstatus", property = "pownstatus"),
			@Result(column = "ptime", property = "ptime", javaType = java.util.Date.class),
			@Result(column = "pcreatetime", property = "pcreatetime", javaType = java.util.Date.class),
			@Result(column = "aid", property = "admin",
				one = @One(select = "top.unltra.lost.dao.AdminDao.selectByAid", fetchType = FetchType.EAGER)),
			@Result(column = "kid", property = "kind", 
				one = @One(select = "top.unltra.lost.dao.KindDao.selectByKid", fetchType = FetchType.EAGER)) })
	List<Pick> selectAllPick(Map<String, Object> params);

	// 动态修改pick
	@SelectProvider(type = PickDynaSqlProvider.class, method = "updatePick")
	void update(Pick pick);


	// 根据参数动态查询pick
	@SelectProvider(type = PickDynaSqlProvider.class, method = "selectWhitParam")
	@Results({ 
			@Result(id = true, column = "pid", property = "pid"),
			@Result(column = "pname", property = "pname"),
			@Result(column = "ppic", property = "ppic"),
			@Result(column = "pdescri", property = "pdescri"),
			@Result(column = "pplace", property = "pplace"),
			@Result(column = "ppersoninf", property = "ppersoninf"),
			@Result(column = "pnowplace", property = "pnowplace"),
			@Result(column = "poutstatus", property = "poutstatus"),
			@Result(column = "pownstatus", property = "pownstatus"),
			@Result(column = "ptime", property = "ptime", javaType = java.util.Date.class),
			@Result(column = "pcreatetime", property = "pcreatetime", javaType = java.util.Date.class),
			@Result(column = "aid", property = "admin",
				one = @One(select = "top.unltra.lost.dao.AdminDao.selectByAid", fetchType = FetchType.EAGER)),
			@Result(column = "kid", property = "kind", 
				one = @One(select = "top.unltra.lost.dao.KindDao.selectByKid", fetchType = FetchType.EAGER)) })
	List<Pick> selectByPage(Map<String, Object> params);
	
	// 根据参数动态查询pick
	@SelectProvider(type = PickDynaSqlProvider.class, method = "selectByTimeAndPage")
	@Results({ 
				@Result(id = true, column = "pid", property = "pid"),
				@Result(column = "pname", property = "pname"),
				@Result(column = "ppic", property = "ppic"),
				@Result(column = "pdescri", property = "pdescri"),
				@Result(column = "pplace", property = "pplace"),
				@Result(column = "ppersoninf", property = "ppersoninf"),
				@Result(column = "pnowplace", property = "pnowplace"),
				@Result(column = "poutstatus", property = "poutstatus"),
				@Result(column = "pownstatus", property = "pownstatus"),
				@Result(column = "ptime", property = "ptime", javaType = java.util.Date.class),
				@Result(column = "pcreatetime", property = "pcreatetime", javaType = java.util.Date.class),
				@Result(column = "aid", property = "admin",
					one = @One(select = "top.unltra.lost.dao.AdminDao.selectByAid", fetchType = FetchType.EAGER)),
				@Result(column = "kid", property = "kind", 
					one = @One(select = "top.unltra.lost.dao.KindDao.selectByKid", fetchType = FetchType.EAGER)) })
	List<Pick> selectByTimeAndPage(Map<String, Object> params);

	// 根据参数查询pick总数
	@SelectProvider(type = PickDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);

	// 动态插入pick
	@SelectProvider(type = PickDynaSqlProvider.class, method = "insertPick")
	void save(Pick pick);
	

}
