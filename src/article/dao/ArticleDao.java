package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import article.model.Article;
import article.model.Writer;
import jdbc.JdbcUtil;

public class ArticleDao {
	public Article insert (Connection con, Article article ) throws SQLException {
		String sql = "INSERT INTO yura_article "
				   + "(writer_id, writer_name, "
				   + "title, content, regdate, moddate, read_cnt) "
				   + "VALUES(?, ?, ?, ?, SYSDATE, SYSDATE, 0)";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql,
							new String[] {"article_no", "regdate", "moddate"});
			
			pstmt.setString(1, article.getWriter().getId());
			pstmt.setString(2, article.getWriter().getName());
			pstmt.setString(3, article.getTitle());
			pstmt.setString(4, article.getContent());
			
			int cnt = pstmt.executeUpdate();
					
			if (cnt == 1) {
				rs = pstmt.getGeneratedKeys();
				int key = 0;
				Date regDate = null;
				Date modDate = null;
				if (rs.next()) {
					key = rs.getInt(1);
					regDate = rs.getTimestamp(2);
					modDate = rs.getTimestamp(3);
				}
				return new Article(key,
						article.getWriter(),
						article.getTitle(),
						article.getContent(),
						regDate,
						modDate,
						0);
			} else {
				return null;
			}
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
	}
	
	public List<Article> select (Connection con, int pageNo, int size) throws SQLException {
		String sql = "SELECT rn, "
			 	   + "article_no, writer_id, writer_name, "
				   + "title, regdate, moddate, read_cnt "
				   + "FROM ("
				   + "SELECT article_no, "
				   + "writer_id, writer_name, title, regdate, moddate, read_cnt, "
				   + "ROW_NUMBER() OVER (ORDER BY article_no DESC) "
				   + "rn "
				   + "FROM yura_article "
				   + ") WHERE rn "
				   + "BETWEEN ? AND ?"; 
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, (pageNo-1) * size + 1);
			pstmt.setInt(2, pageNo * size);
			
			rs = pstmt.executeQuery();
			List<Article> result = new ArrayList<>();
			while (rs.next()) {
				result.add(convertArticle(rs));
			}
			
			return result;
		} finally {
			JdbcUtil.close(rs, pstmt);
		}
				   
	}

	private Article convertArticle(ResultSet rs) throws SQLException {
		return new Article(rs.getInt("article_no"),
				new Writer(rs.getString("writer_id"),
						   rs.getString("writer_name")),
				rs.getString("title"),
				rs.getTimestamp("regdate"),
				rs.getTimestamp("moddate"),   
				rs.getInt("read_cnt"));
	}

	public int selectCount(Connection con) throws SQLException {
		String sql = "SELECT COUNT(*) FROM yura_article";
		
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
			JdbcUtil.close(con);
		}
	}
	
	
	
	
	
	
	
	
}
