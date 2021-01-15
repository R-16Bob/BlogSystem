package util;

import java.util.List;

import dao.PostDao;
import dao.UserDao;
import entity.Post;
import entity.User;

public class Test {
	public static void main(String args[]) {
		UserDao udao=new UserDao();
		/*List<User> ulist=udao.queryUsersByType(2);
		for(User u:ulist) {
			System.out.println(u);
		}*/
		//System.out.println(udao.queryUserByuname("bob"));
		PostDao pdao=new PostDao();
		/*List<Post> plist=pdao.queryPostsByUid(2);
		for(Post p:plist) {
			System.out.println(p);
		}*/
		pdao.deletePostByPid(1);
	}
}
