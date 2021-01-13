package dao;

import util.SQLHelper;

public class PostDao {
	public int addPost(String title,String pcontent,int uid) {
		String sql="insert into post(title,pcontent,uid) values(?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, title,pcontent,uid);
	}
}
