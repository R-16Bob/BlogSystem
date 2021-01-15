package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Post;
import util.SQLHelper;

public class PostDao {
	public int addPost(String title,String pcontent,int uid) {
		String sql="insert into post(title,pcontent,uid) values(?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, title,pcontent,uid);
	}
	public List<Post> queryPostsByUid(int uid){	   	
	   	 String sql="select * from post where uid=?";
	   	 return getPost(SQLHelper.executeQueryByParamsAsList(sql, uid));
	   }
	public static List<Post> getPost(List<Object[]> list){
		List<Post> dlist=new ArrayList<Post>();
		for(Object[] arr:list) {
			Post post=new Post();
			post.setPid(Integer.valueOf(arr[0].toString()));
			post.setTitle(arr[1].toString());
			post.setPcontent(arr[2].toString());
			post.setUid(Integer.valueOf(arr[4].toString()));
			post.setCreated(arr[3].toString().substring(0,16));
			dlist.add(post);
		}
		return dlist;
	}
		
}
