import java.io.Serializable;

public class  BlumingVO implements  Serializable{
	
	private int idx;
	private String userid;
	private String pwd;
	private String name; 
	private String tel;
	private String email;
	
	public BlumingVO() {
		
	}
	public BlumingVO(int idx,String userid,String pwd, String name,  String tel,String email) {
		this.idx=idx; this.userid=userid; this.pwd=pwd; this.name=name;  this.tel=tel; this.email=email;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}////////////////////////////////