package top.unltra.lost.dao.provider;

import static top.unltra.lost.util.common.LostConstants.LOSTNOTICETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import top.unltra.lost.domain.Notice;

public class NoticeDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params) {
		String sql = new SQL() {
			{
				SELECT("*");
				FROM(LOSTNOTICETABLE);
				if (params.get("notice") != null) {
					Notice notice = (Notice) params.get("notice");
					if (notice.getAdmin() != null && notice.getAdmin().getAid() != null && notice.getAdmin().getAid() != 0) {
						WHERE(" aid = #{notice.admin.aid} ");
					}
					if (notice.getKind() != null && notice.getKind().getKid() != null && notice.getKind().getKid() != 0) {
						WHERE(" kid = #{notice.kind.kid} ");
					}
					if (notice.getUser() != null && notice.getUser().getUid() != null && notice.getUser().getUid() != 0) {
						WHERE(" uid = #{notice.user.uid} ");
					}
					if (notice.getLname() != null && !notice.getLname().equals("")) {
						WHERE("  LNAME LIKE CONCAT ('%',#{notice.lname},'%') ");
					}
					if (notice.getLcreatetime() != null && !notice.getLcreatetime().equals("")) {
						WHERE("  lcreatetime LIKE CONCAT ('%',#{notice.lcreatetime},'%') ");
					}
					if (notice.getLtime() != null && !notice.getLtime().equals("")) {
						WHERE("  ltime LIKE CONCAT ('%',#{notice.ltime},'%') ");
					}
					if (notice.getLplace() != null && !notice.getLplace().equals("")) {
						WHERE("  lplace LIKE CONCAT ('%',#{notice.lplace},'%') ");
					}
					if(notice.getLoutstatus()!=null && notice.getLoutstatus().equals("")) {
						WHERE("  poutstatus = #{pick.poutstatus}");
					}
					if(notice.getLpic()!=null && notice.getLpic().equals("")) {
						WHERE("  lpic = #{notice.lpic}");
					}
					if(notice.getLdescri()!=null && notice.getLdescri().equals("")) {
						WHERE("  ldescri = #{notice.ldescri}");
					}
					

				}
			}
		}.toString();

		if (params.get("pageModel") != null) {
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}

		return sql;
	}
	
	// 查询所有失物公告
		public String selectAllNotice(Map<String, Object> params) {
			String sql = new SQL() {
				{
					SELECT("*");
					FROM(LOSTNOTICETABLE);
					if (params.get("notice") != null) {
						Notice notice = (Notice) params.get("notice");
						if (notice.getAdmin() != null && notice.getAdmin().getAid() != null && notice.getAdmin().getAid() != 0) {
							WHERE(" aid = #{notice.admin.aid} ");
						}
						if (notice.getKind() != null && notice.getKind().getKid() != null && notice.getKind().getKid() != 0) {
							WHERE(" kid = #{notice.kind.kid} ");
						}
						if (notice.getUser() != null && notice.getUser().getUid() != null && notice.getUser().getUid() != 0) {
							WHERE(" uid = #{notice.user.uid} ");
						}
						if (notice.getLname() != null && !notice.getLname().equals("")) {
							WHERE("  LNAME LIKE CONCAT ('%',#{notice.lname},'%') ");
						}
						if (notice.getLcreatetime() != null && !notice.getLcreatetime().equals("")) {
							WHERE("  lcreatetime LIKE CONCAT ('%',#{notice.lcreatetime},'%') ");
						}
						if (notice.getLtime() != null && !notice.getLtime().equals("")) {
							WHERE("  ltime LIKE CONCAT ('%',#{notice.ltime},'%') ");
						}
						if (notice.getLplace() != null && !notice.getLplace().equals("")) {
							WHERE("  lplace LIKE CONCAT ('%',#{notice.lplace},'%') ");
						}
						if(notice.getLoutstatus()!=null && notice.getLoutstatus().equals("")) {
							WHERE("  poutstatus = #{pick.poutstatus}");
						}
						if(notice.getLpic()!=null && notice.getLpic().equals("")) {
							WHERE("  lpic = #{notice.lpic}");
						}
						if(notice.getLdescri()!=null && notice.getLdescri().equals("")) {
							WHERE("  ldescri = #{notice.ldescri}");
						}
						

					}
				}
			}.toString();

			return sql;
		}

	// 动态查询总数量
	public String count(Map<String, Object> params) {
		return new SQL() {
			{
				SELECT("count(*)");
				FROM(LOSTNOTICETABLE);
				if (params.get("notice") != null) {
					Notice notice = (Notice) params.get("notice");
					if (notice.getAdmin() != null && notice.getAdmin().getAid() != null && notice.getAdmin().getAid() != 0) {
						WHERE(" aid = #{notice.admin.aid} ");
					}
					if (notice.getKind() != null && notice.getKind().getKid() != null && notice.getKind().getKid() != 0) {
						WHERE(" kid = #{notice.kind.kid} ");
					}
					if (notice.getUser() != null && notice.getUser().getUid() != null && notice.getUser().getUid() != 0) {
						WHERE(" uid = #{notice.user.uid} ");
					}
					if (notice.getLname() != null && !notice.getLname().equals("")) {
						WHERE("  LNAME LIKE CONCAT ('%',#{notice.lname},'%') ");
					}
					if (notice.getLcreatetime() != null && !notice.getLcreatetime().equals("")) {
						WHERE("  lcreatetime LIKE CONCAT ('%',#{notice.lcreatetime},'%') ");
					}
					if (notice.getLtime() != null && !notice.getLtime().equals("")) {
						WHERE("  ltime LIKE CONCAT ('%',#{notice.ltime},'%') ");
					}
					if (notice.getLplace() != null && !notice.getLplace().equals("")) {
						WHERE("  lplace LIKE CONCAT ('%',#{notice.lplace},'%') ");
					}
					if(notice.getLoutstatus()!=null && notice.getLoutstatus().equals("")) {
						WHERE("  poutstatus = #{pick.poutstatus}");
					}
					if(notice.getLpic()!=null && notice.getLpic().equals("")) {
						WHERE("  lpic = #{notice.lpic}");
					}
					if(notice.getLdescri()!=null && notice.getLdescri().equals("")) {
						WHERE("  ldescri = #{notice.ldescri}");
					}
					

				}
			}
		}.toString();
	}

	// 动态插入
	public String insertNotice(Notice notice) {

		return new SQL() {
			{
				INSERT_INTO(LOSTNOTICETABLE);
				if (notice.getLname() != null) {
					VALUES("lname", "#{lname}");
				}
				if (notice.getLpic() != null) {
					VALUES("lpic", "#{lpic}");
				}
				if (notice.getLdescri() != null) {
					VALUES("ldescri", "#{ldescri}");
				}
				if (notice.getLplace() != null) {
					VALUES("lplace", "#{lplace}");
				}
				if (notice.getLtime() != null) {
					VALUES("ltime", "#{ltime}");
				}
				if (notice.getLoutstatus() != null) {
					VALUES("loutstatus", "#{loutstatus}");
				}
				if (notice.getAdmin() != null) {
					VALUES("aid", "#{admin.aid}");
				}
				if (notice.getKind() != null) {
					VALUES("kid", "#{kind.kid}");
				}
				if (notice.getUser() != null) {
					VALUES("uid", "#{user.uid}");
				}
			}
		}.toString();
	}

	// 动态更新
	public String updateNotice(Notice notice){
		
		return new SQL(){
			{
				UPDATE(LOSTNOTICETABLE);
				if(notice.getLname() != null){
					SET(" lname = #{lname} ");
				}
				if(notice.getLpic() != null){
					SET(" lpic = #{lpic} ");
				}
				if(notice.getLdescri() != null){
					SET(" ldescri = #{ldescri} ");
				}
				if(notice.getLtime() != null){
					SET(" ltime = #{ltime} ");
				}
				if(notice.getLoutstatus() != null){
					SET(" loutstatus = #{loutstatus} ");
				}
				if(notice.getAdmin()!= null){
					SET(" aid = #{admin.aid} ");
				}
				if(notice.getKind()!= null){
					SET(" kid = #{kind.kid} ");
				}
				if(notice.getUser()!= null){
					SET(" uid = #{user.uid} ");
				}
				WHERE(" lid = #{lid} ");
			}
		}.toString();
	}


}

