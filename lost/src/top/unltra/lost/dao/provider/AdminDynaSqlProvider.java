package top.unltra.lost.dao.provider;



import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import top.unltra.lost.domain.Admin;
import static top.unltra.lost.util.common.LostConstants.ADMINTABLE;;

/**   
 * @Description: 用户动态SQL语句提供类 
 */
public class AdminDynaSqlProvider {
	//Date date= new Date();
	//DateFormat da = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(ADMINTABLE);
				if(params.get("admin") != null){
					Admin admin = (Admin)params.get("admin");
					if(admin.getAname() != null && !admin.getAname().equals("")){
						WHERE("  aname LIKE CONCAT ('%',#{admin.aname},'%') ");
					}
					if(admin.getApower() != null && !admin.getApower().equals("")){
						WHERE(" apower LIKE CONCAT ('%',#{admin.apower},'%') ");
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
				FROM(ADMINTABLE);
				if(params.get("admin") != null){
					Admin admin = (Admin)params.get("admin");
					if(admin.getAname() != null && !admin.getAname().equals("")){
						WHERE(" aname LIKE CONCAT ('%',#{admin.aname},'%') ");
					}
					if(admin.getApower() != null &&  !admin.getApower().equals("")){
						WHERE(" apower LIKE CONCAT ('%',#{admin.apower},'%') ");
					}
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertAdmin(Admin admin){
		
		return new SQL(){
			{
				INSERT_INTO(ADMINTABLE);
				if(admin.getAname() != null && !admin.getAname().equals("")){
					VALUES("aname", "#{aname}");
				}
				if(admin.getApower() != null && !admin.getApower().equals("")){
					VALUES("apower", "#{apower}");
				}
				if(admin.getApw() != null && !admin.getApw().equals("")){
					VALUES("apw", "#{apw}");
				}
				if(admin.getAphone() != null && !admin.getAphone().equals("")){
					VALUES("aphone", "#{aphone}");
				}
				if(admin.getAtel() != null && !admin.getAtel().equals("")){
					VALUES("atel", "#{atel}");
				}
				if(admin.getAqq() != null && !admin.getAqq().equals("")){
					VALUES("aqq", "#{apw}");
				}
				if(admin.getAmail() != null && !admin.getAmail().equals("")){
					VALUES("amail", "#{amail}");
				}
				
			}
		}.toString();
	}
	// 动态更新
		public String updateAdmin(Admin admin){
			
			return new SQL(){
				{
					UPDATE(ADMINTABLE);
					if(admin.getAname() != null){
						SET(" aname = #{aname} ");
					}
					if(admin.getApw()!= null){
						SET(" apw = #{apw} ");
					}
					if(admin.getApower()!= null){
						SET(" apower = #{apower} ");
					}
					if(admin.getAphone() != null){
						SET("aphone = #{aphone}");
					}
					if(admin.getAtel() != null){
						SET("atel = #{atel}");
					}
					if(admin.getAqq() != null){
						SET("aqq = #{aqq}");
					}
					if(admin.getAmail() != null){
						SET("amail = #{amail}");
					}
					WHERE(" aid = #{aid} ");
				}
			}.toString();
		}
}
