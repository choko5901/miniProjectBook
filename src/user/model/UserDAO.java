package user.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class UserDAO {
private static UserDAO instance = new UserDAO();
	
	public static UserDAO getInstance() {
		return instance;
	}

	
	public static String getName() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from TB_US_GRADE";
		String dname = null;
		
		try {			
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				dname = rset.getString("US_GRADE");
				System.out.println(dname);
			}
		} finally {
//			DBUtil.close(pstmt, con);
		}
		return dname;
	}

}
