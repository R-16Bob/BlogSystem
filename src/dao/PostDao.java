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
	public List<Post> queryAllPosts(){	   	
	   	 String sql="select * from post";
	   	 return getPost(SQLHelper.executeQueryAsList(sql));
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
	//
	public String[] queryUnamesByPlist(List<Post> plist){
		String[] alluname=new String[plist.size()];
		UserDao udao=new UserDao();
		int i=0;
		for(Post p:plist) {
			String uname=udao.queryUnameByUid(p.getUid());
			alluname[i]=uname;
			i++;
		}
		return alluname;
	}
	public Post[] getArray(List<Post> plist) {
		Post[] allplist=new Post[plist.size()];
		int i=0;
		for(Post p:plist) {
			allplist[i]=p;
			i++;
		}
		return allplist;
	}
	public int deletePostByPid(int pid) {
    	String sql="delete from post where pid=?";
    	return SQLHelper.executeUpdateByParams(sql, pid);
    }
	public int updatePost(int pid,String title,String pcontent) {
    	String sql="update post set title=?,pcontent=? where pid=?";
    	return SQLHelper.executeUpdateByParams(sql, title,pcontent,pid);
    }	
	public Post queryPostBypid(int pid){	   	
	   	 String sql="select * from post where pid=?";
	   	 return getPost(SQLHelper.executeQueryByParamsAsList(sql, pid)).get(0);
	   }
	public List<Post> queryPostBytitle(String title){
	   	 String sql="select * from post where title like '%"+title+"%'";
	   	 System.out.println(sql);
	   	 return getPost(SQLHelper.executeQueryAsList(sql));
	   }
}
