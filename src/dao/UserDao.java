package dao;

import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.SQLHelper;

public class UserDao {
	public List<User> queryAllUsers(){
	   	 List<User> clist=new ArrayList<User>();
	   	 String sql="select * from users";
	   	 List<Object[]> cusarr=util.SQLHelper.executeQueryAsList(sql);
	   	 for(Object[] arr:cusarr) {
	   		 User u=new User();
	   		 u.setUid(Integer.valueOf(arr[0].toString()));
	   		 u.setUname(arr[1].toString());
	   		 u.setUpwd(arr[2].toString());
	   		u.setType(Integer.valueOf(arr[3].toString()));
	   		 clist.add(u);
	   	 }
	   	 return clist;
		}
	//根据类型查询
	public List<User> queryUsersByType(int type){
   	 List<User> clist=new ArrayList<User>();
   	 String sql="select * from users where type=?";
   	 List<Object[]> cusarr=util.SQLHelper.executeQueryByParamsAsList(sql,type);
   	 for(Object[] arr:cusarr) {
   		 User u=new User();
   		 u.setUid(Integer.valueOf(arr[0].toString()));
   		 u.setUname(arr[1].toString());
   		 u.setUpwd(arr[2].toString());
   		u.setType(Integer.valueOf(arr[3].toString()));
   		 clist.add(u);
   	 }
   	 return clist;
	}
	//添加普通用户
	public int addUser(String uname,String upwd) {
		String sql="insert into users(uname,upwd) values(?,?)";
		return SQLHelper.executeUpdateByParams(sql, uname,upwd);
	}
	
	//验证登录
	public boolean verify(String uname,String upwd,List<User> ulist) {
		for(User u:ulist) {
			if(u.getUname().equals(uname)&&u.getUpwd().equals(upwd)) {
				return true;
			}
		}
		return false;
	}
	//获取用户名指定对象
	public User queryUserByuname(String name) {
		 List<User> clist=new ArrayList<User>();
   	 String sql="select * from users where uname=?";
   	 List<Object[]> cusarr=util.SQLHelper.executeQueryByParamsAsList(sql,name);
   	 for(Object[] arr:cusarr) {
   		 User u=new User();
   		 u.setUid(Integer.valueOf(arr[0].toString()));
   		 u.setUname(arr[1].toString());
   		 u.setUpwd(arr[2].toString());
   		u.setType(Integer.valueOf(arr[3].toString()));
   		 clist.add(u);
   	 }
   	 return clist.get(0);
	 }
	//uid获得uname
	public String queryUnameByUid(int uid) {
		 List<User> clist=new ArrayList<User>();
  	 String sql="select * from users where uid=?";
  	 List<Object[]> cusarr=util.SQLHelper.executeQueryByParamsAsList(sql,uid);
  	 return cusarr.get(0)[1].toString();
	 }
}
