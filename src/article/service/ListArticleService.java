package article.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.ConnectionProvider;

public class ListArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private int size = 10;
	
	public ArticlePage getArticlePage(int pageNo) {
		try (Connection con = ConnectionProvider.getConnection()) {
			int total = articleDao.selectCount(con);
			List<Article> content = articleDao.select(con, pageNo, size);				
			
			return new ArticlePage(total, pageNo, size, content);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
