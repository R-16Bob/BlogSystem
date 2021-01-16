package entity;
public class CommentView {
	 private int cid;
	 private String ccontent;
	 private String created;
	 private int uid;
	 private int pid;
	 private String uname;
	 
	public CommentView(int cid, String ccontent, String created, int uid, int pid,String uname) {
		super();
		this.cid = cid;
		this.ccontent = ccontent;
		this.created = created;
		this.uid = uid;
		this.pid = pid;
		this.uname=uname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public CommentView() {
		
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "CommentView [cid=" + cid + ", ccontent=" + ccontent + ", created=" + created + ", uid=" + uid + ", pid="
				+ pid + ", uname=" + uname + "]";
	}		
}
