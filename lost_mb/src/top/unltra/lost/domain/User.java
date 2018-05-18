package top.unltra.lost.domain;

import java.io.Serializable;
import java.util.Date;

/*CREATE TABLE `lp_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(10) DEFAULT NULL,
  `stuid` varchar(10) DEFAULT NULL,
  `upw` varchar(20) DEFAULT NULL,
  `uphone` varchar(11) DEFAULT NULL,
  `uqq` varchar(12) DEFAULT NULL,
  `umail` varchar(25) DEFAULT NULL,
  `uaddress` varchar(50) DEFAULT NULL,
  `ucreatetime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;*/

public class User implements Serializable {
	private Integer uid;
	private String uname;
	private String stuid; //学号
	private String upw;
	private String uphone;
	private String uqq;
	private String umail;
	private String uaddress;
	private java.util.Date ucreatetime;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", stuid=" + stuid + ", upw=" + upw + ", uphone=" + uphone
				+ ", uqq=" + uqq + ", umail=" + umail + ", uaddress=" + uaddress + ", ucreatetime=" + ucreatetime + "]";
	}
	
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUphone() {
		return uphone;
	}
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	public String getUqq() {
		return uqq;
	}
	public void setUqq(String uqq) {
		this.uqq = uqq;
	}
	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public java.util.Date getUcreatetime() {
		return ucreatetime;
	}
	public void setUcreatetime(java.util.Date ucreatetime) {
		this.ucreatetime = ucreatetime;
	}

}
