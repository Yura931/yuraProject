package article.service;

import java.sql.Connection;

import article.dao.ArticleDao;
import article.model.Article;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class ModifiedArticleService {
	ArticleDao articleDao = new ArticleDao();
	
	public void modify(ModifiedData modifyData) {
		Connection con = null;
		try {
			con = ConnectionProvider.getConnection();
			Article article = articleDao.selectById(con, modifyData.getArticle_no());
			
			if (article == null) {
				throw new ArticleNotFoundException();
			}
			
			if (!canModify(modifyData.getUserId(), article)) {
				throw new PermissionDeniedException();
			}
			
			articleDao.update(con, modifyData);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con);
		}
		
	}
		private boolean canModify(String modifyingUserId, Article article ) {
			return article.getWriter().getId().equals(modifyingUserId);
		}

}
