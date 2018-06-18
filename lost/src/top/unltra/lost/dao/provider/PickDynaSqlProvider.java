package top.unltra.lost.dao.provider;

import static top.unltra.lost.util.common.LostConstants.PICKTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import top.unltra.lost.domain.Pick;

/*
		  `pid` int(11) NOT NULL,
		  `aid` int(11) DEFAULT NULL,
		  `kid` int(11) DEFAULT NULL,
		  `pname` varchar(30) DEFAULT NULL,
		  `ppic` varchar(50) DEFAULT NULL,
		  `pdescri` varchar(50) DEFAULT NULL,
		  `pplace` varchar(20) DEFAULT NULL,
		  `ptime` date DEFAULT NULL,
		  `ppersoninf` varchar(50) DEFAULT NULL,
		  `pnowplace` varchar(20) DEFAULT NULL,
		  `poutstatus` int(1) DEFAULT NULL,
		  `pownstatus` int(1) DEFAULT NULL,
		  `pcreatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
*/

public class PickDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(PICKTABLE);
				if (params.get("pick") != null) {
					Pick pick = (Pick) params.get("pick");
					if (pick.getAdmin() != null && pick.getAdmin().getAid() != null && pick.getAdmin().getAid() != 0) {
						WHERE(" aid = #{pick.admin.aid} ");
					}
					if (pick.getKind() != null && pick.getKind().getKid() != null && pick.getKind().getKid() != 0) {
						WHERE(" kid = #{pick.kind.kid} ");
					}
					if (pick.getPname() != null && !pick.getPname().equals("")) {
						WHERE("  PNAME LIKE CONCAT ('%',#{pick.pname},'%') ");
					}
					if (pick.getPcreatetime() != null && !pick.getPcreatetime().equals("")) {
						WHERE("  pcreatetime LIKE CONCAT ('%',#{pick.pcreatetime},'%') ");
					}
					if (pick.getPtime() != null && !pick.getPtime().equals("")) {
						WHERE("  ptime LIKE CONCAT ('%',#{pick.ptime},'%') ");
					}
					if (pick.getPplace() != null && !pick.getPplace().equals("")) {
						WHERE("  pplace LIKE CONCAT ('%',#{pick.pplace},'%') ");
					}
					if(pick.getPoutstatus()!=null && pick.getPoutstatus().equals("")) {
						WHERE("  poutstatus = #{pick.poutstatus}");
					}
					if(pick.getPownstatus()!=null && pick.getPownstatus().equals("")) {
						WHERE("  pownstatus = #{pick.pownstatus}");
					}

				}
			}
		}.toString();

		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}

		return sql;
	}
	
	public String selectAllPick(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(PICKTABLE);
				if (params.get("pick") != null) {
					Pick pick = (Pick) params.get("pick");
					if (pick.getAdmin() != null && pick.getAdmin().getAid() != null && pick.getAdmin().getAid() != 0) {
						WHERE(" aid = #{pick.admin.aid} ");
					}
					if (pick.getKind() != null && pick.getKind().getKid() != null && pick.getKind().getKid() != 0) {
						WHERE(" kid = #{pick.kind.kid} ");   
					}
					if (pick.getPname() != null && !pick.getPname().equals("")) {
						WHERE("  PNAME LIKE CONCAT ('%',#{pick.pname},'%') ");
					}
					if (pick.getPcreatetime() != null && !pick.getPcreatetime().equals("")) {
						WHERE("  pcreatetime LIKE CONCAT ('%',#{pick.pcreatetime},'%') ");
					}
					if (pick.getPtime() != null && !pick.getPtime().equals("")) {
						WHERE("  ptime LIKE CONCAT ('%',#{pick.ptime},'%') ");
					}
					if (pick.getPplace() != null && !pick.getPplace().equals("")) {
						WHERE("  pplace LIKE CONCAT ('%',#{pick.pplace},'%') ");
					}
					if(pick.getPoutstatus()!=null && pick.getPoutstatus().equals("")) {
						WHERE("  poutstatus = #{pick.poutstatus}");
					}
					if(pick.getPownstatus()!=null && pick.getPownstatus().equals("")) {
						WHERE("  pownstatus = #{pick.pownstatus}");
					}

				}
			}
		}.toString();

		
		return sql;
	}
	
	public String selectByTimeAndPage(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(PICKTABLE);
				if (params.get("pick") != null) {
					Pick pick = (Pick) params.get("pick");
					if (pick.getAdmin() != null && pick.getAdmin().getAid() != null && pick.getAdmin().getAid() != 0) {
						WHERE(" aid = #{pick.admin.aid} ");
					}
					if (pick.getKind() != null && pick.getKind().getKid() != null && pick.getKind().getKid() != 0) {
						WHERE(" kid = #{pick.kind.kid} ");
					}
					if (pick.getPname() != null && !pick.getPname().equals("")) {
						WHERE("  PNAME LIKE CONCAT ('%',#{pick.pname},'%') ");
					}
					if (pick.getPcreatetime() != null && !pick.getPcreatetime().equals("")) {
						WHERE("  pcreatetime LIKE CONCAT ('%',#{pick.pcreatetime},'%') ");
					}
					if (pick.getPtime() != null && !pick.getPtime().equals("")) {
						WHERE("  ptime LIKE CONCAT ('%',#{pick.ptime},'%') ");
					}
					if (pick.getPplace() != null && !pick.getPplace().equals("")) {
						WHERE("  pplace LIKE CONCAT ('%',#{pick.pplace},'%') ");
					}
					if(pick.getPoutstatus()!=null && pick.getPoutstatus().equals("")) {
						WHERE("  poutstatus = #{pick.poutstatus}");
					}
					if(pick.getPownstatus()!=null && pick.getPownstatus().equals("")) {
						WHERE("  pownstatus = #{pick.pownstatus}");
					}

				}
			}
		}.toString();

		if (params.get("pageModel") != null) {
			sql += " Order By ptime Desc limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}

		return sql;
	}

	// 动态查询总数量
	public String count(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(PICKTABLE);
				if (params.get("pick") != null) {
					Pick pick = (Pick) params.get("pick");
					if (pick.getAdmin() != null && pick.getAdmin().getAid() != null && pick.getAdmin().getAid() != 0) {
						WHERE(" aid = #{pick.admin.aid} ");
					}
					if (pick.getKind() != null && pick.getKind().getKid() != null && pick.getKind().getKid() != 0) {
						WHERE(" kid = #{pick.kind.kid} ");
					}
					if (pick.getPname() != null && !pick.getPname().equals("")) {
						WHERE("  PNAME LIKE CONCAT ('%',#{pick.pname},'%') ");
					}
					if (pick.getPcreatetime() != null && !pick.getPcreatetime().equals("")) {
						WHERE("  pcreatetime LIKE CONCAT ('%',#{pick.pcreatetime},'%') ");
					}
					if (pick.getPtime() != null && !pick.getPtime().equals("")) {
						WHERE("  ptime LIKE CONCAT ('%',#{pick.ptime},'%') ");
					}
					if (pick.getPplace() != null && !pick.getPplace().equals("")) {
						WHERE("  pplace LIKE CONCAT ('%',#{pick.pplace},'%') ");
					}
					if(pick.getPoutstatus()!=null && pick.getPoutstatus().equals("")) {
						WHERE("  poutstatus = #{pick.poutstatus}");
					}
					if(pick.getPownstatus()!=null && pick.getPownstatus().equals("")) {
						WHERE("  pownstatus = #{pick.pownstatus}");
					}
				}
			}
		}.toString();
	}

	// 动态插入
	public String insertPick(Pick pick) {

		return new SQL() {
			{
				INSERT_INTO(PICKTABLE);
				if (pick.getPname() != null) {
					VALUES("pname", "#{pname}");
				}
				if (pick.getPpic() != null) {
					VALUES("ppic", "#{ppic}");
				}
				if (pick.getPdescri() != null) {
					VALUES("pdescri", "#{pdescri}");
				}
				if (pick.getPplace() != null) {
					VALUES("pplace", "#{pplace}");
				}
				if (pick.getPtime() != null) {
					VALUES("ptime", "#{ptime}");
				}
				if (pick.getPpersoninf() != null) {
					VALUES("ppersoninf", "#{ppersoninf}");
				}
				if (pick.getPnowplace() != null) {
					VALUES("pnowplace", "#{pnowplace}");
				}
				if (pick.getPoutstatus() != null) {
					VALUES("poutstatus", "#{poutstatus}");
				}
				if (pick.getPownstatus() != null) {
					VALUES("pownstatus", "#{pownstatus}");
				}
				if (pick.getAdmin() != null) {
					VALUES("aid", "#{admin.aid}");
				}
				if (pick.getKind() != null) {
					VALUES("kid", "#{kind.kid}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updatePick(Pick pick){
		
		return new SQL(){
			{
				UPDATE(PICKTABLE);
				if(pick.getPname() != null){
					SET(" pname = #{pname} ");
				}
				if(pick.getPpic() != null){
					SET(" ppic = #{ppic} ");
				}
				if(pick.getPdescri() != null){
					SET(" pdescri = #{pdescri} ");
				}
				if(pick.getPtime() != null){
					SET(" ptime = #{ptime} ");
				}
				if(pick.getPpersoninf() != null){
					SET(" ppersoninf = #{ppersoninf} ");
				}
				if(pick.getPnowplace() != null){
					SET(" pnowplace = #{pnowplace} ");
				}
				if(pick.getPoutstatus() != null){
					SET(" poutstatus = #{poutstatus} ");
				}
				if(pick.getPownstatus()!= null){
					SET(" pownstatus = #{pownstatus} ");
				}
				if(pick.getAdmin()!= null){
					SET(" aid = #{admin.aid} ");
				}
				if(pick.getKind()!= null){
					SET(" kid = #{kind.kid} ");
				}
				WHERE(" pid = #{pid} ");
			}
		}.toString();
	}


}

