package top.unltra.lost.dao.provider;


import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import top.unltra.lost.domain.Kind;
import static top.unltra.lost.util.common.LostConstants.KINDTABLE;

/**   
 * @Description: kind动态SQL语句提供类
  
 */
public class KindDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(KINDTABLE);
				if(params.get("kind") != null){
					Kind kind = (Kind) params.get("kind");
					if(kind.getKname() != null && !kind.getKname().equals("")){
						WHERE("  kname LIKE CONCAT ('%',#{kind.kname},'%') ");
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
				FROM(KINDTABLE);
				if(params.get("kind") != null){
					Kind kind = (Kind) params.get("kind");
					if(kind.getKname() != null && !kind.getKname().equals("")){
						WHERE("  kname LIKE CONCAT ('%',#{kind.kname},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertKind(Kind kind){
		
		return new SQL(){
			{
				INSERT_INTO(KINDTABLE);
				if(kind.getKname() != null && !kind.getKname().equals("")){
					VALUES("kname", "#{kname}");
				}
				if(kind.getA_kid() != null && !kind.getA_kid().equals("")){
					VALUES("a_kid", "#{a_kid}");
				}
			}
		}.toString();
	}
	// 动态更新
	public String updateKind(Kind kind){
		
		return new SQL(){
			{
				UPDATE(KINDTABLE);
				if(kind.getKname() != null){
					SET(" kname = #{kname} ");
				}
				if(kind.getA_kid() != null){
					SET(" a_kid = #{a_kid} ");
				}
				WHERE(" kid = #{kid} ");
			}
		}.toString();
	}


}
