package top.unltra.lost.dao;


import static top.unltra.lost.util.common.LostConstants.ADMINTABLE;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;


import top.unltra.lost.dao.provider.AdminDynaSqlProvider;
import top.unltra.lost.domain.Admin;

public interface AdminDao {
	// 根据登录名和密码查询admin
		@Select("select * from "+ADMINTABLE+" where aname = #{aname} and apw = #{apw}")
		Admin selectByAnameAndApw(
				@Param("aname") String aname,
				@Param("apw") String apw);
		
		@Select("select * from "+ADMINTABLE+" ")
		List<Admin> selectAllAdmin();
		
		// 根据aid查询admin
		@Select("select * from "+ADMINTABLE+" where aid = #{aid}")
		Admin selectByAid(Integer aid);
		
		// 根据aid删除admin
		@Delete(" delete from "+ADMINTABLE+" where aid = #{aid} ")
		void deleteByAid(Integer aid);
			
		// 动态修改admin
		@SelectProvider(type=AdminDynaSqlProvider.class,method="updateAdmin")
		void update(Admin admin);
			
		// 动态查询
		@SelectProvider(type=AdminDynaSqlProvider.class,method="selectWhitParam")
		List<Admin> selectByPage(Map<String, Object> params);
		
		// 根据参数查询admin总数
		@SelectProvider(type=AdminDynaSqlProvider.class,method="count")
		Integer count(Map<String, Object> params);
		
		// 动态插入admin
		@SelectProvider(type=AdminDynaSqlProvider.class,method="insertAdmin")
		void save(Admin admin);
}
