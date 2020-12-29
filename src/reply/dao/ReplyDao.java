package reply.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import reply.model.Reply;

public class ReplyDao {
	public List<Reply> select (Connection con, int articleNo, int pageNo, int size) throws SQLException {
		String sql = "SELECT "
				   + "rn,"
				   + "reply_id, member_id, "
				   + "reply, regdate "
				   + "FROM ( "
				   + "SELECT reply_id, member_id, "
				   + "article_no, reply, regdate, "
				   + "ROW_NUMBER() OVER "
				   + "(ORDER BY reply_id DESC) "
				   + "rn FROM yura_reply) "
				   + "WHERE article_no=? "
				   + "AND rn BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, articleNo);
			pstmt.setInt(2, (pageNo-1) * size + 1);
			pstmt.setInt(3, pageNo * size);
			
			rs = pstmt.executeQuery();
			List<Reply> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertReply(rs));
			}
			return result;
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
	}

	private Reply convertReply(ResultSet rs) throws SQLException {
		return new Reply(rs.getInt("reply_id"),
					rs.getString("member_id"),
					rs.getString("reply"),
					rs.getTimestamp("regdate")
					); 
		
	}

	public void insert(Connection con, String userId, int article_no, String body) throws SQLException {
		String sql = "INSERT INTO yura_reply "
				   + "(member_id, article_no, reply, regdate)"
				   + "VALUES (?, ?, ?, SYSDATE)";
		
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, userId);
			pstmt.setInt(2, article_no);
			pstmt.setString(3, body);
			
			pstmt.executeUpdate();
		}
	}

	public int selectCount(Connection con) throws SQLException {
		String sql = "SELECT COUNT(*) FROM yura_reply";
				
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JdbcUtil.close(rs, stmt);
		}
	}	
	
	
}










