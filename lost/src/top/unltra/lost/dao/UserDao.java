package top.unltra.lost.dao;

import static top.unltra.lost.util.common.LostConstants.USERTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import top.unltra.lost.dao.provider.UserDynaSqlProvider;
import top.unltra.lost.domain.User;

public interface UserDao {
			// 根据登录名查询user
			@Select("select * from "+USERTABLE+" where uname = #{uname}")
			User selectByUname(@Param("uname") String uname);
			
			// 根据登录名和密码查询user
			@Select("select * from "+USERTABLE+" where uname = #{uname} and upw = #{upw}")
			User selectByUnameAndUpw(@Param("uname") String uname,
                                     @Param("upw") String upw);
			
			@Select("select * from "+USERTABLE+" ")
			List<User> selectAllUser();
			
			// 根据uid查询user
			@Select("select * from "+USERTABLE+" where uid = #{uid}")
			User selectByUid(Integer uid);
			
			// 根据uid删除user
			@Delete(" delete from "+USERTABLE+" where uid = #{uid} ")
			void deleteByUid(Integer uid);
				
			// 动态修改user
			@SelectProvider(type=UserDynaSqlProvider.class,method="updateUser")
			void update(User user);
				
			// 动态查询
			@SelectProvider(type=UserDynaSqlProvider.class,method="selectWhitParam")
			List<User> selectByPage(Map<String, Object> params);
			
			// 根据参数查询user总数
			@SelectProvider(type=UserDynaSqlProvider.class,method="count")
			Integer count(Map<String, Object> params);
			
			// 动态插入user
			@SelectProvider(type=UserDynaSqlProvider.class,method="insertUser")
			void save(User user);

}
