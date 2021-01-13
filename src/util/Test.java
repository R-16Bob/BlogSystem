package util;

import java.util.List;

import dao.UserDao;
import entity.User;

public class Test {
	public static void main(String args[]) {
		UserDao udao=new UserDao();
		/*List<User> ulist=udao.queryUsersByType(2);
		for(User u:ulist) {
			System.out.println(u);
		}*/
		
		System.out.println(udao.queryUserByuname("bob"));
	}
}
