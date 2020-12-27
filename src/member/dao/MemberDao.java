package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	
	public void insert (Connection con, Member member) throws SQLException {
		String sql = "INSERT INTO yura_member "
				   + "VALUES (?, ?, ?, ?, ?, ?, SYSDATE)";
		
		PreparedStatement pstmt = null;
		
		try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getPassword());
		pstmt.setString(4, member.getEmail());
		pstmt.setString(5, member.getBirth());
		pstmt.setString(6, member.getGrade());
		
		pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
	}
	public Member selectById (Connection con, String id) {
		Member member = null;
		String sql = "SELECT member_id, member_name, member_password, "
				   + "member_email, member_birth, grade, regdate "
				   + "FROM yura_member "
				   + "WHERE member_id=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
		member = new Member();
		member.setId(rs.getString(1));
		member.setName(rs.getString(2));
		member.setPassword(rs.getString(3));
		member.setEmail(rs.getString(4));
		member.setBirth(rs.getString(5));
		member.setGrade(rs.getString(6));
		member.setRegdate(rs.getTimestamp(6));
		
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		return member;				
	}
}























