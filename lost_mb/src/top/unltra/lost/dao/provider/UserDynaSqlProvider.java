package top.unltra.lost.dao.provider;



import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import top.unltra.lost.domain.User;
import static top.unltra.lost.util.common.LostConstants.USERTABLE;;

/**   
 * @Description: user动态SQL语句提供类 
 */
public class UserDynaSqlProvider {
	//Date date= new Date();
	//DateFormat da = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(USERTABLE);
				if(params.get("user") != null){
					User user = (User)params.get("user");
					if(user.getUname() != null && !user.getUname().equals("")){
						WHERE("  uname LIKE CONCAT ('%',#{user.uname},'%') ");
					}
					if(user.getStuid() != null && !user.getStuid().equals("")){
						WHERE("  stuid LIKE CONCAT ('%',#{user.stuid},'%') ");
					}
					
				}
			}
		}.toString();
		
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		
		return sql;
	}	
	// 动态查询总数量
	public String count(Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if(params.get("user") != null){
					User user = (User)params.get("user");
					if(user.getUname() != null && !user.getUname().equals("")){
						WHERE(" uname LIKE CONCAT ('%',#{user.uname},'%') ");
					}
					if(user.getStuid() != null && !user.getStuid().equals("")){
						WHERE("  stuid LIKE CONCAT ('%',#{user.stuid},'%') ");
					}
					
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertUser(User user){
		
		return new SQL(){
			{
				INSERT_INTO(USERTABLE);
				if(user.getUname() != null){
					VALUES("uname", "#{uname}");
				}
				if(user.getUpw() != null){
					VALUES("upw", "#{upw}");
				}
				if(user.getStuid() != null){
					VALUES("stuid", "#{stuid}");
				}
				if(user.getUphone() != null){
					VALUES("uphone", "#{uphone}");
				}
				if(user.getUqq() != null){
					VALUES("uqq", "#{uqq}");
				}
				if(user.getUmail() != null){
					VALUES("umail", "#{umail}");
				}
				if(user.getUaddress() != null){
					VALUES("uaddress", "#{uaddress}");
				}
			}
		}.toString();
	}
	// 动态更新
		public String updateUser(User user){
			
			return new SQL(){
				{
					UPDATE(USERTABLE);
					if(user.getUname() != null){
						SET(" uname = #{uname} ");
					}
					if(user.getStuid() != null){
						SET(" stuid = #{stuid} ");
					}
					if(user.getUpw() != null){
						SET(" upw = #{upw} ");
					}
					if(user.getUphone() != null){
						SET(" uphone = #{uphone} ");
					}
					if(user.getUmail() != null){
						SET(" umail = #{umail} ");
					}
					if(user.getUaddress() != null){
						SET(" uaddress = #{uaddress} ");
					}
					if(user.getUqq() != null){
						SET(" uqq = #{uqq} ");
					}
					WHERE(" uid = #{uid} ");
				}
			}.toString();
		}
}
