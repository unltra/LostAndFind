package top.unltra.lost.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/*CREATE TABLE `lp_lostnotice` (
		  `lid` int(11) NOT NULL AUTO_INCREMENT,
		  `uid` int(11) DEFAULT NULL,
		  `kid` int(11) DEFAULT NULL,
		  `aid` int(11) DEFAULT NULL,
		  `lname` varchar(30) DEFAULT NULL,
		  `lpic` varchar(50) DEFAULT NULL,
		  `ldescri` varchar(50) DEFAULT NULL,
		  `lplace` varchar(20) DEFAULT NULL,
		  `ltime` date DEFAULT NULL,
		  `loutstatus` int(1) DEFAULT '0',
		  `lcratetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
		  PRIMARY KEY (`lid`),
		  KEY `FK_lost_ad` (`aid`),
		  KEY `FK_lost_user` (`uid`),
		  KEY `FK_lost_classd` (`kid`),
		  CONSTRAINT `FK_lost_ad` FOREIGN KEY (`aid`) REFERENCES `lp_admin` (`aid`),
		  CONSTRAINT `FK_lost_classd` FOREIGN KEY (`kid`) REFERENCES `lp_kind` (`kid`),
		  CONSTRAINT `FK_lost_user` FOREIGN KEY (`uid`) REFERENCES `lp_user` (`uid`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
*/

public class Notice implements Serializable {
	

	private Integer lid;    // lid
	private String lname;   // 拾物名称
	private String lpic;    // 拾物图片
	private MultipartFile file;		// 文件
	private String ldescri; // 拾物描述
	private String lplace; // 拾物地点
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ltime;  // 拾物时间
	private Integer loutstatus; // 拾物发布状态  默认值为1(发布)call 0(下架)
	
	private Date lcreatetime; // 拾物创建时间
	//special
	private User user; //用户
	private Kind kind; //物品类别
	private Admin admin;//admin审核公告
	
	
	@Override
	public String toString() {
		return "Notice [lid=" + lid + ", lname=" + lname + ", lpic=" + lpic + ", ldescri=" + ldescri + ", lplace="
				+ lplace + ", ltime=" + ltime + ", loutstatus=" + loutstatus + ", lcreatetime=" + lcreatetime
				+ ", user=" + user + ", kind=" + kind + ", admin=" + admin + "]";
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getLpic() {
		return lpic;
	}
	public void setLpic(String lpic) {
		this.lpic = lpic;
	}
	public String getLdescri() {
		return ldescri;
	}
	public void setLdescri(String ldescri) {
		this.ldescri = ldescri;
	}
	public String getLplace() {
		return lplace;
	}
	public void setLplace(String lplace) {
		this.lplace = lplace;
	}
	public Date getLtime() {
		return ltime;
	}
	public void setLtime(Date ltime) {
		this.ltime = ltime;
	}
	public Integer getLoutstatus() {
		return loutstatus;
	}
	public void setLoutstatus(Integer loutstatus) {
		this.loutstatus = loutstatus;
	}
	public Date getLcreatetime() {
		return lcreatetime;
	}
	public void setLcreatetime(Date lcreatetime) {
		this.lcreatetime = lcreatetime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Kind getKind() {
		return kind;
	}
	public void setKind(Kind kind) {
		this.kind = kind;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}


}
