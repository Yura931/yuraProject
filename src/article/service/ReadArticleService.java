package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.ConnectionProvider;

public class ReadArticleService {
	ArticleDao articleDao = new ArticleDao();
	
	public ArticleData getArticle(int article_no, boolean increaseReadCount) {	
		try(Connection con = ConnectionProvider.getConnection()) {
			Article article = articleDao.selectById(con, article_no);
			if (article == null) {
				throw new ArticleNotFoundException();
			}
			
			if (increaseReadCount) {
				articleDao.increaseReadCount(con, article_no);
			}
			
			return new ArticleData(article);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
