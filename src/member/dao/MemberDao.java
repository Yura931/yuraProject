package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	public void delete (Connection con, String id) throws SQLException {
		String sql = "DELETE yura_member "
				   + "WHERE member_id = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
		}
	}
	
	public void update (Connection con, Member member) throws SQLException {
		String sql = "UPDATE yura_member "
				   + "SET member_password=? "
				   + "WHERE member_id=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
		pstmt.setString(1, member.getPassword());
		pstmt.setString(2, member.getId());
				
		pstmt.executeUpdate();
		}
	}
	
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
		member.setRegdate(rs.getTimestamp(7));
		
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		return member;				
	}
	
	public Member selectFindId (Connection con, String name, String email) throws SQLException {
		String sql = "SELECT member_id FROM yura_member "
				   + "WHERE member_name=? "
				   + "AND member_email=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			member.setId(rs.getString(1));			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
		
		return member;
	}

	public Member seletByPwd(Connection con, String id, String name, String email) {
		String sql = "SELECT member_password "
				   + "FROM yura_member "
				   + "WHERE member_id=? "
				   + "AND member_name=? "
				   + "AND member_email=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = new Member();
		
		try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, email);
		
		rs = pstmt.executeQuery();
		if (rs.next()) {
			member.setPassword(rs.getString(1));
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
			return member;
	}
}























