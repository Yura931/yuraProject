package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class WriteService {
	private ArticleDao articleDao = new ArticleDao();
	
	public int write(WriteRequest writeReq) {
		Connection con = null;
		
		try {
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			
			Article article = new Article(
					null, writeReq.getWriter(), writeReq.getTitle(),
					writeReq.getContent(), null, null, 0);
			Article savedArticle = articleDao.insert(con, article);
			
			if (savedArticle == null) {
				throw new RuntimeException ("fail to insert article");
			}
			
			con.commit();
			return savedArticle.getArticle_no();
		} catch (SQLException e) {
			JdbcUtil.rollback(con);
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JdbcUtil.rollback(con);
			throw e;
		} finally {
			JdbcUtil.close(con);
		}
		
	}

}
