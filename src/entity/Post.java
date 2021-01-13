package entity;

public class Post {
	 private int pid;
	 private String title;
	 private String pcontent;
	 private String created;
	 private int uid;
	public Post(int pid, String title, String pcontent, String created, int uid) {
		super();
		this.pid = pid;
		this.title = title;
		this.pcontent = pcontent;
		this.created = created;
		this.uid = uid;
	}

	public Post() {
		
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
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

	@Override
	public String toString() {
		return "Post [pid=" + pid + ", title=" + title + ", pcontent=" + pcontent + ", created=" + created + ", uid=" + uid
				+ "]";
	}

	}

