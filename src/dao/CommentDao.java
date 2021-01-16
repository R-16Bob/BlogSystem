package dao;
import java.util.ArrayList;
import java.util.List;

import entity.Post;
import entity.CommentView;
import util.SQLHelper;

public class CommentDao {
	public int addComment(String ccontent,int uid,int pid) {
		String sql="insert into comment(ccontent,uid,pid) values(?,?,?)";
		return SQLHelper.executeUpdateByParams(sql, ccontent,uid,pid);
	}
	public static List<CommentView> getCommentView(List<Object[]> list){
		List<CommentView> dlist=new ArrayList<CommentView>();
		for(Object[] arr:list) {
			CommentView comment=new CommentView();
			comment.setCid(Integer.valueOf(arr[0].toString()));
			comment.setCcontent(arr[1].toString());
			comment.setCreated(arr[2].toString().substring(0,16));
			comment.setUid(Integer.valueOf(arr[3].toString()));
			comment.setPid(Integer.valueOf(arr[4].toString()));
			comment.setUname(arr[5].toString());
			dlist.add(comment);
		}
		return dlist;
	}
	
	public List<CommentView> queryCommentBypid(int pid){	   	
	   	 String sql="select * from commentView where pid=?";
	   	 return getCommentView(SQLHelper.executeQueryByParamsAsList(sql, pid));
	   }
	public int deleteCommentsByCid(int cid) {
    	String sql="delete from comment where cid=?";
    	return SQLHelper.executeUpdateByParams(sql,cid);
    }
	public List<CommentView> queryCommentbyContent(String content){	   	
	   	 String sql="select * from commentView where ccontent like '%"+content+"%'";
	   	 return getCommentView(SQLHelper.executeQueryAsList(sql));
	   }
}
