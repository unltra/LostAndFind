package top.unltra.lost.domain;



public class Kind implements java.io.Serializable{

	private Integer kid;		// kid
	private String kname;	// 分类名称
	private Integer a_kid;	// 大类
	
	
	@Override
	public String toString() {
		return "Kind [kid=" + kid + ", kname=" + kname + ", a_kid=" + a_kid + "]";
	}
	
	public Integer getKid() {
		return kid;
	}
	public void setKid(Integer kid) {
		this.kid = kid;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public Integer getA_kid() {
		return a_kid;
	}
	public void setA_kid(Integer a_kid) {
		this.a_kid = a_kid;
	}
	
	// 无参数构造器
	public Kind() {
		super();
	}
	

}
