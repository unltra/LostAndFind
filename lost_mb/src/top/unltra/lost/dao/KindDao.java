package top.unltra.lost.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import top.unltra.lost.dao.provider.KindDynaSqlProvider;
import top.unltra.lost.domain.Kind;
import static top.unltra.lost.util.common.LostConstants.KINDTABLE;

/**   
 * @Description: KindMapper接口
 
 */
public interface KindDao {

	// 动态查询
	@SelectProvider(type=KindDynaSqlProvider.class,method="selectWhitParam")
	List<Kind> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=KindDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@Select("select * from "+KINDTABLE+" ")
	List<Kind> selectAllKind();
	
	@Select("select * from "+KINDTABLE+" where KID = #{kid}")
	Kind selectByKid(int id);

	// 根据id删除Kind kind
	@Delete(" delete from "+KINDTABLE+" where kid = #{kid} ")
	void deleteByKid(Integer kid);
	
	// 动态插入Kind kind
	@SelectProvider(type=KindDynaSqlProvider.class,method="insertKind")
	void save(Kind kind);
	
	// 动态修改Kind kind
	@SelectProvider(type=KindDynaSqlProvider.class,method="updateKind")
	void update(Kind kind);
}
