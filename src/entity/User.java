package entity;

public class User {
	private int uid;
	private String uname;
	private String upwd;
	private int type;
	public User() {
	}
	public User(int uid, String uname, String upwd, int type) {
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.type = type;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", type=" + type + "]";
	}
	
}
