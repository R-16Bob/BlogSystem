package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLHelper {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/online_invest",user="root",pwd="666"; 

	private static Connection conn=null;
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection() {
		try {
			if(conn!=null && !conn.isClosed())
				conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	//可变参数
		public static int executeUpdateByParams(String sql,Object... params) {
			int r=0;
			try {
				Connection conn = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pcmd=conn.prepareStatement(sql);
				for(int i=0;i<params.length;i++) {
					Object param=params[i];
					if(param instanceof Integer)
						pcmd.setInt(i+1,new Integer(param.toString()));
					else if(param instanceof Double)
						pcmd.setDouble(i+1, new Double(param.toString()));
					else if(param instanceof Float)
						pcmd.setFloat(i+1, new Float(param.toString()));
					else if(param instanceof String)
						pcmd.setString(i+1, param.toString());
					else pcmd.setObject(i+1, param);
				}
				r=pcmd.executeUpdate();
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return r;
		}
		//将查询到的内容放到List返回
		public static List<Object[]> executeQueryAsList(String sql){
			List<Object[]> list=new ArrayList<Object[]>();
			ResultSet rs=null;
			try {
				conn = DriverManager.getConnection(url, user, pwd);
				Statement cmd=conn.createStatement();
				rs=cmd.executeQuery(sql);
				int cols=rs.getMetaData().getColumnCount();
				while(rs.next()) {
					Object[] arr=new Object[cols];
					for(int i=0;i<arr.length;i++) {
						arr[i]=rs.getObject(i+1);
					}
					list.add(arr);  
				}
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return list;
		}
		public static List<Object[]> executeQueryByParamsAsList(String sql,Object... params){
			List<Object[]> list=new ArrayList<Object[]>();
			ResultSet rs=null;
			try {
				conn = DriverManager.getConnection(url, user, pwd);
				PreparedStatement pcmd=conn.prepareStatement(sql);
				for(int i=0;i<params.length;i++) {
					Object param=params[i];
					if(param instanceof Integer)
						pcmd.setInt(i+1,new Integer(param.toString()));
					else if(param instanceof Double)
						pcmd.setDouble(i+1, new Double(param.toString()));
					else if(param instanceof Float)
						pcmd.setFloat(i+1, new Float(param.toString()));
					else if(param instanceof String)
						pcmd.setString(i+1, param.toString());
					else pcmd.setObject(i+1, param);
				}
				rs=pcmd.executeQuery();
				int cols=rs.getMetaData().getColumnCount();
				while(rs.next()) {
					//每一行记录就是一个Object数组
					Object[] arr=new Object[cols];
					for(int i=0;i<arr.length;i++) {
						arr[i]=rs.getObject(i+1);
					}
					list.add(arr);  //将结果集的每一行都加入list
				}
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return list;
		}
}
