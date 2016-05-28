package cn.domain.hello.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import cn.domain.hello.bean.UserBean;


public class UserDao extends BaseDao{
	public PreparedStatement prepStmt = null;
	public ResultSet rs = null;
	
	public UserBean getUserByName(String src){
		UserBean userBean = null;
		try {
			conn = super.openDB();
			if(conn!=null){
				String sql = "select * from tab_user where username = ?";
				prepStmt = conn.prepareStatement(sql);
				prepStmt.setString(1,src);
				rs = prepStmt.executeQuery();
				if(rs.next()){
					userBean = new UserBean(rs.getInt(1),rs.getString(2),rs.getString(3));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
				if(prepStmt!=null)
					prepStmt.close();
				if(conn!=null)
					conn.close();
				super.closeDB();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userBean;
	}
}
